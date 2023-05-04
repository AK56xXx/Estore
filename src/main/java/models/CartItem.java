package models;

public class CartItem {

	private int idCartItem;
	private int qty;
	private double price;
	private String confirmed;
	private int cartId;
	private int productId;

	public CartItem() {
		super();
	}

	public CartItem(int idCartItem, int qty, double price, String confirmed, int cartId, int productId) {
		super();
		this.idCartItem = idCartItem;
		this.qty = qty;
		this.price = price;
		this.confirmed = confirmed;
		this.cartId = cartId;
		this.productId = productId;
	}

	public int getIdCartItem() {
		return idCartItem;
	}

	public void setIdCartItem(int idCartItem) {
		this.idCartItem = idCartItem;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "CartItem [idCartItem=" + idCartItem + ", qty=" + qty + ", price=" + price + ", confirmed=" + confirmed
				+ ", cartId=" + cartId + ", productId=" + productId + "]";
	}

}
