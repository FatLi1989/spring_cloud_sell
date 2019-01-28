package com.novli.order.Client;

import com.novli.order.dto.ProductStockDto;
import com.novli.order.entity.Info;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 17:57
 */
@Component
@FeignClient (name = "product")
public interface ProductClient {

	@GetMapping ("/msg")
	String productMsg ();


	@PostMapping ("/product/listForOrder")
	List<Info> listProductsInProductId (@RequestBody List<String> productIds);

	@PostMapping ("/product/decreaseStock")
	List<Info> decreaseStock (@RequestBody List<ProductStockDto> productStockDtoList);
}
