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

import com.entity.ZhishikuEntity;
import com.entity.view.ZhishikuView;

import com.service.ZhishikuService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 知识库
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:52
 */
@RestController
@RequestMapping("/zhishiku")
public class ZhishikuController {
    @Autowired
    private ZhishikuService zhishikuService;

    @Autowired
    private StoreupService storeupService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhishikuEntity zhishiku,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhishikuEntity> ew = new EntityWrapper<ZhishikuEntity>();


        //查询结果
		PageUtils page = zhishikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishiku), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ZhishikuEntity zhishiku,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fabushijianend,
                @RequestParam(required = false) Double storeupnumstart,
                @RequestParam(required = false) Double storeupnumend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ZhishikuEntity> ew = new EntityWrapper<ZhishikuEntity>();
        if(fabushijianstart!=null) ew.ge("fabushijian", fabushijianstart);
        if(fabushijianend!=null) ew.le("fabushijian", fabushijianend);
        if(storeupnumstart!=null) ew.ge("storeupnum", storeupnumstart);
        if(storeupnumend!=null) ew.le("storeupnum", storeupnumend);

        //查询结果
		PageUtils page = zhishikuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhishiku), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhishikuEntity zhishiku){
       	EntityWrapper<ZhishikuEntity> ew = new EntityWrapper<ZhishikuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhishiku, "zhishiku"));
        return R.ok().put("data", zhishikuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhishikuEntity zhishiku){
        EntityWrapper< ZhishikuEntity> ew = new EntityWrapper< ZhishikuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhishiku, "zhishiku"));
		ZhishikuView zhishikuView =  zhishikuService.selectView(ew);
		return R.ok("查询知识库成功").put("data", zhishikuView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhishikuEntity zhishiku = zhishikuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhishiku,deSens);
        return R.ok().put("data", zhishiku);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhishikuEntity zhishiku = zhishikuService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(zhishiku,deSens);
        return R.ok().put("data", zhishiku);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZhishikuEntity zhishiku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishiku);
        zhishikuService.insert(zhishiku);
        return R.ok().put("data",zhishiku.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZhishikuEntity zhishiku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishiku);
        zhishikuService.insert(zhishiku);
        return R.ok().put("data",zhishiku.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZhishikuEntity zhishiku, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhishiku);
        //全部更新
        zhishikuService.updateById(zhishiku);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zhishikuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }










}
