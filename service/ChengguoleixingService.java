package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChengguoleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChengguoleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengguoleixingView;


/**
 * 成果类型
 *
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChengguoleixingService extends IService<ChengguoleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChengguoleixingVO> selectListVO(Wrapper<ChengguoleixingEntity> wrapper);
   	
   	ChengguoleixingVO selectVO(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);
   	
   	List<ChengguoleixingView> selectListView(Wrapper<ChengguoleixingEntity> wrapper);
   	
   	ChengguoleixingView selectView(@Param("ew") Wrapper<ChengguoleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChengguoleixingEntity> wrapper);

   	

}

