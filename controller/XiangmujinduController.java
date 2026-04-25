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

import com.entity.XiangmujinduEntity;
import com.entity.view.XiangmujinduView;

import com.service.XiangmujinduService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 项目进度
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
@RestController
@RequestMapping("/xiangmujindu")
public class XiangmujinduController {
    @Autowired
    private XiangmujinduService xiangmujinduService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmujinduEntity xiangmujindu,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();


        //查询结果
		PageUtils page = xiangmujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujindu), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XiangmujinduEntity xiangmujindu,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date dengjiriqiend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();
        if(dengjiriqistart!=null) ew.ge("dengjiriqi", dengjiriqistart);
        if(dengjiriqiend!=null) ew.le("dengjiriqi", dengjiriqiend);

        //查询结果
		PageUtils page = xiangmujinduService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujindu), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmujinduEntity xiangmujindu){
       	EntityWrapper<XiangmujinduEntity> ew = new EntityWrapper<XiangmujinduEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmujindu, "xiangmujindu"));
        return R.ok().put("data", xiangmujinduService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmujinduEntity xiangmujindu){
        EntityWrapper< XiangmujinduEntity> ew = new EntityWrapper< XiangmujinduEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmujindu, "xiangmujindu"));
		XiangmujinduView xiangmujinduView =  xiangmujinduService.selectView(ew);
		return R.ok("查询项目进度成功").put("data", xiangmujinduView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmujinduEntity xiangmujindu = xiangmujinduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiangmujindu,deSens);
        return R.ok().put("data", xiangmujindu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmujinduEntity xiangmujindu = xiangmujinduService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiangmujindu,deSens);
        return R.ok().put("data", xiangmujindu);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujindu);
        xiangmujinduService.insert(xiangmujindu);
        return R.ok().put("data",xiangmujindu.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujindu);
        xiangmujinduService.insert(xiangmujindu);
        return R.ok().put("data",xiangmujindu.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmujinduEntity xiangmujindu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujindu);
        //全部更新
        xiangmujinduService.updateById(xiangmujindu);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmujinduService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
