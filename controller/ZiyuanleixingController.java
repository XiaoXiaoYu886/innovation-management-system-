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

import com.entity.ZiyuanleixingEntity;
import com.entity.view.ZiyuanleixingView;

import com.service.ZiyuanleixingService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源类型
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
@RestController
@RequestMapping("/ziyuanleixing")
public class ZiyuanleixingController {
    @Autowired
    private ZiyuanleixingService ziyuanleixingService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZiyuanleixingEntity ziyuanleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();


        //查询结果
		PageUtils page = ziyuanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanleixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZiyuanleixingEntity ziyuanleixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();

        //查询结果
		PageUtils page = ziyuanleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ziyuanleixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZiyuanleixingEntity ziyuanleixing){
       	EntityWrapper<ZiyuanleixingEntity> ew = new EntityWrapper<ZiyuanleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ziyuanleixing, "ziyuanleixing"));
        return R.ok().put("data", ziyuanleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZiyuanleixingEntity ziyuanleixing){
        EntityWrapper< ZiyuanleixingEntity> ew = new EntityWrapper< ZiyuanleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ziyuanleixing, "ziyuanleixing"));
		ZiyuanleixingView ziyuanleixingView =  ziyuanleixingService.selectView(ew);
		return R.ok("查询资源类型成功").put("data", ziyuanleixingView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZiyuanleixingEntity ziyuanleixing = ziyuanleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziyuanleixing,deSens);
        return R.ok().put("data", ziyuanleixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZiyuanleixingEntity ziyuanleixing = ziyuanleixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(ziyuanleixing,deSens);
        return R.ok().put("data", ziyuanleixing);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(ziyuanleixingService.selectCount(new EntityWrapper<ZiyuanleixingEntity>().eq("ziyuanleixing", ziyuanleixing.getZiyuanleixing()))>0) {
            return R.error("资源类型已存在");
        }
        //ValidatorUtils.validateEntity(ziyuanleixing);
        ziyuanleixingService.insert(ziyuanleixing);
        return R.ok().put("data",ziyuanleixing.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(ziyuanleixingService.selectCount(new EntityWrapper<ZiyuanleixingEntity>().eq("ziyuanleixing", ziyuanleixing.getZiyuanleixing()))>0) {
            return R.error("资源类型已存在");
        }
        //ValidatorUtils.validateEntity(ziyuanleixing);
        ziyuanleixingService.insert(ziyuanleixing);
        return R.ok().put("data",ziyuanleixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZiyuanleixingEntity ziyuanleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ziyuanleixing);
        //验证字段唯一性，否则返回错误信息
        if(ziyuanleixingService.selectCount(new EntityWrapper<ZiyuanleixingEntity>().ne("id", ziyuanleixing.getId()).eq("ziyuanleixing", ziyuanleixing.getZiyuanleixing()))>0) {
            return R.error("资源类型已存在");
        }
        //全部更新
        ziyuanleixingService.updateById(ziyuanleixing);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ziyuanleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
