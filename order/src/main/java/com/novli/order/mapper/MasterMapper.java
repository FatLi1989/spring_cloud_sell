package com.novli.order.mapper;

import com.novli.order.entity.Master;

import java.util.List;

/**
 * 数据层
 *
 * @author ruoyi
 * @date 2019-01-09
 */
public interface MasterMapper {
    /**
     * 查询信息
     *
     * @param orderId ID
     * @return 信息
     */
    Master selectMasterById(String orderId);

    /**
     * 查询列表
     *
     * @param master 信息
     * @return 集合
     */
    List<Master> selectMasterList(Master master);

    /**
     * 新增
     *
     * @param master 信息
     * @return 结果
     */
    int insertMaster(Master master);

    /**
     * 修改
     *
     * @param master 信息
     * @return 结果
     */
    int updateMaster(Master master);

    /**
     * 删除
     *
     * @param orderId ID
     * @return 结果
     */
    int deleteMasterById(String orderId);

    /**
     * 批量删除
     *
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    int deleteMasterByIds(String[] orderIds);

}