package com.novli.product.service.impl;

import com.novli.product.Vo.CategoryVo;
import com.novli.product.entity.Category;
import com.novli.product.enums.ProductStatusEnum;
import com.novli.product.mapper.CategoryMapper;
import com.novli.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-06
 */
@Service
public class CategoryServiceImpl implements ICategoryService
{
	@Autowired
	private CategoryMapper categoryMapper;

	/**
     * 查询信息
     * 
     * @param categoryId ID
     * @return 信息
     */
    @Override
	public Category selectCategoryById(Integer categoryId)
	{
	    return categoryMapper.selectCategoryById(categoryId);
	}
	
	/**
     * 查询列表
     * 
     * @param category 信息
     * @return 集合
     */
	@Override
	public List<Category> selectCategoryList(Category category)
	{
	    return categoryMapper.selectCategoryList(category);
	}
	
    /**
     * 新增
     * 
     * @param category 信息
     * @return 结果
     */
	@Override
	public int insertCategory(Category category)
	{
	    return categoryMapper.insertCategory(category);
	}
	
	/**
     * 修改
     * 
     * @param category 信息
     * @return 结果
     */
	@Override
	public int updateCategory(Category category)
	{
	    return categoryMapper.updateCategory(category);
	}

	/**
     * 删除对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCategoryByIds(String ids)
	{
		return categoryMapper.deleteCategoryByIds(ids.split(","));
	}

	@Override
	public List<CategoryVo> listProductsByCategory () {

		List<CategoryVo> categoryVoList = categoryMapper
				.listProductsByCategory(ProductStatusEnum.up.getCode ());
		return categoryVoList;
	}


}
