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

import com.entity.ZhishifenleiEntity;
import com.entity.view.ZhishifenleiView;

import com.service.ZhishifenleiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 知识分类
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
@RestController
@RequestMapping("/zhishifenlei")
public class ZhishifenleiController {
    @Autowired
    private ZhishifenleiService zhishifenleiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhishifenleiEntity zhishifenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();


        //查询结果
		PageUtils page = zhishifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishifenlei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhishifenleiEntity zhishifenlei,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();

        //查询结果
		PageUtils page = zhishifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishifenlei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhishifenleiEntity zhishifenlei){
       	EntityWrapper<ZhishifenleiEntity> ew = new EntityWrapper<ZhishifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhishifenlei, "zhishifenlei"));
        return R.ok().put("data", zhishifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhishifenleiEntity zhishifenlei){
        EntityWrapper< ZhishifenleiEntity> ew = new EntityWrapper< ZhishifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhishifenlei, "zhishifenlei"));
		ZhishifenleiView zhishifenleiView =  zhishifenleiService.selectView(ew);
		return R.ok("查询知识分类成功").put("data", zhishifenleiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhishifenleiEntity zhishifenlei = zhishifenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhishifenlei,deSens);
        return R.ok().put("data", zhishifenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhishifenleiEntity zhishifenlei = zhishifenleiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhishifenlei,deSens);
        return R.ok().put("data", zhishifenlei);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
        //ValidatorUtils.validateEntity(zhishifenlei);
        zhishifenleiService.insert(zhishifenlei);
        return R.ok().put("data",zhishifenlei.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
        //ValidatorUtils.validateEntity(zhishifenlei);
        zhishifenleiService.insert(zhishifenlei);
        return R.ok().put("data",zhishifenlei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhishifenleiEntity zhishifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishifenlei);
        //验证字段唯一性，否则返回错误信息
        if(zhishifenleiService.selectCount(new EntityWrapper<ZhishifenleiEntity>().ne("id", zhishifenlei.getId()).eq("zhishifenlei", zhishifenlei.getZhishifenlei()))>0) {
            return R.error("知识分类已存在");
        }
        //全部更新
        zhishifenleiService.updateById(zhishifenlei);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhishifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
