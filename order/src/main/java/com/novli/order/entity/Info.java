package com.novli.order.entity;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 表 product_info
 * 
 * @author ruoyi
 * @date 2019-01-06
 */
@Data
public class Info
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String productId;
	/** 商品名称 */
	private String productName;
	/** 单价 */
	private BigDecimal productPrice;
	/** 库存 */
	private Integer productStock;
	/** 描述 */
	private String productDescription;
	/** 小图 */
	private String productIcon;
	/** 商品状态,0正常1下架 */
	private Integer productStatus;
	/** 类目编号 */
	private Integer categoryType;
	/** 创建时间 */
	private String createTime;
	/** 修改时间 */
	private String updateTime;

}
