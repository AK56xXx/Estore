package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Cart;

public class CartDAOImpl implements CartDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public CartDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addCart(Cart cart) {
		try {
			ps=con.prepareStatement("INSERT INTO cart (session,total) Values (?,?)");
			ps.setString(1,cart.getSession());
			ps.setDouble(2,cart.getTotal());
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addCategory " +e );
		}
		return -1;		
		
	}

	@Override
	public int updateCart(Cart cart) {
		try {
			ps=con.prepareStatement("update cart set total=?"
					+ "where session=?");
			
			
			ps.setDouble(1, cart.getTotal());
			ps.setString(2, cart.getSession());
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : updateCart " +e );
		}
		return -1;		
	}
	
	@Override
	public Cart getCartBySession(String session) {
		try {
			Cart cart = new Cart();
			ps = con.prepareStatement("SELECT * from cart where session=?");
			ps.setString(1, session);
			rs = ps.executeQuery();
			
				if (rs.next()) {
				
				cart.setIdCart(rs.getInt(1));;
				cart.setSession(rs.getString(2));
				cart.setTotal(rs.getDouble(3));	
						
				}
			return cart;
			
			

		} catch (Exception e) {
			System.out.println("Connection error : getCartBySession");
		}

		return null;
	}

	@Override
	public int deleteCart(String session) {
		try {
			ps=con.prepareStatement("DELETE from cart where session=?");
			ps.setString(1,session);			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteCart " +e );
		}
		return -1;		
	}

	@Override
	public int exist(String session) {
		try {
			  ps=con.prepareStatement("SELECT * from cart where session=?");
			  ps.setString(1, session);
			  rs=ps.executeQuery();
			  if(rs.next())
				  return 1;
			  else
				  return 0;
		}catch(Exception e) {
				System.out.println("Connection error : exist");
			}
			
		return -1;
	}

	

}
