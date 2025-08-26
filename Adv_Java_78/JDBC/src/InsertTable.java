import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Class are founded....");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "nuthan");
			System.out.println("Database Connected Successfully....");
			Statement smt=c.createStatement();
			smt.execute("insert into java78 values (1,'Datapro','23-jul-1995','vizag')");
			System.out.println("Data Inserted Successfully....");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
