package com.dao;

import com.entity.XiangmuchengguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XiangmuchengguoVO;
import com.entity.view.XiangmuchengguoView;


/**
 * 项目成果
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
public interface XiangmuchengguoDao extends BaseMapper<XiangmuchengguoEntity> {
	
	List<XiangmuchengguoVO> selectListVO(@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);
	
	XiangmuchengguoVO selectVO(@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);
	
	List<XiangmuchengguoView> selectListView(@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);

	List<XiangmuchengguoView> selectListView(Pagination page,@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);

	
	XiangmuchengguoView selectView(@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<XiangmuchengguoEntity> wrapper);



}
