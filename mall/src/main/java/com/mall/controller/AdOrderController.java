package com.mall.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private String uploadPath; // "D:\\IT\\upload\\goods\\"
	
	
	
	// 상품목록에서 이미지 보여주기.
	@ResponseBody
	@GetMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String folderName, String fileName) throws IOException{
		
		// D:\\IT\\upload\\goods\\2022\\11\\22\\
		return FileUtils.getFile(uploadPath + folderName, fileName);
	}
}
