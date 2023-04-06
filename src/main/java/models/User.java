package models;

import java.util.ArrayList;

public class User {
	int idUser;
	String email;
	String fullName;
	String password;
	String photo;
	String role;
	String registerDate;
	
	
	
	
	public User() {
		super();
	}
	
	






	public User(int idUser, String fullName, String email, String password, String photo, String role,
			String registerDate) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.fullName = fullName;
		this.password = password;
		this.photo = photo;
		this.role = role;
		this.registerDate = registerDate;
	}

	
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	

	
	
	
	
	
}
