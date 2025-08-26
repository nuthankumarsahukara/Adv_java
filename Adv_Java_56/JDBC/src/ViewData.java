import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="select * from java56";
			ResultSet rs=smt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getDate(3));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
