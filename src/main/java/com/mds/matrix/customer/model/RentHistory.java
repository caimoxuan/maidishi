package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class RentHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 设备号*/
	private String deviceId;
	/** 设备类型1 车 2 电池*/
	private Integer deviceType;
	/** 装备设备id*/
	private String fitDeviceId;
	/** 骑手openid*/
	private String riderId;
	/** 骑手名称*/
	private String riderName;
	/** 起始时间*/
	private Date rentStart;
	/** 结束时间*/
	private Date rentEnd;
	/** 租赁方案*/
	private Integer rentType;
	/** 收入*/
	private Long income;
	/** 操作人id*/
	private String operatorUserId;
	/** 操作人名称*/
	private String operatorUserName;
	/** 备注*/
	private String remark;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}