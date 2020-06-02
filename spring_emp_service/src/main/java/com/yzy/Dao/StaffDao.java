package com.yzy.Dao;

import com.yzy.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("staffDao")
public interface StaffDao {
    void add(Staff staff);
    void update(Staff staff);
    void delete(Integer id);
    List<Staff> selectAll();
    Staff selectById(Integer id);
}
