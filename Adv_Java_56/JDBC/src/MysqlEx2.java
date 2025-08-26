import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MysqlEx2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/nuthan";
		String username="root";
		String password="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into data values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, 6);
			ps.setString(2, "Yeswanth");
			ps.setString(3, "1999-08-6");
			ps.execute();
			System.out.println("Data inserted Successfully....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
