package com.uncub.mybatis;

import org.apache.commons.lang.StringUtils;

public class TableUtil {
    private static String TABLE_PREFIX = "T_";
    public static String transTableName(String tableName){
        if (StringUtils.isBlank(tableName)) return tableName;
        tableName = StringUtils.lowerCase(tableName);
        tableName = StringUtils.stripStart(tableName, TABLE_PREFIX.toLowerCase());
        String javaName = "";
        String[] strs = tableName.split("_");
        for (String str : strs){
            javaName += StringUtils.upperCase(str.substring(0,1)) + str.substring(1,str.length());
        }
        return javaName;
    }
}
