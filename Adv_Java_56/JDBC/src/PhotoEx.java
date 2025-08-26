import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PhotoEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Classes are found.....");
			Connection con=DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected Successfully....");
			Statement smt=con.createStatement();
			String query="create table javaphoto (sno number,name varchar2(20),photo blob)";
			smt.execute(query);
			System.out.println("Table Created Successfully......");
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
