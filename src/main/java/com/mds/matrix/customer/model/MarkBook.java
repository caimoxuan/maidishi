package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class MarkBook implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 微信openId 小程序登录使用*/
	private String openId;
	/** 物品类型*/
	private Integer markType;
	/** 物品关联id*/
	private String markId;
	/** 收藏名称*/
	private String markName;
	/** 附加属性*/
	private String extra;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}