package com.fangda.config.dataBase;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.config.dataBase
 * @ClassName: SqlServerSql
 * @Author: ccq
 * @Description: sql server的sql语句
 * @Date: 2020/1/17 15:08
 */
public class SqlServerSql implements DBSql {
    @Override
    public String tableSql() {
        String sql = "SELECT CONVERT(varchar(200),A.name) table_name ,CONVERT(varchar(200),C.value) table_comment FROM [sys].[tables] A LEFT JOIN [sys].[extended_properties] C ON C.major_id = A.object_id WHERE C.minor_id=0 group by A.name ,C.value";
        return sql;
    }

    @Override
    public String fieldSql() {
        String sql = "select CONVERT(varchar(200),a.name) as table_name,CONVERT(varchar(200),b.name)  as Field, CONVERT(varchar(200),c.value) as Comment,CONVERT(varchar(200),d.name)  as Type" +
                "    from sys.tables a left join sys.columns b on a.object_id=b.object_id  " +
                "    left join sys.extended_properties c on a.object_id=c.major_id  " +
                "    left join systypes d on b.user_type_id=d.xusertype " +
                "    where a.name=? and c.minor_id<>0 and b.column_id=c.minor_id  " +
                "    and a.schema_id=(  select schema_id from sys.schemas where name='dbo' ) ";
        return sql;
    }
}
