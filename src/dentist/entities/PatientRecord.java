package dentist.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import dentist.database.Database;

public class PatientRecord {
	
	public static void setNewPatientRecord(String appointmentDate, String appointmentTime, String treatmentGiven, String patientNumber)    {
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("INSERT INTO PatientRecord (appointmentDate, appointmentTime, treatmentGiven, patientNumber) VALUES (?, ?, ?, ?);");
	    	stmt.setString(1, appointmentDate);
	    	stmt.setString(2, appointmentTime);
	    	stmt.setString(3, treatmentGiven);
	    	stmt.setString(4, patientNumber);
	    	stmt.executeUpdate();

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	 }

}
