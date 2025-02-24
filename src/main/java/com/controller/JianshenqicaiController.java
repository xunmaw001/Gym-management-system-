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

import com.entity.JianshenqicaiEntity;
import com.entity.view.JianshenqicaiView;

import com.service.JianshenqicaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 健身器材
 * 后端接口
 * @author 
 * @email 
 * @date 2023-05-26 11:50:59
 */
@RestController
@RequestMapping("/jianshenqicai")
public class JianshenqicaiController {
    @Autowired
    private JianshenqicaiService jianshenqicaiService;



    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianshenqicaiEntity jianshenqicai, 
		HttpServletRequest request){

        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<JianshenqicaiEntity>();


		PageUtils page = jianshenqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenqicai), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianshenqicaiEntity jianshenqicai, 
		HttpServletRequest request){
        EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<JianshenqicaiEntity>();

		PageUtils page = jianshenqicaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianshenqicai), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianshenqicaiEntity jianshenqicai){
       	EntityWrapper<JianshenqicaiEntity> ew = new EntityWrapper<JianshenqicaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianshenqicai, "jianshenqicai")); 
        return R.ok().put("data", jianshenqicaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianshenqicaiEntity jianshenqicai){
        EntityWrapper< JianshenqicaiEntity> ew = new EntityWrapper< JianshenqicaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianshenqicai, "jianshenqicai")); 
		JianshenqicaiView jianshenqicaiView =  jianshenqicaiService.selectView(ew);
		return R.ok("查询健身器材成功").put("data", jianshenqicaiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianshenqicaiEntity jianshenqicai = jianshenqicaiService.selectById(id);
        return R.ok().put("data", jianshenqicai);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianshenqicaiEntity jianshenqicai = jianshenqicaiService.selectById(id);
        return R.ok().put("data", jianshenqicai);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request){
    	jianshenqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianshenqicai);

        jianshenqicaiService.insert(jianshenqicai);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request){
    	jianshenqicai.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianshenqicai);

        jianshenqicaiService.insert(jianshenqicai);
        return R.ok();
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianshenqicaiEntity jianshenqicai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianshenqicai);
        jianshenqicaiService.updateById(jianshenqicai);//全部更新
        return R.ok();
    }

    
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianshenqicaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
