package com.novli.order.service.impl;

import com.novli.order.Client.ProductClient;
import com.novli.order.dto.OrderDto;
import com.novli.order.dto.ProductStockDto;
import com.novli.order.entity.Detail;
import com.novli.order.entity.Info;
import com.novli.order.entity.Master;
import com.novli.order.enums.OrderStatusEnum;
import com.novli.order.enums.PayStatusEnums;
import com.novli.order.mapper.MasterMapper;
import com.novli.order.service.IDetailService;
import com.novli.order.service.IMasterService;
import com.novli.order.util.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务层实现
 *
 * @author ruoyi
 * @date 2019-01-09
 */
@Service
public class MasterServiceImpl implements IMasterService {
	@Autowired
	private MasterMapper masterMapper;
	@Autowired
	private IDetailService iDetailService;
	@Autowired
	private ProductClient productClient;

	/**
	 * 查询信息
	 *
	 * @param orderId ID
	 * @return 信息
	 */
	@Override
	public Master selectMasterById (String orderId) {
		return masterMapper.selectMasterById (orderId);
	}

	/**
	 * 查询列表
	 *
	 * @param master 信息
	 * @return 集合
	 */
	@Override
	public List<Master> selectMasterList (Master master) {
		return masterMapper.selectMasterList (master);
	}

	/**
	 * 新增
	 *
	 * @param master 信息
	 * @return 结果
	 */
	@Override
	public int insertMaster (Master master) {
		return masterMapper.insertMaster (master);
	}

	/**
	 * 修改
	 *
	 * @param master 信息
	 * @return 结果
	 */
	@Override
	public int updateMaster (Master master) {
		return masterMapper.updateMaster (master);
	}

	/**
	 * 删除对象
	 *
	 * @param ids 需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteMasterByIds (String ids) {
		return masterMapper.deleteMasterByIds (ids.split (","));
	}

	@Override
	public OrderDto create (OrderDto orderDto) {
		String orderId = KeyUtil.genUniqueKey ();
		//查询商品信息(调用商品服务)
		List<Detail> detailList = orderDto.getDetailList ();
		List<String> productIdList = detailList.stream ()
				.map (Detail:: getProductId)
				.collect (Collectors.toList ());
		List<Info> infoList = productClient.listProductsInProductId (productIdList);
		BigDecimal totalPrice = new BigDecimal (0);
		//计算总价
		for (Info info : infoList) {
			for (Detail detail : orderDto.getDetailList ()) {
				if (detail.getProductId ().equals (info.getProductId ())) {
					totalPrice = new BigDecimal (detail.getProductQuantity ())
							.multiply (info.getProductPrice ())
							.add (totalPrice);
					//订单入库
					BeanUtils.copyProperties (info, detail);
					detail.setOrderId (orderId);
					detail.setDetailId (KeyUtil.genUniqueKey ());
					iDetailService.insertDetail (detail);
				}
			}
		}
		//扣库存(调用商品服务)
		productClient.decreaseStock (detailList.stream ()
				.map (e -> new ProductStockDto (e.getProductId (), e.getProductQuantity ()))
				.collect (Collectors.toList ()));
		//订单入库
		Master master = new Master ();
		orderDto.setOrderId (orderId);
		BeanUtils.copyProperties (orderDto, master);
		master.setOrderAmount (totalPrice);
		master.setOrderStatus (OrderStatusEnum.NEW.getCode ());
		master.setPayStatus (PayStatusEnums.WAIT.getCode ());
		masterMapper.insertMaster (master);
		return orderDto;
	}

}
