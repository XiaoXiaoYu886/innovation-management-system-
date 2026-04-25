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


import com.dao.ChuangyexiangmuDao;
import com.entity.ChuangyexiangmuEntity;
import com.service.ChuangyexiangmuService;
import com.entity.vo.ChuangyexiangmuVO;
import com.entity.view.ChuangyexiangmuView;

@Service("chuangyexiangmuService")
public class ChuangyexiangmuServiceImpl extends ServiceImpl<ChuangyexiangmuDao, ChuangyexiangmuEntity> implements ChuangyexiangmuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangyexiangmuEntity> page = this.selectPage(
                new Query<ChuangyexiangmuEntity>(params).getPage(),
                new EntityWrapper<ChuangyexiangmuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
		  Page<ChuangyexiangmuView> page =new Query<ChuangyexiangmuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChuangyexiangmuVO> selectListVO(Wrapper<ChuangyexiangmuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuangyexiangmuVO selectVO(Wrapper<ChuangyexiangmuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuangyexiangmuView> selectListView(Wrapper<ChuangyexiangmuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangyexiangmuView selectView(Wrapper<ChuangyexiangmuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<ChuangyexiangmuEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
