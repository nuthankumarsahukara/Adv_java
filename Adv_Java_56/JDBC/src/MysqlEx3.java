import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MysqlEx3 {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/nuthan";
		String username="root";
		String password="root";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, username, password);
			String query="insert into data values(?,?,?)";
			PreparedStatement ps=c.prepareStatement(query);
			System.out.println("Enter the sno :");
			int sno=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the name :");
			String name=sc.nextLine();
			System.out.println("Enter the DOB (yyyy-mm-dd) :");
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

