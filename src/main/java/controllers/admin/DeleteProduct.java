package controllers.admin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAOImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet({ "/DeleteProduct", "/deleteProduct", "/delP" })
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAOImpl productDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		productDAOImpl = new ProductDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String idp = request.getParameter("idp");
			int id = Integer.parseInt(idp);
			productDAOImpl.deleteProduct(id);
			System.out.println("item was deleted!");
			response.sendRedirect("adminProducts.jsp");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
