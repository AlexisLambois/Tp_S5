import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import resto.*;
@WebServlet("/servlet/Choix")
public class Choix extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(true);
		Connection con = null;
		ResultSet rs = null;
		Plat p;
		Menu m;
		if(session.getAttribute("menu") == null){
			m = new Menu();
			session.setAttribute("menu",m);
		}else{
			m = (Menu) session.getAttribute("menu");
		}
		
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			String query = "SELECT * FROM plats WHERE pno="+req.getParameter("plat")+";";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			p = new Plat(rs.getInt("pno"),rs.getString("type"),rs.getString("libelle"),rs.getString("description"));
			
			if(rs.getString("type").equals("E")){
				m.setEntree(p);
			}else if(rs.getString("type").equals("P")){
				m.setPlat(p);
			}else if(rs.getString("type").equals("D")){
				m.setDessert(p);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
				if(m.getPlat() == null){
					res.sendRedirect("../plats.jsp?type=P");
				}else if(m.getDessert() == null){
					res.sendRedirect("../plats.jsp?type=D");
				}else if(m.getEntree() == null){
					res.sendRedirect("../plats.jsp?type=E");
				}else{
					res.sendRedirect("../synthese.jsp");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}