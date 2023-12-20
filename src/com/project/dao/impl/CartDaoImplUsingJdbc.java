package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.dao.CartDao;
import com.project.dto.CartDTO;
import com.project.utility.DbConnection;

public class CartDaoImplUsingJdbc implements CartDao {
	private Connection con;
	private PreparedStatement ps;

	@Override
	public boolean addCart(CartDTO cart) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("insert into tbl_cart(customer_name,product_id, product_name,"
					+ " product_price, product_quantity) values(?,?,?,?,?)");
			ps.setString(1, cart.getCustomer_name());
			ps.setInt(2, cart.getProduct_id());
			ps.setString(3, cart.getProduct_name());
			ps.setInt(4, cart.getProduct_price());
			ps.setInt(5, cart.getProduct_quantity());

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
	public boolean deleteCart(String product_name) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("delete from tbl_cart where product_name = ?");
			ps.setString(1, product_name);

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
