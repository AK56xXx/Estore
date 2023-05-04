package controllers.admin;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAOImpl;
import models.Category;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet({ "/UpdateCategory", "/updateCategory", "/updateCtg" })
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAOImpl categoryDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCategory() {
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
			String name = request.getParameter("name");
			int id = Integer.parseInt(idc);
			Category c = new Category();
			c.setNameCategory(name);
			c.setIdCategory(id);

			categoryDAOImpl.updateCategory(c);
			response.sendRedirect("adminCategories.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
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
