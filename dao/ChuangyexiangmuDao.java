package com.dao;

import com.entity.ChuangyexiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuangyexiangmuVO;
import com.entity.view.ChuangyexiangmuView;


/**
 * 创业项目
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChuangyexiangmuDao extends BaseMapper<ChuangyexiangmuEntity> {
	
	List<ChuangyexiangmuVO> selectListVO(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
	
	ChuangyexiangmuVO selectVO(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
	
	List<ChuangyexiangmuView> selectListView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

	List<ChuangyexiangmuView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

	
	ChuangyexiangmuView selectView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);



}
