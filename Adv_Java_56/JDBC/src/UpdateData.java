import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="update java56 set dob='15-jun-1996' where sno=2";
			smt.execute(query);
			System.out.println("Data Updated Successfully......");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
