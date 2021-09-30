package com.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.city.bean.Actioncommit;
import com.city.bean.Actions;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.ActionsImpl;
import com.city.util.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author 关鑫
 * @date 2021/9/29 17:48 星期三
 * @Description com.city.controller
 */
@Controller
@RequestMapping("/Actions")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class ActionsController {

    @Autowired
    private ActionsImpl actionsimpl;

    @RequestMapping("/type")
    @ResponseBody
    public Object selectType() {
        System.out.println("Actions/type");
        List<Actions> actionsList = actionsimpl.queryActions();
        if (actionsList != null) {
            Map<String, String> map = new HashMap<>();
            for (Actions actions : actionsList) {
                map.put(actions.getTypeid(), actions.getTypeid());
            }
            Collection<String> values = map.values();
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", values.size(), values));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/upCount")
    @ResponseBody
    public Object UpCount(String id) {
        System.out.println("Actions/upCount");
        Actions actions = actionsimpl.queryById(id);
        Integer count = actions.getCount();
        actions.setCount(count + 1);
        int i = actionsimpl.upCount(actions);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功"));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/addCommit")
    @ResponseBody
    public Object addCommit(Actioncommit commit) {
        System.out.println("Actions/addCommit");
        int i = actionsimpl.addCommit(commit);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", 1, commit));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作成功"));
        }
    }

    @RequestMapping("/commitByid")
    @ResponseBody
    public Object selectCommitByid(String id) {
        List<Actioncommit> actioncommits = actionsimpl.queryCommit(id);
        if (actioncommits != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", actioncommits.size(), actioncommits));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/byId")
    @ResponseBody
    public Object selectId(String id) {
        Actions actions = actionsimpl.queryById(id);
        if (actions != null) {
            return JSONObject.toJSON(actions);
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "操作失败"));
        }
    }

    @RequestMapping("/all")
    @ResponseBody
    public Object selectAll() {
        List<Actions> actionsList = actionsimpl.queryActions();
        if (actionsList != null) {
            for (Actions actions : actionsList) {
                actions.setImage(ServletUtils.getImageUrl(actions.getImage()));
            }
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", actionsList.size(), actionsList));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/slide")
    @ResponseBody
    public Object selectSlide() {
        List<Actions> actions = actionsimpl.queryActions();
        if (actions != null) {
            for (Actions action : actions) {
                action.setImage(ServletUtils.getImageUrl(action.getImage()));
            }
            List<Actions> actionsList = new ArrayList<>();
            for (Actions action : actions) {
                actionsList.add(action);
                if (actionsList.size() == 5) {
                    return JSONObject.toJSON(new ReturnObject(200, "操作成功", actionsList.size(), actionsList));
                }
            }
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", actionsList.size(), actionsList));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

}
