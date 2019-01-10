package com.novli.product.service;

import com.novli.product.ProductApplicationTests;
import com.novli.product.entity.Info;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 19:03
 */
@Slf4j
@Component
public class IInfoServiceTest extends ProductApplicationTests {

	@Autowired
	IInfoService iInfoService;

	@Test
	public void listProductsIn () {
		List<Info> infoList = iInfoService.listProductsIn (Arrays.asList ("157875196366160022", "157875227953464068"));
		log.info ("infoList={}", infoList.toString ());
		Assert.assertTrue (infoList.size () > 0);
	}
}