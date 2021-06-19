package com.lean.tech.java.Employees.config.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class EmployeeServiceInterceptorAppConfig implements WebMvcConfigurer {
   @Autowired
   InterceptorAPI interceptorAPI;

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(interceptorAPI);
   }
}