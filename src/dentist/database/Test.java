package dentist.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		System.out.println("hello");
		
		/*Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
        try {
        	DatabaseMetaData md = conn.getMetaData();
        	ResultSet rs = md.getTables(null, null, "%", null);
        	while (rs.next()) {
        		System.out.println(rs.getString(3));
        	}
        } catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			 Database.closeStatement(conn, stmt);
		}*/
	}
}
