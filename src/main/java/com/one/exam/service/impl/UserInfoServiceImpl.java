package com.one.exam.service.impl;

import com.one.exam.model.UserInfo;
import com.one.exam.repo.UserInfoRepository;
import com.one.exam.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
    Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Override
    public int addUserInfo(UserInfo userInfo) throws Exception{
        UserInfo user = userInfoRepository.save(userInfo);
        if (user != null) {
            return user.getId();
        } else {
            return 0;
        }
    }

    @Override
    public UserInfo findById(int id) throws Exception{
        return userInfoRepository.findById(id).get(0);
    }
}
