<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="com.bgs_shop.model.*" %>
<%
   Cliente cliente = (Cliente) session.getAttribute("cliente");
   boolean autorizzato = true;
   
   if (cliente!=null)
       autorizzato &= (cliente.getRuolo().equals("admin"));
   
   if (!autorizzato) {
	   RequestDispatcher rd = application.getRequestDispatcher("/homeCustomer.jsp");
   	   rd.forward(request, response);
   }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BGS-Shop/homeAdmin</title>
	</head>
	<body>
		<p><i>${cliente.username} [${cliente.ruolo}]</i></p>
		<a href="inserimentoProdotto.jsp"><input type="button" value="Inserisci Prodotto"/></a>
	</body>
</html>