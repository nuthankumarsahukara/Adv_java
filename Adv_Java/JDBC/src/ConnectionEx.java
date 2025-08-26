import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1522:orcl";
		String username="system";
		String password="nuthan99";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver are found");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Database is connected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
