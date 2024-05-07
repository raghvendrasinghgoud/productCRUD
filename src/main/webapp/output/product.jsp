<%@page import="org.springframework.validation.FieldError"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ page import="java.util.List" %>
  <%@ page import="product.entities.Product" %>
    <%@ page isELIgnored="false"%>

<%@ include file="cdn.jsp" %>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

function onSelectimage(){
	let [image]=document.getElementById('img').files;
	console.log(URL.createObjectURL(image));
	document.getElementById('preview').src=URL.createObjectURL(image);
}
</script>
</head>
<body>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<div class="container mt-5 row" >
	<div class="col-8 ms-5" >
	<h3>Product Overview</h3>
	</div>
	<div class="col-2">
	<button type="submit" oninput="" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" >Add Product</button>
	</div>
	
	<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <form action="product" method="post" enctype="multipart/form-data">
       <div class="form-group">
		<label>	Image</label>
		<img src="#" alt="Select Image" class="rounded mx-auto mb-5 d-block" width="150" height="150" id="preview" />
		<input class="form-control" oninput="onSelectimage()" type="file" id="img" name="img" accept="image/*" value="" >
       </div>
	<input class="form-control" type="text" name="id" value="${requestScope.product.getId()}" hidden></br></br>
	<div class="form-group">
	<label>Name</label> 
	<input class="form-control" type="text" name="pname" value="${requestScope.product.getName()}" /><br/><br/>
	</div>
	<div class="form-group">
	<label>Price</label>
	 <input class="form-control" type="number" name="pprice" value="${requestScope.product.getPrice()}" /><br/><br/>
	
	</div>
	<div class="form-group">
	<label>Brand</label> 
	<input class="form-control" type="text" name="pbrand" value="${requestScope.product.getBrand()}" /><br/><br/>
	
	</div>
	<div class="form-group">
	
	<label>Quantity</label>
	 <input class="form-control" type="number" name="pquantity" value="${requestScope.product.getQuantity()}" /><br/><br/>
	</div>
	
	<div class="form-group">
	<label>Description</label>
	 <textarea class="form-control" rows="5" cols="25" name="pdescription" >${requestScope.product.getDescription()}</textarea>
	
	</div>
	
	<div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save Product</button>
      </div>
</form>
      </div>
      
    </div>
  </div>
</div>
	
	<div class="ms-5 mt-3 col-12" >
	<%
		List<FieldError> fel= (List<FieldError>)request.getAttribute("error");
	
	if(fel!=null){
		for(FieldError f:fel){
	%>
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Invalid Value!</strong><%= f.getDefaultMessage() %>
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	
	<% } } %>
		<table class="table">
			<thead class="thead-dark" >
				<tr>
					<th scope="col" >Image</th>
					<th scope="col" >ID</th>
					<th scope="col" >Name</th>
					<th scope="col" >Price</th>
					<th scope="col" >Brand</th>
					<th scope="col" >Quantity</th>
					<th scope="col" >Description</th>
					<th scope="col" >Image Name</th>
					<th scope="col" >Action</th>
				</tr>
			</thead>
			<tbody>
			<% 
				List<Product> products =(List<Product>)request.getAttribute("products");
				
			for(Product p:products){
				
				String image="products_image/"+p.getImageName();
			%>
				<tr>
					<td><img class="rounded mx-auto" src="<c:url value="<%= image %>" />" width="100" height="100" alt="some_image" /></td>
					<td class="align-middle" ><%= p.getId() %></td>
					<td class="align-middle" ><%= p.getName() %></td>
					<td class="align-middle" ><%= p.getPrice() %></td>
					<td class="align-middle" ><%= p.getBrand() %></td>
					<td class="align-middle" ><%= p.getQuantity() %></td>
					<td class="align-middle" ><%= p.getDescription() %></td>
					<td class="align-middle" ><%= p.getImageName() %></td>
					<td class="align-middle" ><a href="up?id=<%= p.getId() %>"><input class="btn btn-success" type="button" value="Update" /></a></td>
					<td class="align-middle" ><a href="del?id=<%= p.getId() %>"><input class="btn btn-danger" type="button" value="Delete" /></a></td>
					
				</tr>
				<% } %>
			</tbody>
		</table>
		</div>
		
		</div>
</body>
</html>