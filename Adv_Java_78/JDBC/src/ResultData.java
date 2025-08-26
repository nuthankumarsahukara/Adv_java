import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driverClass="oracle.jdbc.driver.OracleDriver";
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			Class.forName(driverClass);
			Connection c=DriverManager.getConnection(url, username, password);
			Statement smt=c.createStatement();
			ResultSet rs=smt.executeQuery("select * from java78");
			ResultSetMetaData rsmd=rs.getMetaData();
			
			System.out.println("Column 1 Name :"+rsmd.getColumnName(1)+" Type:"+rsmd.getColumnTypeName(1));
			System.out.println("Column 2 Name :"+rsmd.getColumnName(2)+" Type:"+rsmd.getColumnTypeName(2));
			System.out.println("Column 3 Name :"+rsmd.getColumnName(3)+" Type:"+rsmd.getColumnTypeName(3));
			System.out.println("Column 4 Name :"+rsmd.getColumnName(4)+" Type:"+rsmd.getColumnTypeName(4));
			
			System.out.println("Total Columns Count :"+rsmd.getColumnCount());
			
			System.out.println("Class Name of Column 1 :"+rsmd.getColumnClassName(1));
			System.out.println("Class Name of Column 2 :"+rsmd.getColumnClassName(2));
			System.out.println("Class Name of Column 3 :"+rsmd.getColumnClassName(3));
			System.out.println("Class Name of Column 4 :"+rsmd.getColumnClassName(4));	
			
			
			System.out.println("Column 1 Nullable "+rsmd.isNullable(1));
			System.out.println("Column 2 Nullable "+rsmd.isNullable(2));
			System.out.println("Column 3 Nullable "+rsmd.isNullable(3));
			System.out.println("Column 4 Nullable "+rsmd.isNullable(4));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
