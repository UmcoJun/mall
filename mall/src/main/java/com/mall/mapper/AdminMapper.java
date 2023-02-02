package com.mall.mapper;

import com.mall.domain.AdminVO;

public interface AdminMapper {

	AdminVO adLogin(String admin_id);
	
	void login_update(String admin_id);
}
