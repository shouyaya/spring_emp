package com.yzy.serice;

import com.yzy.entity.Staff;

public interface SelfService {
    Staff login(String account,String password);
    void changePassword(Integer id,String password);
}
