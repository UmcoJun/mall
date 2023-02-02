package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.domain.ReviewVO;
import com.mall.dto.Criteria;
import com.mall.mapper.ReviewMapper;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	@Override
	public void create(ReviewVO vo) {
		reviewMapper.create(vo);
	}

	@Override
	public List<ReviewVO> list(Integer pdt_num, Criteria cri) {
		return reviewMapper.list(pdt_num, cri);
	}

	@Override
	public int listCount(Integer pdt_num) {
		return reviewMapper.listCount(pdt_num);
	}

	@Override
	public int delete(Long rv_num) {
		return reviewMapper.delete(rv_num);
	}

	@Override
	public int modify(ReviewVO vo) {
		return reviewMapper.modify(vo);
	}

	
}
