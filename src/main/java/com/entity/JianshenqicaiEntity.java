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
 * 健身器材
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-05-26 11:50:59
 */
@TableName("jianshenqicai")
public class JianshenqicaiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JianshenqicaiEntity() {
		
	}
	
	public JianshenqicaiEntity(T t) {
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
	 * 器材编号
	 */
					
	private String qicaibianhao;
	
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
	 * 设置：器材编号
	 */
	public void setQicaibianhao(String qicaibianhao) {
		this.qicaibianhao = qicaibianhao;
	}
	/**
	 * 获取：器材编号
	 */
	public String getQicaibianhao() {
		return qicaibianhao;
	}
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
