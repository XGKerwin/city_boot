package com.city.controller;


import com.alibaba.fastjson.JSONObject;
import com.city.bean.UserOpinion;
import com.city.mapper.UserOpinionMapper;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.UserOpinionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/userOpinion")
public class UserOpinionController {

    @Autowired
    private UserOpinionServiceImpl userOpinionService;

    @RequestMapping("/all")
    @ResponseBody
    public Object selectAll() {
        List<UserOpinion> userOpinions = userOpinionService.selectUserOpinions();
        if (userOpinions != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", userOpinions.size(), userOpinions));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    /**
     * 错误
     * @param userOpinion
     * @return
     */
    @RequestMapping("/add")
    public Object addUserOpinion(UserOpinion userOpinion) {
        int i = userOpinionService.addUserOpinion(userOpinion);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "添加成功", 1, userOpinion));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }




}

