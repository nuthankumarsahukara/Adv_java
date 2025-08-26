import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver are founded");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Database Connected successfully");
			String query="insert into jdbc1(sno,name,place) values (?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setInt(1, 3);
			psmt.setString(2, "Kumar Sai");
			psmt.setString(3, "Hyderabad");
			psmt.execute();
			System.out.println("Insert data successfully");
			con.close();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
	}	
}

