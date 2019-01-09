package com.novli.order.service;

import com.ruoyi.system.domain.Detail;
import java.util.List;

/**
 *  服务层
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
public interface IDetailService 
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
     * 删除信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteDetailByIds(String ids);
	
}
