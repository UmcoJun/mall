package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.domain.CategoryVO;
import com.mall.domain.ProductVO;
import com.mall.dto.Criteria;
import com.mall.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<CategoryVO> getCategoryList() {
		return productMapper.getCategoryList();
	}

	@Override
	public List<CategoryVO> getSubCategoryList(Integer cate_code) {
		return productMapper.getSubCategoryList(cate_code);
	}

	@Override
	public List<ProductVO> getProductListbysubCategory(Integer cate_code, Criteria cri) {
		return productMapper.getProductListbysubCategory(cate_code, cri);
	}

	@Override
	public int getProductCountBysubCategory(Integer cate_code, Criteria cri) {
		return productMapper.getProductCountBysubCategory(cate_code, cri);
	}

	@Override
	public ProductVO getProductDetail(Integer pdt_num) {
		return productMapper.getProductDetail(pdt_num);
	}
}
