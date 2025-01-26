package com.entity.model;

import com.entity.KechengxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
 

/**
 * 课程信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-05-26 11:50:59
 */
public class KechengxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 课程标题
	 */
	
	private String kechengbiaoti;
		
	/**
	 * 课程类型
	 */
	
	private String kechengleixing;
		
	/**
	 * 课程照片
	 */
	
	private String kechengzhaopian;
		
	/**
	 * 授课教练
	 */
	
	private String shoukejiaolian;
		
	/**
	 * 课程简介
	 */
	
	private String kechengjianjie;
		
	/**
	 * 课程详情
	 */
	
	private String kechengxiangqing;
		
	/**
	 * 最近点击时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date clicktime;
		
	/**
	 * 点击次数
	 */
	
	private Integer clicknum;
		
	/**
	 * 价格
	 */
	
	private Double price;
				
	
	/**
	 * 设置：课程标题
	 */
	 
	public void setKechengbiaoti(String kechengbiaoti) {
		this.kechengbiaoti = kechengbiaoti;
	}
	
	/**
	 * 获取：课程标题
	 */
	public String getKechengbiaoti() {
		return kechengbiaoti;
	}
				
	
	/**
	 * 设置：课程类型
	 */
	 
	public void setKechengleixing(String kechengleixing) {
		this.kechengleixing = kechengleixing;
	}
	
	/**
	 * 获取：课程类型
	 */
	public String getKechengleixing() {
		return kechengleixing;
	}
				
	
	/**
	 * 设置：课程照片
	 */
	 
	public void setKechengzhaopian(String kechengzhaopian) {
		this.kechengzhaopian = kechengzhaopian;
	}
	
	/**
	 * 获取：课程照片
	 */
	public String getKechengzhaopian() {
		return kechengzhaopian;
	}
				
	
	/**
	 * 设置：授课教练
	 */
	 
	public void setShoukejiaolian(String shoukejiaolian) {
		this.shoukejiaolian = shoukejiaolian;
	}
	
	/**
	 * 获取：授课教练
	 */
	public String getShoukejiaolian() {
		return shoukejiaolian;
	}
				
	
	/**
	 * 设置：课程简介
	 */
	 
	public void setKechengjianjie(String kechengjianjie) {
		this.kechengjianjie = kechengjianjie;
	}
	
	/**
	 * 获取：课程简介
	 */
	public String getKechengjianjie() {
		return kechengjianjie;
	}
				
	
	/**
	 * 设置：课程详情
	 */
	 
	public void setKechengxiangqing(String kechengxiangqing) {
		this.kechengxiangqing = kechengxiangqing;
	}
	
	/**
	 * 获取：课程详情
	 */
	public String getKechengxiangqing() {
		return kechengxiangqing;
	}
				
	
	/**
	 * 设置：最近点击时间
	 */
	 
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
				
	
	/**
	 * 设置：点击次数
	 */
	 
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getPrice() {
		return price;
	}
			
}
