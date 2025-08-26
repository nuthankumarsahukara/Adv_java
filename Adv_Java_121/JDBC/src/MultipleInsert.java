import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MultipleInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java121 values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1,5);
			ps.setString(2,"Sai");
			ps.setString(3, "5-jun-23");
			ps.addBatch();
			ps.setInt(1,6);
			ps.setString(2,"Devi");
			ps.setString(3, "5-jan-21");
			ps.addBatch();
			ps.setInt(1,7);
			ps.setString(2,"Divya");
			ps.setString(3, "5-jul-18");
			ps.addBatch();
			ps.setInt(1,8);
			ps.setString(2,"Kiran");
			ps.setString(3, "15-mar-15");
			ps.addBatch();
			
			ps.executeBatch();
			
			System.out.println("Data Inserted Successfully....");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
