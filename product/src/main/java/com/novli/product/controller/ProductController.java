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
        List<Info> infoList = iInfoService.selectInfoList(new Info());
        return infoList;
    }
}
