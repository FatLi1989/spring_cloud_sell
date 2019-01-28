package com.novli.product.enums;

import lombok.Getter;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/11 9:57
 */
@Getter
public enum ResultEnum {

	STOCK_NOT_ENOUGH(1, "库存不足"),

	PRODUCT_NOT_EXIST(2, "商品不存在"),;

	private Integer code;

	private String msg;

	ResultEnum (Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
