package dentist;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient {
	
	 private int patientNumber;
	 private String title, forename, surname, contactNumber;
	 private String dateOfBirth;
	 private Connection conn;
	
	public Patient(String title, String forename, String surname, String dob, String contactNumber) {
        create(title, forename, surname, dob, contactNumber);
    }

	private boolean create(String title, String forename, String surname, String dob, String contactNumber){
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.contactNumber = contactNumber;
        conn = Database.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement findNextKeyStmt = null;

        try {
        	


            stmt = conn.prepareStatement("INSERT INTO Patient (title, forename, surname, dateOfBirth, contactNumber) VALUES ( ?, ?, ?, ?, ?)");

            stmt.setString(1, title);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setObject(4, dob);
            stmt.setString(5, contactNumber);

            stmt.executeUpdate();
            
            // THIS IS WHERE SHIT HITS THE FAN OLLIE. IT TRIES TO AUTO POPULATE THE PATIENT NUMBER WITH THE DEFAULT KEY, WHICH HAS ALREADY BEEN USED
            // IS IT REALLY THAT MUCH OF A PROBEL TO JUST HAVE GAPS IN OUR ID?
            // SURELY AS LONG AS THE ID IS CONSISTENT THEN ITS FINE
            

            ResultSet rs = stmt.getGeneratedKeys();
            System.out.println(rs);
            if(rs.next()) { 
            	this.patientNumber = rs.getInt(6);
            	}
            
            

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

}
