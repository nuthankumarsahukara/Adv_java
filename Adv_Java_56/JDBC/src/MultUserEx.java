import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MultUserEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter how many record u will be enter :");
		int r=sc.nextInt();
		System.out.println("-----------------------------------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java56 values (?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			for(int i=1;i<=r;i++) {
				System.out.println("Enter the sno :");
				int sno=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the name :");
				String name=sc.nextLine();
				System.out.println("Enter the DOB (DD-MMM-YYYY) :");
				String date=sc.nextLine();
				System.out.println("-----------------------------------");
				
				ps.setInt(1, sno);
				ps.setString(2, name);
				ps.setString(3, date);
				
				ps.execute();
			}
			
			System.out.println("Data inserted Successfully.....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
