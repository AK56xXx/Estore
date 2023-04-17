package models;

public class Order {
	
	private int idOrder;
	private int idCart;
	private String orderDate;
	
	
	public Order() {
		super();
	}
	
	public Order(int idOrder, int idCart, String orderDate) {
		super();
		this.idOrder = idOrder;
		this.idCart = idCart;
		this.orderDate = orderDate;
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
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", idCart=" + idCart + ", orderDate=" + orderDate
				+ "]";
	}

	
	

}
