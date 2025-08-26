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
			DatabaseMetaData db=c.getMetaData();
			System.out.println("DatabaseProductName : "+db.getDatabaseProductName());
			System.out.println("DatabaseProductVersion : "+db.getDatabaseProductVersion());
			System.out.println("DriverName : "+db.getDriverName());
			System.out.println("DriverVesion : "+db.getDriverVersion());
			System.out.println("DriverMajorVersion : "+db.getDriverMajorVersion());
			System.out.println("DriverMinorVersion : "+db.getDatabaseMinorVersion());
			System.out.println("URL : "+db.getURL());
			System.out.println("UserName : "+db.getUserName());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
