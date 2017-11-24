package dentist.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dentist.database.Database;
import dentist.entities.HealthcarePlanE;

public class TEST {
	
	private static Connection conn;
	int colSelection;
	
	public static void main(String[] args) {
		System.out.println(HealthcarePlanE.fetchCheckupCredits("2"));
	}

	public static String fetchCheckupCredits(String patientNumber) {
		
		String credits = null;
		PreparedStatement stmt = null;
		
		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT numberofCheckupLeft FROM HealthcarePlan WHERE (patientNumber = ?)");
			stmt.setString(1, patientNumber);
			
			ResultSet rs = stmt.executeQuery();
			
	    	while(rs.next())
	    	{
	    		credits = rs.getString(1);
				return credits;
	    	}
		} catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
		return credits;
	}

}
