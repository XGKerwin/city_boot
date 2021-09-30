package com.city.controller;


import com.alibaba.fastjson.JSONObject;
import com.city.bean.NewComment;
import com.city.returnJson.ReturnObject;
import com.city.service.base.NewCommentService;
import com.city.service.impl.NewCommentServiceImpl;
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
@RequestMapping("/newComment")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class NewCommentController {

    @Autowired
    private NewCommentServiceImpl newCommentService;

    @RequestMapping("/obtain")
    @ResponseBody
    public Object selectObtain(String pressId){
        System.out.println("newComment/obtain");
        List<NewComment> newComments = newCommentService.selectAllId(pressId);
        if (newComments != null){
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",newComments.size(),newComments));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/add")
    @ResponseBody
    public Object insert(String userId,String pressId,String content){
        System.out.println("newComment/add");
        int i = newCommentService.insertAdd(userId, pressId, content);
        if (i==1){
            NewComment newComment = new NewComment(userId,pressId,content);
            return JSONObject.toJSON(new ReturnObject(200,"添加成功",1,newComment));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"添加失败"));
        }
    }


}

