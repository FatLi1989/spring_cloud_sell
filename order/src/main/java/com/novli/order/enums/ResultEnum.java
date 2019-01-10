package com.novli.order.enums;

import lombok.Getter;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 10:53
 */
@Getter
public enum ResultEnum {


	PARAM_ERROR (1, "参数错误"),

	CART_EMPTY (2, "购物车为空");

	private Integer code;

	private String msg;

	ResultEnum (Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
