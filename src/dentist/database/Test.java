package dentist.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

public class Test {
	public static void main(String[] args) {		
		String searchString = "b";
		System.out.println(fetchTreatmentCost("check-up"));
	}
	
	
	public static String fetchTreatmentCost(String treatment) {
		String information = null;
		PreparedStatement stmt = null;
		
		Connection conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT cost FROM Treatment WHERE (name = ?)");
			stmt.setString(1, treatment);
			
			ResultSet rs = stmt.executeQuery();
			
	    	while(rs.next())
	    	{
	    		information = rs.getString(1);
				return information;
	    	}
			
			
		} catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
		return information;
	}
}