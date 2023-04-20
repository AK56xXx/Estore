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
import models.Product;
import models.User;
import dao.OrderDAOImpl;
import dao.ProductDAOImpl;

/**
 * Servlet implementation class Checkout
 */
@WebServlet({ "/Checkout", "/checkout", "/orderCheckout" })
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAOImpl cartDAOImpl;
	private UserDAOImpl userDAOImpl;
	private CartItemDAOImpl cartItemDAOImpl;
	private OrderDAOImpl orderDAOImpl;
	private ProductDAOImpl productDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		userDAOImpl = new UserDAOImpl();
	    cartDAOImpl = new CartDAOImpl();
	    cartItemDAOImpl = new CartItemDAOImpl();
	    orderDAOImpl = new OrderDAOImpl();
	    productDAOImpl = new ProductDAOImpl();
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		
		if (u==null) {
			
			response.sendRedirect("connexion.jsp");	
			
		}
		else {
		/*	double total = 0;	
			ProductDAOImpl productCRUD = new ProductDAOImpl();
			Product p = new Product();
			
			 Cart c = cartDAOImpl.getCartBySession(u.getEmail());
			 ArrayList<CartItem> listItems = new ArrayList<CartItem>();
		     listItems = cartItemDAOImpl.getAllCartItemsByCartId(c.getIdCart());
		     for(CartItem ci : listItems){ 
              p = productCRUD.getProductById(ci.getProductId()); 
              
              total = total + p.getPrice();
              ci.setConfirmed("yes");
		     }
		     c.setTotal(total);
		     
		     cartDAOImpl.updateCart(c); */
		        
			response.sendRedirect("checkout.jsp");	
			
		}
		
		
		
		
		
		
		
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
		
		
	}

}
