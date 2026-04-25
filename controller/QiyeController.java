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
import com.service.TokenService;
import com.entity.TokenEntity;
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

import com.entity.QiyeEntity;
import com.entity.view.QiyeView;

import com.service.QiyeService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 企业
 * 后端接口
 * @author 
 * @email 
 * @date 2026-03-06 23:32:50
 */
@RestController
@RequestMapping("/qiye")
public class QiyeController {
    @Autowired
    private QiyeService qiyeService;







	@Autowired
	private TokenService tokenService;

	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", username));
        // 判断用户锁定状态
        if(u!=null && u.getStatus().intValue()==1) {
            //返回已锁定提示
            return R.error("账号已锁定，请联系管理员。");
        }
        // 当用户不存在或md5方式验证密码不通过时
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
        // 获取登录token
        String token = tokenService.generateToken(u.getId(), username,"qiye",  "企业" );
        //返回token
		return R.ok().put("token", token);
	}



	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QiyeEntity qiye){
    	//ValidatorUtils.validateEntity(qiye);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
        //判断是否存在相同企业名称，否则返回错误信息
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
		Long uId = new Date().getTime();
		qiye.setId(uId);
        //设置登录密码md5方式加密
        qiye.setMima(EncryptUtil.md5(qiye.getMima()));
        //保存用户
        qiyeService.insert(qiye);
        return R.ok();
    }



	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QiyeEntity u = qiyeService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        qiyeService.updateById(u);
        return R.ok("密码已重置为：123456");
    }

    /**
     * 获取账号列表
     */
    @RequestMapping("/accountList")
    public R getAccountList(@RequestParam Map<String, Object> params,QiyeEntity qiye){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
        Wrapper<QiyeEntity> wrapper =MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params);
        List<Map> list = qiyeService.selectList(wrapper).stream().map(v -> {
            Map<String, Object> map = new HashMap<>();
            map.put("id", v.getId());
            map.put("account", v.getQiyemingcheng());
            return map;
        }).collect(Collectors.toList());
        return R.ok().put("data", list);
    }






    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QiyeEntity qiye,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();


        //查询结果
		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
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
    public R list(@RequestParam Map<String, Object> params,QiyeEntity qiye,
                @RequestParam(required = false) Double statusstart,
                @RequestParam(required = false) Double statusend,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
        if(statusstart!=null) ew.ge("status", statusstart);
        if(statusend!=null) ew.le("status", statusend);

        //查询结果
		PageUtils page = qiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }




	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QiyeEntity qiye){
       	EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qiye, "qiye"));
        return R.ok().put("data", qiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QiyeEntity qiye){
        EntityWrapper< QiyeEntity> ew = new EntityWrapper< QiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qiye, "qiye"));
		QiyeView qiyeView =  qiyeService.selectView(ew);
		return R.ok("查询企业成功").put("data", qiyeView);
    }

    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QiyeEntity qiye = qiyeService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(qiye,deSens);
        return R.ok().put("data", qiye);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
        //ValidatorUtils.validateEntity(qiye);
        //验证账号唯一性，否则返回错误信息
        QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		qiye.setId(new Date().getTime());
        //密码使用md5方式加密
        qiye.setMima(EncryptUtil.md5(qiye.getMima()));
        qiyeService.insert(qiye);
        return R.ok().put("data",qiye.getId());
    }

    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //验证字段唯一性，否则返回错误信息
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
        //ValidatorUtils.validateEntity(qiye);
        //验证账号唯一性，否则返回错误信息
        QiyeEntity u = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", qiye.getQiyemingcheng()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	qiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		qiye.setId(new Date().getTime());
        //密码使用md5方式加密
        qiye.setMima(EncryptUtil.md5(qiye.getMima()));
        qiyeService.insert(qiye);
        return R.ok().put("data",qiye.getId());
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        QiyeEntity qiye = qiyeService.selectOne(new EntityWrapper<QiyeEntity>().eq("qiyemingcheng", username));
        return R.ok().put("data", qiye);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody QiyeEntity qiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qiye);
        //验证字段唯一性，否则返回错误信息
        if(qiyeService.selectCount(new EntityWrapper<QiyeEntity>().ne("id", qiye.getId()).eq("qiyemingcheng", qiye.getQiyemingcheng()))>0) {
            return R.error("企业名称已存在");
        }
	    QiyeEntity qiyeEntity = qiyeService.selectById(qiye.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(qiye.getMima()) && !qiye.getMima().equals(qiyeEntity.getMima())) {
            //密码使用md5方式加密
            qiye.setMima(EncryptUtil.md5(qiye.getMima()));
        }
        //全部更新
        qiyeService.updateById(qiye);
        if(null!=qiye.getQiyemingcheng())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(qiye.getQiyemingcheng());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", qiye.getId()));
        }
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }








    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,QiyeEntity qiye, HttpServletRequest request){
        EntityWrapper<QiyeEntity> ew = new EntityWrapper<QiyeEntity>();
        int count = qiyeService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qiye), params), params));
        return R.ok().put("data", count);
    }


}
