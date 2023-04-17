package controllers;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartItemDAOImpl;

/**
 * Servlet implementation class DeleteCartItem
 */
@WebServlet({ "/DeleteCartItem", "/deleteItem", "/deleteCartItem" })
public class DeleteCartItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CartItemDAOImpl cartItemDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartItem() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		cartItemDAOImpl = new CartItemDAOImpl();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String idp = request.getParameter("idp");
		int idProduct = Integer.parseInt(idp);
		cartItemDAOImpl.deleteCartItem(idProduct);
		System.out.println("item was deleted!");
		response.sendRedirect("cart.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
