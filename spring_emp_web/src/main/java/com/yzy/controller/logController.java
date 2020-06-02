package com.yzy.controller;


import com.yzy.entity.Log;
import com.yzy.serice.LogService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("logController")
public class logController {
    @Resource(name = "logService")
    private LogService logService;

    public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLog = logService.getOperationLog();
        request.setAttribute("LIST",operationLog);
        request.setAttribute("TYPE","操作");
        request.getRequestDispatcher("/log_list.jsp").forward(request,response);
    }

    public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLog = logService.getLoginLog();
        request.setAttribute("LIST",operationLog);
        request.setAttribute("TYPE","登陆");
        request.getRequestDispatcher("/log_list.jsp").forward(request,response);
    }

    public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Log> operationLog = logService.getSystemLog();
        request.setAttribute("LIST",operationLog);
        request.setAttribute("TYPE","系统");
        request.getRequestDispatcher("/log_list.jsp").forward(request,response);
    }
}
