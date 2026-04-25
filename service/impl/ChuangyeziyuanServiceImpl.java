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


import com.dao.ChuangyeziyuanDao;
import com.entity.ChuangyeziyuanEntity;
import com.service.ChuangyeziyuanService;
import com.entity.vo.ChuangyeziyuanVO;
import com.entity.view.ChuangyeziyuanView;

@Service("chuangyeziyuanService")
public class ChuangyeziyuanServiceImpl extends ServiceImpl<ChuangyeziyuanDao, ChuangyeziyuanEntity> implements ChuangyeziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ChuangyeziyuanEntity> page = this.selectPage(
                new Query<ChuangyeziyuanEntity>(params).getPage(),
                new EntityWrapper<ChuangyeziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ChuangyeziyuanEntity> wrapper) {
		  Page<ChuangyeziyuanView> page =new Query<ChuangyeziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ChuangyeziyuanVO> selectListVO(Wrapper<ChuangyeziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ChuangyeziyuanVO selectVO(Wrapper<ChuangyeziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ChuangyeziyuanView> selectListView(Wrapper<ChuangyeziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ChuangyeziyuanView selectView(Wrapper<ChuangyeziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
