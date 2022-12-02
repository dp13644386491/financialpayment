package com.jr.biz.impl;

import com.jr.biz.IUserBiz;
import com.jr.dao.impl.UserDaolmpl;
import com.jr.entry.User;

public class UserBizImpl implements IUserBiz {
    /**
     * 登录功能
     * @param user
     * @return
     */
    UserDaolmpl userDaolmpl=new UserDaolmpl();
    @Override
    public User login(User user) {
        return userDaolmpl.queryByAccountAndPassword(user);
    }
}
