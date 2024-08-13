package com.itheima.applicationContext;

import com.itheima.utils.SpringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomApplicationContentAware implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    // forth way to get spring application context
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CustomApplicationContentAware.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
