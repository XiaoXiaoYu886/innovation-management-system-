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

import com.entity.ChengguoleixingEntity;
import com.entity.view.ChengguoleixingView;

import com.service.ChengguoleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 成果类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
@RestController
@RequestMapping("/chengguoleixing")
public class ChengguoleixingController {
    @Autowired
    private ChengguoleixingService chengguoleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengguoleixingEntity chengguoleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChengguoleixingEntity> ew = new EntityWrapper<ChengguoleixingEntity>();


        //查询结果
		PageUtils page = chengguoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengguoleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChengguoleixingEntity chengguoleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChengguoleixingEntity> ew = new EntityWrapper<ChengguoleixingEntity>();

        //查询结果
		PageUtils page = chengguoleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengguoleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengguoleixingEntity chengguoleixing){
       	EntityWrapper<ChengguoleixingEntity> ew = new EntityWrapper<ChengguoleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengguoleixing, "chengguoleixing"));
        return R.ok().put("data", chengguoleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengguoleixingEntity chengguoleixing){
        EntityWrapper< ChengguoleixingEntity> ew = new EntityWrapper< ChengguoleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengguoleixing, "chengguoleixing"));
		ChengguoleixingView chengguoleixingView =  chengguoleixingService.selectView(ew);
		return R.ok("查询成果类型成功").put("data", chengguoleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengguoleixingEntity chengguoleixing = chengguoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chengguoleixing,deSens);
        return R.ok().put("data", chengguoleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengguoleixingEntity chengguoleixing = chengguoleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chengguoleixing,deSens);
        return R.ok().put("data", chengguoleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengguoleixingEntity chengguoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengguoleixing);
        chengguoleixingService.insert(chengguoleixing);
        return R.ok().put("data",chengguoleixing.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengguoleixingEntity chengguoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengguoleixing);
        chengguoleixingService.insert(chengguoleixing);
        return R.ok().put("data",chengguoleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengguoleixingEntity chengguoleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengguoleixing);
        //全部更新
        chengguoleixingService.updateById(chengguoleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengguoleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
