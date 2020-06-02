package com.yzy.serice.impl;

import com.yzy.Dao.StaffDao;
import com.yzy.entity.Staff;
import com.yzy.serice.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("StaffService")
public class StaffServiceImp implements StaffService {

    @Resource(name = "staffDao")
    private StaffDao dao;

    public void add(Staff staff) {
        dao.add(staff);
    }

    public void edit(Staff staff) {
        dao.update(staff);
    }

    public void remove(Integer id) {
        dao.delete(id);
    }

    public Staff get(Integer id) {
        return dao.selectById(id);
    }

    public List<Staff> getAll() {
        return  dao.selectAll();
    }
}
