package dao;

import models.Cart;

public interface CartDAO {

	public int addCart(Cart cart);

	public int updateCart(Cart cart);

	public int exist(String session);

	public Cart getCartBySession(String session);

	public int deleteCart(String session);

}
