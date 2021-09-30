package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.NewComment;
import com.city.mapper.NewCommentMapper;
import com.city.service.base.NewCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
@Service
public class NewCommentServiceImpl extends ServiceImpl<NewCommentMapper, NewComment> implements NewCommentService {

    @Autowired
    private NewCommentMapper newCommentMapper;

    public List<NewComment> selectAllId(String pressId) {
        QueryWrapper<NewComment> wrapper = new QueryWrapper<>();
        wrapper.eq("pressId", pressId);
        return newCommentMapper.selectList(wrapper);
    }

    public int insertAdd(String userId, String pressId, String content) {
        int insert = newCommentMapper.insert(new NewComment(userId, pressId, content));
        if (insert == 1) {
            return 1;
        }else {
            return 0;
        }
    }

}
