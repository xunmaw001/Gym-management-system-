package com.entity.view;

import com.entity.DiscussjianshenqicaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 健身器材评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-05-26 11:51:00
 */
@TableName("discussjianshenqicai")
public class DiscussjianshenqicaiView  extends DiscussjianshenqicaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjianshenqicaiView(){
	}
 
 	public DiscussjianshenqicaiView(DiscussjianshenqicaiEntity discussjianshenqicaiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjianshenqicaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
