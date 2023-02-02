package com.mall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mall.domain.CategoryVO;
import com.mall.domain.ProductVO;
import com.mall.dto.Criteria;

public interface AdProductMapper {
	
	// 1차카테고리 목록
	List<CategoryVO> getCategoryList();
	
	// 1차카테고리 참조하는 2차카테고리 목록
	List<CategoryVO> getSubCategoryList(Integer cate_code);

	// 상품정보 저장
	void productInsert(ProductVO vo);
	
	// 상품목록
	List<ProductVO> getProductList(Criteria cri);
	
	// 상품개수
	int getProductTotalCount(Criteria cri);
	
	// 상품수정정보
	ProductVO getProductByNum(Integer pdt_num);
	
	// 상품수정하기
	void productModify(ProductVO vo);
	
	// 상품삭제하기
	void productDelete(Integer pdt_num);
	
	// 판매여부 변경
	void btnSalesYN(@Param("pdt_num") Integer pdt_num, @Param("pdt_buy") String pdt_buy);
	
}
