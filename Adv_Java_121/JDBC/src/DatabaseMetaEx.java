import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DatabaseMetaEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			DatabaseMetaData dm=c.getMetaData();
			
			System.out.println("DatabaseProductName :"+dm.getDatabaseProductName());
			System.out.println("DatabaseProductVersion :"+dm.getDatabaseProductVersion());
			System.out.println("DriverName :"+dm.getDriverName());
			System.out.println("DriverVersion :"+dm.getDriverVersion());
			System.out.println("Connection :"+dm.getConnection());
			System.out.println("UserName :"+dm.getUserName());
			System.out.println("MaxRowSize :"+dm.getMaxRowSize());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
