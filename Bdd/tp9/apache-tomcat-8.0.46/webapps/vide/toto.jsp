<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vide</title>
<%@ page import="java.util.*"%>
</head>
<body>
	<h1>Hello World</h1>
	<%!
		public class Cpt{ 
			private int val=0;
			public String getVal(){ 
				return "" + val; 
			}
			public void incr() {
				val++;
			}
		}
	%><%
		Cpt global=(Cpt)application.getAttribute("global");
		
		if (global==null){ 
			global=new Cpt();
			application.setAttribute("global",global);
		}
		global.incr();
	
		Cpt local=(Cpt)session.getAttribute("local");
		
		if (local==null){ 
			local=new Cpt();
			session.setAttribute("local",local);
		}
		local.incr();
	%>
	<h1>Vous avez accédé <%= local.getVal() %> fois à cette page sur les <%= global.getVal() %> accès effectués.</h1>
</body>
</html>