import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="delete from java121 where name='Divya'";
			smt.execute(query);
			System.out.println("Data deleted successfully.....");
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
