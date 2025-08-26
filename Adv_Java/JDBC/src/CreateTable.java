import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

		public static void main(String[] args) {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			String username="system";
			String password="nuthan";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Driver are found");
				Connection con=DriverManager.getConnection(url,username,password);
				System.out.println("Database is connected");
				String query="CREATE TABLE JDBC1"
						+ "(SNO NUMBER(3),NAME VARCHAR2(15),PLACE VARCHAR2(15))";
				Statement smt=con.createStatement();
				smt.execute(query);
				System.out.print("Table create successfully..");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
