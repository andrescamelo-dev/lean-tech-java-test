package com.lean.tech.java.Employees.config.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class InterceptorAPI implements HandlerInterceptor {

   static final Logger LOG = LoggerFactory.getLogger(InterceptorAPI.class);

   @Override
   public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler) 
      throws Exception {
      
         LOG.info("Pre Handle method is Calling: {} " , request.getContentType());
      return true;
   }
   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, 
      Object handler, ModelAndView modelAndView) throws Exception {
      
         LOG.info("Post Handle method is Calling:  {}", request.getRequestURI());
   }
   @Override
   public void afterCompletion
      (HttpServletRequest request, HttpServletResponse response, Object 
      handler, Exception exception) throws Exception {
      
         LOG.info("Request and Response is completed: {}", request.getHeaderNames());
   }
}