package dao;

import java.util.ArrayList;

import models.CartItem;

public interface CartItemDAO {
	
	public int addCartItem(CartItem cartItem);
	public int updateCartItem(CartItem cartItem);
	public CartItem getCartItemById(int id);
	public ArrayList<CartItem> getAllCartItemsByCartId(int id);
	public int deleteCartItem(int id);
	public int updateItemConfirmation(int id);
	public int itemMigration(int id, String str);
	public int countCartItems(int id);

	
}
