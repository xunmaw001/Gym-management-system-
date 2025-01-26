package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
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

import com.entity.JiaolianxinxiEntity;
import com.entity.view.JiaolianxinxiView;

import com.service.JiaolianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 教练信息
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-26 11:51:00
 */
@RestController
@RequestMapping("/jiaolianxinxi")
public class JiaolianxinxiController {
    @Autowired
    private JiaolianxinxiService jiaolianxinxiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi, 
		HttpServletRequest request){

        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();


		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaolianxinxiEntity jiaolianxinxi, 
		HttpServletRequest request){
        EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();

		PageUtils page = jiaolianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaolianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaolianxinxiEntity jiaolianxinxi){
       	EntityWrapper<JiaolianxinxiEntity> ew = new EntityWrapper<JiaolianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi")); 
        return R.ok().put("data", jiaolianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaolianxinxiEntity jiaolianxinxi){
        EntityWrapper< JiaolianxinxiEntity> ew = new EntityWrapper< JiaolianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaolianxinxi, "jiaolianxinxi")); 
		JiaolianxinxiView jiaolianxinxiView =  jiaolianxinxiService.selectView(ew);
		return R.ok("查询教练信息成功").put("data", jiaolianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
        return R.ok().put("data", jiaolianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaolianxinxiEntity jiaolianxinxi = jiaolianxinxiService.selectById(id);
        return R.ok().put("data", jiaolianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	jiaolianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianxinxi);

        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
    	jiaolianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaolianxinxi);

        jiaolianxinxiService.insert(jiaolianxinxi);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaolianxinxiEntity jiaolianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaolianxinxi);
        jiaolianxinxiService.updateById(jiaolianxinxi);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaolianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
