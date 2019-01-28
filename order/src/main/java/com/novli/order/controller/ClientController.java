package com.novli.order.controller;

import com.novli.order.Client.ProductClient;
import com.novli.order.dto.ProductStockDto;
import com.novli.order.entity.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 14:35
 */
@Slf4j
@ResponseBody
@RestController
public class ClientController {

	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ProductClient productClient;

	@GetMapping ("/msg")
	public String getMsg () {

		//第一种方式 根据指定的url获取服务端信息
/*		String result = restTemplate.getForObject ("http://localhost:8673/msg", String.class);
		log.info ("result={}", result);*/
		//第二种方式 根据服务端实例名称获取服务端实例
	/*	ServiceInstance instance = loadBalancerClient.choose ("PRODUCT");
		String url = String.format ("http://%s:%s", instance.getHost (), instance.getPort ()) + "/msg";
		String result = restTemplate.getForObject (url,
				String.class);*/
		//第三种方式 根据服务端实例名称获取服务实例
	/*	String result = restTemplate.getForObject ("http://PRODUCT/msg", String.class);
		log.info ("result = {}", result);*/
		/*String result = productClient.productMsg ();
		log.info ("【result】={}", result);*/
		ProductStockDto productStockDto = new ProductStockDto ();
		productStockDto.setProductId ("157875196366160022");
		productStockDto.setProductStock (1);
		List<Info> infoList = productClient
				.decreaseStock (Arrays.asList (productStockDto));
		log.info ("infoList = {}", infoList);
		return "1";
	}

}
