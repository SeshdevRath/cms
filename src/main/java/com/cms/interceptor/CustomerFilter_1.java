package com.cms.interceptor;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(2) // Filter sequence
public class CustomerFilter_1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Customer filter 1 called");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
