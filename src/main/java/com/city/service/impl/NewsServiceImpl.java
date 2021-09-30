package com.city.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.city.bean.News;
import com.city.mapper.NewsMapper;
import com.city.service.base.NewsService;
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
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    public List<News> selectNews() {
        List<News> newsList = newsMapper.selectList(new QueryWrapper());
        return newsList;
    }

    public List<News> selectThem(String theme){
        QueryWrapper<News> wrapper = new QueryWrapper<>();
        wrapper.eq("theme",theme);
        List<News> newsList = newsMapper.selectList(wrapper);
        return newsList;
    }


}
