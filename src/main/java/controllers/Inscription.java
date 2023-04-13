package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartDAOImpl;
import dao.UserDAOImpl;
import extra.values.Strings;
import models.Cart;
import models.User;

/**
 * Servlet implementation class Inscription
 */
@WebServlet({ "/Inscription", "/inscription" , "/signup" })
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartDAOImpl cartDAOImpl;
	private UserDAOImpl userDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDAOImpl = new UserDAOImpl();
		cartDAOImpl = new CartDAOImpl();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd ;
		rd = request.getRequestDispatcher("signup.jsp");	
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname = (String) request.getParameter("fname");
		String lname = (String) request .getParameter("lname");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		

		RequestDispatcher rd ;
	
		

		
		int existe = userDAOImpl.exist(email) ;
		if (existe==1) {
			request.setAttribute("ERROR", Strings.ERROR_EMAIL_EXIST);
			rd = request.getRequestDispatcher("signup.jsp");
		}else {
			
			Cart cart = new Cart();
			cart.setSession(email);
			cartDAOImpl.addCart(cart);
		
			
			Cart cartAdded = new Cart();
			cartAdded = cartDAOImpl.getCartBySession(email);
			
			User user = new User();
			user.setFname(fname);
			user.setLname(lname);
			user.setEmail(email);
			user.setPassword(password);
			user.setIdCart(cartAdded.getIdCart());
			
					
			int creation = userDAOImpl.addUser(user);
			if (creation==1) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				rd = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("ERROR", Strings.ERROR_DB_PROBLEM);
				rd = request.getRequestDispatcher("signup.jsp");
			}
		}
		
		rd.forward(request, response);
		
	}

}
