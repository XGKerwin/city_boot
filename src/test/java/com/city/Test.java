package com.city;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.User;
import com.city.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/18 8:44 星期六
 * @Description com.city
 */
@Controller
public class Test {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @org.junit.jupiter.api.Test
    public void Test1(){
        QueryWrapper<User> wrapper = new QueryWrapper();
        wrapper.eq("username","uzi");
        List<User> userList = userMapper.selectList(wrapper);
        System.out.println(userList);
    }

}
