package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.bean.User;
import com.city.bean.Violation;
import com.city.bean.ViolationPlate;
import com.city.bean.ViolationType;
import com.city.mapper.UserMapper;
import com.city.mapper.ViolationMapper;
import com.city.mapper.ViolationPlateMapper;
import com.city.mapper.ViolationTypeMapper;
import com.city.service.base.UserService;
import com.city.service.base.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/29 17:21 星期三
 * @Description com.city.service.impl
 */
@Service
public class ViolationImpl extends ServiceImpl<ViolationMapper, Violation> implements ViolationService {

    @Autowired
    private ViolationMapper violationMapper;

    @Autowired
    private ViolationTypeMapper violationTypeMapper;

    @Autowired
    private ViolationPlateMapper violationPlateMapper;

    public List<Violation> queryViolations(String licencePlate,String engineNumber,String catType){
        QueryWrapper<Violation> wrapper = new QueryWrapper<>();
        wrapper.eq("licencePlate",licencePlate);
        wrapper.eq("engineNumber",engineNumber);
        wrapper.eq("catType",catType);
        return violationMapper.selectList(wrapper);
    }

    public List<ViolationType> queryViolationTypes(){
        return violationTypeMapper.selectList(new QueryWrapper<>());
    }

    public List<ViolationPlate> queryViolationPlate(){
        return violationPlateMapper.selectList(new QueryWrapper<>());
    }


}
