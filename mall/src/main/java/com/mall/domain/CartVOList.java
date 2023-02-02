package com.mall.domain;

import lombok.Data;

@Data
public class CartVOList {

	/*
	 p.pdt_img_folder, p.pdt_img, p.pdt_price, c.cart_amount, p.pdt_price * c.cart_amount as sales_price, c.mem_id, c.pdt_num, c.cart_code
	 */

	private Long cart_code;
	private Integer pdt_num;
	private String pdt_name;
	private String mem_id;
	private int pdt_price;
	private int cart_amount;
	private String pdt_img_folder;
	private String pdt_img;
	private int sales_price; // sql처리 : pdt_price * cart_amount
	
	
}
