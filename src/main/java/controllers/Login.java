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

import dao.UserDAOImpl;
import extra.values.Strings;
import models.User;

/**
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login", "/connexion", "/Connexion" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAOImpl userDAOImpl;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    public void init(ServletConfig config) throws ServletException {
    	userDAOImpl = new UserDAOImpl();
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
