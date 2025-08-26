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
			Connection con=DriverManager.getConnection(url, username, password);
			Statement smt=con.createStatement();
			String query="update java121 set name='Tarun Kumar' where sno=4";
			smt.execute(query);
			System.out.println("Update Data successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
