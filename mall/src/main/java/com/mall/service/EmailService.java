package com.mall.service;

import com.mall.dto.EmailDTO;

public interface EmailService {

	void sendMail(EmailDTO dto, String message);
}
