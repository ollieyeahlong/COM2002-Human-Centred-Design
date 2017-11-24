package dentist.gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dentist.database.Database;

public class TEST {
	
	private static Connection conn;
	int colSelection;
	
	public static void main(String[] args) {
		System.out.println("Results");
		if (patientOnPlan("9")) {
			System.out.println("T");
		};
	}

	

}
