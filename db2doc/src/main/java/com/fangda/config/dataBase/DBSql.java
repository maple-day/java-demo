package com.fangda.config.dataBase;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.config
 * @ClassName: DBSql
 * @Author: ccq
 * @Description: 数据库sql语句
 * @Date: 2020/1/17 15:01
 */
public interface DBSql {

    /**
     * @description 获取所有表的sql语句, 完整的sql语句，或者只有一个参数的sql
     * @Author ccq
     * @date 2020/1/17 15:02
     */
    String tableSql();

    /**
     * @description 获取所有表的字段信息的sql语句, 变量用？代替
     * @Author ccq
     * @date 2020/1/17 15:03
     */
    String fieldSql();
}
