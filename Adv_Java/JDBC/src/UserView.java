import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserView {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521/xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver are found ...");
			Connection con=DriverManager.getConnection(url,username,password);
			System.out.println("Database connected successfully....");
			String query="select * from jdbc1 where sno=?";
			PreparedStatement psmt=con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Id :");
			psmt.setInt(1, sc.nextInt());
			ResultSet rs=psmt.executeQuery();
			System.out.println("Sno    Name     Place");
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
