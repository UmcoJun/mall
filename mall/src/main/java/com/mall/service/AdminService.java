package com.mall.service;

import com.mall.domain.AdminVO;

public interface AdminService {

	AdminVO adLogin(String admin_id);
	
	void login_update(String admin_id);
}
