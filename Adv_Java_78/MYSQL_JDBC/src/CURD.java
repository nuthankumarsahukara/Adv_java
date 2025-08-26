import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CURD {
	static String driverClass="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/nuthan";
	static String username="root";
	static String password="root";
	
	public static void insertData(int sno,String name,String place) throws Exception {
		Class.forName(driverClass);
		Connection c=DriverManager.getConnection(url, username, password);
		PreparedStatement ps=c.prepareStatement("insert into java78 values(?,?,?)");
		ps.setInt(1, sno);
		ps.setString(2, name);
		ps.setString(3, place);		
		ps.execute();		
		System.out.println("Data Inserted Successfully......");
	}
	
	public static void readData() throws Exception {
		Class.forName(driverClass);
		Connection c=DriverManager.getConnection(url, username, password);
		Statement smt=c.createStatement();
		ResultSet rs=smt.executeQuery("select * from java78");
		System.out.println("SNo \t Name \t Place");
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString("name")+"\t"+rs.getString(3));
		}
	}
	
	public static void updateData(int sno,String name,String place) throws Exception {
		Class.forName(driverClass);
		Connection c=DriverManager.getConnection(url, username, password);
		PreparedStatement ps=c.prepareStatement("update java78 set name=?,place=? where sno=?");
		ps.setString(1, name);
		ps.setString(2, place);	
		ps.setInt(3, sno);
		ps.execute();		
		System.out.println("Data Updated Successfully......");		
	}
	
	public static void deleteData(int sno) throws Exception {
		Class.forName(driverClass);
		Connection c=DriverManager.getConnection(url, username, password);
		PreparedStatement ps=c.prepareStatement("delete from java78 where sno=?");
		ps.setInt(1, sno);
		ps.execute();		
		System.out.println("Data Deleted Successfully......");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			insertData(1, "Nuthan", "Vizag");
			insertData(2,"Sai","Hyderabad");
			insertData(3, "Vinod", "Chennai");
			readData();			
			updateData(2, "Sai Kumar", "Hyderabad");
			readData();			
			deleteData(3);
			readData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
