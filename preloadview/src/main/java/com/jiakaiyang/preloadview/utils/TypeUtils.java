package com.jiakaiyang.preloadview.utils;

/**
 * 类型相关的工具类
 */
public class TypeUtils {

    public static boolean isActivity(String className) {
        Class compareClass = null;
        Class actvityClass = null;
        try {
            actvityClass = Class.forName("Activity");
            compareClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return compareClass == actvityClass;
    }
}
