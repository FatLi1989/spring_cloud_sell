package com.novli.order.dto;

import com.novli.order.entity.Detail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 11:04
 */
@Data
public class OrderDto {

	/**
	 * 订单id
	 */
	private String orderId;
	/**
	 * 买家名字
	 */
	private String buyerName;
	/**
	 * 买家电话
	 */
	private String buyerPhone;
	/**
	 * 买家地址
	 */
	private String buyerAddress;
	/**
	 * 买家微信openid
	 */
	private String buyerOpenid;
	/**
	 * 订单总金额
	 */
	private BigDecimal orderAmount;
	/**
	 * 订单状态, 默认为新下单
	 */
	private Integer orderStatus;
	/**
	 * 支付状态, 默认未支付
	 */
	private Integer payStatus;
	/**
	 * 订单详情
	 */
	private List<Detail> detailList;

}
