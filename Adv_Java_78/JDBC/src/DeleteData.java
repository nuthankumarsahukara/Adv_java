import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driverClass="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="delete from java78 where sno=8";
			int rows=smt.executeUpdate(query);
			System.out.println(rows +" rows are deleted.");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
