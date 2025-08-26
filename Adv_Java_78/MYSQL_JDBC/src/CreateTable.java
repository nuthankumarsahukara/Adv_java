import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/nuthan";
		String username="root";
		String password="root";
		try {
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="create table java78 (sno int,name varchar(20),place varchar(20))";
			smt.execute(query);
			System.out.println("Table Created Successfully........");
		}catch(Exception e) {
			e.printStackTrace();;
		}
	}

}
