package com.yzy.global;

import javax.servlet.*;
import java.io.IOException;

public class encoding implements Filter {
    private String encoding="UTF-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        if (config.getInitParameter("encoding")!=null)
            encoding=config.getInitParameter("encoding");
    }

}