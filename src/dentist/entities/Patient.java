package dentist.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dentist.database.Database;

public class Patient {
	
	 private int patientNumber;
	 private String title, forename, surname, dateOfBirth, contactNumber;
	 
	 private Connection conn;
	
	public Patient(String title, String forename, String surname, String dob, String contactNumber, Address address) {
        create(title, forename, surname, dob, contactNumber, address);
    }

	private boolean create(String title, String forename, String surname, String dob, String contactNumber, Address address){
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.dateOfBirth = dob;
        this.contactNumber = contactNumber;
        
        conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            
        	stmt = conn.prepareStatement("INSERT INTO Patient (title, forename, surname, dateOfBirth, contactNumber) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, title);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setObject(4, dob);
            stmt.setString(5, contactNumber);

            stmt.executeUpdate();
            
            ResultSet res = stmt.getGeneratedKeys();
            if(res.next()) { 
            	patientNumber = res.getInt(1);
            }
            
            stmt = conn.prepareStatement("INSERT INTO Address (houseNumber, streetName, districtName, cityName, postcode, patientNumber) VALUES (?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, address.getHouseNo());
            stmt.setString(2, address.getStreet());
            stmt.setString(3, address.getDistrict());
            stmt.setString(4, address.getCity());
            stmt.setString(5, address.getPostcode());
            stmt.setInt(6, patientNumber);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }
	

}
