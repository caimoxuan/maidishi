package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 车架号*/
	private String carId;
	/** 车辆状态*/
	private Integer carStatus;
	/** 租赁时间（月）*/
	private Integer rentTime;
	/** 毛利润*/
	private Long grossProfit;
	/** 押金*/
	private Long deposit;
	/** 租赁人*/
	private String rentUser;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}