package com.itheima.applicationContext;

import com.itheima.utils.SpringUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomApplicationListener implements ApplicationListener<ApplicationContextEvent> {

    // second way to get spring application context
    @Override
    public void onApplicationEvent(ApplicationContextEvent event) {
        SpringUtils.setApplicationContext(event.getApplicationContext());
    }
}
