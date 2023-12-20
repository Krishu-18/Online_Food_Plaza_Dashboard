package com.project.service;
import com.project.dto.CartDTO;

public interface CartService{
	boolean addCart(CartDTO cart);

	boolean deleteCart(String product_name);
}
