package com.novli.product.service;

import com.novli.product.ProductApplicationTests;
import com.novli.product.vo.CategoryVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 14:22
 */
@Component
public class ICategoryServiceTest extends ProductApplicationTests {

	@Autowired
	ICategoryService iCategoryService;

	@Test
	public void listProductsByCategory () {
		List<CategoryVo> categoryVoList = iCategoryService.listProductsByCategory ();
		Assert.assertTrue (categoryVoList.size ()>0);
	}
}