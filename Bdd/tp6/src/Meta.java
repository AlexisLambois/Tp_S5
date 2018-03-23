import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Meta {

	public static void main(String[] args) {
		
		Connection con = null;
		ResultSet rs = null;
		
		try{

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			String query = "SELECT * FROM test";
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData md = rs.getMetaData();
			System.out.println(md.getColumnCount());
			for (int i = 1; i <= md.getColumnCount(); i++) {
				System.out.println(md.getColumnName(i) + " " + md.getColumnTypeName(i));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
