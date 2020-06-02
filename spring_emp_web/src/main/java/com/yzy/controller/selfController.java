package com.yzy.controller;

import com.yzy.entity.Staff;
import com.yzy.serice.SelfService;
import com.yzy.serice.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Controller("selfController")
public class selfController {
    @Autowired
    SelfService selfService;
    @Autowired
    StaffService staffService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/login.jsp");
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Staff staff = selfService.login(account, password);
        if (staff!=null){
            request.getSession().setAttribute("USER",staff);
            response.sendRedirect("/self/main.do");
        }else{
            response.sendRedirect("/toLogin.do");
        }
    }
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("USER",null);
        response.sendRedirect("/login.jsp");
    }
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }
    public void info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/info.jsp");
    }
    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/change_password.jsp");
    }
    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        String password1 = request.getParameter("password1");
        Staff user = (Staff) request.getSession().getAttribute("USER");
        if(Objects.equals(user.getPassword(),password)){
            user.setPassword(password1);
            staffService.edit(user);
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"/login.jsp\"</script>");
//            response.sendRedirect("/login.jsp");
        }else{
            response.sendRedirect("/change_password.jsp");
        }
    }
}
