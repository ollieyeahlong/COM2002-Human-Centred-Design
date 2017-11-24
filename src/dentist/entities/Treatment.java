package dentist.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dentist.database.Database;

public class Treatment {
	
	public static ArrayList<String> getPatientTreatment(String patientNumber) {
	    ArrayList<String> treatmentList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try {
	    	
	    	stmt = conn.prepareStatement("SELECT treatmentGiven FROM PatientRecord WHERE (patientNumber = ?)");
	    	stmt.setString(1, patientNumber);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String treatmentGiven = rs.getString(1);
	    		treatmentList.add(treatmentGiven); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(treatmentList);
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
	
	public static boolean fetchIfPrePaid(String patientNumber) {
		String information = null;
		PreparedStatement stmt = null;
		
		Connection conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT * FROM HealthcarePlan WHERE (patientNumber = ?)");
			stmt.setString(1, patientNumber);
			
			ResultSet rs = stmt.executeQuery();
			
	    	while(rs.next())
	    	{
	    		information = rs.getString(1);
	    		if (information != null) {
	    			return true;
	    		}
				return false;
	    	}
			
			
		} catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
		return false;
	}

}
