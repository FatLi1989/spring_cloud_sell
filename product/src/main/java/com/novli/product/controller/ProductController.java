package com.novli.product.controller;


import com.novli.product.entity.Info;
import com.novli.product.service.IInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@ResponseBody
@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    IInfoService iInfoService;

    @GetMapping("/list")
    public List<Info> selectProduct() {

        /**
         *  1.查询所有在架的商品
         *  2.获取类目type列表
         *  3.查询类目
         *  4.构造数据
         */
        List<Info> infoList = iInfoService.selectInfoList(new Info());
        return infoList;
    }
}
