package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAOImpl;
import dao.CartItemDAOImpl;
import dao.UserDAOImpl;
import models.Cart;
import models.CartItem;
import models.User;
import models.Order;
import dao.OrderDAOImpl;

/**
 * Servlet implementation class Command
 */
@WebServlet({ "/Command", "/command", "/order" })
public class Command extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAOImpl cartDAOImpl;
	private UserDAOImpl userDAOImpl;
	private CartItemDAOImpl cartItemDAOImpl;
	private OrderDAOImpl orderDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		userDAOImpl = new UserDAOImpl();
		cartDAOImpl = new CartDAOImpl();
		cartItemDAOImpl = new CartItemDAOImpl();
		orderDAOImpl = new OrderDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			User u = (User) session.getAttribute("user");

			String country = (String) request.getParameter("billing_country");
			String adr = (String) request.getParameter("billing_address_1");
			String city = (String) request.getParameter("billing_city");
			String state = (String) request.getParameter("billing_state");
			String poste = (String) request.getParameter("billing_postcode");
			String tel = (String) request.getParameter("billing_phone");

			u.setCountry(country);
			u.setAddress(adr);
			u.setCity(city);
			u.setState(state);
			u.setPostecode(poste);
			u.setPhone(tel);

			System.out.println(u.toString());
			userDAOImpl.updateUser(u);

			Cart c = cartDAOImpl.getCartBySession(u.getEmail());
			ArrayList<CartItem> listItems = new ArrayList<CartItem>();
			listItems = cartItemDAOImpl.getAllCartItemsByCartId(c.getIdCart());
			for (CartItem ci : listItems) {
				ci.setConfirmed("yes");
				cartItemDAOImpl.updateCartItem(ci);
			}

			Order order = new Order();
			order.setIdCart(c.getIdCart());
			order.setOrderDate(LocalDateTime.now().toString());
			orderDAOImpl.addOrder(order);

			response.sendRedirect("confirmed.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
