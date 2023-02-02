package com.mall.service;

import java.util.List;

import com.mall.domain.CartVO;
import com.mall.domain.CartVOList;

public interface CartService {

	void cart_add(CartVO vo);
	
	List<CartVOList> cart_list(String mem_id);
	
	void cart_qty_change(Long cart_code, int cart_amount);

	void cart_delete(Long cart_code);
	
	void cart_empty(String mem_id);
	
	void cart_sel_delete(List<Long> cart_code_arr);

	int getCartProductCountByUserID(String mem_id);
}
