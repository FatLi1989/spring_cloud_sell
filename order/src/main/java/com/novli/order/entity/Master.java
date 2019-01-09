package com.novli.order.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 表 order_master
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
@Data
public class Master
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String orderId;
	/** 买家名字 */
	private String buyerName;
	/** 买家电话 */
	private String buyerPhone;
	/** 买家地址 */
	private String buyerAddress;
	/** 买家微信openid */
	private String buyerOpenid;
	/** 订单总金额 */
	private BigDecimal orderAmount;
	/** 订单状态, 默认为新下单 */
	private Integer orderStatus;
	/** 支付状态, 默认未支付 */
	private Integer payStatus;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

}
