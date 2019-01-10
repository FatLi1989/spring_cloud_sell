package com.novli.order.vo;

import lombok.Data;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 10:23
 */
@Data
public class ResultVo<T> {

	private Integer code;

	private String msg;

	private T data;
}
