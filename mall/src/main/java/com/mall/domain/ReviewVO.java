package com.mall.domain;

import java.util.Date;

import lombok.Data;

// 스프링에서 사용하는 VO클래스는 setter, getter, tostring 메소드 필수

@Data
public class ReviewVO {

	private Long rv_num; 
	private String mem_id; 
	private Integer pdt_num; 
	private String rv_content; 
	private int rv_score; 
	private Date rv_date_reg;
}
