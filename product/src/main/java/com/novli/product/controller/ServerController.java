package com.novli.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 14:35
 */
@ResponseBody
@RestController
public class ServerController {

	@GetMapping ("/msg")
	public String getMsg () {
		return "this is product";
	}

}
