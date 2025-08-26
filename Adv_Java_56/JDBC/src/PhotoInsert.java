import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PhotoInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="nuthan";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Sno :");
		int sno=sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter the Name :");
		String name=sc.nextLine();
		
		System.out.println("Enter the Photo File Path:");
		String file=sc.nextLine();
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Classes are found.....");
			Connection con=DriverManager.getConnection(url, username, password);
			System.out.println("Database Connected Successfully....");
			FileInputStream fis = new FileInputStream(new File(file));
			String sql = "INSERT INTO javaphoto (sno, name, photo) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, sno);
            ps.setString(2, name);
            ps.setBinaryStream(3, fis,(int) new File(file).length());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Photo Data uploaded successfully!");
            } else {
                System.out.println("Photo Data upload failed.");
            }
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
