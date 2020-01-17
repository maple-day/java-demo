package com.fangda.config;

import com.fangda.config.dataBase.DBSql;
import com.fangda.config.dataBase.MySqlSql;
import com.fangda.config.dataBase.SqlServerSql;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.*;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.config
 * @ClassName: DB2DocUtil
 * @Author: ccq
 * @Description: 数据库导成doc工具类
 * @Date: 2020/1/17 14:58
 */
@Component
public class DB2DocUtil {

    @Value("${data_name}")
    private String dataName;
    @Value("${doc_dir_path}")
    private String docDirPath;

    @Value("${db_type:1}")
    private Integer dbType;//数据库类型没有设置默认mysql

    @Autowired
    DriverManagerDataSource driverManagerDataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void db2Doc() {
        if (!DataBaseTypeEnum.isInCode(dbType)) {
            throw new RuntimeException("不支持改数据库导出doc");
        }
        XWPFDocument xdoc = new XWPFDocument();
        XWPFParagraph title = xdoc.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun rt = title.createRun();
        rt.setBold(true);
        rt.setFontFamily("微软雅黑");
        rt.setText(dataName + "数据库设计文档");
        rt.setFontSize(20);
        rt.setColor("333333");
        rt.setBold(true);

        DBSql dbSql;
        if (dbType.compareTo(DataBaseTypeEnum.MYSQL.getCode()) == 0) {
            dbSql = new MySqlSql();
        } else {
            dbSql = new SqlServerSql();
        }
        Map<String, String[][]> datas = dataInfo(dataName, dbSql);
        Set<String> keySet = datas.keySet();
        for (String table : keySet) {
            XWPFParagraph headLine1 = xdoc.createParagraph();
            headLine1.setAlignment(ParagraphAlignment.LEFT);
            XWPFRun runHeadLine1 = headLine1.createRun();
            runHeadLine1.setText(table);
            runHeadLine1.setFontSize(18);
            runHeadLine1.setFontFamily("微软雅黑");
            runHeadLine1.setColor("000000");

            String[][] clumns = datas.get(table);

            XWPFTable dTable = xdoc.createTable(clumns.length + 1, 4);
            createTable(dTable, xdoc, clumns);
            setEmptyRow(xdoc, rt);
        }
        // 在服务器端生成
        FileOutputStream fos = null;
        try {
            String docPath = docDirPath + File.separator + dataName + "_" + (new Date()).getTime() + ".docx";
            FileUtils.forceMkdirParent(new File(docPath));
            fos = new FileOutputStream(docPath);
            xdoc.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * 获取数据库每个表的信息
     *
     * @param data
     * @return
     */
    private Map<String, String[][]> dataInfo(String data, DBSql dbSql) {
        String sql = dbSql.tableSql();
        if (StringUtils.isBlank(sql)) {
            throw new RuntimeException("查询所有表的sql语句不能为空");
        }
        List<Map<String, Object>> list;
        if (dbType.compareTo(DataBaseTypeEnum.MYSQL.getCode()) == 0) {
            list = jdbcTemplate.queryForList(sql, data);
        } else if (dbType.compareTo(DataBaseTypeEnum.SQL_SERVER.getCode()) == 0) {
            list = jdbcTemplate.queryForList(sql);
        } else {
            list = new ArrayList<>();
        }
        System.out.println("list.size = " + list.size());
        Map<String, String[][]> datas = new HashMap<>();
        for (Map<String, Object> map : list) {
            String table_name = map.get("table_name") + "";
            String table_comment = map.get("table_comment") + "";
            if (dbType.compareTo(DataBaseTypeEnum.MYSQL.getCode()) == 0) {
                datas.put("表:" + table_name + ":" + table_comment, tableInfo(data + "." + table_name, dbSql));
            } else if (dbType.compareTo(DataBaseTypeEnum.SQL_SERVER.getCode()) == 0) {
                datas.put("表:" + table_name + ":" + table_comment, tableInfo(table_name, dbSql));
            }
        }
        return datas;
    }


    /**
     * 获取每个表的字段信息
     *
     * @param table
     * @return
     */
    private String[][] tableInfo(String table, DBSql dbSql) {
        String sql = dbSql.fieldSql();
        if (StringUtils.isBlank(sql)) {
            throw new RuntimeException("查询表字段的sql语句不能为空");
        }
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, table);
        String[][] tables = new String[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            String[] info = new String[4];
            info[0] = map.get("Field") + "";
            info[1] = map.get("Type") + "";
            info[2] = map.get("null") + "";
            info[3] = map.get("Comment") + "";
            tables[i] = info;
        }
        return tables;
    }

    /**
     * 生成表格
     */
    public static void createTable(XWPFTable xTable, XWPFDocument xdoc, String[][] clumns) {
        String bgColor = "111111";
        CTTbl ttbl = xTable.getCTTbl();
        CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
        CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
        tblWidth.setW(new BigInteger("8600"));
        tblWidth.setType(STTblWidth.DXA);
        setCellText(xdoc, getCellHight(xTable, 0, 0), "字段名", bgColor, 1500);
        setCellText(xdoc, getCellHight(xTable, 0, 1), "数据类型", bgColor, 2000);
        setCellText(xdoc, getCellHight(xTable, 0, 2), "是否可空", bgColor, 1200);
        setCellText(xdoc, getCellHight(xTable, 0, 3), "说明", bgColor, 3500);
        int length = clumns.length;
        for (int i = 0; i < length; i++) {
            setCellText(xdoc, getCellHight(xTable, i + 1, 0), clumns[i][0], bgColor, 1500);
            setCellText(xdoc, getCellHight(xTable, i + 1, 1), clumns[i][1], bgColor, 2000);
            setCellText(xdoc, getCellHight(xTable, i + 1, 2), clumns[i][2], bgColor, 1200);
            setCellText(xdoc, getCellHight(xTable, i + 1, 3), clumns[i][3], bgColor, 3500);
        }
    }

    // 设置表格高度
    private static XWPFTableCell getCellHight(XWPFTable xTable, int rowNomber, int cellNumber) {
        XWPFTableRow row = null;
        row = xTable.getRow(rowNomber);
        row.setHeight(100);
        XWPFTableCell cell = null;
        cell = row.getCell(cellNumber);
        return cell;
    }

    /**
     * 单元格设置文本
     *
     * @param xDocument
     * @param cell
     * @param text
     * @param bgcolor
     * @param width
     */
    private static void setCellText(XWPFDocument xDocument, XWPFTableCell cell, String text, String bgcolor,
                                    int width) {
        CTTc cttc = cell.getCTTc();
        CTTcPr cellPr = cttc.addNewTcPr();
        cellPr.addNewTcW().setW(BigInteger.valueOf(width));
        XWPFParagraph pIO = cell.addParagraph();
        cell.removeParagraph(0);
        XWPFRun rIO = pIO.createRun();
        rIO.setFontFamily("微软雅黑");
        rIO.setColor("000000");
        rIO.setFontSize(10);
        rIO.setText(text);
    }

    // 设置表格间的空行
    public static void setEmptyRow(XWPFDocument xdoc, XWPFRun r1) {
        XWPFParagraph p1 = xdoc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        p1.setVerticalAlignment(TextAlignment.CENTER);
        r1 = p1.createRun();
    }

}
