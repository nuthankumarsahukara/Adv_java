import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/nuthan";
		String username="root";
		String password="root";
		try {
			Class.forName(driverClass);
			System.out.println("Driver Class are Founded......");
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected Successfully........");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
