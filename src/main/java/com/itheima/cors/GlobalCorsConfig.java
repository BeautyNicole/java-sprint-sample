package com.itheima.cors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 1. 添加Cors 配置信息
        CorsConfiguration config = new CorsConfiguration();
        // 放行哪些origin
        config.addAllowedOrigin("*");
        // 是否发送cookie
        config.setAllowCredentials(true);
        // 放行哪些方法
        config.addAllowedMethod("*");
        //放行哪些原始请求头部信息
        config.addAllowedHeader("*");
        //暴露哪些头部信息
        config.addExposedHeader("*");

        // 2. 添加映射路径
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);

        // 3. 返回新的CorsFilter
        return new CorsFilter(corsConfigurationSource);
    }
}
