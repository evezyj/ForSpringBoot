package com.one.exam.service;

import com.one.exam.model.UserInfo;


public interface UserInfoService {
    int addUserInfo(UserInfo userInfo) throws Exception;

    UserInfo findById(int id) throws Exception;
}
