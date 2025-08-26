import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement smt= con.createStatement();
			String query="insert into java121 values (2,'Vinod','15-may-1985')";
			smt.execute(query);
			System.out.println("Data insterd Successfully ....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
