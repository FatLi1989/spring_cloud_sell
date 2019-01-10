package com.novli.order.util;

import java.util.Random;

/**
 * @author NovLi
 * @Title:
 * @ProjectName spring_cloud_sell
 * @Description: TODO
 * @date 2019/1/10 13:30
 */
public class KeyUtil {


	public static synchronized String genUniqueKey() {
		Random random = new Random ();
		Integer number =random.nextInt (900000)+100000;
		return System.currentTimeMillis () + String.valueOf (number);
	}

	public static void main (String[] args) {
		System.out.println (KeyUtil.genUniqueKey ());
	}

}
