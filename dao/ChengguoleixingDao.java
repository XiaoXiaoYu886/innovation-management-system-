package com.dao;

import com.entity.ChengguoleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChengguoleixingVO;
import com.entity.view.ChengguoleixingView;


/**
 * 成果类型
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChengguoleixingDao extends BaseMapper<ChengguoleixingEntity> {
	
	List<ChengguoleixingVO> selectListVO(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);
	
	ChengguoleixingVO selectVO(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);
	
	List<ChengguoleixingView> selectListView(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);

	List<ChengguoleixingView> selectListView(Pagination page,@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);

	
	ChengguoleixingView selectView(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);
	

}
