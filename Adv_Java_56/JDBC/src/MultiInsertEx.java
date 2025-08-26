import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MultiInsertEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="insert into java56 values(3,'Sai','15-may-2000')";
			String query1="insert into java56 values(4,'Kumar','10-jun-2005')";
			String query2="insert into java56 values(5,'Devi','1-may-2005')";
			smt.execute(query);
			smt.execute(query1);
			smt.execute(query2);
			System.out.println("Data inserted Successfully....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
