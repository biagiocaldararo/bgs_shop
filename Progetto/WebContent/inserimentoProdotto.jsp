<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BGS-Shop/inserisciProdotto</title>
	</head>
	<body>
		<p><i>${cliente.username} [${cliente.ruolo}]</i></p>
		<form action="inserisciProdotto.do" method="post">
			<h1> Inserimento Prodotto</h1>
			
			<p> Nome* <input type="text" name="nome"/>
			<font color="red">${errori["nome"]}</font></p>
				                    	
			<p> Descrizione* <input type="text" name="descrizione"/>
			<font color="red">${errori["descrizione"]}</font></p>             				
			
			<p> Prezzo* <input type="text" name="prezzo"/>
			<font color="red">${errori["prezzo"]}</font></p>
			
			<p><input type="submit" name="submit" value="Inserisci" /></p>
			
			<p><i> * Campo obligatorio </i></p>
		</form>
		<a href="homeAdmin.jsp"><input type="button" value="Home"/></a>
	</body>
</html>