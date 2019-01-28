package com.novli.order.Convert;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.novli.order.dto.OrderDto;
import com.novli.order.entity.Detail;
import com.novli.order.entity.Master;
import com.novli.order.enums.ResultEnum;
import com.novli.order.exception.OrderException;
import com.novli.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 11:09
 */
@Slf4j
public class OrderVoConvertToOrderDto {

	public static OrderDto convertToOrderDto (OrderForm orderForm) {
		Gson gson = new Gson ();
		OrderDto orderDto = new OrderDto ();
		orderDto.setBuyerName (orderForm.getName ());
		orderDto.setBuyerAddress (orderForm.getAddress ());
		orderDto.setBuyerPhone (orderForm.getPhone ());
		orderDto.setBuyerOpenid (orderForm.getOpenId ());

		List<Detail> detailList = new ArrayList<> ();

		try {
			detailList = gson.fromJson (orderForm.getItems (),
					new TypeToken<List<Detail>> () {
			}.getType ());
		} catch (JsonSyntaxException e) {
			log.error ("【json转换】错误, String = {}", orderForm.getItems ());
			throw new OrderException (ResultEnum.PARAM_ERROR);
		}
		orderDto.setDetailList (detailList);

		return orderDto;
	}
}
