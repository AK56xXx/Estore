<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.Category" %>
<%@ page import="dao.CategoryDAOImpl" %>
<%@page import="java.util.ArrayList"%>

<%@ page import="models.CartItem" %>
<%@ page import="dao.CartItemDAOImpl" %>
<%@ page import="models.Cart" %>
<%@ page import="dao.CartDAOImpl" %>
<%@ page import="models.Product" %>
<%@ page import="dao.ProductDAOImpl" %>
<%@ page import="models.Order" %>
<%@ page import="dao.OrderDAOImpl" %>

  
    
    <div class="header-area">
        <div class="container">
            <div class="row">
                <div class="col-md-8">
                    <div class="user-menu">
                        <ul>
                      
                            <li><a href="#"><i class="fa fa-user"></i> My Account</a> </li>
                      		<li><a href="#"><i class="fa fa-heart"></i> Wishlist</a></li>
                            <li><a href="cart.jsp"><i class="fa fa-user"></i> My Cart</a></li>
                            <li><a href="checkout.jsp"><i class="fa fa-user"></i> Checkout</a></li>
                            
                         <%
						User user = (User) session.getAttribute("user");
						if(user == null){
						%>
                            <li><a href="login"><i class="fa fa-user"></i> Login</a></li>
                         
                        
                        <%
							}
						%> 
						<% 
						if(user != null){
						%>
					  <li><a href="logout"><i class="fa fa-user"></i> <% out.print(user.getFname()+" "+user.getLname()); %> :  Logout</a></li>
						</ul>

						 <%
							}
						 %> 
                    </div>
                </div>
                
                <div class="col-md-4">
                    <div class="header-right">
                        <ul class="list-unstyled list-inline">
                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">currency :</span><span class="value">USD </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">USD</a></li>
                                    <li><a href="#">INR</a></li>
                                    <li><a href="#">GBP</a></li>
                                </ul>
                            </li>

                            <li class="dropdown dropdown-small">
                                <a data-toggle="dropdown" data-hover="dropdown" class="dropdown-toggle" href="#"><span class="key">language :</span><span class="value">English </span><b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">English</a></li>
                                    <li><a href="#">French</a></li>
                                    <li><a href="#">German</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        
        
   

    </div> <!-- End header area -->
    
    
     <div class="site-branding-area">
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="logo">
                        <h1><a href="./"><img src="img/logo.png"></a></h1>
                    </div>
                </div>
               
                <div class="col-sm-6">
                 <%
                
                
                if (user == null) {
                	String sessionId = session.getId();
                	CartDAOImpl cartDAOImpl = new CartDAOImpl();
                    Cart ct = cartDAOImpl.getCartBySession(sessionId);
                    CartItemDAOImpl cartItemDAOImpl = new CartItemDAOImpl();
                    ProductDAOImpl productDAOImpl = new ProductDAOImpl();
                    Product p = new Product();
                    double total=0;
                    
                    ArrayList<CartItem> listItems = new ArrayList<CartItem>();
                    listItems = cartItemDAOImpl.getAllCartItemsByCartId(ct.getIdCart());
                    
                    int i = cartItemDAOImpl.countCartItems(ct.getIdCart());
                    
                    for(CartItem ci : listItems){ 
    		              p = productDAOImpl.getProductById(ci.getProductId()); 
    		              
    		              total = total + p.getPrice();
                	
                		}
                    ct.setTotal(total);
                    %>
                    <div class="shopping-item">
                    
                        <a href="cart.jsp">Cart - <span class="cart-amunt">$<%= total %></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><%= i %></span></a>
                    </div>
                    
                <%   
                }else {
                CartDAOImpl cartDAOImpl = new CartDAOImpl();
                Cart ct = cartDAOImpl.getCartBySession(user.getEmail());
                CartItemDAOImpl cartItemDAOImpl = new CartItemDAOImpl();
                ProductDAOImpl productDAOImpl = new ProductDAOImpl();
                Product p = new Product();
                double total=0;
                
                ArrayList<CartItem> listItems = new ArrayList<CartItem>();
                listItems = cartItemDAOImpl.getAllCartItemsByCartId(ct.getIdCart());
                
                int i = cartItemDAOImpl.countCartItems(ct.getIdCart());
                
                for(CartItem ci : listItems){ 
		              p = productDAOImpl.getProductById(ci.getProductId()); 
		              
		              total = total + p.getPrice();
                
                }
                ct.setTotal(total);
              //  cartDAOImpl.updateCart(c);
                
                
                
                %>
                    <div class="shopping-item">
                    
                        <a href="cart.jsp">Cart - <span class="cart-amunt">$<%= total %></span> <i class="fa fa-shopping-cart"></i> <span class="product-count"><%= i %></span></a>
                    </div>
                    <% } %>
                </div>
            </div>
        </div>
    </div> <!-- End site branding area -->
    
<div class="mainmenu-area">
   <div class="container">
	   <div class="navbar">
	    <a href="index.jsp">Home</a>
	     <%
				              CategoryDAOImpl ctg = new CategoryDAOImpl();
				              ArrayList<Category> list = new ArrayList<Category>();
				              list = ctg.getAllCategories();
				              for(Category c : list){
				             %>
				 
				  
			
				
				   
				 
					      <a href="shop.jsp?idc=<%=c.getIdCategory()%>"><%=c.getNameCategory()%></a>
					    
		 <% } %>
        </div>
       
      </div>
  </div> <!-- End mainmenu area -->
    
 
  