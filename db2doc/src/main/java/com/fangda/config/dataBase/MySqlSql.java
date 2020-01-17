package com.fangda.config.dataBase;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.config
 * @ClassName: MySqlSql
 * @Author: ccq
 * @Description: mysql的sql语句
 * @Date: 2020/1/17 15:04
 */
public class MySqlSql implements DBSql {
    @Override
    public String tableSql() {
        return "select table_name,table_comment from information_schema.tables where table_schema = ? ";
    }

    @Override
    public String fieldSql() {
        return "SHOW FULL FIELDS FROM ?";
    }
}
