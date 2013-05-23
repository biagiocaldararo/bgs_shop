<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BGS-Shop/home</title>
	</head>
	<body>
		<form action="login.do" method="post">
			<p>Username <input type="text" name="username"/>
			   Password  <input type="password" name="password"/>
			   <input type="submit" name="submit" value="Accedi"/>
			</p>
		</form>
		<h1>BGS-Shop</h1>
		<h2>Buy Great Solutions</h2>
		<form action="consultaProdotti.do" method="post">
			<input type="submit" name="submit" value="Catalogo Prodotti"/>	
		</form>
	</body>
</html>