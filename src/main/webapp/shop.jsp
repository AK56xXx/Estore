<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Product" %>
<%@ page import="models.User" %>
<%@ page import="dao.ProductDAOImpl" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<!--
	ustora by freshdesignweb.com
	Twitter: https://twitter.com/freshdesignweb
	URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shop Page- Ustora Demo</title>
    
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>
    
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    
    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/menu.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <%@ include file="header.jsp" %>
    <%
    try{
    int idu;
    try {
    	if(!session.getAttribute("user").equals(null))
    	{
    	User u = (User) session.getAttribute("user");
        idu = u.getIdUser();
    	}
    	else {
    		idu=0;
    	}
    } catch (Exception e) {
        idu = 0;
    }

     String sessionId = session.getId();
  
    int idc =Integer.parseInt(request.getParameter("idc"));
    
    CategoryDAOImpl ct = new CategoryDAOImpl();
    Category category = new Category();
    category = ct.getCategoryById(idc);
    
    
    %>
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2><%= category.getNameCategory() %></h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
   <form action="AddCartItem" method="get">
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
            <% 
            	
				ProductDAOImpl productDAOImpl= new ProductDAOImpl();
				ArrayList<Product> products = productDAOImpl.getAllProductsByCategory(idc);
			
				for (int i=0; i<products.size();i++){
			%>
                <div class="col-md-3 col-sm-6">
                    <div class="single-shop-product">
                        <div class="product-upper">
                        <%
                        // convert Blob objct to an image
                        Blob blob = products.get(i).getImage();
                        if (blob != null) {
                        InputStream inputStream = blob.getBinaryStream();
                        byte[] imageData = inputStream.readAllBytes();
                        String base64Image = Base64.getEncoder().encodeToString(imageData);
                        
                        
                        %>
                            <img src="data:image/jpg;base64,<%=base64Image%>" alt="image">
                            <% } %>
                        </div>
                        <h2><a href="product.jsp?idp=<%=products.get(i).getIdProduct() %>&idc=<%=idc%>"><%=products.get(i).getProductName() %> </a></h2>
                        <div class="product-carousel-price">
                            <ins><%=products.get(i).getPrice() %></ins> <del><%=products.get(i).getOldPrice() %></del>
                        </div>  
          
                        <div class="product-option-shop">
                            <a class="add_to_cart_button" data-quantity="1" data-product_sku="" data-product_id="70" rel="nofollow" href="addItem?idp=<%= products.get(i).getIdProduct() %>&ses=<%=sessionId%>&idu=<%=idu%>&p=<%=products.get(i).getPrice()%>">Add to cart</a>
                        </div>                       
                    </div>
                </div>
                
                <%
				}
    }catch(Exception e)
    {
    	System.err.println(e);
    }
    
                %>
                
               
            </div>
      
            
            <div class="row">
                <div class="col-md-12">
                    <div class="product-pagination text-center">
                        <nav>
                          <ul class="pagination">
                            <li>
                              <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">2</a></li>
                            <li><a href="#">3</a></li>
                            <li><a href="#">4</a></li>
                            <li><a href="#">5</a></li>
                            <li>
                              <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
                            </li>
                          </ul>
                        </nav>                        
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
   </form> 
<%@ include file="footer.jsp" %>

   
   
    <!-- Latest jQuery form server -->
    <script src="https://code.jquery.com/jquery.min.js"></script>
    
    <!-- Bootstrap JS form CDN -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    
    <!-- jQuery sticky menu -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.sticky.js"></script>
    
    <!-- jQuery easing -->
    <script src="js/jquery.easing.1.3.min.js"></script>
    
    <!-- Main Script -->
    <script src="js/main.js"></script>
  </body>
</html>