package com.novli.order.service.impl;

import java.util.List;

import com.novli.order.entity.Detail;
import com.novli.order.mapper.DetailMapper;
import com.novli.order.service.IDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *  服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
@Service
public class DetailServiceImpl implements IDetailService
{
	@Autowired
	private DetailMapper detailMapper;

	/**
     * 查询信息
     * 
     * @param detailId ID
     * @return 信息
     */
    @Override
	public Detail selectDetailById(String detailId)
	{
	    return detailMapper.selectDetailById(detailId);
	}
	
	/**
     * 查询列表
     * 
     * @param detail 信息
     * @return 集合
     */
	@Override
	public List<Detail> selectDetailList(Detail detail)
	{
	    return detailMapper.selectDetailList(detail);
	}
	
    /**
     * 新增
     * 
     * @param detail 信息
     * @return 结果
     */
	@Override
	public int insertDetail(Detail detail)
	{
	    return detailMapper.insertDetail(detail);
	}
	
	/**
     * 修改
     * 
     * @param detail 信息
     * @return 结果
     */
	@Override
	public int updateDetail(Detail detail)
	{
	    return detailMapper.updateDetail(detail);
	}

	/**
     * 删除对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteDetailByIds(String ids)
	{
		return detailMapper.deleteDetailByIds(ids.split (","));
	}
	
}
