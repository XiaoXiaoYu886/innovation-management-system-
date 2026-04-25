package com.dao;

import com.entity.ZiyuanshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZiyuanshenqingVO;
import com.entity.view.ZiyuanshenqingView;


/**
 * 资源申请
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
public interface ZiyuanshenqingDao extends BaseMapper<ZiyuanshenqingEntity> {
	
	List<ZiyuanshenqingVO> selectListVO(@Param("ew") Wrapper<ZiyuanshenqingEntity> wrapper);
	
	ZiyuanshenqingVO selectVO(@Param("ew") Wrapper<ZiyuanshenqingEntity> wrapper);
	
	List<ZiyuanshenqingView> selectListView(@Param("ew") Wrapper<ZiyuanshenqingEntity> wrapper);

	List<ZiyuanshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanshenqingEntity> wrapper);

	
	ZiyuanshenqingView selectView(@Param("ew") Wrapper<ZiyuanshenqingEntity> wrapper);
	

}
