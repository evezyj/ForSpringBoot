package com.one.exam.TestService;

import com.one.exam.model.UserInfo;
import com.one.exam.service.UserInfoService;
import com.one.exam.service.impl.UserInfoServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest {

    UserInfoService userInfoService = new UserInfoServiceImpl();
    @Test
    public void testAddUser(){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setCountCorrect(10);
        userInfo.setEmail("123@qq.com");
        userInfo.setFalseSubject("1,2,3");
        userInfo.setTrueSubject("4,5,6");

        userInfo.setName("Cicy1");
    }
}
