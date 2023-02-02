package com.mall.domain;

import lombok.Data;

// 주문관리 : 주문상세정보에서 주문상세상품정보를 사용. 
// (OrderDetailVO, ProductVo 2개의 클래스를 사용 ) 기존의 VO클래스를 이용목적으로 만듬)

@Data
public class OrderDetailProductVO {

	// 기존 클래스
	private OrderDetailVO orderDetailVO; // 주문상세 클래스
	private ProductVO productVO; // 상품 클래스
}
