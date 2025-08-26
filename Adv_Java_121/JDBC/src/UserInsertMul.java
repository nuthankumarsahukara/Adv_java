import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInsertMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the how row you need :");
		int r=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java121 values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			for(int i=1;i<=r;i++) {
				System.out.println("Enter the ID :");
				int id=sc.nextInt();				
				sc.nextLine();
				
				System.out.println("Enter the Name :");
				String name=sc.nextLine();
				
				System.out.println("Enter the DOB (DD-MON-YYYY) :");
				String dob=sc.nextLine();
				
				ps.setInt(1,id);
				ps.setString(2,name);
				ps.setString(3,dob);
				ps.addBatch();
				System.out.println("------------------------------");
			}
			
			ps.executeBatch();
			System.out.println("Data Inserted Successfully....");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
