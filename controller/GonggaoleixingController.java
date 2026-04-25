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

import com.entity.GonggaoleixingEntity;
import com.entity.view.GonggaoleixingView;

import com.service.GonggaoleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 公告类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:50
 */
@RestController
@RequestMapping("/gonggaoleixing")
public class GonggaoleixingController {
    @Autowired
    private GonggaoleixingService gonggaoleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,GonggaoleixingEntity gonggaoleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GonggaoleixingEntity> ew = new EntityWrapper<GonggaoleixingEntity>();


        //查询结果
		PageUtils page = gonggaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,GonggaoleixingEntity gonggaoleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<GonggaoleixingEntity> ew = new EntityWrapper<GonggaoleixingEntity>();

        //查询结果
		PageUtils page = gonggaoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, gonggaoleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( GonggaoleixingEntity gonggaoleixing){
       	EntityWrapper<GonggaoleixingEntity> ew = new EntityWrapper<GonggaoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( gonggaoleixing, "gonggaoleixing"));
        return R.ok().put("data", gonggaoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(GonggaoleixingEntity gonggaoleixing){
        EntityWrapper< GonggaoleixingEntity> ew = new EntityWrapper< GonggaoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( gonggaoleixing, "gonggaoleixing"));
		GonggaoleixingView gonggaoleixingView =  gonggaoleixingService.selectView(ew);
		return R.ok("查询公告类型成功").put("data", gonggaoleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        GonggaoleixingEntity gonggaoleixing = gonggaoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gonggaoleixing,deSens);
        return R.ok().put("data", gonggaoleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        GonggaoleixingEntity gonggaoleixing = gonggaoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(gonggaoleixing,deSens);
        return R.ok().put("data", gonggaoleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody GonggaoleixingEntity gonggaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoleixing);
        gonggaoleixingService.insert(gonggaoleixing);
        return R.ok().put("data",gonggaoleixing.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody GonggaoleixingEntity gonggaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoleixing);
        gonggaoleixingService.insert(gonggaoleixing);
        return R.ok().put("data",gonggaoleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody GonggaoleixingEntity gonggaoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(gonggaoleixing);
        //全部更新
        gonggaoleixingService.updateById(gonggaoleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        gonggaoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
