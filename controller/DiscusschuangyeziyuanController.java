package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import com.utils.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusschuangyeziyuanEntity;
import com.entity.view.DiscusschuangyeziyuanView;

import com.service.DiscusschuangyeziyuanService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 创业资源评论
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:53
 */
@RestController
@RequestMapping("/discusschuangyeziyuan")
public class DiscusschuangyeziyuanController {
    @Autowired
    private DiscusschuangyeziyuanService discusschuangyeziyuanService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusschuangyeziyuanEntity discusschuangyeziyuan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusschuangyeziyuanEntity> ew = new EntityWrapper<DiscusschuangyeziyuanEntity>();


        //查询结果
		PageUtils page = discusschuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschuangyeziyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }


    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusschuangyeziyuanEntity discusschuangyeziyuan,
                @RequestParam(required = false) Double thumbsupnumstart,
                @RequestParam(required = false) Double thumbsupnumend,
                @RequestParam(required = false) Double crazilynumstart,
                @RequestParam(required = false) Double crazilynumend,
                @RequestParam(required = false) Double istopstart,
                @RequestParam(required = false) Double istopend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DiscusschuangyeziyuanEntity> ew = new EntityWrapper<DiscusschuangyeziyuanEntity>();
        if(thumbsupnumstart!=null) ew.ge("thumbsupnum", thumbsupnumstart);
        if(thumbsupnumend!=null) ew.le("thumbsupnum", thumbsupnumend);
        if(crazilynumstart!=null) ew.ge("crazilynum", crazilynumstart);
        if(crazilynumend!=null) ew.le("crazilynum", crazilynumend);
        if(istopstart!=null) ew.ge("istop", istopstart);
        if(istopend!=null) ew.le("istop", istopend);

        //查询结果
		PageUtils page = discusschuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschuangyeziyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusschuangyeziyuanEntity discusschuangyeziyuan){
       	EntityWrapper<DiscusschuangyeziyuanEntity> ew = new EntityWrapper<DiscusschuangyeziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusschuangyeziyuan, "discusschuangyeziyuan"));
        return R.ok().put("data", discusschuangyeziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusschuangyeziyuanEntity discusschuangyeziyuan){
        EntityWrapper< DiscusschuangyeziyuanEntity> ew = new EntityWrapper< DiscusschuangyeziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusschuangyeziyuan, "discusschuangyeziyuan"));
		DiscusschuangyeziyuanView discusschuangyeziyuanView =  discusschuangyeziyuanService.selectView(ew);
		return R.ok("查询创业资源评论成功").put("data", discusschuangyeziyuanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusschuangyeziyuanEntity discusschuangyeziyuan = discusschuangyeziyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusschuangyeziyuan,deSens);
        return R.ok().put("data", discusschuangyeziyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusschuangyeziyuanEntity discusschuangyeziyuan = discusschuangyeziyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(discusschuangyeziyuan,deSens);
        return R.ok().put("data", discusschuangyeziyuan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusschuangyeziyuanEntity discusschuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusschuangyeziyuan);
        discusschuangyeziyuanService.insert(discusschuangyeziyuan);
        return R.ok().put("data",discusschuangyeziyuan.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusschuangyeziyuanEntity discusschuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusschuangyeziyuan);
        discusschuangyeziyuanService.insert(discusschuangyeziyuan);
        return R.ok().put("data",discusschuangyeziyuan.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusschuangyeziyuanEntity discusschuangyeziyuan = discusschuangyeziyuanService.selectOne(new EntityWrapper<DiscusschuangyeziyuanEntity>().eq("", username));
        return R.ok().put("data", discusschuangyeziyuan);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusschuangyeziyuanEntity discusschuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusschuangyeziyuan);
        //全部更新
        discusschuangyeziyuanService.updateById(discusschuangyeziyuan);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusschuangyeziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusschuangyeziyuanEntity discusschuangyeziyuan, HttpServletRequest request,String pre){
        EntityWrapper<DiscusschuangyeziyuanEntity> ew = new EntityWrapper<DiscusschuangyeziyuanEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        // 组装参数
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");

		PageUtils page = discusschuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusschuangyeziyuan), params), params));
        return R.ok().put("data", page);
    }









}
