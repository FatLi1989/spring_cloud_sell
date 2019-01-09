package com.novli.product.controller;


import com.novli.product.vo.CategoryVo;
import com.novli.product.vo.ResultVo;
import com.novli.product.service.ICategoryService;
import com.novli.product.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@ResponseBody
@RestController
@RequestMapping ("/product")
public class ProductController {


	@Autowired
	private ICategoryService iCategoryService;

	@GetMapping ("/list")
	public ResultVo selectProduct () {

		/**
		 *  1.查询所有在架的商品
		 *  2.获取类目type列表
		 *  3.查询类目
		 *  4.构造数据
		 */
		List<CategoryVo> categoryVoList = iCategoryService.listProductsByCategory();

		return ResultUtil.success (categoryVoList);
	}
}
