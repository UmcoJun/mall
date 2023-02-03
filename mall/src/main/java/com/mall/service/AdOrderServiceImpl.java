package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mall.domain.OrderDetailVOList;
import com.mall.domain.OrderVO;
import com.mall.domain.PaymentVO;
import com.mall.dto.Criteria;
import com.mall.mapper.AdOrderMapper;
import com.mall.mapper.AdPaymentMapper;

import lombok.Setter;

@Service
public class AdOrderServiceImpl implements AdOrderService {

	@Setter(onMethod_ = {@Autowired})
	private AdOrderMapper adOrderMapper;
	
	@Setter(onMethod_ = {@Autowired})
	private AdPaymentMapper adPaymentMapper;

	@Override
	public List<OrderVO> getOrderList(Criteria cri, String odr_status, String startDate, String endDate) {
		return adOrderMapper.getOrderList(cri, odr_status, startDate, endDate);
	}

	@Override
	public int getOrderTotalCount(Criteria cri, String odr_status, String startDate, String endDate) {
		return adOrderMapper.getOrderTotalCount(cri, odr_status, startDate, endDate);
	}

	@Override
	public void orderStatusChange(Long odr_code, String odr_status) {
		adOrderMapper.orderStatusChange(odr_code, odr_status);
	}

	@Override
	public int orderStatusCount(String odr_status) {
		return adOrderMapper.orderStatusCount(odr_status);
	}

	@Override
	public List<OrderDetailVOList> getOrderDetailList(Long odr_code) {
		return adOrderMapper.getOrderDetailList(odr_code);
	}

	@Override
	public PaymentVO getPayment(Long odr_code) {
		return adOrderMapper.getPayment(odr_code);
	}

	@Override
	public OrderVO getOrder(Long odr_code) {
		return adOrderMapper.getOrder(odr_code);
	}

	@Override
	public void pay_memo(Integer pay_code, String pay_memo) {
		adOrderMapper.pay_memo(pay_code, pay_memo);
	}

	// 주문 삭제
	@Transactional
	@Override
	public void orderInfoDelete(Long odr_code) {
		
		// 1) 주문상세테이블 삭제
		adOrderMapper.orderDetailDelete(odr_code);
		
		// 2) 결제테이블 삭제
		adOrderMapper.paymentDelete(odr_code);
		
		// 3) 주문테이블 삭제
		adOrderMapper.orderDelete(odr_code);
	}
	
	// 상품 개별삭제 : 1) ORDER_DETAIL_TBL 상품삭제  2) ORDER_TBL 총주문금액 변경(차감)  3) PAYMENT_TBL 총주문금액 변경(차감)
	@Transactional
	@Override
	public void orderDetailProductDelete(Long odr_code, Integer pdt_num, int odr_price) {
		
		// 1) 삭제
		adOrderMapper.orderDetailProductDelete(odr_code, pdt_num);
		
		// 2) 주문테이블 가격변경
		adOrderMapper.orderTotalPriceChange(odr_code, odr_price);
		
		// 3) 결제테이블 가격변경
		adPaymentMapper.orderPayTotalPriceChange(odr_code, odr_price);
	}
	

}
