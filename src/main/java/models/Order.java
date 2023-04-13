package models;

public class Order {
	
	private int idOrder;
	private int idCart;
	
	
	public Order() {
		super();
	}


	public Order(int idOrder, int idCart) {
		super();
		this.idOrder = idOrder;
		this.idCart = idCart;
	}


	public int getIdOrder() {
		return idOrder;
	}


	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}


	public int getIdCart() {
		return idCart;
	}


	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}


	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", idCart=" + idCart + "]";
	}
	
	
	
	
	

}
