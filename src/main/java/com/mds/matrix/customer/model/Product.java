package com.mds.matrix.customer.model;
import java.util.Date;

import java.io.Serializable;
import lombok.Data;

@Data
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 自增主键*/
	private Long id;
	/** 产品id*/
	private Long productId;
	/** 产品名称*/
	private String productName;
	/** 剩余库存*/
	private Long quantity;
	/** 总库存*/
	private Long totalQuantity;
	/** 成本*/
	private Long cost;
	/** 利润*/
	private Long profit;
	/** 乐观锁*/
	private Long version;
	/** 创建时间*/
	private Date createTime;
	/** 更新时间*/
	private Date updateTime;


}