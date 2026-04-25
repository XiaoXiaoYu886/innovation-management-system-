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

import com.entity.YaoqingpingshenEntity;
import com.entity.view.YaoqingpingshenView;

import com.service.YaoqingpingshenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 邀请评审
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
@RestController
@RequestMapping("/yaoqingpingshen")
public class YaoqingpingshenController {
    @Autowired
    private YaoqingpingshenService yaoqingpingshenService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YaoqingpingshenEntity yaoqingpingshen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yaoqingpingshen.setXuehao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiye")) {
			yaoqingpingshen.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<YaoqingpingshenEntity> ew = new EntityWrapper<YaoqingpingshenEntity>();


        //查询结果
		PageUtils page = yaoqingpingshenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaoqingpingshen), params), params));
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
    public R list(@RequestParam Map<String, Object> params,YaoqingpingshenEntity yaoqingpingshen,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yaoqingshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date yaoqingshijianend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<YaoqingpingshenEntity> ew = new EntityWrapper<YaoqingpingshenEntity>();
        if(yaoqingshijianstart!=null) ew.ge("yaoqingshijian", yaoqingshijianstart);
        if(yaoqingshijianend!=null) ew.le("yaoqingshijian", yaoqingshijianend);

        //查询结果
		PageUtils page = yaoqingpingshenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yaoqingpingshen), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YaoqingpingshenEntity yaoqingpingshen){
       	EntityWrapper<YaoqingpingshenEntity> ew = new EntityWrapper<YaoqingpingshenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yaoqingpingshen, "yaoqingpingshen"));
        return R.ok().put("data", yaoqingpingshenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YaoqingpingshenEntity yaoqingpingshen){
        EntityWrapper< YaoqingpingshenEntity> ew = new EntityWrapper< YaoqingpingshenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yaoqingpingshen, "yaoqingpingshen"));
		YaoqingpingshenView yaoqingpingshenView =  yaoqingpingshenService.selectView(ew);
		return R.ok("查询邀请评审成功").put("data", yaoqingpingshenView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YaoqingpingshenEntity yaoqingpingshen = yaoqingpingshenService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yaoqingpingshen,deSens);
        return R.ok().put("data", yaoqingpingshen);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YaoqingpingshenEntity yaoqingpingshen = yaoqingpingshenService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(yaoqingpingshen,deSens);
        return R.ok().put("data", yaoqingpingshen);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YaoqingpingshenEntity yaoqingpingshen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaoqingpingshen);
        yaoqingpingshenService.insert(yaoqingpingshen);
        return R.ok().put("data",yaoqingpingshen.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YaoqingpingshenEntity yaoqingpingshen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaoqingpingshen);
        yaoqingpingshenService.insert(yaoqingpingshen);
        return R.ok().put("data",yaoqingpingshen.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YaoqingpingshenEntity yaoqingpingshen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yaoqingpingshen);
        //全部更新
        yaoqingpingshenService.updateById(yaoqingpingshen);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yaoqingpingshenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
