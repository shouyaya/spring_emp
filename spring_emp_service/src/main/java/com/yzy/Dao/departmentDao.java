package com.yzy.Dao;

import com.yzy.entity.department;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository("departmentDao")
public interface departmentDao {
    void add(department dep);
    void update(department dep);
    void delete(Integer id);
    List<department> selectAll();
    department selectById(Integer id);
}
