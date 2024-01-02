package com.users.userservice.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.users.userservice.filter.JwtAuthenticationFilter;

@Configuration
public class AppConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new JwtAuthenticationFilter());
        // filter.addUrlPatterns("/api/persons/*");
        filter.addUrlPatterns("/api/users/**");
        return filter;
    }

}
