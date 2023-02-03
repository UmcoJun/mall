package com.mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mall.domain.CategoryVO;
import com.mall.service.ProductService;

import lombok.extern.log4j.Log4j;
/*
 @ControllerAdvice : 공통모델작업과 Execption(예외처리)에 사용된다. 
 * 
 com.mall.controller 패키지안의 존재하는 컨트롤러의 매핑주소 요청을 받으면, categoryList 메소드가 자동으로 호출된다.
 */
@Log4j
@ControllerAdvice(basePackages = {"com.mall.controller"})
public class GlobalControllerAdvice {

	@Autowired
	private ProductService productService;
	
	 // 1차카테고리 목록을 읽어오는 작업.
	@ModelAttribute
	public void categoryList(Model model) {
		
		log.info("1차카테고리 정보");
		
		List<CategoryVO> cateList = productService.getCategoryList();
		model.addAttribute("maincateList", cateList);
	}
}
