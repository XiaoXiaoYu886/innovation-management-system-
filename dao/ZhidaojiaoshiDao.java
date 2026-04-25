package com.dao;

import com.entity.ZhidaojiaoshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhidaojiaoshiVO;
import com.entity.view.ZhidaojiaoshiView;


/**
 * 指导教师
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:50
 */
public interface ZhidaojiaoshiDao extends BaseMapper<ZhidaojiaoshiEntity> {
	
	List<ZhidaojiaoshiVO> selectListVO(@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);
	
	ZhidaojiaoshiVO selectVO(@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);
	
	List<ZhidaojiaoshiView> selectListView(@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);

	List<ZhidaojiaoshiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);

	
	ZhidaojiaoshiView selectView(@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ZhidaojiaoshiEntity> wrapper);



}
