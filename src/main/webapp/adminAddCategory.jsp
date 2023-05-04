<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

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

<%@ include file="adminNavbar.jsp" %>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://bootswatch.com/4/darkly/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Category</title>
    </head>
    <style>
     
    </style>
    <body>
        <form method="post" action="addCategory"> 
            
            
            <%

			%>
                
              

              
        <div class="container">
        <h1>Add Category</h1>
        
        
        <table class="table">
            
            

            
            <tr>
            <th>Category Name:  <input type="text" name="name" placeholder="Category Name"> </th>
            </tr>
            
 
            
            <tr>
                <th> <input type="submit" value="Add"> </th>
            </tr>
            
            
            
        
            
            
            
            
            
        </table>

        
        
        
        
        
        
        
           <% 
          
         
          
         
         
       
       
           %>
        
     
        
        
         </div>
             


        </form>
    </body>
    
 

</html>