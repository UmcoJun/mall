package com.mall.domain;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentVO {

	private Integer pay_code; // 일련변호 관리
	private Long	odr_code; // 주문번호
	private String 	mem_id;	  // 회원 ID
	private String	pay_method; // 결제종류
	private Date	pay_date; // 결제날짜
	private int		pay_tot_price; // 결제금액
	private int		pay_nobank_price; // 무통장입금금액
	private int		pay_rest_price; // 미지급금
	private String	pay_nobank_user; // 무통장 입금자명
	private String	pay_nobank; // 무통장 입금은행
	
	private String 	pay_memo;
}
