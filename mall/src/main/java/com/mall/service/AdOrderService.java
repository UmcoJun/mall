package com.mall.service;

import java.util.List;

import com.mall.domain.OrderDetailVOList;
import com.mall.domain.OrderVO;
import com.mall.domain.PaymentVO;
import com.mall.dto.Criteria;

public interface AdOrderService {

	List<OrderVO> getOrderList(
			   Criteria cri, 
			   String odr_status,
			   String startDate, String endDate);

	int getOrderTotalCount(
			   Criteria cri, 
			   String odr_status,
			   String startDate, String endDate);

	void orderStatusChange(Long odr_code, String odr_status);
	
	int orderStatusCount(String odr_status);
	
	List<OrderDetailVOList> getOrderDetailList(Long odr_code);
	
	PaymentVO getPayment(Long odr_code);
	
	OrderVO getOrder(Long odr_code);
	
	void pay_memo(Integer pay_code, String pay_memo);
	
	void orderInfoDelete(Long odr_code);
	
	void orderDetailProductDelete(Long odr_code, Integer pdt_num, int odr_price);
}
