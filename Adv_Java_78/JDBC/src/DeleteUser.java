import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driverClass="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			String query="delete from java78 where sno=?";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the SNo :");
			int sno=sc.nextInt();
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, sno);
			int rows=ps.executeUpdate();
			System.out.println(rows+" rows are deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
