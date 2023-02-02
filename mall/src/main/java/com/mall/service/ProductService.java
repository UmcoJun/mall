package com.mall.service;

import java.util.List;

import com.mall.domain.CategoryVO;
import com.mall.domain.ProductVO;
import com.mall.dto.Criteria;

public interface ProductService {

	List<CategoryVO> getCategoryList();
	
	List<CategoryVO> getSubCategoryList(Integer cate_code);

	List<ProductVO> getProductListbysubCategory(Integer cate_code, Criteria cri);
	
	int getProductCountBysubCategory(Integer cate_code, Criteria cri);

	ProductVO getProductDetail(Integer pdt_num);
}
