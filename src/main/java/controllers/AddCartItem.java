package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

/**
 * Servlet implementation class AddCartItem
 */
@WebServlet({ "/AddCartItem", "/addCartItem", "/addItem" })
public class AddCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAOImpl cartDAOImpl;
	private UserDAOImpl userDAOImpl;
	private CartItemDAOImpl cartItemDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
	  	userDAOImpl = new UserDAOImpl();
	    cartDAOImpl = new CartDAOImpl();
	    cartItemDAOImpl = new CartItemDAOImpl();
	}
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		 HttpSession session = request.getSession();
		 
		 String sessionId = session.getId();
		 String idp = request.getParameter("idp");
		 String idu = request.getParameter("idu");
		 String p = request.getParameter("p");
		
		 if (idp != null && !idp.isEmpty() && idu != null && !idu.isEmpty() && p != null && !p.isEmpty()) { 
		 
		
	     int idUser = Integer.parseInt(idu);
			 
		 int idProduct = Integer.parseInt(idp);
		  
		 double price = Double.parseDouble(p);
		 
		 int exist = cartDAOImpl.exist(sessionId);	 
		 
		 
		
		 

		 
		 if (idUser == 0 && exist == 0) {
			 
			 Cart c = new Cart();
			 c.setSession(sessionId);
			 cartDAOImpl.addCart(c);
			 Cart cp = cartDAOImpl.getCartBySession(sessionId);
			 int idc = cp.getIdCart();
			 CartItem ci = new CartItem();
			 ci.setCartId(idc);
			 ci.setProductId(idProduct);
			 ci.setPrice(price);
			 ci.setQty(1);
			 cartItemDAOImpl.addCartItem(ci);

		 }
		 
	     else if(idUser == 0 && exist == 1 ) {
	    	 
	    	 Cart cartUser = cartDAOImpl.getCartBySession(sessionId);
			 CartItem itemUser = new CartItem();
			 itemUser.setCartId(cartUser.getIdCart());
			 itemUser.setProductId(idProduct);
			 itemUser.setPrice(price);
			 itemUser.setQty(1);
			 cartItemDAOImpl.addCartItem(itemUser);
				
		
	    	     	 
	     }
				 
		 else {
			 
			 
			User u = (User) session.getAttribute("user");
			String emailSession = u.getEmail();
			
			Cart cartUser = cartDAOImpl.getCartBySession(emailSession);
			
			
			CartItem itemUser = new CartItem();
			itemUser.setCartId(cartUser.getIdCart());
			itemUser.setProductId(idProduct);
			itemUser.setPrice(price);
			itemUser.setQty(1);
			cartItemDAOImpl.addCartItem(itemUser);
			
			//migration session items ---> user items
			
		/*	ArrayList<CartItem> cis = new ArrayList<CartItem>();
			Cart cartSession = cartDAOImpl.getCartBySession(sessionId);
			cis = cartItemDAOImpl.getAllCartItemsByCartId(cartSession.getIdCart());
			for (CartItem ci : cis) {
				
				CartItem cartItem = new CartItem();
				
				cartItem.setCartId(cartUser.getIdCart());
				cartItem.setProductId(ci.getProductId());
				cartItem.setPrice(ci.getPrice());
				cartItem.setQty(ci.getQty());	
				cartItemDAOImpl.addCartItem(cartItem);			
				
			}*/
			
			
			
		}
		 
		System.out.println("item added to cart!");
		response.sendRedirect("cart.jsp");	
		
		
		
		}
		 
		 
		}catch (NullPointerException | NumberFormatException e)
		{
			System.out.println("item null : " +e.getMessage());
		} 
			
	
			 
		 
		 
	
	
	/*	String idp = (String) request.getParameter("email");
		String session = (String) request.getParameter("password");
		String idu = (String) request.getParameter("password");
		

		RequestDispatcher rd ;
		
		int x = userDAOImpl.verifyLogin(email, password);
		
			
			User user = userDAOImpl.getUserByEmail(email);
		
			HttpSession session = request.getSession();
			
			session.setAttribute("user", user); */
			
			
			/**********************/
			
			
			
			
			
			
			
			
		//	rd = request.getRequestDispatcher("cart.jsp");	
		
	}





	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
