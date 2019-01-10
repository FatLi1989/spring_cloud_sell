package com.novli.order.enums;

import lombok.Getter;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 13:55
 */
@Getter
public enum OrderStatusEnum {

	NEW(1, "新建订单");

	private Integer code;

	private String msg;

	OrderStatusEnum (Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
