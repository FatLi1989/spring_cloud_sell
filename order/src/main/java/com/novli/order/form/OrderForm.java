package com.novli.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 10:34
 */
@Data
public class OrderForm {

	@NotEmpty (message = "买家姓名必填")
	private String name;
	@NotEmpty (message = "手机号必填")
	private String phone;
	@NotEmpty (message = "地址必填")
	private String address;
	@NotEmpty (message = "openId必填")
	private String openId;
	@NotEmpty (message = "购物车不能为空")
	private String items;
}
