package com.yzy.Dao;

import com.yzy.entity.Staff;
import org.springframework.stereotype.Repository;

@Repository("selfDao")
public interface SelfDao {
    Staff selectByAccount(String account);
}
