<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ctp</title>
<%@ page import="tool.BddTools"%>
<%@ page import="resto.*"%>
<%@ page import="java.util.*"%>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
</head>
<body>
	<div class="pure-menu pure-menu-horizontal">
	    <ul class="pure-menu-list">
	        <li class="pure-menu-item"><a href="plats.jsp?type=E" class="pure-menu-link">Entrees</a></li>
	        <li class="pure-menu-item"><a href="plats.jsp?type=P" class="pure-menu-link">Plats</a></li>
	        <li class="pure-menu-item"><a href="plats.jsp?type=D" class="pure-menu-link">Desserts</a></li>
	        <li class="pure-menu-item"><a href="synthese.jsp" class="pure-menu-link">Synthese</a></li>
	    </ul>
	</div>
	<div style="margin-left:3%;">
	<form action="./servlet/Choix">
	<%
		ArrayList<String> list = null;
		ArrayList<String> choix = new ArrayList<>() ;
		BddTools t = null;
		try {
			t = new BddTools("da2i");
			if(request.getParameter("type") == null ){
				list = t.getRequests("SELECT pno FROM plats WHERE type='E';");
			}else{
				list = t.getRequests("SELECT pno FROM plats WHERE type='"+request.getParameter("type")+"';");
			}
			for(int i = 0 ; i < list.size() ; i++){
				choix = t.getRequests("SELECT libelle FROM plats WHERE pno='"+list.get(i)+"';");
				out.println("<input type=\"radio\" name=\"plat\" id=\""+list.get(i)+"\" value=\""+list.get(i)+"\" required>"+choix.get(0)+"<br>");
			}
			
		}catch(Exception e) {
 	   		e.printStackTrace();
 	   	}finally{
 	    	t.fermer();
 	    }
	%>
	<input type="submit" value="valider">
	</form>
	</div>
	<script language="JavaScript">
		<%if( session.getAttribute("menu") != null){
			if( ((Menu) session.getAttribute("menu")).getEntree() != null ){%>
				if(document.getElementById(<%=((Menu) session.getAttribute("menu")).getEntree().getPno()%>) != null ){
					document.getElementById(<%=((Menu) session.getAttribute("menu")).getEntree().getPno()%>).checked='checked';
				}
			<%}
			if( ((Menu) session.getAttribute("menu")).getPlat() != null ){%>
				if(document.getElementById(<%=((Menu) session.getAttribute("menu")).getPlat().getPno()%>) != null ){
					document.getElementById(<%=((Menu) session.getAttribute("menu")).getPlat().getPno()%>).checked='checked';
				}
			<%}
			if( ((Menu) session.getAttribute("menu")).getDessert() != null ){%>
				if(document.getElementById(<%=((Menu) session.getAttribute("menu")).getDessert().getPno()%>) != null ){
					document.getElementById(<%=((Menu) session.getAttribute("menu")).getDessert().getPno()%>).checked='checked';
				}
			<%}
		}%>
	</script>
</body>
</html>