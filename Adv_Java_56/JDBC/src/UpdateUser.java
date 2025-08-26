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
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Name");
		System.out.println("2. DOB");
		System.out.println("Enter the choice :");
		int ch=sc.nextInt();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			switch(ch) {
				case 1 :
					String query="update java56 set name= ? where sno = ?";
					PreparedStatement ps=c.prepareStatement(query);
					System.out.println("Enter the sno :");
					int sno=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the name :");
					String name=sc.nextLine();
					
					ps.setString(1, name);
					ps.setInt(2, sno);
					
					ps.execute();
					break;
				case 2 :
					String query1="update java56 set dob= ? where sno = ?";
					PreparedStatement ps1=c.prepareStatement(query1);
					System.out.println("Enter the sno :");
					int no=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter the DOB(dd-mmm-yyyy) :");
					String dob=sc.nextLine();
					
					ps1.setString(1, dob);
					ps1.setInt(2, no);
					
					ps1.execute();
					break;
				default :
					System.out.println("Please enter the valid Choice.....");
			}
			System.out.println("Data Updated Successfully....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
