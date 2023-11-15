<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="java.util.List" %>
  <%@ page import="product.entities.Product" %>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>${requestScope.msg}<a href="<%= request.getContextPath() %>/"><button type="submit">Add Product</button></a></h2>
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Price</th>
					<th>Brand</th>
					<th>Description</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<% 
				List<Product> products =(List<Product>)request.getAttribute("products");
				
			for(Product p:products){
			%>
				<tr>
					<td><%= p.getId() %></td>
					<td><%= p.getName() %></td>
					<td><%= p.getPrice() %></td>
					<td><%= p.getBrand() %></td>
					<td><%= p.getDescription() %></td>
					<td><a href="up?id=<%= p.getId() %>"><input type="button" value="Update" /></a></td>
					<td><a href="del?id=<%= p.getId() %>"><input type="button" value="Delete" /></a></td>
					
				</tr>
				<% } %>
			</tbody>
		</table>
</body>
</html>