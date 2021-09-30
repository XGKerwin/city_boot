package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.UserOpinion;
import com.city.mapper.UserOpinionMapper;
import com.city.service.base.UserOpinionService;
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
public class UserOpinionServiceImpl extends ServiceImpl<UserOpinionMapper, UserOpinion> implements UserOpinionService {

    @Autowired
    private UserOpinionMapper userOpinionMapper;

    public List<UserOpinion> selectUserOpinions(){
        List<UserOpinion> userOpinions = userOpinionMapper.selectList(new QueryWrapper<>());
        return userOpinions;
    }

    public int addUserOpinion(UserOpinion userOpinion){
        return userOpinionMapper.insert(userOpinion);
    }



}
