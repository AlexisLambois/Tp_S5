<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ctp</title>
<%@ page import="tool.BddTools"%>
<%@ page import="java.util.*"%>
<%@ page import="resto.*"%>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
</head>
<body>
	<div class="pure-menu pure-menu-horizontal">
	    <ul class="pure-menu-list">
	        <li class="pure-menu-item"><a href="plats.jsp" class="pure-menu-link">Retour</a></li>
	    </ul>
	</div>
	<div style="margin-left:3%">
	<form action="./servlet/Enregister">
		<label>Entre : </label><br>
		<input readonly="readonly" value="<%out.print(((Menu) session.getAttribute("menu")).getEntree().toString());%>"><br>
		<label>Plat : </label><br>
		<input readonly="readonly" value="<%out.print(((Menu) session.getAttribute("menu")).getPlat().toString());%>"><br>
		<label>Dessert : </label><br>
		<input readonly="readonly" value="<%out.print(((Menu) session.getAttribute("menu")).getDessert().toString());%>"><br>
		<label>Date : </label><br>
		<input type="date" name="date"/><br/>
		<label>Email : </label><br>
		<input type="email" name="mail"/><br><br>
		<input type="submit" value="valider"/>
	</form>
	</div>
</body>
</html>