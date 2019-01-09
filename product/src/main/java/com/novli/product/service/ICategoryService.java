package com.novli.product.service;

import com.novli.product.vo.CategoryVo;
import com.novli.product.entity.Category;

import java.util.List;

/**
 * 服务层
 *
 * @author ruoyi
 * @date 2019-01-06
 */
public interface ICategoryService {
	/**
	 * 查询信息
	 *
	 * @param categoryId ID
	 * @return 信息
	 */
	Category selectCategoryById (Integer categoryId);

	/**
	 * 查询列表
	 *
	 * @param category 信息
	 * @return 集合
	 */
	List<Category> selectCategoryList (Category category);

	/**
	 * 新增
	 *
	 * @param category 信息
	 * @return 结果
	 */
	int insertCategory (Category category);

	/**
	 * 修改
	 *
	 * @param category 信息
	 * @return 结果
	 */
	int updateCategory (Category category);

	/**
	 * 删除信息
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	int deleteCategoryByIds (String ids);

	/**
	 * 获取上架商品类目
	 */
	List<CategoryVo> listProductsByCategory ();
}
