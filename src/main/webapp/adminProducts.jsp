<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@ page import="models.User" %>
<%@ page import="models.Category" %>
<%@ page import="dao.CategoryDAOImpl" %>

<%@ page import="models.CartItem" %>
<%@ page import="dao.CartItemDAOImpl" %>
<%@ page import="models.Cart" %>
<%@ page import="dao.CartDAOImpl" %>
<%@ page import="models.Product" %>
<%@ page import="dao.ProductDAOImpl" %>
<%@ page import="models.Order" %>
<%@ page import="dao.OrderDAOImpl" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.util.Base64" %>

<%@ include file="adminNavbar.jsp" %>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <style>
     
    </style>
    <body>
        <form>

              
        <div class="container">
        <h1>Products List</h1>
        <br>
        <a href="adminAddProduct.jsp"  class="btn btn-success">Add product</a>
        <hr>
        <table class="table">
        <thead>
            <tr>
                <th>Id Product</th>
                <th>Category</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Old Price</th>
                <th>Image</th>
            </tr>
        </thead>
        
         
        <tbody>
           <%
           try{
              ProductDAOImpl pd = new ProductDAOImpl();
              ArrayList <Product> list = new ArrayList<Product>();
              list = pd.getAllProducts();
              CategoryDAOImpl cd = new CategoryDAOImpl();
              Category c = new Category();
              for(Product l : list){
            	  
                   c = cd.getCategoryById(l.getIdCategory());
                   
                   Blob blob = l.getImage();
                   if (blob != null) {
                   InputStream inputStream = blob.getBinaryStream();
                   byte[] imageData = inputStream.readAllBytes();
                   String base64Image = Base64.getEncoder().encodeToString(imageData);
                   
                   
                   %>
                       
           
            <tr>
        
                
                <td><%=l.getIdProduct() %></td>
                <td><%=c.getNameCategory() %></td>
                <td><%=l.getProductName() %></td>
                <td> <textarea id="w3review" name="w3review" rows="5" cols="50" disabled> <%=l.getDescription() %> </textarea></td>
                <td><%=l.getPrice() %></td>
                <td><%=l.getOldPrice() %></td>
                <td><img src="data:image/jpg;base64,<%=base64Image%>" alt="image"></td>
            <% } %>
                
                <td>
                 <a href="adminUpdateProduct.jsp?idp=<%=l.getIdProduct() %>"  class="btn btn-light">Edit</a>
                 <a href="deleteProduct?idp=<%=l.getIdProduct() %>"  class="btn btn-danger">Delete</a>           
                </td>
            </tr>
       <% 
       }
       }catch(Exception e){
    	   System.out.println(e.getMessage());
       }
       %>
             
             
        
            
       
        </tbody>
        
    </table>

        
        
        
        
        
        
    
        
     
        
        
         </div>
             


        </form>
    </body>
    
 

</html>