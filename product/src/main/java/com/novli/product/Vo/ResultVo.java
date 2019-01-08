package com.novli.product.Vo;

import lombok.Data;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 12:09
 */
@Data
public class ResultVo<T> {

	private  Integer code;

	private String msg;

	private T data;

}
