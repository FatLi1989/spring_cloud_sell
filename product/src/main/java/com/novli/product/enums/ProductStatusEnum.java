package com.novli.product.enums;

import lombok.Getter;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 12:15
 */
@Getter
public enum ProductStatusEnum {

	up(0, "上架"), down(1, "下架"),  ;

	private Integer code;

	private String status;

	ProductStatusEnum (Integer code, String status) {
		this.code = code;
		this.status = status;
	}
}
