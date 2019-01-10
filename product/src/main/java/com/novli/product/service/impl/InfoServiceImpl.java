package com.novli.product.service.impl;

import java.util.List;

import com.novli.product.mapper.InfoMapper;
import com.novli.product.entity.Info;
import com.novli.product.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 服务层实现
 *
 * @author ruoyi
 * @date 2019-01-06
 */
@Service
public class InfoServiceImpl implements IInfoService {
	@Autowired
	private InfoMapper infoMapper;

	/**
	 * 查询信息
	 *
	 * @param productId ID
	 * @return 信息
	 */
	@Override
	public Info selectInfoById (String productId) {
		return infoMapper.selectInfoById (productId);
	}

	/**
	 * 查询列表
	 *
	 * @param info 信息
	 * @return 集合
	 */
	@Override
	public List<Info> selectInfoList (Info info) {
		return infoMapper.selectInfoList (info);
	}

	/**
	 * 新增
	 *
	 * @param info 信息
	 * @return 结果
	 */
	@Override
	public int insertInfo (Info info) {
		return infoMapper.insertInfo (info);
	}

	/**
	 * 修改
	 *
	 * @param info 信息
	 * @return 结果
	 */
	@Override
	public int updateInfo (Info info) {
		return infoMapper.updateInfo (info);
	}

	/**
	 * 删除对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteInfoByIds (String ids) {
		return infoMapper.deleteInfoByIds (ids.split (","));
	}

	@Override
	public List<Info> listProductsIn (List<String> productIds) {
		List<Info> infoList = infoMapper.listProductsIn (productIds);
		return infoList;
	}

}
