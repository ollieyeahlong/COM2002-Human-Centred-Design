package dentist.entities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dentist.database.Database;

public class Address {

	private int houseNo;
    private String street, city, district, postcode;
    
    private Connection conn;
    
    public Address(int houseNo, String street, String city, String district, String postcode) {
    	create(houseNo, street, city, district, postcode);
  
    }
    
    public int getHouseNo() { 
    	return houseNo; 
    }

    public String getStreet() {
    	return street; 
    }

    public String getCity() { 
    	return city; 
    }

    public String getDistrict() { 
    	return district; 
    }

    public String getPostcode() { 
    	return postcode; 
    }
    
    private boolean create(int houseNo, String street, String city, String district, String postcode){
    	this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.district = district;
        this.postcode = postcode.replace(" ", "");;
    	
        conn = Database.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Address (houseNumber, streetName, "
                    + "cityName, districtName, postcode) VALUES (?, ?, ?, ?, ?)");           
            
            stmt.setInt(1, this.houseNo);
            stmt.setString(2, this.street);
            stmt.setString(3, this.city);
            stmt.setString(4, this.district);
            stmt.setString(5, this.postcode);

            stmt.executeUpdate();
        }
        catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        finally {
            Database.closeStatement(conn, stmt);
        }

        return true;
    }
}
