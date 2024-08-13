package com.itheima.applicationContext;

import com.itheima.utils.SpringUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomApplicationContextInitializer implements ApplicationContextInitializer {
    // first way to get spring application context
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        SpringUtils.setApplicationContext(applicationContext);
    }
}
