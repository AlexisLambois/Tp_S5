import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import resto.*;
@WebServlet("/servlet/Enregister")
public class Enregister extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			
		Connection con = null;
		
		try{
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			HttpSession session = req.getSession(true);
			Menu m = (Menu) session.getAttribute("menu");
			
			String query = "INSERT INTO menu(entree,plat,dessert,mail,resa) VALUES("+m.getEntree().getPno()+","+m.getPlat().getPno()+","+m.getDessert().getPno()+",'"+req.getParameter("mail")+"','"+req.getParameter("date")+"');";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
		
			if (session != null) {
			    session.invalidate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
				res.sendRedirect("../plats.jsp");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	String getDigit(String phrase) {
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher m = pattern.matcher(phrase);
		m.find();
		return (String)m.group();
	}
}