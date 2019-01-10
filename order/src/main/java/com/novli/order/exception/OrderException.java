package com.novli.order.exception;

import com.novli.order.enums.ResultEnum;
import lombok.Data;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 10:45
 */
@Data
public class OrderException extends RuntimeException{

   private Integer code;

   public OrderException(Integer code, String msg) {
		super(msg);
		this.code = code;
   }

   public OrderException (ResultEnum resultEnum) {
		super(resultEnum.getMsg ());
		this.code = resultEnum.getCode ();
   }

}
