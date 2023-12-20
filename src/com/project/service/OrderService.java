package com.project.service;

import com.project.dto.OrderDTO;

public interface OrderService {
	boolean bookOrder(OrderDTO order);

	boolean cancelOrder(String customer_name);
}
