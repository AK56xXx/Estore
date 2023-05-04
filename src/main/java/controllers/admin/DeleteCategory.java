package controllers.admin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAOImpl;

/**
 * Servlet implementation class DeleteCategory
 */
@WebServlet({ "/DeleteCategory", "/deleteCategory", "/deleteCtg" })
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAOImpl categoryDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		categoryDAOImpl = new CategoryDAOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String idc = request.getParameter("idc");
			int id = Integer.parseInt(idc);
			categoryDAOImpl.deleteCategory(id);
			System.out.println("item was deleted!");
			response.sendRedirect("adminCategories.jsp");
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
