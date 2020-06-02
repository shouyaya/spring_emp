package com.yzy.serice;

import com.yzy.entity.department;

import java.util.List;

public interface DepartmentService {
    void add(department dep);
    void edit(department dep);
    void remove(Integer id);
    department get(Integer id);
    List<department> getAll();
}
