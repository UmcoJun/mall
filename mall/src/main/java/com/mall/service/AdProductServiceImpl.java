package com.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.domain.CategoryVO;
import com.mall.domain.ProductVO;
import com.mall.dto.Criteria;
import com.mall.mapper.AdProductMapper;

import lombok.Setter;

@Service
public class AdProductServiceImpl implements AdProductService {

	@Setter(onMethod_ = {@Autowired})
	private AdProductMapper adProductMapper;

	@Override
	public List<CategoryVO> getCategoryList() {
		return adProductMapper.getCategoryList();
	}

	@Override
	public List<CategoryVO> getSubCategoryList(Integer cate_code) {
		return adProductMapper.getSubCategoryList(cate_code);
	}

	@Override
	public void productInsert(ProductVO vo) {
		adProductMapper.productInsert(vo);
	}

	@Override
	public List<ProductVO> getProductList(Criteria cri) {
		return adProductMapper.getProductList(cri);
	}

	@Override
	public int getProductTotalCount(Criteria cri) {
		return adProductMapper.getProductTotalCount(cri);
	}

	@Override
	public ProductVO getProductByNum(Integer pdt_num) {
		return adProductMapper.getProductByNum(pdt_num);
	}

	@Override
	public void productModify(ProductVO vo) {
		adProductMapper.productModify(vo);
	}

	@Override
	public void productDelete(Integer pdt_num) {
		adProductMapper.productDelete(pdt_num);
	}

	@Override
	public void btnSalesYN(Integer pdt_num, String pdt_buy) {
		adProductMapper.btnSalesYN(pdt_num, pdt_buy);
	}
	
}
