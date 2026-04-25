package com.dao;

import com.entity.DiscusschuangyeziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusschuangyeziyuanVO;
import com.entity.view.DiscusschuangyeziyuanView;


/**
 * 创业资源评论
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:53
 */
public interface DiscusschuangyeziyuanDao extends BaseMapper<DiscusschuangyeziyuanEntity> {
	
	List<DiscusschuangyeziyuanVO> selectListVO(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);
	
	DiscusschuangyeziyuanVO selectVO(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);
	
	List<DiscusschuangyeziyuanView> selectListView(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);

	List<DiscusschuangyeziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);

	
	DiscusschuangyeziyuanView selectView(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);
	

}
