import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName(driverClass);
			System.out.println("Driver are founded.......");
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected Successfully......");
			Statement smt=c.createStatement();
			String query="create table java78 (sno number(3),name varchar2(20),dob date,place varchar2(15))";
			smt.execute(query);
			System.out.println("Table Created Successfully....");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}

}
