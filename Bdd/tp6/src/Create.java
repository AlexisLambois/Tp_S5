import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Create {

	public static void main(String[] args) {
		Connection con = null;
		
		try{

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			String query = "CREATE TABLE test(tno serial,prix int,descrip text);";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(query);
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
