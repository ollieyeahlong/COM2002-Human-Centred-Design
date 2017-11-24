package dentist.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

public class Test {
	public static void main(String[] args) {		
		Connection conn = Database.getConnection();
		PreparedStatement stmt = null;
        
        try {
        	stmt = conn.prepareStatement("SELECT * FROM  Patient");
        	ResultSet res = stmt.executeQuery();
        	ResultSetMetaData rsmd = (ResultSetMetaData) res.getMetaData();
        	int columnsNumber = rsmd.getColumnCount();
        	
        	while (res.next()) {
        		//Print one row          
        		for(int i = 1 ; i <= columnsNumber; i++){

        		      System.out.print(res.getString(i) + " "); //Print one element of a row

        		}

        		  System.out.println();//Move to the next line to print the next row.           

        		    }
        } catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			 Database.closeStatement(conn, stmt);
		}
        
        
        
        
        
        
        
        /*
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
		}
		*/
        
        
	}
}
