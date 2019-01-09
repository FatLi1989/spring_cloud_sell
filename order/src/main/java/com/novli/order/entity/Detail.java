package com.novli.order.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表 order_detail
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
@Data
public class Detail
{
	/**  */
	private String detailId;
	/**  */
	private String orderId;
	/**  */
	private String productId;
	/** 商品名称 */
	private String productName;
	/** 当前价格,单位分 */
	private BigDecimal productPrice;
	/** 数量 */
	private Integer productQuantity;
	/** 小图 */
	private String productIcon;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;
}
