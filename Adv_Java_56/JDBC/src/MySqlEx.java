import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySqlEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/nuthan","root","root");
			Statement smt=con.createStatement();
			String query="insert into data values(2,'Vinod','2000-05-15')";
			smt.execute(query);
			System.out.println("Data inserted successfully....");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
