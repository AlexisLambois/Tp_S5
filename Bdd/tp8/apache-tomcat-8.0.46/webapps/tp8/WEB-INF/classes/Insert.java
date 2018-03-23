import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet/Insert")
public class Insert extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Connection con=null;
		
		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			
			// execution de la requete
			Statement stmt = con.createStatement();
			
			String nom = req.getParameter("nom");
			String mdp = req.getParameter("mdp");
			String b1 = req.getParameter("b1");
			
			stmt.executeUpdate("");
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
				res.sendRedirect("../test.html");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
