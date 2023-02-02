package com.mall.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mall.domain.CategoryVO;
import com.mall.domain.ProductVO;
import com.mall.dto.Criteria;
import com.mall.dto.PageDTO;
import com.mall.service.ProductService;
import com.mall.util.FileUtils;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/product/*")
@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	// 업로드폴더 주입
	@Resource(name = "uploadPath") // servlet-context.xml 설정.
	private String uploadPath; // "D:\\IT\\upload\\goods\\"
		
	
	// 1차카테고리를 참조하는 2차카테고리 목록
	@ResponseBody
	@GetMapping("/subCategoryList/{cate_code}") // 요청주소 /admin/product/subCategoryList/1차 카테고리코드
	public ResponseEntity<List<CategoryVO>> subCategoryList(@PathVariable("cate_code") Integer cate_code) {
		
		ResponseEntity<List<CategoryVO>> entity = null;
		
		entity = new ResponseEntity<List<CategoryVO>>(productService.getSubCategoryList(cate_code), HttpStatus.OK);
		
		return entity;
	}
	
	// 2차카테고리를 참조하는 상품리스트(페이징포함, 검색제외)
	// 예시 : 특수문자 /의 값을 서버가 받을때 @PathVariable이 해결을 할 수가 없다. 중간 작업이 필요하다.
	@GetMapping("/productList/{cate_code}/{cate_name}")
	public String productList(@ModelAttribute("cri") Criteria cri, @PathVariable("cate_code") Integer cate_code, @ModelAttribute("cate_name") String cate_name, Model model) {
		
		log.info("2차카테고리 코드: " + cate_code);
		log.info("2차카테고리 이름: " + cate_name);
		
		// 2차카테고리 이름
		model.addAttribute("cate_name", cate_name);
		
		// 1) 상품목록
		List<ProductVO> productList = productService.getProductListbysubCategory(cate_code, cri);
		
		// 브라우저에서 상품이미지 출력시 DB의 날짜폴더가 \ 로 되어 있어 특수문자로 인한 요청에 문제가 발생한다.
		// \ 를 /로 변환하여, 사용하게 해야한다. 아래 작업
		productList.forEach(vo -> {
			vo.setPdt_img_folder(vo.getPdt_img_folder().replace("\\", "/"));
		});
		
		model.addAttribute("productList", productList);
		
		// 2) 페이징작업
		int totalCount = productService.getProductCountBysubCategory(cate_code, cri);
		
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));

		return "/product/productList";
	}
	
	// 상품상세
	@GetMapping("/productDetail")
	public void productDetail(Integer pdt_num, Model model) {
		
		//model.addAttribute(productService.getProductDetail(pdt_num)); // model 이름 : ProductVO -> productVO
		ProductVO productVO = productService.getProductDetail(pdt_num);
		
		productVO.setPdt_img_folder(productVO.getPdt_img_folder().replace("\\", "/"));
		
		model.addAttribute("productVO", productVO);
	}
	
	// 상품목록에서 이미지 보여주기.
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String folderName, String fileName) throws IOException{
		
		// D:\\IT\\upload\\goods\\2022\\11\\22\\
		return FileUtils.getFile(uploadPath + folderName, fileName);
	}
}
