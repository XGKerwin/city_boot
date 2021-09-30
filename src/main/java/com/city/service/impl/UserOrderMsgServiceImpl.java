package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.UserOrderMsg;
import com.city.mapper.UserOrderMsgMapper;
import com.city.service.base.UserOrderMsgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
@Service
public class UserOrderMsgServiceImpl extends ServiceImpl<UserOrderMsgMapper, UserOrderMsg> implements UserOrderMsgService {

    @Autowired
    private UserOrderMsgMapper userOrderMsgMapper;

    public List<UserOrderMsg> userOrderMsgList(){
        List<UserOrderMsg> userOrderMsgs = userOrderMsgMapper.selectList(new QueryWrapper<>());
        return userOrderMsgs;
    }




}
