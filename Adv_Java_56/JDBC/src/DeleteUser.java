import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner s=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println("Enter the ID :");
			int id=s.nextInt();
			String query="delete from java56 where sno=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, id);
			int rows=ps.executeUpdate();
			if(rows>0)
				System.out.println("Data Deleted successfully..........");
			else
				System.out.println("Data does not exists..........");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
