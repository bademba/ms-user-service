package com.baproject.userservice.logging;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;


public class LoggingInterceptor implements HandlerInterceptor {


    private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("REQUEST::"+"|Method="+ request.getMethod()+"|URI="+ request.getRequestURI()+ "|RequestBody="+ handler+"|SourceIP="+ request.getRemoteAddr()+"|RemoteUser="+request.getRemoteUser()+"|ContentType="+request.getContentType()+"|User-Agent="+request.getHeader("User-Agent"));
         return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("RESPONSE::"+ "ResponseContent="+handler+"|ContentType="+ response.getContentType()+"|ResponseStatus="+response.getStatus());
    }


}