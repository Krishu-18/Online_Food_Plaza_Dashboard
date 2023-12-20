package com.project.dao;

import com.project.dto.CartDTO;

public interface CartDao {
	boolean addCart(CartDTO cart);

	boolean deleteCart(String product_name);
}
