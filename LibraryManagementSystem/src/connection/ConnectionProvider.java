package connection;
import java.sql.*;

public class ConnectionProvider {

	
		public static Connection getCon() {
		    try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hardiklibrary", "root", "hardik");
		        return con;
		    } catch (Exception e) {
		        System.out.println(e);
		        return null;
		    }
		}
}

	
//jdbc:mysql://localhost:3306/?user=root