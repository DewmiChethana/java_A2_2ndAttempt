package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection {
	
	
	public Connection get_connection() {
		
		Connection connection=null;
		
		try {
			
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/trial_calculation","root","");
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return connection;
		
	}
	

}
