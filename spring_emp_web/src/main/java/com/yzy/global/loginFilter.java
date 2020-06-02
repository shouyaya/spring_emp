package com.yzy.global;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getSession().getAttribute("USER")!=null){
            chain.doFilter(request,response);
        }else{
            if(request.getServletPath().toLowerCase().indexOf("login")!=-1){
                chain.doFilter(request,response);
            }else{
                response.sendRedirect("/login.jsp");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
