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
public enum PayStatusEnums {

	WAIT(1, "等待支付");

	private Integer code;

	private String msg;

	PayStatusEnums (Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
