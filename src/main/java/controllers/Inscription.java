package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import extra.db.DataBaseConnection;

/**
 * Servlet implementation class Inscription
 */
@WebServlet({ "/Inscription", "/inscription" , "/signup" })
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String fullname = (String) request.getParameter("fullname");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		
		DataBaseConnection.getConnected();
		RequestDispatcher rd ;

		
		int existe = DataBaseConnection.exist(email);
		if (existe==1) {
			request.setAttribute("ERROR", "Utilisateur existe déja !");
			rd = request.getRequestDispatcher("signup.jsp");
		}else {
			 int creation = DataBaseConnection.createUser(fullname, email, password);
			if (creation==1) {
				HttpSession session = request.getSession();
				session.setAttribute("user", fullname);
				rd = request.getRequestDispatcher("index.jsp");
			}else {
				request.setAttribute("ERROR", "Erreur lors de l'ajout !");
				rd = request.getRequestDispatcher("signup.jsp");
			}
		}
		
		rd.forward(request, response);
		
	}

}
