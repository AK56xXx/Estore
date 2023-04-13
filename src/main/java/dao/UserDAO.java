package dao;

import java.util.ArrayList;

import models.User;

public interface UserDAO {
	
	public int verifyLogin(String email, String password);
	public int exist(String email);
	public int addUser(User user);
	public User getUserById(int id);
	public User getUserByEmail(String email);
	public int updateUser(User user);
	public ArrayList<User>getAllUsers();
	public int deleteUser(int id);
	
}
