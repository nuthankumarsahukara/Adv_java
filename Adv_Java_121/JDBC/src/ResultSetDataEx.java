import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetDataEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="select * from java121";
			ResultSet rs=smt.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("No of columns : "+rsmd.getColumnCount());
		
				System.out.println(rsmd.getColumnName(1));
				System.out.println(rsmd.getColumnTypeName(1));
				
				System.out.println(rsmd.getColumnName(2));
				System.out.println(rsmd.getColumnTypeName(2));
				
				System.out.println(rsmd.getColumnName(3));
				System.out.println(rsmd.getColumnTypeName(3));
				
				System.out.println(rsmd.getColumnDisplaySize(1));
				System.out.println(rsmd.getColumnDisplaySize(2));
				System.out.println(rsmd.getColumnDisplaySize(3));
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
