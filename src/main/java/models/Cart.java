package models;

public class Cart {

	private int idCart;
	private String session;
	private double total;

	public Cart() {
		super();
	}

	public Cart(int idCart, String session, double total) {
		super();
		this.idCart = idCart;
		this.session = session;
		this.total = total;
	}

	public int getIdCart() {
		return idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [idCart=" + idCart + ", session=" + session + ", total=" + total + "]";
	}

}
