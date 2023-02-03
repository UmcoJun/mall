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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mall.domain.OrderDetailVOList;
import com.mall.domain.OrderVO;
import com.mall.dto.Criteria;
import com.mall.dto.PageDTO;
import com.mall.service.AdOrderService;
import com.mall.util.FileUtils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("admin/order/*")
@Controller
public class AdOrderController {

	@Setter(onMethod_ = {@Autowired})
	private AdOrderService adOrderService;
	
	// 업로드폴더 주입
	@Resource(name = "uploadPath") // servlet-context.xml 설정.
	private String uploadPath; 
	
	// 주문 목록. 클라이언트에서 페이지번호클릭, 검색클릭, 주문상태 버튼 클릭
	@GetMapping("/orderList")
	public void orderList(
			Criteria cri, 
			@ModelAttribute("startDate") String startDate,
			@ModelAttribute("endDate") String endDate,
			@ModelAttribute("odr_status") String odr_status, 
			Model model) {
		
		// 주문 목록
		List<OrderVO> orderList = adOrderService.getOrderList(cri, odr_status, startDate, endDate);
		model.addAttribute("orderList", orderList);
		
		// 페이징 정보
		int totalCount = adOrderService.getOrderTotalCount(cri, odr_status, startDate, endDate);
		model.addAttribute("pageMaker", new PageDTO(cri, totalCount));
		
		// 진행상태 카운트
		model.addAttribute("orderStatus1", adOrderService.orderStatusCount("주문접수"));
		model.addAttribute("orderStatus2", adOrderService.orderStatusCount("결제완료"));
		model.addAttribute("orderStatus3", adOrderService.orderStatusCount("배송준비중"));
		model.addAttribute("orderStatus4", adOrderService.orderStatusCount("배송처리"));
		model.addAttribute("orderStatus5", adOrderService.orderStatusCount("배송완료"));
		model.addAttribute("orderStatus6", adOrderService.orderStatusCount("주문취소"));
		model.addAttribute("orderStatus7", adOrderService.orderStatusCount("미주문"));
		model.addAttribute("orderStatus8", adOrderService.orderStatusCount("취소요청"));
		model.addAttribute("orderStatus9", adOrderService.orderStatusCount("취소완료"));
		model.addAttribute("orderStatus10", adOrderService.orderStatusCount("교환요청"));
		model.addAttribute("orderStatus11", adOrderService.orderStatusCount("교환완료"));
	}
	
	// 주문상태 변경
	@GetMapping("/orderStatusChange")
	public ResponseEntity<String> orderStatusChange(Long odr_code, String odr_status) {
		
		ResponseEntity<String> entity = null;
		
		adOrderService.orderStatusChange(odr_code, odr_status);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 주문상태 체크 변경
	@PostMapping("/orderCheckedStateChange")
	@ResponseBody
	public ResponseEntity<String> orderCheckedStateChange(
			@RequestParam("odr_code_arr[]") List<Long> odr_code_arr, 
			@RequestParam("odr_status_arr[]") List<String> odr_status_arr) {
		
		log.info("주문번호: " + odr_code_arr);
		log.info("주문상태: " + odr_status_arr);
		
		ResponseEntity<String> entity = null;
		
		for(int i = 0; i < odr_code_arr.size(); i++) {
			adOrderService.orderStatusChange(odr_code_arr.get(i), odr_status_arr.get(i));
		}
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 주문 상세보기
	@GetMapping("/orderDetail")
	public void orderDetail(Long odr_code, Model model) {
		
		List<OrderDetailVOList> odList = adOrderService.getOrderDetailList(odr_code);
	
		odList.forEach(vo -> {
			vo.setPdt_img_folder(vo.getPdt_img_folder().replace("\\", "/"));
		});
		
		// 주문 상세정보 OrderDetailVO
		model.addAttribute("odList", odList);
		// 결제정보 
		model.addAttribute("paymentVO", adOrderService.getPayment(odr_code));
		// 주문정보
		model.addAttribute("orderVO", adOrderService.getOrder(odr_code));
	}
	
	// 관리자 메모
	@PostMapping("/pay_memo")
	@ResponseBody
	public ResponseEntity<String> pay_memo(Integer pay_code, String pay_memo) {
		
		ResponseEntity<String> entity = null;
		
		adOrderService.pay_memo(pay_code, pay_memo);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	// 주문삭제
	@GetMapping("/orderDelete")
	public String orderDelete(Criteria cri, Long odr_code, RedirectAttributes rttr) {
		
		adOrderService.orderInfoDelete(odr_code);
		
		rttr.addFlashAttribute("msg", "주문이 삭제되었습니다.");
		
		return "redirect:/admin/order/orderList" + cri.getListLink();
	}
	
	// 주문상품 개별삭제
	@GetMapping("/orderDetailProductDelete")
	@ResponseBody
	public ResponseEntity<String> orderDetailProductDelete(Long odr_code, Integer pdt_num, int odr_price) {
		
		ResponseEntity<String> entity = null;
		
		adOrderService.orderDetailProductDelete(odr_code, pdt_num, odr_price);
		
		entity = new ResponseEntity<String>("success", HttpStatus.OK);
		
		return entity;
	}
	
	
	// 상품목록에서 이미지 보여주기.
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String folderName, String fileName) throws IOException{
		
		// D:\\IT\\upload\\goods\\2022\\11\\22\\
		return FileUtils.getFile(uploadPath + folderName, fileName);
	}
}
