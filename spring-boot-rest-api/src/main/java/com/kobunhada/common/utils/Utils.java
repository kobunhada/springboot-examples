package com.kobunhada.common.utils;

public class Utils {
    /**
     * If target is null or white-space or "", it replace default value.
     *
     * @param replaceTarget targetValue
     * @param defaultValue defaultValue
     * @return
     */
    public static String replaceNullToDefaultValue(String replaceTarget, String defaultValue) {
        if (replaceTarget == null ||  replaceTarget.trim().equals("")) {
            return defaultValue;
        }
        return replaceTarget;
    }

}
