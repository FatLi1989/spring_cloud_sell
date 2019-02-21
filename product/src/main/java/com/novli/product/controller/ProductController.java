package com.novli.product.controller;


import com.novli.product.dto.ProductStockDto;
import com.novli.product.entity.Info;
import com.novli.product.service.IInfoService;
import com.novli.product.vo.CategoryVo;
import com.novli.product.vo.ResultVo;
import com.novli.product.service.ICategoryService;
import com.novli.product.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@ResponseBody
@RestController
@RequestMapping ("/product")
public class ProductController {


	@Autowired
	private ICategoryService iCategoryService;
	@Autowired
	private IInfoService iInfoService;

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

	/**
	 * 获取订单对应商品信息(给订单服务用)
	 * @param productIds
	 * @return
	 */
	@PostMapping("/listForOrder")
	public List<Info> listProductsInProductId(@RequestBody List<String> productIds) {
		List<Info> infoList = iInfoService.listProductsIn(productIds);
		return infoList;
	}

	/**
	 * 扣库存
	 */
	@PostMapping("/decreaseStock")
	public void decreaseStock (@RequestBody List<ProductStockDto> productStockDtoList) {
		iInfoService.decreaseStock(productStockDtoList);
	}
}
