package com.project.service.impl;
import com.project.dto.CartDTO;
import com.project.dao.impl.CartDaoImplUsingJdbc;
import com.project.service.CartService;
import com.project.dao.CartDao;


public class CartServiceImpl implements CartService {
	private CartDao cartDao = new CartDaoImplUsingJdbc();// downcasting
	@Override
	public boolean addCart(CartDTO cart) {
		boolean isCartProductSaved = cartDao.addCart(cart);
		return isCartProductSaved;
	}

	@Override
	public boolean deleteCart(String product_name) {
		return cartDao.deleteCart(product_name);
	}
}
