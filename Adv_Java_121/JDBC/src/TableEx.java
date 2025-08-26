import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableEx {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, username, password);
			Statement smt=con.createStatement();
			String query="create table java121 (sno number,name varchar2(15),DOB date)";
			smt.execute(query);
			System.out.println("Table created Successfully ....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
