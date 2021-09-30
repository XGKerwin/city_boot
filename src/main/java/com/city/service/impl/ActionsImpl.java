package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.bean.Actioncommit;
import com.city.bean.Actions;
import com.city.mapper.ActioncommitMapper;
import com.city.mapper.ActionsMapper;
import com.city.service.base.ActionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/29 17:49 星期三
 * @Description com.city.service.impl
 */
@Service
public class ActionsImpl extends ServiceImpl<ActionsMapper, Actions> implements ActionsService {

    @Autowired
    private ActionsMapper actionsMapper;

    @Autowired
    private ActioncommitMapper actioncommitMapper;

    public List<Actions> queryActions() {
        return actionsMapper.selectList(new QueryWrapper<>());
    }

    public Actions queryById(String id) {
        QueryWrapper<Actions> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return actionsMapper.selectOne(wrapper);
    }

    public List<Actioncommit> queryCommit(String id) {
        QueryWrapper<Actioncommit> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return actioncommitMapper.selectList(wrapper);
    }

    public int addCommit(Actioncommit actioncommit) {
        return actioncommitMapper.insert(actioncommit);
    }

    public int upCount(Actions actions) {
        return actionsMapper.updateById(actions);
    }


}
