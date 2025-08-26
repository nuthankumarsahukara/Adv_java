import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","nuthan");
			Statement smt=con.createStatement();
			String query="insert into java56 values(2,'Vinod','5-may-2008')";
			smt.execute(query);
			System.out.println("Data inserted successfully....");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
