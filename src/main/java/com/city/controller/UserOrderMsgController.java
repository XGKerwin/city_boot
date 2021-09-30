package com.city.controller;


import com.alibaba.fastjson.JSONObject;
import com.city.bean.UserOrderMsg;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.UserOrderMsgServiceImpl;
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
@RequestMapping("/userOrderMsg")
public class UserOrderMsgController {

    @Autowired
    private UserOrderMsgServiceImpl userOrderMsgService;

    @RequestMapping("/all")
    @ResponseBody
    public Object userOrderMsgList() {
        List<UserOrderMsg> userOrderMsgs = userOrderMsgService.userOrderMsgList();
        if (userOrderMsgs != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", userOrderMsgs.size(), userOrderMsgs));
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "失败"));
        }
    }

}

