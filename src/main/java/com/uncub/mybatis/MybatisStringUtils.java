package com.uncub.mybatis;

import org.apache.commons.lang.StringUtils;

public class MybatisStringUtils {
    public static String upperCaseFirstChar(String str){
        if (StringUtils.isBlank(str) || str.length() == 1){
            return str;
        }
        return str.substring(0,1).toUpperCase() + str.substring(1,str.length());
    }

    public static String lowerCaseFirstChar(String str){
        if (StringUtils.isBlank(str) || str.length() == 1){
            return str;
        }
        return str.substring(0,1).toLowerCase() + str.substring(1,str.length());
    }
}
