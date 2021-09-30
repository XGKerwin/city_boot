package com.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.city.bean.*;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.MetroImpl;
import com.city.util.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/27 17:08 星期一
 * @Description com.city.controller
 */

@Controller
@RequestMapping("/metro")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class MetroController {

    @Autowired
    private MetroImpl metro;

    @RequestMapping("/all")
    @ResponseBody
    public Object selectAll() {
        System.out.println("metro/all");
        List<Metro> metros = metro.selectAll();
        if (metros != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", metros.size(), metros));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/currentName")
    @ResponseBody
    public Object selectCurrentName(String currentName) {
        System.out.println("metro/currentName");
        List<MetroMsg> metroMsgs = metro.selectCurrentName(currentName);
        List<Metro> metros = new ArrayList<>();
        for (MetroMsg metroMsg : metroMsgs) {
            Metro metro = this.metro.selectOne(metroMsg.getLineId());
            metros.add(metro);
        }
        return JSONObject.toJSON(new ReturnObject(200, "操作成功", metros.size(), metros));
    }


    @RequestMapping("/lineIdmsg")
    @ResponseBody
    public Object selectLineId(String lineId) {
        System.out.println("metro/lineIdmsg");
        List<MetroMsg> metroMsgs = metro.selectLineIdMsg(lineId);
        if (metroMsgs != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", metroMsgs.size(), metroMsgs));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/Notice")
    @ResponseBody
    public Object selectNotice(String number) {
        System.out.println("metro/Notice");
        List<MetroNotice> metroNotices = metro.selectNotice(number);
        if (metroNotices != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", metroNotices.size(), metroNotices));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/Them")
    @ResponseBody
    public Object selectThem() {
        System.out.println("metro/Them");
        List<MetroTheme> metroThemes = metro.selectTheme();
        if (metroThemes != null) {
            for (MetroTheme metroTheme : metroThemes) {
                metroTheme.setSubpic(ServletUtils.getImageUrl(metroTheme.getSubpic()));
            }
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", metroThemes.size(), metroThemes));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/lostAndFound")
    @ResponseBody
    public Object selectFound() {
        System.out.println("metro/lostAndFound");
        List<Metrofound> metrofounds = metro.selectMetroFound();
        if (metrofounds != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", metrofounds.size(), metrofounds));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/Legend")
    @ResponseBody
    public Object selectLegend() {
        System.out.println("metro/Legend");
        List<MetroLegend> metroLegends = metro.selectLegend();
        if (metroLegends != null) {
            for (MetroLegend metroLegend : metroLegends) {
                metroLegend.setImage(ServletUtils.getImageUrl(metroLegend.getImage()));
            }

            return JSONObject.toJSON(new ReturnObject(200,"操作成功",metroLegends.size(),metroLegends));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/language")
    @ResponseBody
    public Object selectLanguage(){
        System.out.println("metro/language");
        List<MetroLanguage> metroLanguages = metro.selectLanguage();
        if (metroLanguages!=null){
            for (MetroLanguage metroLanguage : metroLanguages) {
                metroLanguage.setImage(ServletUtils.getImageUrl(metroLanguage.getImage()));
            }
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",metroLanguages.size(),metroLanguages));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }


}
