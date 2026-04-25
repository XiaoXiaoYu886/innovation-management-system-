package com.dao;

import com.entity.YaoqingpingshenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YaoqingpingshenVO;
import com.entity.view.YaoqingpingshenView;


/**
 * 邀请评审
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface YaoqingpingshenDao extends BaseMapper<YaoqingpingshenEntity> {
	
	List<YaoqingpingshenVO> selectListVO(@Param("ew") Wrapper<YaoqingpingshenEntity> wrapper);
	
	YaoqingpingshenVO selectVO(@Param("ew") Wrapper<YaoqingpingshenEntity> wrapper);
	
	List<YaoqingpingshenView> selectListView(@Param("ew") Wrapper<YaoqingpingshenEntity> wrapper);

	List<YaoqingpingshenView> selectListView(Pagination page,@Param("ew") Wrapper<YaoqingpingshenEntity> wrapper);

	
	YaoqingpingshenView selectView(@Param("ew") Wrapper<YaoqingpingshenEntity> wrapper);
	

}
