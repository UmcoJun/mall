package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.domain.CartVO;
import com.mall.domain.CartVOList;
import com.mall.domain.OrderDetailProductVO;
import com.mall.domain.OrderDetailVO;
import com.mall.domain.OrderVO;
import com.mall.domain.PaymentVO;
import com.mall.dto.Criteria;

public interface OrderMapper {

	// 1) 주문 저장하기
	void orderSave(OrderVO vo); // odr_code Null 상태
	
	// 2-1) 주문상세 저장하기.	장바구니테이블의 데이터를 참조해서, 주문상세테이블에 저장한다.
	void orderDetailSave(@Param("odr_code") Long odr_code, @Param("mem_id") String mem_id);
	
	// 2-2) 주문상세 저장하기. 	바로구매에서 주문상세저장하기(장바구니 사용안함)
	void orderDirectDetailSave(OrderDetailVO vo);
	
	// 3) 결제정보 저장하기
	void paymentSave(PaymentVO vo);
	
	// 바로 구매해서 보여줄 주문내역
	CartVOList directOrder(CartVO vo);
	
	// 시퀀스 가져오기
	Long getOrderSequence();
	
	// 진행중인 주문건수(배송완료 전)
	int getOrderProcessCount(String mem_id);
	
	// 주문내역
	List<OrderVO> getOrderList(@Param("mem_id") String mem_id, @Param("cri") Criteria cri);
	
	int getOrderTotalCount(String mem_id);
	
	// 주문상세정보  resultMap 사용
	List<OrderDetailProductVO> getOrderDetailList(Long odr_code);
		
}
