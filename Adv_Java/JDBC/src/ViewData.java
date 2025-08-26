import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewData {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver are found ...");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Database connected successfully....");
			String query="select * from jdbc1";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(query);
			System.out.println("Sno  Name \tPlace");
			while(rs.next()) {
				System.out.print("  "+rs.getInt(1));
				System.out.print("  "+rs.getString(2));
				System.out.print("  "+rs.getString(3));
				System.out.println(" ");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
