<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
</head>
<body>
	<%
		Connection con=null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			Statement stmt = con.createStatement();
			String query="SELECT dat,ip FROM login WHERE nom='"+request.getParameter("nom")+"' AND '"+request.getParameter("mdp")+"';";
			rs = stmt.executeQuery(query);
			if(rs.next()){ %>
				<h1>Bonjour Mr <%=request.getParameter("nom")%> votre dernière connection date de <%=rs.getString(0)%> de la machine <%=rs.getString(1)%></h1>
		  <%}else{ 
			  	java.util.Date actuelle = new java.util.Date();
			  	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			  	String dat = dateFormat.format(actuelle);
			  	query="INSERT INTO login VALUES('"+request.getParameter("nom")+"','"+request.getParameter("mdp")+"','"+dat+"','"+request.getRemoteAddr()+"';";
				stmt.executeUpdate(query);
				%><h1>Bonjour Mr <%=request.getParameter("nom")%>, bienvenu sur ce site</h1><%
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>