package dentist.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dentist.database.Database;

public class Appointment {
	
	public static ArrayList<String> getAllAppointmentForPatient(String patientNumber)    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select appointmentDate from PatientRecord WHERE patientNumber = ?");
	    	stmt.setString(1, patientNumber);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		dateList.add(date); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(dateList);
	 }
	
	public static Boolean isPatientBusy(String patientNumber, String startDate, String startTime)    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select patientNumber from Appointment WHERE startTime = ? AND startDate = ?");
	    	stmt.setString(1, startTime);
	    	stmt.setString(2, startDate);	    	
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		if (date.equals(patientNumber)) {
	    			return true;
	    		} else {
	    			return false;
	    		}
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
		return false;
	 }
	
	public static Boolean isPartnerBusy(String partner, String startDate, String startTime)    {
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select partner from Appointment WHERE startTime = ? AND startDate = ?");
	    	stmt.setString(1, startTime);
	    	stmt.setString(2, startDate);	    	
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String partner1 = rs.getString(1);
	    		if (partner1.equals(partner)) {
	    			return true;
	    		} else {
	    			return false;
	    		}
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
		return false;
	 }
	
	public static ArrayList<String> getAllTreatmentsForDateAndPatient(String appointmentDateString, String patientNumberString)    {
	    ArrayList<String> treatmentList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select treatmentGiven from PatientRecord WHERE appointmentDate = ? AND patientNumber = ?");
	    	stmt.setString(1, appointmentDateString);
	    	stmt.setString(2, patientNumberString);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		treatmentList.add(date); //here you can get data, the '1' indicates column number based on your query
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
	
	// start date only
	public static ArrayList<String> getAllAppointments()    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select startDate, startTime  from Appointment");
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		String time = rs.getString(2);
	    		dateList.add(date + time); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(dateList);
	 }
	
	public static ArrayList<String> getDentistAppointments()    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select startDate, startTime  from Appointment WHERE partner = 'dentist'");
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		String time = rs.getString(2);
	    		dateList.add(date + time); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(dateList);
	 }
	
	public static ArrayList<String> getHygienistAppointments()    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select startDate, startTime  from Appointment WHERE partner = 'hygienist'");
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String date = rs.getString(1);
	    		String time = rs.getString(2);
	    		dateList.add(date + time); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(dateList);
	 }
	
	public static String getPatientNameFromDateAndTime(String startTime, String startDate)    {
	    String name = null;
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select patientNumber from Appointment WHERE startTime = ? AND startDate = ?");
	    	stmt.setString(1, startTime);
	    	stmt.setString(2, startDate);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		name = rs.getString(1);
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(name);
	 }
	
	public static String getWhoIsTreating(String startTime, String startDate, String patientNumber)    {
	    String name = null;
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select partner from Appointment WHERE startTime = ? AND startDate = ? AND patientNumber = ?");
	    	stmt.setString(1, startTime);
	    	stmt.setString(2, startDate);
	    	stmt.setString(3, patientNumber);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		name = rs.getString(1);
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(name);
	 }
	
	
	
	public static void setNewAppointment(String startDate, String endDate, String startTime, String endTime, String partner, String patientNumber)    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("INSERT INTO Appointment (startDate, endDate, startTime, endTime, partner, patientNumber) VALUES (?, ?, ?, ?, ?, ?);");
	    	stmt.setString(1, startDate);
	    	stmt.setString(2, endDate);
	    	stmt.setString(3, startTime);
	    	stmt.setString(4, endTime);
	    	stmt.setString(5, partner);
	    	stmt.setString(6, patientNumber);
	    	stmt.executeUpdate();

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	 }
	
	public static void setNewHoliday(String startDate, String endDate, String partner)    {
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("INSERT INTO Appointment (startTime, startDate, endDate, partner, patientNumber, endTime) VALUES (?, ?, ?, ?, ?, ?)");
	    	stmt.setString(1, "00:01:00");
	    	stmt.setString(2, startDate);
	    	stmt.setString(3, endDate);
	    	stmt.setString(4, partner);
	    	stmt.setString(5, "13");
	    	stmt.setString(6, "23:59:59");

	    	stmt.executeUpdate();

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	 }
	
	public static ArrayList<String> getHolidayDates(String partner)    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("select startDate, endDate from Appointment WHERE patientNumber = '13' AND partner =?");
	    	stmt.setString(1, partner);
	    	ResultSet rs = stmt.executeQuery();
	    	while(rs.next())
	    	{
	    		String startDate = rs.getString(1);
	    		String endDate = rs.getString(2);
	    		dateList.add(startDate + endDate); //here you can get data, the '1' indicates column number based on your query
	    	}

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	  		

	    return(dateList);
	 }
	
	public static void deleteAppointment(String startDate1, String startTime1, String patientNumber1)    {
	    ArrayList<String> dateList = new ArrayList<String>();
	    PreparedStatement stmt = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("DELETE FROM Appointment WHERE startDate = ? AND startTime = ? AND patientNumber = ?");
	    	stmt.setString(1, startDate1);
	    	stmt.setString(2, startTime1);
	    	stmt.setString(3, patientNumber1);
	    	
	    	stmt.executeUpdate();

	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	          }
	 }
	
	public static void amendAppointment(String oldStartDate, String startDate1, String oldStartTime, String startTime1, String patientNumber1)    {
	    PreparedStatement stmt = null;
	    PreparedStatement stmt2 = null;
        Connection conn = Database.getConnection();
	    try{
	    	
	    	stmt = conn.prepareStatement("UPDATE Appointment SET startDate = REPLACE (startDate, ?, ?)");
	    	stmt.setString(1, oldStartDate);
	    	stmt.setString(2, startDate1);
	    	
	    	stmt.executeUpdate();
	    	
	    	stmt2 = conn.prepareStatement("UPDATE Appointment SET startTime = REPLACE (startTime, ?, ?)");
	    	stmt2.setString(1, oldStartTime);
	    	stmt2.setString(2, startTime1);
	    	stmt2.executeUpdate();
	    	
	          }
	          catch(Exception e)
	          {
	              System.out.println("Error in getData"+e);
	          }  finally {
	              Database.closeStatement(conn, stmt);
	              Database.closeStatement(conn, stmt2);
	          }
	 }
	
	

}
