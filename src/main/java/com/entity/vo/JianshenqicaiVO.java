package com.entity.vo;

import com.entity.JianshenqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 健身器材
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-05-26 11:50:59
 */
public class JianshenqicaiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 器材名称
	 */
	
	private String qicaimingcheng;
		
	/**
	 * 器材类型
	 */
	
	private String qicaileixing;
		
	/**
	 * 器材照片
	 */
	
	private String qicaizhaopian;
		
	/**
	 * 器材用途
	 */
	
	private String qicaiyongtu;
		
	/**
	 * 器材详情
	 */
	
	private String qicaixiangqing;
				
	
	/**
	 * 设置：器材名称
	 */
	 
	public void setQicaimingcheng(String qicaimingcheng) {
		this.qicaimingcheng = qicaimingcheng;
	}
	
	/**
	 * 获取：器材名称
	 */
	public String getQicaimingcheng() {
		return qicaimingcheng;
	}
				
	
	/**
	 * 设置：器材类型
	 */
	 
	public void setQicaileixing(String qicaileixing) {
		this.qicaileixing = qicaileixing;
	}
	
	/**
	 * 获取：器材类型
	 */
	public String getQicaileixing() {
		return qicaileixing;
	}
				
	
	/**
	 * 设置：器材照片
	 */
	 
	public void setQicaizhaopian(String qicaizhaopian) {
		this.qicaizhaopian = qicaizhaopian;
	}
	
	/**
	 * 获取：器材照片
	 */
	public String getQicaizhaopian() {
		return qicaizhaopian;
	}
				
	
	/**
	 * 设置：器材用途
	 */
	 
	public void setQicaiyongtu(String qicaiyongtu) {
		this.qicaiyongtu = qicaiyongtu;
	}
	
	/**
	 * 获取：器材用途
	 */
	public String getQicaiyongtu() {
		return qicaiyongtu;
	}
				
	
	/**
	 * 设置：器材详情
	 */
	 
	public void setQicaixiangqing(String qicaixiangqing) {
		this.qicaixiangqing = qicaixiangqing;
	}
	
	/**
	 * 获取：器材详情
	 */
	public String getQicaixiangqing() {
		return qicaixiangqing;
	}
			
}
