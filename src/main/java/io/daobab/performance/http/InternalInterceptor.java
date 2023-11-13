package io.daobab.performance.http;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class InternalInterceptor implements HandlerInterceptor {

    private final String execTime = "EXECUTION TIME";
    private final String startTime = "START TIME";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
        response.setHeader(startTime, "" + System.nanoTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model) {
        String reqUri = request.getRequestURI();
        if (reqUri.startsWith("/invoker") || reqUri.equals("/")) {
            return;
        }
        var startTimeStr = response.getHeader(startTime);
        if (startTimeStr != null) {
            long startTime = Long.parseLong(startTimeStr);
            long microseconds = ((System.nanoTime() - startTime) / 1000);
            log.info(getClass().getSimpleName() + " URI: " + reqUri + ", " + execTime + " = " + microseconds + " microseconds ");
            response.setHeader(execTime, "" + microseconds);
        } else {
            log.info(getClass().getSimpleName() + " URI: " + reqUri + ", " + execTime + " = ?");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
        if (exception != null) {
            log.info(getClass().getSimpleName() + " An error occured.");
        }
    }
}
