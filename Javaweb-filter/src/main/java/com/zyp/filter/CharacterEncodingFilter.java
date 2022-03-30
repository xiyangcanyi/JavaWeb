package com.zyp.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterFilter初始化:......" );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("CharacterFilter执行前:......" );
        chain.doFilter(request,response);
        System.out.println("CharacterFilter执行后:......" );

    }

    @Override
    public void destroy() {
        System.out.println("CharacterFilter摧毁......" );
    }
}
