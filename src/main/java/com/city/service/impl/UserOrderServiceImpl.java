package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.UserOrder;
import com.city.mapper.UserOrderMapper;
import com.city.service.base.UserOrderService;
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
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    public List<UserOrder> selectUserOrder(){
        return userOrderMapper.selectList(new QueryWrapper<>());
    }

    public UserOrder selectId(String id){
        QueryWrapper<UserOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return userOrderMapper.selectOne(wrapper);
    }
}
