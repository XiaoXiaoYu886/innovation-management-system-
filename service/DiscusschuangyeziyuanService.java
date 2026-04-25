package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusschuangyeziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusschuangyeziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusschuangyeziyuanView;


/**
 * 创业资源评论
 *
 * @author 
 * @email 
 * @date 2026-03-06 23:32:53
 */
public interface DiscusschuangyeziyuanService extends IService<DiscusschuangyeziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusschuangyeziyuanVO> selectListVO(Wrapper<DiscusschuangyeziyuanEntity> wrapper);
   	
   	DiscusschuangyeziyuanVO selectVO(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);
   	
   	List<DiscusschuangyeziyuanView> selectListView(Wrapper<DiscusschuangyeziyuanEntity> wrapper);
   	
   	DiscusschuangyeziyuanView selectView(@Param("ew") Wrapper<DiscusschuangyeziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusschuangyeziyuanEntity> wrapper);

   	

}

