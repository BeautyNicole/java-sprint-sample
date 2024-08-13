package com.itheima;

import com.itheima.service.impl.BookService;
import com.itheima.utils.SpringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
@EnableCaching
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringbootCacheSampleApplication {

    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(SpringbootCacheSampleApplication.class, args);

        // third way to get spring application context
        // SpringUtils.setApplicationContext(context);

        // get bean by class name
        BookService bookService1 = (BookService) context.getBean("bookService");
        System.out.println(bookService1);

        // get bean by class type
        BookService bookService2 = context.getBean(BookService.class);
        System.out.println(bookService2);

        // get bean by name and class type
        BookService bookService3 = context.getBean("bookService", BookService.class);
        System.out.println(bookService3);


        System.out.println("---------------------------");
    }

}
