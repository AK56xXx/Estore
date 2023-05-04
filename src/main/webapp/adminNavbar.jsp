<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
<form action="logout" method="get">
<nav class="navbar navbar-expand-sm navbar-dark bg-primary mb-3">
<div class="container">
<a href="adminCategories.jsp" class="navbar-brand">Admin panel</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mobile-nav">

<span class="navbar-toggle-icon"></span>
</button>

<div class="collapse navbar-collapse" id="mobile-nav">
<ul class="navbar-nav ml-auto">

<li class="nav-item">
<a href="adminCategories.jsp" class="nav-link">Manage Categories</a>
</li>

<li class="nav-item">
<a href="adminProducts.jsp" class="nav-link">Manage products</a>
</li>


</ul>
</div>

</div>
    

    <input class="btn btn-outline-secondary" type="submit" value="Logout">

</nav>
    
</form>
        
        
        
        
        
        
        
        
        
    </body>
</html>