package com.fangda.config;

/**
 * @ProjectName: java-demo
 * @Package: com.fangda.config
 * @ClassName: DataBaseTypeEnum
 * @Author: ccq
 * @Description: 数据库类型
 * @Date: 2020/1/17 14:51
 */
public enum DataBaseTypeEnum {
    MYSQL(1, "mysql"),
    SQL_SERVER(2, "sql server");

    private Integer code;
    private String desc;

    DataBaseTypeEnum(Integer type, String database_name) {
        this.desc = database_name;
        this.code = type;
    }


    /**
     * @description 该值是否是枚举值
     * @Author ccq
     * @date 2020/1/17 15:21
     */
    public static boolean isInCode(Integer code) {
        if (code == null) {
            return false;
        }
        DataBaseTypeEnum[] typeEnums = DataBaseTypeEnum.values();
        for (DataBaseTypeEnum typeEnum : typeEnums) {
            if (typeEnum.code.compareTo(code) == 0) {
                return true;
            }
        }
        return false;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
