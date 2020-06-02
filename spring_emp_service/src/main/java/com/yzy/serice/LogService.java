package com.yzy.serice;

import com.yzy.entity.Log;

import java.util.List;

public interface LogService {
    void addOperationLog(Log log);
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    List<Log> getOperationLog();
    List<Log> getSystemLog();
    List<Log> getLoginLog();
}
