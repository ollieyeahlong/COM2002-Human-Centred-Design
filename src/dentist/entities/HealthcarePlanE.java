package dentist.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dentist.database.Database;

public class HealthcarePlanE {
	
	private static Connection conn;
	
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
		credits = "0";
		return credits;
	}
	
	public static String fetchHygCredits(String patientNumber) {
		
		String credits = null;
		PreparedStatement stmt = null;
		
		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT numberOfHygieneVisitsLeft FROM HealthcarePlan WHERE (patientNumber = ?)");
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
		credits = "0";
		return credits;
	}
	
	public static String fetchRepairCredits(String patientNumber) {
		
		String credits = null;
		PreparedStatement stmt = null;
		
		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT numberOfRepairsLeft FROM HealthcarePlan WHERE (patientNumber = ?)");
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
		credits = "0";
		return credits;
	}
	
	
	public static String getCurrentMedicalPlan(String patientNumber) {
		
		String information = null;
		PreparedStatement stmt = null;
		
		conn = Database.getConnection();
		try {
			stmt = conn.prepareStatement("SELECT * FROM HealthcarePlan WHERE (patientNumber = ?)");
			stmt.setString(1, patientNumber);
			
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
	
	public static ArrayList<String> getAllHealthcarePlans()    {
	    ArrayList<String> plansList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select DISTINCT name from HealthcarePlan");

	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String plans = rs.getString(1);
	    		plansList.add(plans); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(plansList);
	 }
	
	public static void addToPlan(String patientNumber, String newPlan) {
		PreparedStatement stmt = null;
        conn = Database.getConnection();
        String nhsS = "NHS Free Plan";
        String mmS = "Maintenance Plan";
        String ohS = "Oral Health Plan";
	    try{
	    	
	    	System.out.println("here");
	    	stmt = conn.prepareStatement("INSERT INTO HealthcarePlan (name, monthlyPayment, patientNumber, numberOfCheckupLeft, numberOfHygieneVisitsLeft, numberOfRepairsLeft) VALUES (?, ?, ?, ?, ?, ?)");
	    	
	    	if (newPlan.equals(nhsS)) {
	    		stmt.setString(1, "NHS Free Plan");
	    		stmt.setString(2, "0");
	    		stmt.setString(3, patientNumber);
	    		
	    		stmt.setString(4, "6");
	    		stmt.setString(5, "1");
	    		stmt.setString(6, "9");
	    		
	    	} else if (newPlan.equals(mmS)) {
	    		stmt.setString(1, "Maintenance Plan");
	    		stmt.setString(2, "15");
	    		stmt.setString(3, patientNumber);
	    		
	    		stmt.setString(4, "2");
	    		stmt.setString(5, "2");
	    		stmt.setString(6, "4");
	    		
	    	} else if (newPlan.equals(ohS)) {
	    		stmt.setString(1, "Oral Health Plan");
	    		stmt.setString(2, "21");
	    		stmt.setString(3, patientNumber);
	    		
	    		stmt.setString(4, "3");
	    		stmt.setString(5, "3");
	    		stmt.setString(6, "0");
	    	}
	    	
	    	
	    	stmt.executeUpdate();
	    	
	    	
	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
		
		
		
		
	}
	
	public static void updateCurrentPlan() {
		
	}

	public static void removeFromPlan(String patientNum, String oldPlan) {
		PreparedStatement stmt = null;
        conn = Database.getConnection();
	    try{
	    	
	    	System.out.println("here");
	    	stmt = conn.prepareStatement("DELETE FROM HealthcarePlan WHERE patientNumber = ? AND name = ?");
	    	stmt.setString(1, patientNum);
	    	stmt.setString(2, oldPlan);

	    	
	    	stmt.executeUpdate();
	    	
	    	
	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }

	}

	public static boolean patientOnPlan(String patientNum) {
		PreparedStatement stmt = null;
        conn = Database.getConnection();
	    try {
	    	stmt = conn.prepareStatement("SELECT EXISTS(SELECT * FROM HealthcarePlan WHERE patientNumber = ?)");
	    	stmt.setString(1, patientNum);

	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		Integer plans = rs.getInt(1);
	    		if (plans >= 1) {
	    			return true;
	    		}
	    	}
	    } catch(Exception e)
        {
            System.out.println("Error in getData"+e);
        }  finally {
            Database.closeStatement(conn, stmt);
        }
		return false;
	}

}
