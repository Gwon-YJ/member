package com.example.member.common.config;

import com.example.member.common.filter.CustomFilter;
import com.example.member.common.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class WebConfig {

//    @Bean
//    @Order(1)
//    public FilterRegistrationBean customFilter() {
//        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new CustomFilter()); // Filter 등록
//        filterRegistrationBean.setOrder(1); // Filter 순서 1 설정
//        filterRegistrationBean.addUrlPatterns("/*"); // 전체 URL에 Filter 적용
//
//        return filterRegistrationBean;
//    }

    @Bean
    @Order(1)
    public FilterRegistrationBean loginFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LoginFilter()); // Filter 등록
        filterRegistrationBean.setOrder(1); // Filter 순서 1 설정
        filterRegistrationBean.addUrlPatterns("/*"); // 전체 URL에 Filter 적용

        return filterRegistrationBean;
    }
}
