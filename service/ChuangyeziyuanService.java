package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ChuangyeziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ChuangyeziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangyeziyuanView;


/**
 * 创业资源
 *
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
public interface ChuangyeziyuanService extends IService<ChuangyeziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ChuangyeziyuanVO> selectListVO(Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	ChuangyeziyuanVO selectVO(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	List<ChuangyeziyuanView> selectListView(Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	ChuangyeziyuanView selectView(@Param("ew") Wrapper<ChuangyeziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ChuangyeziyuanEntity> wrapper);

   	

}

