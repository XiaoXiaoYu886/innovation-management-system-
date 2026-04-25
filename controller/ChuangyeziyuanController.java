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

import com.entity.ChuangyeziyuanEntity;
import com.entity.view.ChuangyeziyuanView;

import com.service.ChuangyeziyuanService;
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
 * 创业资源
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:51
 */
@RestController
@RequestMapping("/chuangyeziyuan")
public class ChuangyeziyuanController {
    @Autowired
    private ChuangyeziyuanService chuangyeziyuanService;

    @Autowired
    private StoreupService storeupService;









    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qiye")) {
			chuangyeziyuan.setQiyemingcheng((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();


        //查询结果
		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date gengxinshijianstart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date gengxinshijianend,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date clicktimestart,
                @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") Date clicktimeend,
                @RequestParam(required = false) Double clicknumstart,
                @RequestParam(required = false) Double clicknumend,
                @RequestParam(required = false) Double discussnumstart,
                @RequestParam(required = false) Double discussnumend,
                @RequestParam(required = false) Double storeupnumstart,
                @RequestParam(required = false) Double storeupnumend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
        if(gengxinshijianstart!=null) ew.ge("gengxinshijian", gengxinshijianstart);
        if(gengxinshijianend!=null) ew.le("gengxinshijian", gengxinshijianend);
        if(clicktimestart!=null) ew.ge("clicktime", clicktimestart);
        if(clicktimeend!=null) ew.le("clicktime", clicktimeend);
        if(clicknumstart!=null) ew.ge("clicknum", clicknumstart);
        if(clicknumend!=null) ew.le("clicknum", clicknumend);
        if(discussnumstart!=null) ew.ge("discussnum", discussnumstart);
        if(discussnumend!=null) ew.le("discussnum", discussnumend);
        if(storeupnumstart!=null) ew.ge("storeupnum", storeupnumstart);
        if(storeupnumend!=null) ew.le("storeupnum", storeupnumend);

        //查询结果
		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChuangyeziyuanEntity chuangyeziyuan){
       	EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chuangyeziyuan, "chuangyeziyuan"));
        return R.ok().put("data", chuangyeziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChuangyeziyuanEntity chuangyeziyuan){
        EntityWrapper< ChuangyeziyuanEntity> ew = new EntityWrapper< ChuangyeziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chuangyeziyuan, "chuangyeziyuan"));
		ChuangyeziyuanView chuangyeziyuanView =  chuangyeziyuanService.selectView(ew);
		return R.ok("查询创业资源成功").put("data", chuangyeziyuanView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChuangyeziyuanEntity chuangyeziyuan = chuangyeziyuanService.selectById(id);
        if(null==chuangyeziyuan.getClicknum()){
            chuangyeziyuan.setClicknum(0);
        }
		chuangyeziyuan.setClicknum(chuangyeziyuan.getClicknum()+1);
		chuangyeziyuan.setClicktime(new Date());
		chuangyeziyuanService.updateById(chuangyeziyuan);
        chuangyeziyuan = chuangyeziyuanService.selectView(new EntityWrapper<ChuangyeziyuanEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chuangyeziyuan,deSens);
        return R.ok().put("data", chuangyeziyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChuangyeziyuanEntity chuangyeziyuan = chuangyeziyuanService.selectById(id);
        if(null==chuangyeziyuan.getClicknum()){
            chuangyeziyuan.setClicknum(0);
        }
		chuangyeziyuan.setClicknum(chuangyeziyuan.getClicknum()+1);
		chuangyeziyuan.setClicktime(new Date());
		chuangyeziyuanService.updateById(chuangyeziyuan);
        chuangyeziyuan = chuangyeziyuanService.selectView(new EntityWrapper<ChuangyeziyuanEntity>().eq("id", id));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(chuangyeziyuan,deSens);
        return R.ok().put("data", chuangyeziyuan);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyeziyuan);
        chuangyeziyuanService.insert(chuangyeziyuan);
        return R.ok().put("data",chuangyeziyuan.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyeziyuan);
        chuangyeziyuanService.insert(chuangyeziyuan);
        return R.ok().put("data",chuangyeziyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chuangyeziyuan);
        //全部更新
        chuangyeziyuanService.updateById(chuangyeziyuan);
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chuangyeziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request,String pre){
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
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
		params.put("sort", "clicknum");
        params.put("order", "desc");

		PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        return R.ok().put("data", page);
    }



    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,ChuangyeziyuanEntity chuangyeziyuan, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "ziyuanleixing";
        // 查询收藏集合
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "chuangyeziyuan").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<ChuangyeziyuanEntity> chuangyeziyuanList = new ArrayList<ChuangyeziyuanEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            List<String> typeList = new ArrayList<String>();
            for(StoreupEntity s : storeups) {
                if(typeList.contains(s.getInteltype())) continue;
                typeList.add(s.getInteltype());
                chuangyeziyuanList.addAll(chuangyeziyuanService.selectList(new EntityWrapper<ChuangyeziyuanEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<ChuangyeziyuanEntity> ew = new EntityWrapper<ChuangyeziyuanEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        // 根据协同结果查询结果并返回
        PageUtils page = chuangyeziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chuangyeziyuan), params), params));
        List<ChuangyeziyuanEntity> pageList = (List<ChuangyeziyuanEntity>)page.getList();
        if(chuangyeziyuanList.size()<limit) {
            int toAddNum = (limit-chuangyeziyuanList.size())<=pageList.size()?(limit-chuangyeziyuanList.size()):pageList.size();
            for(ChuangyeziyuanEntity o1 : pageList) {
                boolean addFlag = true;
                for(ChuangyeziyuanEntity o2 : chuangyeziyuanList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    chuangyeziyuanList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(chuangyeziyuanList.size()>limit) {
            chuangyeziyuanList = chuangyeziyuanList.subList(0, limit);
        }
        page.setList(chuangyeziyuanList);
        return R.ok().put("data", page);
    }






}
