package com.novli.product.entity;

import lombok.Data;
import java.util.Date;

/**
 * 表 product_category
 * 
 * @author ruoyi
 * @date 2019-01-06
 */
@Data
public class Category
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private Integer categoryId;
	/** 类目名字 */
	private String categoryName;
	/** 类目编号 */
	private Integer categoryType;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

}
