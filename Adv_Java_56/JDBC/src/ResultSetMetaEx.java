import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetMetaEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			String query="select * from java56";
			ResultSet rs=smt.executeQuery(query);
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("No of columns : "+rsmd.getColumnCount());
			
			System.out.println("Column 1 Name : "+rsmd.getColumnName(1));
			System.out.println("Column 1 Type : "+rsmd.getColumnTypeName(1));			
			System.out.println("Column 2 Name : "+rsmd.getColumnName(2));
			System.out.println("Column 2 Type : "+rsmd.getColumnTypeName(2));
			System.out.println("Column 3 Name : "+rsmd.getColumnName(3));
			System.out.println("Column 3 Type : "+rsmd.getColumnTypeName(3));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
