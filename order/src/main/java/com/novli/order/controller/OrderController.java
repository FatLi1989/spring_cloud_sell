package com.novli.order.controller;

import com.novli.order.Convert.OrderVoConvertToOrderDto;
import com.novli.order.dto.OrderDto;
import com.novli.order.enums.ResultEnum;
import com.novli.order.exception.OrderException;
import com.novli.order.form.OrderForm;
import com.novli.order.service.IMasterService;
import com.novli.order.util.ResultUtil;
import com.novli.order.vo.ResultVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 10:22
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping ("/order")
public class OrderController {

	@Autowired
	IMasterService iMasterService;

	//校验参数
	@PostMapping ("/create")
	public ResultVo createOrder (@Valid OrderForm orderForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors ()) { //绑定参数异常 抛出异常 打印日志
			log.error ("【创建订单】 参数不正确，orderForm= {}", orderForm);
			throw new OrderException (ResultEnum.PARAM_ERROR.getCode (),
					bindingResult.getFieldError ().getDefaultMessage ());
		}
		OrderDto orderDto = OrderVoConvertToOrderDto.convertToOrderDto (orderForm);
		if (CollectionUtils.isEmpty (orderDto.getDetailList ())) {
			log.error ("【创建订单】购物车信息为空");
			throw new OrderException (ResultEnum.CART_EMPTY);
		}
		OrderDto result = iMasterService.create (orderDto);
		Map map = new HashMap<String, String> ();
		map.put ("orderId", result.getOrderId ());
		return ResultUtil.success (map);
	}
}
