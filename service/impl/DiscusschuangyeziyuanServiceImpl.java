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


import com.dao.DiscusschuangyeziyuanDao;
import com.entity.DiscusschuangyeziyuanEntity;
import com.service.DiscusschuangyeziyuanService;
import com.entity.vo.DiscusschuangyeziyuanVO;
import com.entity.view.DiscusschuangyeziyuanView;

@Service("discusschuangyeziyuanService")
public class DiscusschuangyeziyuanServiceImpl extends ServiceImpl<DiscusschuangyeziyuanDao, DiscusschuangyeziyuanEntity> implements DiscusschuangyeziyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusschuangyeziyuanEntity> page = this.selectPage(
                new Query<DiscusschuangyeziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscusschuangyeziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusschuangyeziyuanEntity> wrapper) {
		  Page<DiscusschuangyeziyuanView> page =new Query<DiscusschuangyeziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusschuangyeziyuanVO> selectListVO(Wrapper<DiscusschuangyeziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusschuangyeziyuanVO selectVO(Wrapper<DiscusschuangyeziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusschuangyeziyuanView> selectListView(Wrapper<DiscusschuangyeziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusschuangyeziyuanView selectView(Wrapper<DiscusschuangyeziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
