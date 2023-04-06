package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


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
			ps=con.prepareStatement("INSERT INTO users Values (NULL, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,user.getEmail());
			ps.setString(2, user.getFullName());
		    ps.setString(3, user.getPassword());
		    ps.setString(4, user.getPhoto());
			ps.setString(5, user.getRole());
		

			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addUser " +e );
		}
		return -1;		
	}

	@Override
	public User getUserById(int id) {
		try {
			User user = new User();
			ps = con.prepareStatement("SELECT * from users where idUser=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setIdUser(rs.getInt(1));
				user.setEmail(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setPhoto(rs.getString(5));
				user.setRole(rs.getString(7));
				user.setRegisterDate(rs.getString(8));	
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
				user.setEmail(rs.getString(2));
				user.setFullName(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setPhoto(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setRegisterDate(rs.getString(7));	
			}
			return user;

		} catch (Exception e) {
			System.out.println("Connection error : getUserByEmail");
		}

		return null;
	}

	@Override
	public int updateUser(User user) {
		
		try {
			ps=con.prepareStatement("update users set email=?, fullName=?, "
					+ "password=?, photo=?, role=?"
					+ "where idUser=?");
			ps.setString(1,user.getEmail());
			ps.setString(2, user.getFullName());
		    ps.setString(3, user.getPassword());
		    ps.setString(4, user.getPhoto());
			ps.setString(5, user.getRole());
		    ps.setInt(7, user.getIdUser());

			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addUser " +e );
		}
		return -1;		
	}

	@Override
	public int deleteUser(int id) {
		
		try {
			ps=con.prepareStatement("DELETE from users where idUser=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteUser " +e );
		}
		return -1;		
	}

}
