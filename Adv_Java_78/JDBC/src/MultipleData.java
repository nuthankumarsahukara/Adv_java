import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MultipleData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver classes are founded.......");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","nuthan");
			System.out.println("Database connected successfully.........");
			String query="insert into java78 values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1, 3);
			ps.setString(2, "NareshIT");
			ps.setString(3, "15-jul-2003");
			ps.setString(4, "Hyderabad");
			ps.addBatch();
			
			ps.setInt(1, 4);
			ps.setString(2, "DurgaIT");
			ps.setString(3, "15-jul-2020");
			ps.setString(4, "Hyderabad");
			ps.addBatch();
			
			ps.setInt(1, 5);
			ps.setString(2, "SureshIT");
			ps.setString(3, "5-may-2015");
			ps.setString(4, "Banglore");
			ps.addBatch();
			
			ps.executeBatch();
			System.out.println("Data Inserted Successfully........");
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
