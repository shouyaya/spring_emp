package com.yzy.serice;

import com.yzy.entity.Staff;
import com.yzy.entity.department;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void edit(Staff staff);
    void remove(Integer id);
    Staff get(Integer id);
    List<Staff> getAll();
}
