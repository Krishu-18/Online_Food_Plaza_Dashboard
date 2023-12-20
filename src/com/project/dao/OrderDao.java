package com.project.dao;

import com.project.dto.OrderDTO;

public interface OrderDao {
	boolean bookOrder(OrderDTO cart);

	boolean cancelOrder(String customer_name);
}
