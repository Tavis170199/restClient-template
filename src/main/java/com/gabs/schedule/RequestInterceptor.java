package com.gabs.schedule;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LogManager.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object object) {
        if (object instanceof HandlerMethod) {
            Class<?> controllerClass = ((HandlerMethod) object).getBeanType();
            LOGGER.info( request.getMethod() + " " + request.getRequestURL() +" " + controllerClass.getName());
        }
        return true;
    }

    @Override
    public void postHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object object, ModelAndView model){
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object object, Exception exception){
    }
}
