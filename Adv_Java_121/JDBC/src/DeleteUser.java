import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteUser {
	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="delete from java121 where sno=?";
			PreparedStatement ps=c.prepareStatement(query);
			System.out.println("Enter the Id :");
			int id=sc.nextInt();
			ps.setInt(1, id);
			ps.execute();
			System.out.println("Delete data successfully.....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

