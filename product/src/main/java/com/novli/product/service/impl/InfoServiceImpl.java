package com.novli.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.druid.support.json.JSONUtils;
import com.novli.product.dto.ProductStockDto;
import com.novli.product.enums.ResultEnum;
import com.novli.product.exception.ProductException;
import com.novli.product.mapper.InfoMapper;
import com.novli.product.entity.Info;
import com.novli.product.service.IInfoService;
import com.novli.product.util.JsonUtil;
import com.rabbitmq.tools.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 服务层实现
 *
 * @author ruoyi
 * @date 2019-01-06
 */
@Slf4j
@Service
public class InfoServiceImpl implements IInfoService {
    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 查询信息
     *
     * @param productId ID
     * @return 信息
     */
    @Override
    public Info selectInfoById(String productId) {
        return infoMapper.selectInfoById(productId);
    }

    /**
     * 查询列表
     *
     * @param info 信息
     * @return 集合
     */
    @Override
    public List<Info> selectInfoList(Info info) {
        return infoMapper.selectInfoList(info);
    }

    /**
     * 新增
     *
     * @param info 信息
     * @return 结果
     */
    @Override
    public int insertInfo(Info info) {
        return infoMapper.insertInfo(info);
    }

    /**
     * 修改
     *
     * @param info 信息
     * @return 结果
     */
    @Override
    public int updateInfo(Info info) {
        return infoMapper.updateInfo(info);
    }

    /**
     * 删除对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInfoByIds(String ids) {
        return infoMapper.deleteInfoByIds(ids.split(","));
    }

    @Override
    public List<Info> listProductsIn(List<String> productIds) {
        List<Info> infoList = infoMapper.listProductsIn(productIds);
        return infoList;
    }

    /**
     * 商品扣库存
     *
     * @param productStockDtoList
     * @return
     */
    @Override
    public void decreaseStock(List<ProductStockDto> productStockDtoList) {
        List<Info> infoList = decreaseStockProcess(productStockDtoList);
        //发送mq消息
        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(infoList));
    }

    @Transactional
    public List<Info> decreaseStockProcess(List<ProductStockDto> productStockDtoList) {

        List<Info> productStockDtoArrayList = new ArrayList<>();

        //查询库存
        for (ProductStockDto productStockDto : productStockDtoList) {
            Info info = infoMapper.selectInfoById(productStockDto.getProductId());
            //判断库存是否足够
            if (info == null) {
                log.error("【商品扣库存】时商品信息不存在");
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            if (info.getProductStock() - productStockDto.getProductStock() < 0) {
                log.error("【商品扣库存】时库存不足 ProductStock = {}", info.getProductStock());
                throw new ProductException(ResultEnum.STOCK_NOT_ENOUGH);
            }
            //修改库存
            info.setProductStock(info.getProductStock() - productStockDto.getProductStock());
            infoMapper.updateInfo(info);
            productStockDtoArrayList.add(info);
        }
        return productStockDtoArrayList;
    }
}
