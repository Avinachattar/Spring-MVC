<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<Style>
.jumbotron {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 60%;
	left: 20%;
	position: fixed;
}
</Style>
</head>
<body>
	<div class="container">
		<div class="jumbotron bg-info">
			<form action="getProductById" method="post">
				<h2 class="text-center mb-4">Search Product By Id</h2>
				<div class="form-group">
					<label for="productId">Product Id</label> <input type="number"
						name="productId" min="1" class="form-control" required>
				</div>
				<div>
					<input type="submit" name="getProductById"
						class="btn btn-outline-light"> <a
						class="btn btn-outline-light" href="index.jsp">Home</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>