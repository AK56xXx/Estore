package controllers;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet({ "/Home", "/home" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Generate a unique identifier using UUID
        String uniqueId = UUID.randomUUID().toString();

        // Create a cookie with the unique identifier
        Cookie cookie = new Cookie("uniqueId", uniqueId);

        // Set the cookie's expiration time (optional)
        cookie.setMaxAge(365 * 24 * 60 * 60); // 1 year

        // Set the cookie on the response
        response.addCookie(cookie);

        // Output the unique identifier to the response
        response.getWriter().write("Your unique identifier is: " + uniqueId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
