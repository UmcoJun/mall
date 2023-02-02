package com.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.mapper.AdOrderMapper;

import lombok.Setter;

@Service
public class AdOrderServiceImpl implements AdOrderService {

	@Setter(onMethod_ = {@Autowired})
	private AdOrderMapper adOrderMapper;
	
	

}
