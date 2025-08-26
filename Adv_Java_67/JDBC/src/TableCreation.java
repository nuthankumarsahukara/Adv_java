import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="create table java67 (sno number,name varchar2(20),dob date,place varchar2(20))";
			smt.execute(query);
			System.out.println("Table Created Successfully......");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
