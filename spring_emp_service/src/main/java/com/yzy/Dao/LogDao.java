package com.yzy.Dao;

import com.yzy.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("logDao")
public interface LogDao {
    List<Log> selectLogByType(String type);
    void insertLog(Log log);
}
