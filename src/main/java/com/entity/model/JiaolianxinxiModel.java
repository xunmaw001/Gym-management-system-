package com.entity.model;

import com.entity.JiaolianxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 教练信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-26 11:51:00
 */
public class JiaolianxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 教练名称
	 */
	
	private String jiaolianmingcheng;
		
	/**
	 * 教练照片
	 */
	
	private String jiaolianzhaopian;
		
	/**
	 * 教练性别
	 */
	
	private String jiaolianxingbie;
		
	/**
	 * 教练特长
	 */
	
	private String jiaoliantezhang;
		
	/**
	 * 教练简介
	 */
	
	private String jiaolianjianjie;
		
	/**
	 * 教练详情
	 */
	
	private String jiaolianxiangqing;
				
	
	/**
	 * 设置：教练名称
	 */
	 
	public void setJiaolianmingcheng(String jiaolianmingcheng) {
		this.jiaolianmingcheng = jiaolianmingcheng;
	}
	
	/**
	 * 获取：教练名称
	 */
	public String getJiaolianmingcheng() {
		return jiaolianmingcheng;
	}
				
	
	/**
	 * 设置：教练照片
	 */
	 
	public void setJiaolianzhaopian(String jiaolianzhaopian) {
		this.jiaolianzhaopian = jiaolianzhaopian;
	}
	
	/**
	 * 获取：教练照片
	 */
	public String getJiaolianzhaopian() {
		return jiaolianzhaopian;
	}
				
	
	/**
	 * 设置：教练性别
	 */
	 
	public void setJiaolianxingbie(String jiaolianxingbie) {
		this.jiaolianxingbie = jiaolianxingbie;
	}
	
	/**
	 * 获取：教练性别
	 */
	public String getJiaolianxingbie() {
		return jiaolianxingbie;
	}
				
	
	/**
	 * 设置：教练特长
	 */
	 
	public void setJiaoliantezhang(String jiaoliantezhang) {
		this.jiaoliantezhang = jiaoliantezhang;
	}
	
	/**
	 * 获取：教练特长
	 */
	public String getJiaoliantezhang() {
		return jiaoliantezhang;
	}
				
	
	/**
	 * 设置：教练简介
	 */
	 
	public void setJiaolianjianjie(String jiaolianjianjie) {
		this.jiaolianjianjie = jiaolianjianjie;
	}
	
	/**
	 * 获取：教练简介
	 */
	public String getJiaolianjianjie() {
		return jiaolianjianjie;
	}
				
	
	/**
	 * 设置：教练详情
	 */
	 
	public void setJiaolianxiangqing(String jiaolianxiangqing) {
		this.jiaolianxiangqing = jiaolianxiangqing;
	}
	
	/**
	 * 获取：教练详情
	 */
	public String getJiaolianxiangqing() {
		return jiaolianxiangqing;
	}
			
}
