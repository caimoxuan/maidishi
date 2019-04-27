package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class BatteryDateil implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 电池id*/
	private String batteryId;
	/** 状态*/
	private Integer batteryStatus;
	/** 采购批次 订单*/
	private String orderBatch;
	/** 采购时间*/
	private Date orderTime;
	/** 更换次数*/
	private Integer changeTime;
	/** 总租时长 月*/
	private Integer totalRentTime;
	/** 图片信息*/
	private String batteryImg;
	/** 租赁信息*/
	private String rentInfo;
	/** 当前状态（代缴费..）*/
	private Integer useStatus;
	/** 维修次数*/
	private Integer repairTime;
	/** 入库时间*/
	private Date storeTime;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}