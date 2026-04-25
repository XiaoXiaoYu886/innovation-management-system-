package com.dao;

import com.entity.ChuangyeziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ChuangyeziyuanVO;
import com.entity.view.ChuangyeziyuanView;


/**
 * 创业资源
 * 
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChuangyeziyuanDao extends BaseMapper<ChuangyeziyuanEntity> {
	
	List<ChuangyeziyuanVO> selectListVO(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
	
	ChuangyeziyuanVO selectVO(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
	
	List<ChuangyeziyuanView> selectListView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);

	List<ChuangyeziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);

	
	ChuangyeziyuanView selectView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
	

}
