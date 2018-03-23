import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TestDB {

	public static void main(String[] args) {
		
		Connection con = null;
		
		try{
			Properties pr = new Properties();
			FileInputStream fis = new FileInputStream("properties");
			pr.load(fis);
			fis.close();
			String driver = pr.getProperty("driver");
			String url = pr.getProperty("url");
			String base = pr.getProperty("base");
			String user = pr.getProperty("user");
			String password = pr.getProperty("password");
			
			Class.forName(driver);
			con = DriverManager.getConnection(url+base,user,password);
			
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
