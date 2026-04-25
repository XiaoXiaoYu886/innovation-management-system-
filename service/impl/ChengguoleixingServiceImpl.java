package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ChengguoleixingDao;
import com.entity.ChengguoleixingEntity;
import com.service.ChengguoleixingService;
import com.entity.vo.ChengguoleixingVO;
import com.entity.view.ChengguoleixingView;

@Service("chengguoleixingService")
public class ChengguoleixingServiceImpl extends ServiceImpl<ChengguoleixingDao, ChengguoleixingEntity> implements ChengguoleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChengguoleixingEntity> page = this.selectPage(
                new Query<ChengguoleixingEntity>(params).getPage(),
                new EntityWrapper<ChengguoleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChengguoleixingEntity> wrapper) {
		  Page<ChengguoleixingView> page =new Query<ChengguoleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChengguoleixingVO> selectListVO(Wrapper<ChengguoleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChengguoleixingVO selectVO(Wrapper<ChengguoleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChengguoleixingView> selectListView(Wrapper<ChengguoleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChengguoleixingView selectView(Wrapper<ChengguoleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
