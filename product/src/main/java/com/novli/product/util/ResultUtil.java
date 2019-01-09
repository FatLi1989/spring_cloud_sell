package com.novli.product.util;

import com.novli.product.vo.ResultVo;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/8 12:30
 */
public class ResultUtil {

	public static ResultVo success (Object object) {
		ResultVo resultVo = new ResultVo ();
		resultVo.setCode (100);
		resultVo.setMsg ("success");
		resultVo.setData (object);
		return resultVo;
	}

}
