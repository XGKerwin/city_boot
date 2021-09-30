package com.city.controller;

import com.alibaba.fastjson.JSONObject;
import com.city.bean.Bus;
import com.city.bean.BusMsg;
import com.city.bean.BusOrder;
import com.city.returnJson.ReturnObject;
import com.city.service.impl.BusImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/29 8:51 星期三
 * @Description com.city.controller
 */
@Controller
@RequestMapping("/bus")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {}, allowCredentials = "true")
public class BusController {

    @Autowired
    private BusImpl busImpl;

    @RequestMapping("/all")
    @ResponseBody
    public Object selectAll() {
        System.out.println("bus/all");
        List<Bus> buses = busImpl.queryBus();
        if (buses != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", buses.size(), buses));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/busmsg")
    @ResponseBody
    public Object selectBusMsg(String linesId) {
        System.out.println("bus/busmsg");
        List<BusMsg> busMsgs = busImpl.queryBusMsg(linesId);
        if (busMsgs != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", busMsgs.size(), busMsgs));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/busOrder")
    @ResponseBody
    public Object selectBusOrder(String userId) {
        System.out.println("bus/busOrder");
        List<BusOrder> busOrders = busImpl.queryBusOrder(userId);
        if (busOrders != null) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", busOrders.size(), busOrders));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/setBusOrder")
    @ResponseBody
    public Object addBusOrder(BusOrder busOrder) {
        System.out.println("bus/setBusOrder");
        int i = busImpl.addBusOrder(busOrder);
        if (i == 1) {
            return JSONObject.toJSON(new ReturnObject(200, "操作成功", 1, busOrder));
        } else {
            return JSONObject.toJSON(new ReturnObject(500, "操作失败"));
        }
    }

    @RequestMapping("/busbyId")
    @ResponseBody
    public Object selectBusById(String lineId) {
        System.out.println("bus/busbyId");
        Bus bus = busImpl.queryBusById(lineId);
        if (bus != null) {
            return JSONObject.toJSON(bus);
        } else {
            return JSONObject.toJSON(new ReturnObject(200, "操作失败"));
        }
    }




}
