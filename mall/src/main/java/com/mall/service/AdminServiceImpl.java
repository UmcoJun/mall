package com.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mall.domain.AdminVO;
import com.mall.mapper.AdminMapper;

import lombok.Setter;

@Service
public class AdminServiceImpl implements AdminService {

	@Setter(onMethod_ = {@Autowired})
	private AdminMapper adminMapper;

	@Override
	public AdminVO adLogin(String admin_id) {
		return adminMapper.adLogin(admin_id);
	}

	@Override
	public void login_update(String admin_id) {
		adminMapper.login_update(admin_id);
	}

}
