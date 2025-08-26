import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionEx {
	public static void main(String[] args) {
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
		Class.forName(driver);
		System.out.println("Driver Class are found ....");
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("Database Connected Succesfully.....");
		con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
