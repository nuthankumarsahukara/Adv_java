import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseMeta {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,username,password);
			 DatabaseMetaData metaData = con.getMetaData();
			 System.out.println("Database Product Name :"+metaData.getDatabaseProductName());
			 System.out.println("Database Product Version :"+metaData.getDatabaseProductVersion());
			 System.out.println("Database Driver Name :"+metaData.getDriverName());
			 System.out.println("Database Driver Version :"+metaData.getDriverVersion());
			 System.out.println("Database Connection Information :"+metaData.getConnection());
			 System.out.println("Database UserName :"+metaData.getUserName());
			 System.out.println("Database URL :"+metaData.getURL());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
