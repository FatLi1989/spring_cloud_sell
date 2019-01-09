package com.novli.order.mapper;

import com.novli.order.entity.Detail;
import java.util.List;

/**
 *  数据层
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
public interface DetailMapper 
{
	/**
     * 查询信息
     * 
     * @param detailId ID
     * @return 信息
     */
	public Detail selectDetailById(String detailId);
	
	/**
     * 查询列表
     * 
     * @param detail 信息
     * @return 集合
     */
	public List<Detail> selectDetailList(Detail detail);
	
	/**
     * 新增
     * 
     * @param detail 信息
     * @return 结果
     */
	public int insertDetail(Detail detail);
	
	/**
     * 修改
     * 
     * @param detail 信息
     * @return 结果
     */
	public int updateDetail(Detail detail);
	
	/**
     * 删除
     * 
     * @param detailId ID
     * @return 结果
     */
	public int deleteDetailById(String detailId);
	
	/**
     * 批量删除
     * 
     * @param detailIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteDetailByIds(String[] detailIds);
	
}