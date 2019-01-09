package com.novli.order.service.impl;

import com.novli.order.entity.Master;
import com.novli.order.mapper.MasterMapper;
import com.novli.order.service.IMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *  服务层实现
 * 
 * @author ruoyi
 * @date 2019-01-09
 */
@Service
public class MasterServiceImpl implements IMasterService
{
	@Autowired
	private MasterMapper masterMapper;

	/**
     * 查询信息
     * 
     * @param orderId ID
     * @return 信息
     */
    @Override
	public Master selectMasterById(String orderId)
	{
	    return masterMapper.selectMasterById(orderId);
	}
	
	/**
     * 查询列表
     * 
     * @param master 信息
     * @return 集合
     */
	@Override
	public List<Master> selectMasterList(Master master)
	{
	    return masterMapper.selectMasterList(master);
	}
	
    /**
     * 新增
     * 
     * @param master 信息
     * @return 结果
     */
	@Override
	public int insertMaster(Master master)
	{
	    return masterMapper.insertMaster(master);
	}
	
	/**
     * 修改
     * 
     * @param master 信息
     * @return 结果
     */
	@Override
	public int updateMaster(Master master)
	{
	    return masterMapper.updateMaster(master);
	}

	/**
     * 删除对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteMasterByIds(String ids)
	{
		return masterMapper.deleteMasterByIds(ids.split(","));
	}
	
}
