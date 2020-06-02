package com.yzy.serice.impl;

import com.yzy.Dao.SelfDao;
import com.yzy.Dao.StaffDao;
import com.yzy.entity.Staff;
import com.yzy.serice.SelfService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("selfService")
public class SelfServiceImp implements SelfService {
    @Resource(name = "selfDao")
    private SelfDao selfDao;
    @Resource(name = "staffDao")
    private StaffDao staffDao;
    public Staff login(String account, String password) {
        Staff staff = selfDao.selectByAccount(account);
        if(staff==null){
            return null;
        }else{
            if(Objects.equals(password,staff.getPassword())){
                return staff;
            }else{
                return null;
            }
        }
    }

    public void changePassword(Integer id, String password) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(password);
        staffDao.update(staff);
    }
}
