import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class TestDB {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
		String url = "jdbc:mysql://localhost:3306/springdemo?serverTimezone=America/Chicago";
		String user = "root";
		String password = "bsdoma@05";

		// Load the Connector/J driver
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		Connection conn = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
