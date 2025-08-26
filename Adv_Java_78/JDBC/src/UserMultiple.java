import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UserMultiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver class are founded......");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","nuthan");
			System.out.println("Database Connected Successfully......");
			Scanner sc=new Scanner(System.in);
			PreparedStatement ps=c.prepareStatement("insert into java78 values (?,?,?,?)");
			
			System.out.println("How many records do you want ?");
			int records=sc.nextInt();
			
			for(int i=1;i<=records;i++) {
				System.out.println("Enter the SNo :");
				int sno=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter the Name :");
				String name=sc.nextLine();
				
				System.out.println("Enter the DOB (DD-MMM-YYYY):");
				String dob=sc.nextLine();
				
				System.out.println("Enter the Place :");
				String place=sc.nextLine();

				ps.setInt(1, sno);
				ps.setString(2, name);
				ps.setString(3,dob);
				ps.setString(4, place);
				
				ps.addBatch();
			}
			ps.executeBatch();
			System.out.println("Data Inserted Successfully............");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
