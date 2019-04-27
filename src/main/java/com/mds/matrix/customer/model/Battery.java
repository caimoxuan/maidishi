package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class Battery implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 电池id*/
	private String batteryId;
	/** 状态*/
	private Integer batteryStatus;
	/** 租赁时长*/
	private Integer rentTime;
	/** 检测值*/
	private Integer testCode;
	/** 车架号*/
	private String carId;
	/** 租赁人名称*/
	private String rentUserName;
	/** 租赁人id*/
	private String rentUserId;
	/** 总收入*/
	private Long totalIncome;
	/** 乐观锁*/
	private Long version;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}