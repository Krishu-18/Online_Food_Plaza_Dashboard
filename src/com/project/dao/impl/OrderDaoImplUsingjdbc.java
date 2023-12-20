package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dao.OrderDao;
import com.project.dto.OrderDTO;
import com.project.utility.DbConnection;

public class OrderDaoImplUsingjdbc implements OrderDao {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public boolean bookOrder(OrderDTO order) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("insert into tbl_order(customer_name,customer_id, product_name,"
					+ " product_quantity,totalbill) values(?,?,?,?,?)");
			ps.setString(1,order.getCustomer_name());
			ps.setInt(2, order.getCustomer_id());
			ps.setString(3, order.getProduct_name());
			ps.setInt(4, order.getProduct_quantity());
			ps.setFloat(5, order.getTotalbill());

			int rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					ps.close();
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean cancelOrder(String customer_name) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("delete from tbl_order where customer_name = ?");
			ps.setString(1, customer_name);

			int rows = ps.executeUpdate();
			if (rows > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					ps.close();
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

		
	}

}