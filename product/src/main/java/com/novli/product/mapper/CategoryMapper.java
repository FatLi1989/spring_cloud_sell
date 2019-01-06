package com.novli.product.mapper;

import com.novli.product.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;	

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2019-01-06
 */
@Mapper
@Component
public interface CategoryMapper 
{
	/**
     * 查询信息
     * 
     * @param categoryId ID
     * @return 信息
     */
	public Category selectCategoryById(Integer categoryId);
	
	/**
     * 查询列表
     * 
     * @param category 信息
     * @return 集合
     */
	public List<Category> selectCategoryList(Category category);
	
	/**
     * 新增
     * 
     * @param category 信息
     * @return 结果
     */
	public int insertCategory(Category category);
	
	/**
     * 修改
     * 
     * @param category 信息
     * @return 结果
     */
	public int updateCategory(Category category);
	
	/**
     * 删除
     * 
     * @param categoryId ID
     * @return 结果
     */
	public int deleteCategoryById(Integer categoryId);
	
	/**
     * 批量删除
     * 
     * @param categoryIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteCategoryByIds(String[] categoryIds);
	
}