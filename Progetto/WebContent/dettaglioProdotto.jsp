<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BGS-Shop/Product</title>
	</head>
	<body>
		<h1>Specifiche del Prodotto</h1>
		<p><b>Cod: </b>${prodotto.cod}</p>
		<p><b>Nome: </b>${prodotto.nome}</p>
		<p><b>Descrizione: </b>${prodotto.descrizione}</p>
		<p><b>Prezzo: </b>${prodotto.prezzo}</p>
		<a href="catalogoProdotti.jsp"><input type="button" value="Catalogo Prodotti"/></a>
	</body>
</html>