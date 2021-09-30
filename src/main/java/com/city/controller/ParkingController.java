package com.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.city.bean.Parking;
import com.city.bean.ParkingUser;
import com.city.bean.Parkingrecord;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.ParkingImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/27 19:32 星期一
 * @Description com.city.controller
 */

@Controller
@RequestMapping("/parking")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class ParkingController {

    @Autowired
    private ParkingImpl parking;

    @RequestMapping("/all")
    @ResponseBody
    public Object selectAll() {
        System.out.println("parking/all");
        List<Parking> parkings = parking.selectParkingAll();
        if (parkings != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", parkings.size(), parkings));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/parkingid")
    @ResponseBody
    public Object selectParking(String parkingid) {
        System.out.println("parking/parkingid");
        Parking parking = this.parking.selectById(parkingid);
        if (parking != null) {
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",1,parking));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/record")
    @ResponseBody
    public Object selectRecord(){
        System.out.println("parking/record");
        List<Parkingrecord> parkingrecords = parking.selectRecord();
        if (parkingrecords != null){
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",parkingrecords.size(),parkingrecords));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/EntryTime")
    @ResponseBody
    public Object selectEntryTime(String EntryTime){
        System.out.println("parking/EntryTime");
        List<Parkingrecord> parkingrecords = parking.selectEntryTime(EntryTime);
        if (parkingrecords!=null){
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",parkingrecords.size(),parkingrecords));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/ByOutTime")
    @ResponseBody
    public Object selectByOutTime(String ByOutTime){
        System.out.println("parking/ByOutTime");
        List<Parkingrecord> parkingrecords = parking.selectByOutTime(ByOutTime);
        if (parkingrecords!=null){
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",parkingrecords.size(),parkingrecords));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

    @RequestMapping("/User")
    @ResponseBody
    public Object selectUser(){
        System.out.println("parking/User");
        List<ParkingUser> parkingUsers = parking.selectUserList();
        if (parkingUsers!=null){
            return JSONObject.toJSON(new ReturnObject(200,"操作成功",parkingUsers.size(),parkingUsers));
        }else {
            return JSONObject.toJSON(new ReturnObject(500,"操作失败"));
        }
    }

}
