package com.neusoft.mapper;

import com.neusoft.bean.User;
import com.neusoft.bean.UserInfo;

/**
 * Created by ttc on 2018/8/2.
 */
public interface UserMapper {
    int addUser(User user);
    User isUserExist(User user);
    int updateUserById(UserInfo user);
    UserInfo queryUserById(int id);
}
