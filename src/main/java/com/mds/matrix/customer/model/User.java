package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;

import com.mds.matrix.common.enums.UserType;
import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 用户id*/
	private String userId;
	/** 用户类型 0 管理 2 店员 4 骑手*/
	private UserType userType;
	/** 微信openId 小程序登录使用*/
	private String openId;
	/** 微信昵称*/
	private String nickName;
	/** 性别*/
	private Integer gender;
	/** 头像地址*/
	private String avatarUrl;
	/** 国家*/
	private String country;
	/** 省份*/
	private String province;
	/** 地区*/
	private String city;
	/** 真实姓名*/
	private String realName;
	/** 电话*/
	private Long mobile;
	/** 身份证*/
	private String identityId;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}