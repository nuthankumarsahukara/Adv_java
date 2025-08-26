import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter the SNo :");
			int sno=sc.nextInt();
			
			System.out.println("1. Name");
			System.out.println("2. DOB");
			System.out.println("3. Place");
			System.out.println("Enter the Choice :");
			int choice=sc.nextInt();
			
			PreparedStatement ps=null;
			int rows;
			sc.nextLine();
			switch (choice) {
				case 1 : 
						String nameQuery="update java78 set name= ? where sno =?";
						ps=c.prepareStatement(nameQuery);
						System.out.println("Enter the Name :");
						String name=sc.nextLine();
						ps.setString(1, name);
						ps.setInt(2, sno);
						
						rows=ps.executeUpdate();
						System.out.println(rows +" rows are updated");
						System.out.println("Name updated Successfully....");
						
						break;
						
				case 2  :
						String dobQuery="update java78 set dob= ? where sno =?";
						ps=c.prepareStatement(dobQuery);
						System.out.println("Enter the DOB (DD-MMM-YYYY) :");
						String dob=sc.nextLine();
						ps.setString(1, dob);
						ps.setInt(2, sno);
					
						rows=ps.executeUpdate();
						System.out.println(rows +" rows are updated");
						System.out.println("DOB updated Successfully....");
					
						break;
				case 3 :
						String placeQuery="update java78 set place= ? where sno =?";
						ps=c.prepareStatement(placeQuery);
						System.out.println("Enter the Place :");
						String place=sc.nextLine();
						ps.setString(1, place);
						ps.setInt(2, sno);
						
						rows=ps.executeUpdate();
						System.out.println(rows +" rows are updated");
						System.out.println("Place updated Successfully....");
						
						break;
				default :
						System.out.println("Please Enter The Valid Number ..... ");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
