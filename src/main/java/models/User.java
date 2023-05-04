package models;

public class User {

	private int idUser;
	private String email;
	private String fname;
	private String lname;
	private String password;
	private String photo;
	private String country;
	private String address;
	private String city;
	private String state;
	private String postecode;
	private String phone;
	private String role;
	private int idCart;
	private String registerDate;

	public User() {
		super();
	}

	public User(int idUser, String email, String fname, String lname, String password, String photo, String country,
			String address, String city, String state, String postecode, String phone, String role, int idCart,
			String registerDate) {
		super();
		this.idUser = idUser;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.password = password;
		this.photo = photo;
		this.country = country;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postecode = postecode;
		this.phone = phone;
		this.role = role;
		this.idCart = idCart;
		this.registerDate = registerDate;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostecode() {
		return postecode;
	}

	public void setPostecode(String postecode) {
		this.postecode = postecode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", email=" + email + ", fname=" + fname + ", lname=" + lname + ", password="
				+ password + ", photo=" + photo + ", country=" + country + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", postecode=" + postecode + ", phone=" + phone + ", role=" + role + ", idCart="
				+ idCart + ", registerDate=" + registerDate + "]";
	}

}
