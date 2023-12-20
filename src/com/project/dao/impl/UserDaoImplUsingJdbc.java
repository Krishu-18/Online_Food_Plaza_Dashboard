package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.utility.DbConnection;

public class UserDaoImplUsingJdbc implements UserDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public boolean saveUser(UserDTO user) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("insert into tbl_user(name, email, pass) values(?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());

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
	public boolean updateUser(UserDTO user) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("update tbl_user set name=?,email=?,pass=?  where id=?");
			ps.setInt(4, user.getId());
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPass());

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
	public boolean deleteUser(String email) {
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("delete from tbl_user where email=?");

			ps.setString(1, email);

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
	public UserDTO searchUser(UserDTO user) {

		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("SELECT * FROM Tbl_User WHERE EMAIL= ?");
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				String pass = rs.getString("PASS");
				System.out.println("id=" + id + "name=" + name + "email=" + email + "password=" + pass);
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
		return user;
	}

	@Override
	public List<UserDTO> showAllUser() {
		List<UserDTO> users = new ArrayList<>();
		try {
			con = DbConnection.establishConnection();
			ps = con.prepareStatement("select * from  tbl_user");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String pass = rs.getString("pass");
				UserDTO user = new UserDTO(id, name, email, pass);
				users.add(user);

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
		return users;
	}

}
