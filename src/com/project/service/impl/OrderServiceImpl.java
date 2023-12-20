package com.project.service.impl;
import com.project.dao.impl.OrderDaoImplUsingjdbc;
import com.project.dao.OrderDao;
import com.project.dto.OrderDTO;
import com.project.service.OrderService;

public class OrderServiceImpl implements OrderService {
     private OrderDao orderDao=new OrderDaoImplUsingjdbc();
	@Override
	public boolean bookOrder(OrderDTO order) {
     boolean isOrdersaved= orderDao.bookOrder(order);
		return isOrdersaved;
	}

	@Override
	public boolean cancelOrder(String customer_name) {
		
		return orderDao.cancelOrder(customer_name);
	}

}
