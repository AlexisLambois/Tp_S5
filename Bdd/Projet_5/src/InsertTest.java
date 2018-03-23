import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;

public class InsertTest {

	public static void main(String[] args) {
		Connection con = null;

		try{

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://psqlserv/da2i","lamboisa","moi");
			Statement stmt = con.createStatement();
			Random r = new Random();
			for (int i = 1; i <= 1000; i++) {
				String query = "INSERT INTO fournisseurs VALUES("+i+",'fournisseur"+i+"','ville"+i+"');";
				stmt.executeUpdate(query);
			}
			System.out.println("truc");
			for (int i = 1; i <= 10000; i++) {
				int valeur = 200 + r.nextInt(600 - 200);
				String query = "INSERT INTO produits VALUES("+i+",'libelle"+i+"',"+valeur+");";
				stmt.executeUpdate(query);
			}
			System.out.println("truc");
			String query ="";
			int valeur1;
			int valeur2;
			for (int i = 1; i <= 1000; i++) {
				for (int j = 0; j < 1000; j++) {
					valeur1 = 1 + r.nextInt(10000 - 1);
					valeur2 = 1 + r.nextInt(100 - 1);
					query = "INSERT INTO commandes(fno,pno,qute) VALUES("+i+","+valeur1+","+valeur2+");";
					stmt.executeUpdate(query);
				}
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
