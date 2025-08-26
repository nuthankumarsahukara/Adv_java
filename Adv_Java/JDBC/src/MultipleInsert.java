import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleInsert {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,username,password);
		String query="insert into jdbc1(sno,name,place) values(?,?,?)";
		PreparedStatement psmt=con.prepareStatement(query);
		psmt.setInt(1, 7);
		psmt.setString(2, "Kiran");
		psmt.setString(3, "Mumbai");
		psmt.addBatch();
		psmt.setInt(1, 8);
		psmt.setString(2, "Sai");
		psmt.setString(3, "Palasa");
		psmt.addBatch();
		psmt.setInt(1, 9);
		psmt.setString(2, "Vinay");
		psmt.setString(3, "Tekkali");
		psmt.addBatch();
		psmt.executeBatch();
		System.out.println("Multiple is inserted ...");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		

	}

}
