package com.mall.service;

import java.util.List;

import com.mall.domain.ReviewVO;
import com.mall.dto.Criteria;

public interface ReviewService {

	void create(ReviewVO vo);
	
	List<ReviewVO> list(Integer pdt_num, Criteria cri);

	int listCount(Integer pdt_num);
	
	int delete(Long rv_num);
	
	int modify(ReviewVO vo);
}
