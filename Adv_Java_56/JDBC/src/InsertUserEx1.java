import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertUserEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into java56 values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			System.out.println("Enter the sno :");
			int sno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name :");
			String name=sc.nextLine();
			System.out.println("Enter the DOB (DD-MMM-YYYY) :");
			String date=sc.nextLine();			
			ps.setInt(1, sno);
			ps.setString(2, name);
			ps.setString(3, date);
			ps.execute();
			System.out.println("Data inserted Successfully....");
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
