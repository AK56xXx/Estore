package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.User;

public class UserDAOImpl implements UserDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public UserDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int verifyLogin(String email, String password) {
		try {
			ps = con.prepareStatement("SELECT * from users where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : verifyLogin");
		}

		return -1;
	}

	@Override
	public int addUser(User user) {
		try {
			ps = con.prepareStatement("INSERT INTO users (fname,lname,email,password,id_cart) Values (?, ?, ?, ?, ?)");

			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getIdCart());
			/*
			 * ps.setString(5, user.getPhoto()); ps.setString(6, user.getCountry());
			 * ps.setString(7, user.getAddress()); ps.setString(8, user.getCity());
			 * ps.setString(9, user.getState()); ps.setString(10, user.getPostecode());
			 * ps.setString(11, user.getPhone()); ps.setString(12, user.getRole());
			 */

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addUser " + e);
		}
		return -1;
	}

	@Override
	public User getUserById(int id) {
		try {
			User user = new User();
			ps = con.prepareStatement("SELECT * from users where id_user=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {

				user.setIdUser(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setPhoto(rs.getString(6));
				user.setCountry(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setCity(rs.getString(9));
				user.setState(rs.getString(10));
				user.setPostecode(rs.getString(11));
				user.setPhone(rs.getString(12));
				user.setRole(rs.getString(13));
				user.setIdCart(rs.getInt(14));
				user.setRegisterDate(rs.getString(15));
			}
			return user;

		} catch (Exception e) {
			System.out.println("Connection error : getUserById");
		}

		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			User user = new User();
			ps = con.prepareStatement("SELECT * from users where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {

				user.setIdUser(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setPhoto(rs.getString(6));
				user.setCountry(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setCity(rs.getString(9));
				user.setState(rs.getString(10));
				user.setPostecode(rs.getString(11));
				user.setPhone(rs.getString(12));
				user.setRole(rs.getString(13));
				user.setIdCart(rs.getInt(14));
				user.setRegisterDate(rs.getString(15));

				return user;
			}

		} catch (Exception e) {
			System.out.println("Connection error : getUserByEmail");
		}

		return null;
	}

	@Override
	public int updateUser(User user) {
		try {
			ps = con.prepareStatement("update users set fname=?,lname=?,email=?, "
					+ "password=?, photo=?, country=?, address=?, city=?, state=?, postecode=?, phone=?, role=?, id_cart=? "
					+ "where id_user=?");

			ps.setString(1, user.getFname());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getPhoto());
			ps.setString(6, user.getCountry());
			ps.setString(7, user.getAddress());
			ps.setString(8, user.getCity());
			ps.setString(9, user.getState());
			ps.setString(10, user.getPostecode());
			ps.setString(11, user.getPhone());
			ps.setString(12, user.getRole());
			ps.setInt(13, user.getIdCart());
			ps.setInt(14, user.getIdUser());

			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : addUser " + e);
		}
		return -1;
	}

	@Override
	public int deleteUser(int id) {
		try {
			ps = con.prepareStatement("DELETE from users where id_user=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i > 0)
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : deleteUser " + e);
		}
		return -1;
	}

	@Override
	public int exist(String email) {
		try {
			ps = con.prepareStatement("SELECT * from users where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : exist");
		}

		return -1;
	}

	@Override
	public ArrayList<User> getAllUsers() {
		try {

			ArrayList<User> list = new ArrayList<User>();
			ps = con.prepareStatement("SELECT * from users");
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setPhoto(rs.getString(6));
				user.setCountry(rs.getString(7));
				user.setAddress(rs.getString(8));
				user.setCity(rs.getString(9));
				user.setState(rs.getString(10));
				user.setPostecode(rs.getString(11));
				user.setPhone(rs.getString(12));
				user.setRole(rs.getString(13));
				user.setIdCart(rs.getInt(14));
				user.setRegisterDate(rs.getString(15));

				list.add(user);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getAllUsers");
		}

		return null;

	}

	@Override
	public int verifyRole(String email, String password) {
		try {
			ps = con.prepareStatement("SELECT * from users where email=? and password=? and role=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, "admin");
			rs = ps.executeQuery();
			if (rs.next())
				return 1;
			else
				return 0;
		} catch (Exception e) {
			System.out.println("Connection error : verifyRole " + e.getMessage());
		}

		return -1;
	}

}
