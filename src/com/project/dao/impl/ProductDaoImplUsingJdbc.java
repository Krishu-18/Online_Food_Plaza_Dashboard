package com.project.dao.impl;

import com.project.dao.ProductDao;
import com.project.dto.ProductDTO;
import com.project.dto.UserDTO;
import com.project.utility.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplUsingJdbc implements ProductDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public boolean saveProduct(ProductDTO product) {

		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement(
					"insert into tbl_product(Product_Name,Product_Price, Product_Quantity) values(?,?,?)");
			ps.setString(1, product.getProduct_Name());
			ps.setInt(2, product.getProduct_Price());
			ps.setInt(3, product.getProduct_Quantity());

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
	public boolean updateProduct(ProductDTO product) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("update tbl_product set Product_Name=?,Product_Price=?,Product_Quantity=?  where Product_Id=?");
			ps.setInt(4, product.getProduct_Id());
			ps.setString(1, product.getProduct_Name());
			ps.setInt(2, product.getProduct_Price());
			ps.setInt(3, product.getProduct_Quantity());

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
	public boolean deleteProduct(String product_name) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("delete from tbl_product where Product_Name=?");

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

	@Override
	public ProductDTO searchProduct(ProductDTO product_name) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("SELECT * FROM Tbl_Product WHERE PRODUCT_NAME= ?");
			ps.setString(1, product_name.getProduct_Name());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("Product_Id");
				String name = rs.getString("Product_Name");
				int price = rs.getInt("Product_Price");
				int quantity = rs.getInt("Product_Quantity");

				System.out.println("Product id= " + id + " Product name=  " + name + " Product Price= " + price
						+ "Product Qumatity= " + quantity);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return product_name;
	}

	@Override
	public List<ProductDTO> showAllProduct() {
		List<ProductDTO> products = new ArrayList<>();
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("select * from  tbl_product");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("Product_Id");
				String name = rs.getString("Product_Name");
				int price = rs.getInt("Product_Price");
				int quantity = rs.getInt("Product_Quantity");
				ProductDTO product = new ProductDTO(id, name, price, quantity);
				products.add(product);

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
		return products;
	}
}
