import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driverClass="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			String query="delete from java78 where to_char(sno)=? or name=?";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the SNo Or Name :");
			String data=sc.nextLine();
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, data);
			ps.setString(2, data);
			int rows=ps.executeUpdate();
			System.out.println(rows+" rows are deleted");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
