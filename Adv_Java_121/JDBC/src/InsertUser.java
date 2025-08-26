import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(url, username, password);
			String query="insert into java121 values (?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the ID :");
			int id=sc.nextInt();
			
			sc.nextLine();
			
			System.out.println("Enter the Name :");
			String name=sc.nextLine();
			
			System.out.println("Enter the DOB (DD-MON-YYYY) :");
			String dob=sc.nextLine();
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, dob);
			
			int row =ps.executeUpdate();
			
			if(row>0) 
				System.out.println(row +" row is inserted .....");
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
