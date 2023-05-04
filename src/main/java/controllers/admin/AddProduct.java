package controllers.admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ProductDAOImpl;
import models.Product;

/**
 * Servlet implementation class AddProduct
 */
@MultipartConfig(maxFileSize = 16177215) // ***************** This annotation make you upload files/images ******************************
@WebServlet({ "/AddProduct", "/addProduct", "/addPrd" })
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAOImpl productDAOImpl;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public void init(ServletConfig config) throws ServletException {
		productDAOImpl = new ProductDAOImpl();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// **************************** you need to work with POST when you upload image or files to work ******************************
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String category = request.getParameter("category");
			String name = request.getParameter("name");
			String desc = request.getParameter("desc");
			String price = request.getParameter("price");
			String oprice = request.getParameter("oprice");
			// steps to get the uploaded image in JSP
			Part filePart = request.getPart("imageFile");
			
			if (filePart != null && filePart.getSize() > 0) {
			   InputStream inputStream = filePart.getInputStream();
			   byte[] imageData = inputStream.readAllBytes();
			    
			
			// transform the image to a Blob object
		    Blob imageBlob = new javax.sql.rowset.serial.SerialBlob(imageData);
	
			
			
			Product p = new Product();
			p.setIdCategory(Integer.parseInt(category));
			p.setProductName(name);
			p.setDescription(desc);
			p.setPrice(Double.parseDouble(price));
			p.setOldPrice(Double.parseDouble(oprice));
			p.setImage(imageBlob);
			
		    productDAOImpl.addProduct(p);
			
			
			response.sendRedirect("adminProducts.jsp");	
			}
			else {
				System.out.println("file empty or not mounted !");
			}
			
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}	
	}

}
