package com.dao;

import com.entity.XiangmushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmushenqingVO;
import com.entity.view.XiangmushenqingView;


/**
 * 项目申请
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
public interface XiangmushenqingDao extends BaseMapper<XiangmushenqingEntity> {
	
	List<XiangmushenqingVO> selectListVO(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	
	XiangmushenqingVO selectVO(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	
	List<XiangmushenqingView> selectListView(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);

	List<XiangmushenqingView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);

	
	XiangmushenqingView selectView(@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmushenqingEntity> wrapper);



}
