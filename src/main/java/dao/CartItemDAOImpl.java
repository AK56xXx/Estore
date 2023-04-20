package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.CartItem;


public class CartItemDAOImpl implements CartItemDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	

	public CartItemDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addCartItem(CartItem cartItem) {
		try {
			ps=con.prepareStatement("INSERT INTO cart_item (qty,price,cart_id,product_id) Values (?,?,?,?)");
			
			ps.setInt(1,cartItem.getQty());
			ps.setDouble(2,cartItem.getPrice());
			ps.setInt(3,cartItem.getCartId());
			ps.setInt(4,cartItem.getProductId());
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addCartItem " +e );
		}
		return -1;		
	}

	@Override
	public int updateCartItem(CartItem cartItem) {
		try {
			ps=con.prepareStatement("UPDATE cart_item set qty=?, price=?, confirmed=? where id=?");
			ps.setInt(1,cartItem.getQty());
			ps.setDouble(2,cartItem.getPrice());
			ps.setString(3,cartItem.getConfirmed());
			ps.setInt(4,cartItem.getIdCartItem());
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : updateCartItem " +e );
		}
		return -1;		
	}

	@Override
	public CartItem getCartItemById(int id) {
		try {
			CartItem cartItem = new CartItem();
			ps=con.prepareStatement("select * from cart_item where id=? ");
			
			ps.setInt(1,id);

			rs = ps.executeQuery();
	
			if (rs.next()) {
				
				cartItem.setIdCartItem(rs.getInt(1));
				cartItem.setQty(rs.getInt(2));
				cartItem.setPrice(rs.getDouble(3));
				cartItem.setConfirmed(rs.getString(4));
				cartItem.setCartId(rs.getInt(5));
				cartItem.setProductId(rs.getInt(6));
				
			}
			return cartItem;

		} catch (Exception e) {
			System.out.println("Connection error : getCartItemById");
		}

		return null;
	}

	@Override
	public ArrayList<CartItem> getAllCartItemsByCartId(int id) {
		try {
			String no = "no";
			ArrayList<CartItem> list = new ArrayList<CartItem>();
			ps=con.prepareStatement("select * from cart_item where cart_id=? and confirmed=?");
			
			ps.setInt(1,id);
			ps.setString(2, no);

			rs = ps.executeQuery();
	
			while (rs.next()) {
				CartItem cartItem = new CartItem();
				cartItem.setIdCartItem(rs.getInt(1));
				cartItem.setQty(rs.getInt(2));
				cartItem.setPrice(rs.getDouble(3));
				cartItem.setConfirmed(rs.getString(4));
				cartItem.setCartId(rs.getInt(5));
				cartItem.setProductId(rs.getInt(6));
				
				list.add(cartItem);
			}
			return list;

		} catch (Exception e) {
			System.out.println("Connection error : getCartItemsByCartId");
		}

		return null;
	}

	@Override
	public int deleteCartItem(int id) {
		try {
			ps=con.prepareStatement("DELETE from cart_item where id=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteCartItem " +e );
		}
		return -1;		
	}

	@Override
	public int updateItemConfirmation(int id) {
		return id;
	
	}

	@Override
	public int itemMigration(int id,String str) {
		try {
			ps=con.prepareStatement("update cart_item as ct,(select id_cart from cart where `session`= ? as c) set ct.cart_id=c.id_cart ");
			
			ps.setInt(1,id);
			ps.setString(2,str);
				
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : itemMigration " +e );
		}
		return -1;		
	}

	@Override
	public int countCartItems(int id) {
		try {
			ps=con.prepareStatement("select count(*) as count from cart_item where cart_id=? and confirmed=?");
			ps.setInt(1,id);
			ps.setString(2,"no");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
			return rs.getInt("count");
			}
			} catch(Exception e) {
			System.out.println("Connection error : countCartItem " + e);
			}
			return -1;
			
	}


}
