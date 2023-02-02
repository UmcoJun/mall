package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.domain.ReviewVO;
import com.mall.dto.Criteria;

public interface ReviewMapper {

	void create(ReviewVO vo);
	
	List<ReviewVO> list(@Param("pdt_num") Integer pdt_num, @Param("cri") Criteria cri);

	int listCount(Integer pdt_num);
	
	int delete(Long rv_num);
	
	int modify(ReviewVO vo);
}
