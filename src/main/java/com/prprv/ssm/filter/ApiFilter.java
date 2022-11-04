package com.prprv.ssm.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 未確認の庭師
 */
@Log4j2
@WebFilter(filterName = "ApiFilter", urlPatterns = "/api/*")
public class ApiFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // URI过滤：/api/xxx
        String[] uri = request.getRequestURI().split("/api");
        switch (uri[uri.length - 1]) {
            case "/login":
            case "/register":
            case "/logout":
            case "/user":
            case "/user/update":
            case "/user/delete":
            case "/user/insert":
            case "/user/list":
                log.debug("收到请求: " + request.getMethod() + " " + request.getRequestURI());
                filterChain.doFilter(servletRequest, servletResponse);
                break;
            default:
                response.sendError(404);
                break;
        }
    }
}
