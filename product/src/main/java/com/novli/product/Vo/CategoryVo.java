package com.novli.product.Vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 12:20
 */
@Data
public class CategoryVo {

	@JsonProperty("name")
	private String categoryName;
	@JsonProperty("type")
	private String categoryType;
	@JsonProperty("foods")
	private List<ProductInfoVo> productInfoVoList;
}
