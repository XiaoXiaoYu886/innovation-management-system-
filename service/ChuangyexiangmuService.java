package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuangyexiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuangyexiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangyexiangmuView;


/**
 * 创业项目
 *
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChuangyexiangmuService extends IService<ChuangyexiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangyexiangmuVO> selectListVO(Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	ChuangyexiangmuVO selectVO(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	List<ChuangyexiangmuView> selectListView(Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	ChuangyexiangmuView selectView(@Param("ew") Wrapper<ChuangyexiangmuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<ChuangyexiangmuEntity> wrapper);



}

