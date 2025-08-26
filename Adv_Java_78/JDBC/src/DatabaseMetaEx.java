import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			DatabaseMetaData dbmd=c.getMetaData();
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("Database Connection Information: " + dbmd.getConnection());
			System.out.println("Database User Name : " + dbmd.getUserName());
			System.out.println("Database URL :"+dbmd.getURL());
			
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
