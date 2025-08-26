import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Class are founded....");
		Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "nuthan");
		System.out.println("Database Connected Successfully....");
		Scanner sc=new Scanner(System.in);
		PreparedStatement ps=c.prepareStatement("insert into java78 values(?,?,?,?)");
		
		System.out.println("Enter the S.No :");
		int sno=sc.nextInt();
		ps.setInt(1, sno);
		
		sc.nextLine();
		
		System.out.println("Enter the Name :");
		String name=sc.nextLine();
		ps.setString(2, name);
		
		System.out.println("Enter the DOB (DD-MMM-YYYY) :");
		String dob=sc.nextLine();
		ps.setString(3, dob);
		
		System.out.println("Enter the Place :");
		String place=sc.nextLine();
		ps.setString(4, place);
		
		ps.execute();
		
		System.out.println("Data Inserted Successfully..........");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
