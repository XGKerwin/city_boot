package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.city.bean.Livingpayment;
import com.city.bean.LivingpaymentType;
import com.city.mapper.LivingpaymentMapper;
import com.city.mapper.LivingpaymentTypeMapper;
import com.city.service.base.LivingpaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 关鑫
 * @date 2021/9/28 7:49 星期二
 * @Description com.city.service.impl
 */
@Service
public class LivingExpensesImpl extends ServiceImpl<LivingpaymentMapper, Livingpayment> implements LivingpaymentService {

    @Autowired
    private LivingpaymentMapper livingpaymentMapper;

    @Autowired
    private LivingpaymentTypeMapper livingpaymentTypeMapper;

    public List<Livingpayment> queryLiveName(String userId, String liveName){
        QueryWrapper<Livingpayment> wrapper = new QueryWrapper<>();
        wrapper.eq("userId",userId);
        wrapper.eq("liveName",liveName);
        return livingpaymentMapper.selectList(wrapper);
    }

    public int insertLivingPaymentType(String userid,String typeName){
        int insert = livingpaymentTypeMapper.insert(new LivingpaymentType(userid, typeName));
        if (insert==1){
            return 1;
        }else {
            return 0;
        }
    }

    public List<LivingpaymentType> queryUserid(String userid){
        QueryWrapper<LivingpaymentType> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",userid);
        return livingpaymentTypeMapper.selectList(wrapper);
    }

}
