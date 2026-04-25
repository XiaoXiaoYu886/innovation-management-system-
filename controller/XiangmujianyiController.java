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

import com.entity.XiangmujianyiEntity;
import com.entity.view.XiangmujianyiView;

import com.service.XiangmujianyiService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 项目建议
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
@RestController
@RequestMapping("/xiangmujianyi")
public class XiangmujianyiController {
    @Autowired
    private XiangmujianyiService xiangmujianyiService;










    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XiangmujianyiEntity xiangmujianyi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			xiangmujianyi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<XiangmujianyiEntity> ew = new EntityWrapper<XiangmujianyiEntity>();


        //查询结果
		PageUtils page = xiangmujianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujianyi), params), params));
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
    public R list(@RequestParam Map<String, Object> params,XiangmujianyiEntity xiangmujianyi,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyiriqistart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date jianyiriqiend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<XiangmujianyiEntity> ew = new EntityWrapper<XiangmujianyiEntity>();
        if(jianyiriqistart!=null) ew.ge("jianyiriqi", jianyiriqistart);
        if(jianyiriqiend!=null) ew.le("jianyiriqi", jianyiriqiend);

        //查询结果
		PageUtils page = xiangmujianyiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xiangmujianyi), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XiangmujianyiEntity xiangmujianyi){
       	EntityWrapper<XiangmujianyiEntity> ew = new EntityWrapper<XiangmujianyiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xiangmujianyi, "xiangmujianyi"));
        return R.ok().put("data", xiangmujianyiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XiangmujianyiEntity xiangmujianyi){
        EntityWrapper< XiangmujianyiEntity> ew = new EntityWrapper< XiangmujianyiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xiangmujianyi, "xiangmujianyi"));
		XiangmujianyiView xiangmujianyiView =  xiangmujianyiService.selectView(ew);
		return R.ok("查询项目建议成功").put("data", xiangmujianyiView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XiangmujianyiEntity xiangmujianyi = xiangmujianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiangmujianyi,deSens);
        return R.ok().put("data", xiangmujianyi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XiangmujianyiEntity xiangmujianyi = xiangmujianyiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(xiangmujianyi,deSens);
        return R.ok().put("data", xiangmujianyi);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XiangmujianyiEntity xiangmujianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujianyi);
        xiangmujianyiService.insert(xiangmujianyi);
        return R.ok().put("data",xiangmujianyi.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XiangmujianyiEntity xiangmujianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujianyi);
        xiangmujianyiService.insert(xiangmujianyi);
        return R.ok().put("data",xiangmujianyi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XiangmujianyiEntity xiangmujianyi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xiangmujianyi);
        //全部更新
        xiangmujianyiService.updateById(xiangmujianyi);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xiangmujianyiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
