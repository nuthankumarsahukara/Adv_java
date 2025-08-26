import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java56 values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, 6);
			ps.setString(2, "Yeswanth");
			ps.setString(3, "04-sep-2005");
			ps.execute();
			System.out.println("Data inserted Successfully....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
