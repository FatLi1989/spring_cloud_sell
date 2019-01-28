package com.novli.product.service;

import com.novli.product.dto.ProductStockDto;
import com.novli.product.entity.Info;

import java.util.List;

/**
 *  服务层
 * 
 * @author ruoyi
 * @date 2019-01-06
 */
public interface IInfoService 
{
	/**
     * 查询信息
     * 
     * @param productId ID
     * @return 信息
     */
	public Info selectInfoById(String productId);
	
	/**
     * 查询列表
     * 
     * @param info 信息
     * @return 集合
     */
	public List<Info> selectInfoList(Info info);
	
	/**
     * 新增
     * 
     * @param info 信息
     * @return 结果
     */
	public int insertInfo(Info info);
	
	/**
     * 修改
     * 
     * @param info 信息
     * @return 结果
     */
	public int updateInfo(Info info);
		
	/**
     * 删除信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteInfoByIds(String ids);

	List<Info> listProductsIn (List<String> productIds);

	List<Info> decreaseStock (List<ProductStockDto> productStockDtoList);
}
