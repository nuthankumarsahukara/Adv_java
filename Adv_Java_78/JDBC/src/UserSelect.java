import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driverClass="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the SNo :");
			int sno=sc.nextInt();
			String query="select * from java78 where sno=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, sno);
			ResultSet rs=ps.executeQuery();
			System.out.println("SNo \t Name \t DOB \t Place");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDate(3)+"\t"+rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
