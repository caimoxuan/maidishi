package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class CustomerHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 微信openId 小程序登录使用*/
	private String openId;
	/** 操作人名称*/
	private String userName;
	/** 操作类型*/
	private Integer operatorType;
	/** 操作数据*/
	private String operatorDate;
	/** 操作时间*/
	private Date operatorTime;
	/** 涉及金额*/
	private Long amount;
	/** 操作对象名称*/
	private String targetUserName;
	/** 操作对象id*/
	private String targetUserId;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}