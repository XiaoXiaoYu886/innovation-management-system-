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

import com.entity.ShezhizhiweiEntity;
import com.entity.view.ShezhizhiweiView;

import com.service.ShezhizhiweiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 设置职位
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
@RestController
@RequestMapping("/shezhizhiwei")
public class ShezhizhiweiController {
    @Autowired
    private ShezhizhiweiService shezhizhiweiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShezhizhiweiEntity shezhizhiwei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShezhizhiweiEntity> ew = new EntityWrapper<ShezhizhiweiEntity>();


        //查询结果
		PageUtils page = shezhizhiweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shezhizhiwei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShezhizhiweiEntity shezhizhiwei,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shezhishijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date shezhishijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShezhizhiweiEntity> ew = new EntityWrapper<ShezhizhiweiEntity>();
        if(shezhishijianstart!=null) ew.ge("shezhishijian", shezhishijianstart);
        if(shezhishijianend!=null) ew.le("shezhishijian", shezhishijianend);

        //查询结果
		PageUtils page = shezhizhiweiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shezhizhiwei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShezhizhiweiEntity shezhizhiwei){
       	EntityWrapper<ShezhizhiweiEntity> ew = new EntityWrapper<ShezhizhiweiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shezhizhiwei, "shezhizhiwei"));
        return R.ok().put("data", shezhizhiweiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShezhizhiweiEntity shezhizhiwei){
        EntityWrapper< ShezhizhiweiEntity> ew = new EntityWrapper< ShezhizhiweiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shezhizhiwei, "shezhizhiwei"));
		ShezhizhiweiView shezhizhiweiView =  shezhizhiweiService.selectView(ew);
		return R.ok("查询设置职位成功").put("data", shezhizhiweiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShezhizhiweiEntity shezhizhiwei = shezhizhiweiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shezhizhiwei,deSens);
        return R.ok().put("data", shezhizhiwei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShezhizhiweiEntity shezhizhiwei = shezhizhiweiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shezhizhiwei,deSens);
        return R.ok().put("data", shezhizhiwei);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShezhizhiweiEntity shezhizhiwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shezhizhiwei);
        shezhizhiweiService.insert(shezhizhiwei);
        return R.ok().put("data",shezhizhiwei.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShezhizhiweiEntity shezhizhiwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shezhizhiwei);
        shezhizhiweiService.insert(shezhizhiwei);
        return R.ok().put("data",shezhizhiwei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShezhizhiweiEntity shezhizhiwei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shezhizhiwei);
        //全部更新
        shezhizhiweiService.updateById(shezhizhiwei);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shezhizhiweiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
