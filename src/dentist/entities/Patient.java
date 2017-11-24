package dentist.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dentist.database.Database;

public class Patient {
	


	private int patientNumber;
	 private String title;
	private static String forename;
	private static String surname;
	private String dateOfBirth;
	private String contactNumber;
	 
	 private static Connection conn;
	 
	 public Patient(String surname) {
		 patientBySurname(surname);
	 }
	
	public Patient(String title, String forename, String surname, String dob, String contactNumber, Address address) {
        create(title, forename, surname, dob, contactNumber, address);
    }
	
	public static String getOldInfo(String colSelection, String patientNumber) {
		String information = null;
		PreparedStatement stmt = null;
		
		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT * FROM Patient WHERE (patientNumber = ?)");
			stmt.setString(1, patientNumber);
			
			ResultSet rs = stmt.executeQuery();
			
	    	while(rs.next())
	    	{
	    		
	    		if (colSelection == "Title") { // title
	    			information = rs.getString(1);
	    		} else if (colSelection == "Forename") { // forename
	    			information = rs.getString(2);
	    		} else if (colSelection == "Surname") { // surname
	    			information = rs.getString(3);
	    		} else if (colSelection == "D.O.B") { // dob
	    			information = rs.getString(4);
	    		} else if (colSelection == "Contact Number") { // contact number
	    			information = rs.getString(5);
	    		}
	    		
	    		
	    		
				return information;
	    	}
			
			
		} catch(SQLException e) {
            System.out.println(e.toString());
        }  finally {
            Database.closeStatement(conn, stmt);
        }
		return information;
	}
	
	
	
	public static ArrayList<String> getAllPatientNames()    {
	    ArrayList<String> surnameList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select forename, surname, patientNumber from Patient");

	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String surname = rs.getString(2);
	    		String forename = rs.getString(1);
	    		Integer patientNumber = rs.getInt(3);
	    		surnameList.add(forename + " " + surname + " " + patientNumber); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(surnameList);
	 }
	
	public static void setNewInformation(String newData, String colToChange, String patientNumber) {
		PreparedStatement stmt = null;
        conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("UPDATE Patient SET " + colToChange +" = ? WHERE patientNumber = ?");
	    	stmt.setString(1, newData);
	    	stmt.setString(2, patientNumber);

	    	stmt.executeUpdate();
	    	
	    	
	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
		
		
	}
	
	
	
	 private boolean patientBySurname(String sn) {
	        PreparedStatement stmt = null;
	        conn = Database.getConnection();
	        try {
	            stmt = conn.prepareStatement("SELECT * FROM Patient WHERE surname = ? LIMIT 1");

	            stmt.setString(1, surname);
	            
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	                this.patientNumber = rs.getInt("patientNumber");
	                this.title = rs.getString("title");
	                this.forename = rs.getString("forename");
	                this.surname = rs.getString("surname");
	                this.dateOfBirth = rs.getString("dateofBirth");
	                this.contactNumber = rs.getString("contactNumber");

	            }
	        } catch(SQLException e) {
	            System.out.println(e.toString());
	            return false;
	        }  finally {
	            Database.closeStatement(conn, stmt);
	        }

	        return true;
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
        	
        	int count = 0;
            
        	stmt = conn.prepareStatement("INSERT INTO Patient (title, forename, surname, dateOfBirth, contactNumber, patientNumber) VALUES ( ?, ?, ?, ?, ?, ?)");
        	
        	
        	Statement stmt3 = conn.createStatement();
        	ResultSet rs3 = stmt3.executeQuery("SELECT MAX(patientNumber) AS total FROM Patient");
        	    while(rs3.next()){
        	    	count = (rs3.getInt("total") + 1);
        	    }

            stmt.setString(1, title);
            stmt.setString(2, forename);
            stmt.setString(3, surname);
            stmt.setObject(4, dob);
            stmt.setString(5, contactNumber);
            System.out.println("Count for Patient: " + count);
			stmt.setInt(6, count);
            
            PreparedStatement stmt2 = conn.prepareStatement("INSERT INTO Address (houseNumber, streetName, districtName, cityName, postcode, patientNumber) VALUES (?, ?, ?, ?, ?, ?)");

            stmt2.setInt(1, address.getHouseNo());
            stmt2.setString(2, address.getStreet());
            stmt2.setString(3, address.getDistrict());
            stmt2.setString(4, address.getCity());
            stmt2.setString(5, address.getPostcode());
            System.out.println("Count for Patient: " + count);
            stmt2.setInt(6, count);

            
            
            stmt.executeUpdate();
            stmt2.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }  finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }

	public static ArrayList<Patient> findPatients(String surname2) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
