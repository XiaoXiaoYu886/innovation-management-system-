package com.dao;

import com.entity.ShezhizhiweiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShezhizhiweiVO;
import com.entity.view.ShezhizhiweiView;


/**
 * 设置职位
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
public interface ShezhizhiweiDao extends BaseMapper<ShezhizhiweiEntity> {
	
	List<ShezhizhiweiVO> selectListVO(@Param("ew") Wrapper<ShezhizhiweiEntity> wrapper);
	
	ShezhizhiweiVO selectVO(@Param("ew") Wrapper<ShezhizhiweiEntity> wrapper);
	
	List<ShezhizhiweiView> selectListView(@Param("ew") Wrapper<ShezhizhiweiEntity> wrapper);

	List<ShezhizhiweiView> selectListView(Pagination page,@Param("ew") Wrapper<ShezhizhiweiEntity> wrapper);

	
	ShezhizhiweiView selectView(@Param("ew") Wrapper<ShezhizhiweiEntity> wrapper);
	

}
