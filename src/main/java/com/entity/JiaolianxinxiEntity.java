package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 教练信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-26 11:51:00
 */
@TableName("jiaolianxinxi")
public class JiaolianxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaolianxinxiEntity() {
		
	}
	
	public JiaolianxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 教练编号
	 */
					
	private String jiaolianbianhao;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：教练编号
	 */
	public void setJiaolianbianhao(String jiaolianbianhao) {
		this.jiaolianbianhao = jiaolianbianhao;
	}
	/**
	 * 获取：教练编号
	 */
	public String getJiaolianbianhao() {
		return jiaolianbianhao;
	}
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
