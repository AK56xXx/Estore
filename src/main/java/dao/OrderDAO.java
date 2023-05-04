package dao;

import java.util.ArrayList;

import models.Order;

public interface OrderDAO {

	public int addOrder(Order order);

	public int updateOrder(Order order);

	public Order getOrderById(int id);

	public ArrayList<Order> getAllOrdersByCart(int id);

	public int deleteOrder(int id);

}
