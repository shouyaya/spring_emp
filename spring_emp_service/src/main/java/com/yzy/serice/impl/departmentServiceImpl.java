package com.yzy.serice.impl;


import com.yzy.Dao.departmentDao;
import com.yzy.entity.department;
import com.yzy.serice.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("departmentService")
public class departmentServiceImpl implements DepartmentService{

   @Autowired
    private departmentDao dao;


    public void add(department dep) {
        dao.add(dep);
    }

    public void edit(department dep) {
        dao.update(dep);
    }

    public void remove(Integer id) {
        dao.delete(id);
    }

    public department get(Integer id) {
        return dao.selectById(id);
    }

    public List<department> getAll() {
        return dao.selectAll();
    }
}
