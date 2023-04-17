package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import models.Order;

public class OrderDAOImpl implements OrderDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	

	public OrderDAOImpl() {
		con = extra.db.DataBaseConnection.getConnected();
	}

	@Override
	public int addOrder(Order order) {
		try {
			ps=con.prepareStatement("INSERT INTO order_sales (cart_id, order_date) Values (?,?)");
			ps.setInt(1,order.getIdCart());
			ps.setString(2,order.getOrderDate());
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : addOrder " +e );
		}
		return -1;		
	}

	@Override
	public int updateOrder(Order order) {
		try {
			ps=con.prepareStatement("UPDATE order_sales set cart_id=?, order_date=? where id=?");
			ps.setInt(1,order.getIdCart());
			ps.setString(2,order.getOrderDate());
			ps.setInt(3,order.getIdOrder());
			
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : updateOrder " +e );
		}
		return -1;		
	}

	@Override
	public Order getOrderById(int id) {
		try {
			Order order = new Order();
			ps=con.prepareStatement("select * from order_sales where id=?");
			
			ps.setInt(1,id);

			rs = ps.executeQuery();
	
			if (rs.next()) {
				
				order.setIdOrder(rs.getInt(1));
				order.setIdCart(rs.getInt(2));
				order.setOrderDate(rs.getString(3));
			}
			return order;

		} catch (Exception e) {
			System.out.println("Connection error : getOrderById");
		}

		return null;
	}

	@Override
	public ArrayList<Order> getAllOrdersByCart(int id) {
		try {
		
		ArrayList<Order> list = new ArrayList<Order>();
		
		ps=con.prepareStatement("select * from order_sales where cart_id=?");
		
		ps.setInt(1,id);

		rs = ps.executeQuery();

		if (rs.next()) {
			Order order = new Order();
			order.setIdOrder(rs.getInt(1));
			order.setIdCart(rs.getInt(2));
			order.setOrderDate(rs.getString(3));
			
			list.add(order);
		}
		return list;

	} catch (Exception e) {
		System.out.println("Connection error : getCartItemsByCartId");
	}

	return null;
	}

	@Override
	public int deleteOrder(int id) {
		try {
			ps=con.prepareStatement("DELETE from order_sales where id=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if (i>0)
				return 1;
			else
				return 0;
		}catch(Exception e){
			System.out.println("Connection error : deleteOrder " +e );
		}
		return -1;		
	}



}
