package com.yzy.serice.impl;

import com.yzy.Dao.LogDao;
import com.yzy.entity.Log;
import com.yzy.serice.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("logService")
public class LogServiceImpl implements LogService {
    @Resource(name = "logDao")
    private LogDao logDao;
    @Override
    public void addOperationLog(Log log) {
        log.setOprTime(new Date());
        log.setType("operation");
        logDao.insertLog(log);
    }

    @Override
    public void addSystemLog(Log log) {
        log.setOprTime(new Date());
        log.setType("system");
        logDao.insertLog(log);
    }

    @Override
    public void addLoginLog(Log log) {
        log.setOprTime(new Date());
        log.setType("login");
        logDao.insertLog(log);
    }

    @Override
    public List<Log> getOperationLog() {
        return logDao.selectLogByType("operation");
    }

    @Override
    public List<Log> getSystemLog() {
        return logDao.selectLogByType("system");
    }

    @Override
    public List<Log> getLoginLog() {
        return logDao.selectLogByType("login");
    }
}
