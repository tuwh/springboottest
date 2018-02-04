package com.uncub.common.dto;

import java.io.Serializable;

public class WarpDTO implements Serializable{
    private String className;
    private static String version = "V1.0";


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public static String getVersion() {
        return version;
    }

}
