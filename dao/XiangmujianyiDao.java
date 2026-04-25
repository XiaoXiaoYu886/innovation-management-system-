package com.dao;

import com.entity.XiangmujianyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmujianyiVO;
import com.entity.view.XiangmujianyiView;


/**
 * 项目建议
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
public interface XiangmujianyiDao extends BaseMapper<XiangmujianyiEntity> {
	
	List<XiangmujianyiVO> selectListVO(@Param("ew") Wrapper<XiangmujianyiEntity> wrapper);
	
	XiangmujianyiVO selectVO(@Param("ew") Wrapper<XiangmujianyiEntity> wrapper);
	
	List<XiangmujianyiView> selectListView(@Param("ew") Wrapper<XiangmujianyiEntity> wrapper);

	List<XiangmujianyiView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmujianyiEntity> wrapper);

	
	XiangmujianyiView selectView(@Param("ew") Wrapper<XiangmujianyiEntity> wrapper);
	

}
