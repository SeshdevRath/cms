package com.cms.config;

import com.cms.interceptor.CustomerNewFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerFilterConfig {

    @Bean
    public FilterRegistrationBean<CustomerNewFilter> registrationBean() {
        FilterRegistrationBean<CustomerNewFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomerNewFilter());
        registrationBean.addUrlPatterns("/customers/*");

        return registrationBean;
    }
}
