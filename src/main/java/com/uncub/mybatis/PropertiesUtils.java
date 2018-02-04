package com.uncub.mybatis;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {
    private final static Properties properties  = new Properties();;

    static {
        try {
            properties.load(PropertiesUtils.class.getResourceAsStream("/generator.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return (String) properties.get(key);
    }

}
