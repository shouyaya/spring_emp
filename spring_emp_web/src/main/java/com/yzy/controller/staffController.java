package com.yzy.controller;

import com.yzy.entity.Staff;
import com.yzy.entity.department;
import com.yzy.serice.DepartmentService;
import com.yzy.serice.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Controller
public class staffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private DepartmentService departmentService;
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> all = staffService.getAll();
        request.setAttribute("LIST",all);
        request.getRequestDispatcher("/staff_list.jsp").forward(request,response);
    }
    public void toEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<department> DLIST = departmentService.getAll();
        Staff OBJ = staffService.get(Integer.parseInt(id));
        request.setAttribute("DLIST",DLIST);
        request.setAttribute("OBJ",OBJ);
        request.getRequestDispatcher("/staff_edit.jsp").forward(request,response);
    }
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id=Integer.parseInt(request.getParameter("id"));
        String account = request.getParameter("account");
        Integer did =Integer.parseInt(request.getParameter("did")) ;
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String info = request.getParameter("info");

        Staff staff = staffService.get(id);
        staff.setAccount(account);
        staff.setDid(did);
        staff.setName(name);
        staff.setBornDate(bornDate);
        staff.setInfo(info);
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<department> all = departmentService.getAll();
        request.setAttribute("DLIST",all);
        request.getRequestDispatcher("/staff_add.jsp").forward(request,response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password ="123456";
        String Status="正常";
        String account = request.getParameter("account");
        Integer did = Integer.parseInt(request.getParameter("did"));
        String name = request.getParameter("name");
        String sex=request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        Date bornDate=null;
        try {
            bornDate= new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Staff staff=new Staff();
        staff.setPassword(password);
        staff.setStatus(Status);
        staff.setAccount(account);
        staff.setDid(did);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        staffService.remove(Integer.parseInt(id));
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Staff staff = staffService.get(Integer.parseInt(id));
        request.setAttribute("OBJ",staff);
        request.getRequestDispatcher("/staff_detail.jsp").forward(request,response);
    }
}
