package com.dao;

import com.entity.PingshenyijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingshenyijianVO;
import com.entity.view.PingshenyijianView;


/**
 * 评审意见
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface PingshenyijianDao extends BaseMapper<PingshenyijianEntity> {
	
	List<PingshenyijianVO> selectListVO(@Param("ew") Wrapper<PingshenyijianEntity> wrapper);
	
	PingshenyijianVO selectVO(@Param("ew") Wrapper<PingshenyijianEntity> wrapper);
	
	List<PingshenyijianView> selectListView(@Param("ew") Wrapper<PingshenyijianEntity> wrapper);

	List<PingshenyijianView> selectListView(Pagination page,@Param("ew") Wrapper<PingshenyijianEntity> wrapper);

	
	PingshenyijianView selectView(@Param("ew") Wrapper<PingshenyijianEntity> wrapper);
	

}
