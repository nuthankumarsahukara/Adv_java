import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultMetaEx {

	public static void main(String[] args) {
			String url="jdbc:oracle:thin:@localhost:1521/xe";
			String username="system";
			String password="nuthan";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection(url,username,password);
				String query="select * from jdbc1";
				Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(query);
				ResultSetMetaData rsmd =rs.getMetaData();
				System.out.println("Column Number: " + rsmd.getColumnCount());
				System.out.println("1st Column name :"+rsmd.getColumnName(1)); 
				System.out.println("Type of column 1 :" + rsmd.getColumnTypeName(1));
	            System.out.println("2nd Column name :"+rsmd.getColumnName(2)); 
	            System.out.println("Type of column 2 :" + rsmd.getColumnTypeName(2));
	            System.out.println("3rd Column name :"+rsmd.getColumnName(3));
	            System.out.println("Type of column 3 :" + rsmd.getColumnTypeName(3));
	           // System.out.println("4th Column name :"+rsmd.getColumnName(4));
	            
	            
	        }catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}

	}

}
