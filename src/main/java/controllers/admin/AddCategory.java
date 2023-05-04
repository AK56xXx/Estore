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
 * Servlet implementation class AddCategory
 */
@WebServlet({ "/AddCategory", "/addCategory", "/addCtg" })
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAOImpl categoryDAOImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCategory() {
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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			String name = request.getParameter("name");
			Category c = new Category();
			c.setNameCategory(name);
			categoryDAOImpl.addCategory(c);
			response.sendRedirect("adminCategories.jsp");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
