import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserSelect1 {

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
			System.out.println("Enter the SNo or Name:");
			String data=sc.nextLine();
			String query="select * from java78 where to_char(sno)=? or name=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setString(1, data);
			ps.setString(2, data);
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
