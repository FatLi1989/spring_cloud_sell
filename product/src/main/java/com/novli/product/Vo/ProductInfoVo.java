package com.novli.product.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 12:21
 */
@Data
public class ProductInfoVo {
	@JsonProperty ("id")
	private String productId;
	@JsonProperty ("name")
	private String productName;
	@JsonProperty ("price")
	private BigDecimal productPrice;
	@JsonProperty ("description")
	private String productDescription;
	@JsonProperty ("icon")
	private String productIcon;
}
