package com.novli.product.exception;

import com.novli.product.enums.ResultEnum;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/11 9:55
 */
public class ProductException extends  RuntimeException{


	private Integer code;

	public ProductException (Integer code, String msg) {
		super(msg);
		this.code = code;
	}

	public ProductException (ResultEnum resultEnum) {
		super(resultEnum.getMsg ());
		this.code = resultEnum.getCode ();
	}

}
