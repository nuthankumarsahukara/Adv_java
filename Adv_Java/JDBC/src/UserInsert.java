import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInsert {

	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url,username,password);
			String query="insert into jdbc1(sno,name,place) values(?,?,?)";
			PreparedStatement psmt=con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the SNo :");			
			psmt.setInt(1, sc.nextInt());
			sc.nextLine();
			System.out.println("Enter the Name :");	
			psmt.setString(2, sc.nextLine());
			System.out.println("Enter the Place :");			
			psmt.setString(3, sc.nextLine());
			psmt.execute();
			System.out.print("Insert Data Successfully");
			sc.close();
			psmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}

}
