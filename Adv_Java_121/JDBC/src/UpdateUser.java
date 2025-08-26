import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, username, password);
			String query="update java121 set name=? where sno= ? ";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name :");
			String name=sc.nextLine();
			System.out.println("Enter the Sno :");
			int id=sc.nextInt();
			PreparedStatement psmt=con.prepareStatement(query);
			psmt.setString(1, name);
			psmt.setInt(2, id);
			int row =psmt.executeUpdate();
			if(row > 0)
				System.out.println(row +" row is Updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
