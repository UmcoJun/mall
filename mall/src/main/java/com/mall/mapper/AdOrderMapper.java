package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.domain.OrderDetailVOList;
import com.mall.domain.OrderVO;
import com.mall.domain.PaymentVO;
import com.mall.dto.Criteria;

public interface AdOrderMapper {

	// 주문목록
	List<OrderVO> getOrderList(
			   @Param("cri") Criteria cri, 
			   @Param("odr_status") String odr_status,
			   @Param("startDate") String startDate, @Param("endDate") String endDate);

	// 주문 페이징
	int getOrderTotalCount(
			   @Param("cri") Criteria cri, 
			   @Param("odr_status") String odr_status,
			   @Param("startDate") String startDate, @Param("endDate") String endDate);
	
	// 주문상태 변경
	void orderStatusChange(@Param("odr_code") Long odr_code, @Param("odr_status") String odr_status);

	// 주문진행상태 
	int orderStatusCount(String odr_status);
	
	// 주문 상세보기 
	List<OrderDetailVOList> getOrderDetailList(Long odr_code);
	
	// 결제정보
	PaymentVO getPayment(Long odr_code);
	
	// 주문정보
	OrderVO getOrder(Long odr_code);
	
	// 관리자메모
	void pay_memo(@Param("pay_code") Integer pay_code, @Param("pay_memo") String pay_memo);

	// 주문삭제
	void orderDelete(Long odr_code);
	void orderDetailDelete(Long odr_code);
	void paymentDelete(Long odr_code);
	
	// 1) 개별상품삭제기능
	void orderDetailProductDelete(@Param("odr_code") Long odr_code, @Param("pdt_num") Integer pdt_num);
	
	// 2) 주문테이블 총 금액 변경
	void orderTotalPriceChange(@Param("odr_code") Long odr_code, @Param("odr_price") int odr_price);
}
