package com.novli.product.mapper;

import com.novli.product.vo.ProductInfoVo;
import com.novli.product.entity.Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据层
 *
 * @author ruoyi
 * @date 2019-01-06
 */
@Mapper
@Component
public interface InfoMapper {
	/**
	 * 查询信息
	 *
	 * @param productId ID
	 * @return 信息
	 */
	Info selectInfoById (String productId);

	/**
	 * 查询列表
	 *
	 * @param info 信息
	 * @return 集合
	 */
	List<Info> selectInfoList (Info info);

	/**
	 * 新增
	 *
	 * @param info 信息
	 * @return 结果
	 */
	int insertInfo (Info info);

	/**
	 * 修改
	 *
	 * @param info 信息
	 * @return 结果
	 */
	int updateInfo (Info info);

	/**
	 * 删除
	 *
	 * @param productId ID
	 * @return 结果
	 */
	int deleteInfoById (String productId);

	/**
	 * 批量删除
	 *
	 * @param productIds 需要删除的数据ID
	 * @return 结果
	 */
	int deleteInfoByIds (String[] productIds);

	List<ProductInfoVo> listProductByCatogoryType (@Param ("categoryType") String categoryType);
}