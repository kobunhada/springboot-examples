package com.kobunhada.common.utils;

public class Utils {
    public static String replaceNullToDefaultValue(String replace, String defaultValue) {
        if (replace == null ||  replace.trim().equals("")) {
            return defaultValue;
        }
        return replace;
    }

}
