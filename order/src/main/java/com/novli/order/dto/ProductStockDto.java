package com.novli.order.dto;

import lombok.Data;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/11 9:46
 */
@Data
public class ProductStockDto {

	private String productId;

	private Integer productStock;

	public ProductStockDto (String productId, Integer productStock) {
		this.productId = productId;
		this.productStock = productStock;
	}

	public ProductStockDto () {
	}
}
