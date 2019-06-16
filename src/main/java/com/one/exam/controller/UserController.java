package com.one.exam.controller;

import com.alibaba.fastjson.JSON;
import com.one.exam.model.UserInfo;
import com.one.exam.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoService userInfoService;

    Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int addUser(@RequestBody String reqBody) {
        log.debug("start UserController addUser reqBody: " + reqBody);
        UserInfo userInfoObj = null;
        int result = 0;
        try {
            userInfoObj = JSON.parseObject(reqBody, UserInfo.class);
            if (userInfoObj.getName() == null || userInfoObj.getName().isEmpty()) {
                UserInfo userInfo = userInfoService.findById(userInfoObj.getId());
                userInfoObj.setName(userInfo.getName());
                userInfoObj.setAge(userInfo.getAge());
                userInfoObj.setEmail(userInfo.getEmail());
            }
            result = userInfoService.addUserInfo(userInfoObj);
            log.debug("addUser userInfoObj: " + userInfoObj.toString() + ", result: " + result);
        } catch (Exception e) {
            log.error("Exception in method addUser：" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/findById", method = RequestMethod.GET)
    public UserInfo findUserInfoById(@RequestParam("userId") int userId) {
        log.debug("start UserController findUserInfoById userId: " + userId);
        UserInfo userInfo = null;
        try {
            userInfo = userInfoService.findById(userId);
            log.debug("findUserInfoById userInfo: " + userInfo.toString());
        } catch (Exception e) {
            log.error("Exception in method findUserInfoById：" + e.getMessage());
        }
        return userInfo;
    }
}
