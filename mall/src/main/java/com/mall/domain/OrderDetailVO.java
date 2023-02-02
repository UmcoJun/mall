package com.mall.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDetailVO {

	private Long odr_code;
	private Integer pdt_num;
	private int odr_amount;
	private int odr_price;

}
