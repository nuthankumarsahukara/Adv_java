import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="delete from jdbc1 where sno=12";
			Statement smt=con.createStatement();
			int rows=smt.executeUpdate(query);
			if(rows>0) {
				System.out.println("Delete the record...");	
			}else {
				System.out.println("No Rows Delete the record...");
			}
			String query1="select * from jdbc1";
			ResultSet rs=smt.executeQuery(query1);
			System.out.println("Sno   Name    Place");
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
