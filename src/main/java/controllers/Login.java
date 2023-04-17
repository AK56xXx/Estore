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
import extra.values.Strings;
import models.Cart;
import models.CartItem;
import models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login", "/connexion", "/Connexion" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAOImpl;
	private CartDAOImpl cartDAOImpl;
	private CartItemDAOImpl cartItemDAOImpl;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init(ServletConfig config) throws ServletException {
    	userDAOImpl = new UserDAOImpl();
    	cartDAOImpl = new CartDAOImpl();
    	cartItemDAOImpl = new CartItemDAOImpl();
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd ;
		rd = request.getRequestDispatcher("connexion.jsp");	
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		
		

		RequestDispatcher rd ;
		
		int x = userDAOImpl.verifyLogin(email, password);
		if (x==1) {
			
			User user = userDAOImpl.getUserByEmail(email);
		
			HttpSession session = request.getSession();
			
			session.setAttribute("user", user);
			
			
			/**********************/
			String sessionId = session.getId();
			User u = (User) session.getAttribute("user");
			String emailSession = u.getEmail();
			
			Cart cartUser = cartDAOImpl.getCartBySession(emailSession);
			ArrayList<CartItem> cis = new ArrayList<CartItem>();
			Cart cartSession = cartDAOImpl.getCartBySession(sessionId);
			cis = cartItemDAOImpl.getAllCartItemsByCartId(cartSession.getIdCart());
			for (CartItem ci : cis) {
				
				CartItem cartItem = new CartItem();
				
				cartItem.setCartId(cartUser.getIdCart());
				cartItem.setProductId(ci.getProductId());
				cartItem.setPrice(ci.getPrice());
				cartItem.setQty(ci.getQty());
				
				cartItemDAOImpl.addCartItem(cartItem);
				
				
				
				
			}
			
		/**********************/	
			
			
			
			
			rd = request.getRequestDispatcher("index.jsp");	
			
			
		}else if(x==0) {
			
			request.setAttribute("ERROR", Strings.ERROR_LOGIN);
			rd = request.getRequestDispatcher("connexion.jsp");
			
		}else {
			request.setAttribute("ERROR", Strings.ERROR_DB_PROBLEM);
			rd = request.getRequestDispatcher("connexion.jsp");	
		}
		
		rd.forward(request, response);
		
	}

}
