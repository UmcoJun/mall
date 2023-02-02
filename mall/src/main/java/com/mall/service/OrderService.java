package com.mall.service;

import java.util.List;

import com.mall.domain.CartVO;
import com.mall.domain.CartVOList;
import com.mall.domain.OrderDetailProductVO;
import com.mall.domain.OrderDetailVO;
import com.mall.domain.OrderVO;
import com.mall.domain.PaymentVO;
import com.mall.dto.Criteria;

public interface OrderService {

	List<CartVOList> cart_list(String mem_id);
	
	// 장바구니 -> 주문하기
	void orderSave(OrderVO o_vo, PaymentVO p_vo); // String type 제거
	
	// 바로구매 -> 주문하기
	void orderDirectSave(OrderVO o_vo, OrderDetailVO od_vo, PaymentVO p_vo); // 추가
	
	CartVOList directOrder(CartVO vo);
	
	Long getOrderSequence();
	
	int getOrderProcessCount(String mem_id);
	
	List<OrderVO> getOrderList(String mem_id, Criteria cri);
	
	int getOrderTotalCount(String mem_id);
	
	List<OrderDetailProductVO> getOrderDetailList(Long odr_code);
	
}
