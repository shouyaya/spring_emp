package com.yzy.controller;

import com.sun.deploy.net.HttpResponse;
import com.yzy.entity.department;
import com.yzy.serice.DepartmentService;
import com.yzy.serice.impl.departmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller("departmentController")
public class departmentController {
    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<department> all = departmentService.getAll();
        request.setAttribute("LIST",all);
        request.getRequestDispatcher("/department_list.jsp").forward(request,response);
    }

    /**
     * 跳转至添加页面
     * @param request
     * @param response
     * @throws IOException
     */
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/department_add.jsp");
    }

    /**
     * 添加部门功能
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= request.getParameter("name");
        String address= request.getParameter("address");
        department dep=new department();
        dep.setName(name);
        dep.setAddress(address);
        departmentService.add(dep);
        request.getRequestDispatcher("/department/list.do").forward(request,response);
    }

    /**
     * 跳转至编辑页面
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void toEdit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        department Obj = departmentService.get(id);
        request.setAttribute("OBJ",Obj);
        request.getRequestDispatcher("/department_edit.jsp").forward(request,response);
    }

    /**
     * 编辑部门的功能
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void edit(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        Integer id =Integer.parseInt(request.getParameter("id")) ;
        String name=request.getParameter("name");
        String address=request.getParameter("address");
        department dep=new department();
        dep.setId(id);
        dep.setName(name);
        dep.setAddress(address);
        departmentService.edit(dep);
        request.getRequestDispatcher("/department/list.do").forward(request,response);
    }



    /**
     * 删除部门功能
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void remove(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
        Integer id=Integer.parseInt(request.getParameter("id"));
        departmentService.remove(id);
        request.getRequestDispatcher("/department/list.do").forward(request,response);
    }
}
