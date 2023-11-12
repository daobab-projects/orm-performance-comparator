package io.daobab.performance.http;

//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class LogFilter {//extends HttpFilter {
//    private FilterConfig filterConfigObj;
//
//    public void init(FilterConfig config) throws ServletException {
//        this.filterConfigObj = config;
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws ServletException, IOException {
//        HttpServletResponseCopier responseCopier = new HttpServletResponseCopier((HttpServletResponse) response);
//
//        try {
//            chain.doFilter(request, responseCopier);
//            responseCopier.flushBuffer();
//        } finally {
//            byte[] copy = responseCopier.getCopy();
//            System.out.println(new String(copy, response.getCharacterEncoding()));
//        }
//    }
}
