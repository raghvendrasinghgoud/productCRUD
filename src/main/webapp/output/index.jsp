
<%@ page isELIgnored="false"%>
<html>
<body>
<h2>Product Management</h2>
<a href="get"><button>Show Products</button></a>
<form action="product" method="post">
	<input type="text" name="id" value="${requestScope.product.getId()}" hidden></br></br>
	Name: <input type="text" name="pname" value="${requestScope.product.getName()}" /><br/><br/>
	Price: <input type="number" name="pprice" value="${requestScope.product.getPrice()}" /><br/><br/>
	Brand: <input type="text" name="pbrand" value="${requestScope.product.getBrand()}" /><br/><br/>
	Description: <textarea rows="5" cols="25" name="pdescription" >${requestScope.product.getDescription()}</textarea>
	<input type="submit" />
	
</form>
</body>
</html>
