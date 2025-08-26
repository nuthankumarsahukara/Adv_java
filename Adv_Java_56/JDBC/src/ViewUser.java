import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			System.out.println("Enter the ID :");
			int id=sc.nextInt();
			String query="select * from java56 where sno=?";
			PreparedStatement ps=c.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)+"   "+rs.getString(2)+"   "+rs.getDate(3));
			}else {
				System.out.println("Data does not exist.....");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
