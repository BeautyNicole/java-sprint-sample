package com.itheima.utils;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.apache.commons.lang3.math.NumberUtils;

public class SpringUtils {
    private static ApplicationContext applicationContext;
    private static Environment env;


    public static void setApplicationContext(ApplicationContext applicationContext) {
        if(SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
            SpringUtils.env = applicationContext.getEnvironment();
            // TODO: 设置之后可以做一些操作
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Environment getEnv() {
        return env;
    }

    // get bean by name
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    // get bean by class
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // get bean by both name and class
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    // get env property from config file
    public static String getString(String key) {
        return getEnv().getProperty(key);
    }

    public static int getInt(String key) {
        return NumberUtils.toInt(getEnv().getProperty(key));
    }

    public static long getLong(String key) {
        return NumberUtils.toLong(getEnv().getProperty(key));
    }

    public static boolean getBoolean(String key) {
        return BooleanUtils.toBoolean(getEnv().getProperty(key));
    }


}
