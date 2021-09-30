package com.city.controller;


import com.alibaba.fastjson.JSONObject;
import com.city.bean.User;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    @ResponseBody
    public Object selectLogin(String username, String password) {
        System.out.println("user/login");
        List<User> user = userService.setUser(username, password);
        if (user.size() != 0) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", 1, user.get(0)));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object addUser(User user) {
        System.out.println("user/register");
        List<User> userList = userService.selectUsers();
        String username = user.getUsername();
        if (username == null) {
            return JSONObject.toJSON(new ReturnObject(500, "用户名为空"));
        }
        for (User user1 : userList) {
            if (user1.getUsername().equals(username)) {
                return JSONObject.toJSON(new ReturnObject(500, "用户名已注册"));
            }
        }
        int i = userService.addUser(user);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "添加成功", 1, user));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "添加失败"));
        }
    }

    @RequestMapping("all")
    @ResponseBody
    public Object selectAll() {
        System.out.println("user/all");
        List<User> userList = userService.selectUsers();
        if (userList != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", userList.size(), userList));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/information")
    @ResponseBody
    public Object selectUser(String id) {
        System.out.println("user/information");
        List<User> userList = userService.selectUser(id);
        if (userList.size() != 0) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", 1, userList.get(0)));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("updateUser")
    @ResponseBody
    public Object updateUser(User user) {
        System.out.println("user/updateUser");
        int i = userService.updateUser(user);
        System.out.println(i);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", 1, user));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

}

