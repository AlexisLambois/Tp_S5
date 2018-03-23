import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class BddTools {
	
	Connection con = null;
	
	public BddTools( String base ){
		this.con = connecter(base);
	}
	
	public Connection connecter(String base){
		
		Connection con = null;

		try{
			Properties pr = new Properties();
			FileInputStream fis = new FileInputStream("properties");
			pr.load(fis);
			fis.close();
			String driver = pr.getProperty("driver");
			String url = pr.getProperty("url");
			String user = pr.getProperty("user");
			String password = pr.getProperty("password");

			Class.forName(driver);
			con = DriverManager.getConnection(url+base,user,password);

		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
	
	public void fermer(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int nbLines(String table){
		try{
			String query = "SELECT count(*) FROM test";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	
	public ArrayList<ArrayList<String>> getRequest(String requete){
		
		ArrayList<ArrayList<String>> temp = new ArrayList<>();
		
		try{
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			ResultSetMetaData md = rs.getMetaData();
			
			ArrayList<String> temp2 = new ArrayList<>();
			for (int i = 1; i <= md.getColumnCount(); i++) {
				temp2.add(md.getColumnName(i));
			}
			temp.add(temp2);
			
			ArrayList<String> donne = new ArrayList<>();
			while(rs.next()){
				donne = new ArrayList<>();
				for (int i = 1; i <= md.getColumnCount(); i++) {
					donne.add(rs.getString(i));
				}
				temp.add(donne);
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return temp;
		
	}
	
	public String describe(String table){
		String res = "";
		try{
			String query = "SELECT * FROM "+table;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData md = rs.getMetaData();
			res += "Nombre de colonne : "+ (md.getColumnCount()) + "\n";
			for (int i = 1; i <= md.getColumnCount(); i++) {
				res += "Colonne : " + (md.getColumnName(i) + " de type " + md.getColumnTypeName(i)) + "\n";
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return res;
	}

}
