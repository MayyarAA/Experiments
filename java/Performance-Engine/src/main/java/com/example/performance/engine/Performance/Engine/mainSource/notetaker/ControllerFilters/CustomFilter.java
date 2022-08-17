package com.example.performance.engine.Performance.Engine.mainSource.notetaker.ControllerFilters;

import com.example.performance.engine.Performance.Engine.mainSource.notetaker.Utils.CustomLogger;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {
    CustomLogger customLogger;
    @Autowired
    public CustomFilter(CustomLogger customLogger){
        this.customLogger = customLogger;
    }
    public String description() {
        return "logging filter";
    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        customLogger.info("Start of API request to notetaker");
        filterChain.doFilter(servletRequest, servletResponse);//sends request to next resource
        customLogger.info("End of API request to notetaker");
    }
}
