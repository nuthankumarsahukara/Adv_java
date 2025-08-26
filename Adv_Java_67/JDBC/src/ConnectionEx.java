import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver are founded......");
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected Successfully.........");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
