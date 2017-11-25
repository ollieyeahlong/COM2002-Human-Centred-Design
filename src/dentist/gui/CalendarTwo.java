package dentist.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
//import java.sql.Date;
//import java.sql.Time;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dentist.entities.Appointment;
import dentist.entities.Patient;

public class CalendarTwo {

	
	private JPanel calendar;
	private JButton prevWeek;
	private JButton nextWeek;
	private JLabel currentDate;
	private JLabel lblMonday;
	private JPanel mondayApps;
	private JPanel tuesdayApps;
	private JPanel wednesdayApps;
	private JPanel thursdayApps;
	private JPanel fridayApps;
	
	GregorianCalendar cal = new GregorianCalendar();
	
	private ArrayList<String> Appointments;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public CalendarTwo() {
		initialize();
	}
	
	private void clear() {
		mondayApps.removeAll();
		tuesdayApps.removeAll();
		wednesdayApps.removeAll();
		thursdayApps.removeAll();
		fridayApps.removeAll();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
        
		
		
		calendar = new JPanel();
		calendar.setBounds(173, 55, 551, 423);
		calendar.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		calendar.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		prevWeek = new JButton("<");
		prevWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cal.add(cal.WEEK_OF_YEAR, -1);
				clear();
				updateWeek();
				
			}
		});
		panel.add(prevWeek, BorderLayout.WEST);
		
		nextWeek = new JButton(">");
		nextWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.add(cal.WEEK_OF_YEAR, +1);
				clear();
				updateWeek();
			}

			
		});
		panel.add(nextWeek, BorderLayout.EAST);
		
		currentDate = new JLabel("Week");
		currentDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		//String month = realCalendar.getDisplayName(realCalendar.MONTH, realCalendar.LONG, Locale.US);
	    currentDate.setText("");
	    updateWeek();
		panel.add(currentDate, BorderLayout.CENTER);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		calendar.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblMonday = new JLabel("Monday");
		GridBagConstraints gbc_lblMonday = new GridBagConstraints();
		gbc_lblMonday.insets = new Insets(10, 0, 10, 5);
		gbc_lblMonday.gridx = 0;
		gbc_lblMonday.gridy = 0;
		panel_1.add(lblMonday, gbc_lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		GridBagConstraints gbc_lblTuesday = new GridBagConstraints();
		gbc_lblTuesday.insets = new Insets(10, 0, 10, 5);
		gbc_lblTuesday.gridx = 1;
		gbc_lblTuesday.gridy = 0;
		panel_1.add(lblTuesday, gbc_lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		GridBagConstraints gbc_lblWednesday = new GridBagConstraints();
		gbc_lblWednesday.insets = new Insets(10, 0, 10, 5);
		gbc_lblWednesday.gridx = 2;
		gbc_lblWednesday.gridy = 0;
		panel_1.add(lblWednesday, gbc_lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");

		GridBagConstraints gbc_lblThursday = new GridBagConstraints();
		gbc_lblThursday.insets = new Insets(10, 0, 10, 5);
		gbc_lblThursday.gridx = 3;
		gbc_lblThursday.gridy = 0;
		panel_1.add(lblThursday, gbc_lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");

		GridBagConstraints gbc_lblFriday = new GridBagConstraints();
		gbc_lblFriday.insets = new Insets(10, 0, 10, 0);
		gbc_lblFriday.gridx = 4;
		gbc_lblFriday.gridy = 0;
		panel_1.add(lblFriday, gbc_lblFriday);
		
		mondayApps = new JPanel();
		mondayApps.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel_1.add(mondayApps, gbc_panel_2);
		
		
		
		
		
		tuesdayApps = new JPanel();
		tuesdayApps.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		panel_1.add(tuesdayApps, gbc_panel_3);
		
		wednesdayApps = new JPanel();
		wednesdayApps.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		panel_1.add(wednesdayApps, gbc_panel_4);
		
		thursdayApps = new JPanel();
		thursdayApps.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 3;
		gbc_panel_5.gridy = 1;
		panel_1.add(thursdayApps, gbc_panel_5);
		
		fridayApps = new JPanel();
		fridayApps.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 4;
		gbc_panel_6.gridy = 1;
		panel_1.add(fridayApps, gbc_panel_6);
	}
	
	public void updateWeek() {
		cal.set(cal.DAY_OF_WEEK, 2);
		int weekOfYear = cal.get(cal.WEEK_OF_YEAR);
		String weekOfYearAsString = Integer.toString(weekOfYear);
		
		
		
		int dayOfWeek = cal.get(cal.DAY_OF_WEEK);
		
		
		
		int month = cal.get(cal.MONTH);
		int year = cal.get(cal.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM YYYY");
		String fullDate = sdf.format(cal.getTime());
		
		currentDate.setText("(" + weekOfYearAsString + "/52) " + fullDate);

		
		updatePanel();
		
	}
	
	public void updatePanel() {
		
		
		int dayOfMonth = cal.get(cal.DAY_OF_MONTH);
		int monthOfYear = cal.get(cal.MONTH);
		monthOfYear = monthOfYear + 1;
		int year = cal.get(cal.YEAR);
		//System.out.println(dayOfMonth);
		int rangeForWeek = dayOfMonth + 5;
		
		ArrayList<String> allStarDates = (Appointment.getAllAppointments());  
		String [] arrayOfAllStartDates = allStarDates.toArray(new String[allStarDates.size()]);
		
		for (int i=0; i<arrayOfAllStartDates.length; i++) {
			String dateSubString = arrayOfAllStartDates[i].substring(0, 10);
			
			String timeSub = arrayOfAllStartDates[i].substring(10, 15);
			
			String dayOfWeekSub = dateSubString.substring(8, 10);
			Integer dayOfWeekSubInteger = Integer.parseInt(dayOfWeekSub);
			
			String monthSubString = dateSubString.substring(5, 7);
			Integer monthSubInteger = Integer.parseInt(monthSubString);
			
			String yearSubString = dateSubString.substring(0, 4);
			Integer yearSubInteger = Integer.parseInt(yearSubString);
			
			if ((dayOfWeekSubInteger < rangeForWeek) && (dayOfWeekSubInteger >= dayOfMonth) && (monthSubInteger == (monthOfYear)) && (yearSubInteger == (year))) {
				System.out.println("Day Is Valid" + dateSubString);
				System.out.println("Month int is: " + monthSubInteger);
				
				//yearSubInteger
				//monthSubInteger
				//dayOfWeekSubInteger

				    Date dateComplete = (new GregorianCalendar(yearSubInteger, (monthSubInteger -1), dayOfWeekSubInteger)).getTime();
				    System.out.println(dateComplete);
				    String dayOfWeek = new SimpleDateFormat("EEEE").format(dateComplete);

				    

				String patientNumberString = Appointment.getPatientNameFromDateAndTime(timeSub, dateSubString);    
				String patientName = Patient.fetchForename(patientNumberString);
				String whoWith = Appointment.getWhoIsTreating(timeSub, dateSubString, patientNumberString);
				
				btnNewButton_1 = new JButton(dateSubString + "@" + timeSub);
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AppointmentDetails a = new AppointmentDetails(patientName, timeSub, dateSubString, whoWith);
					}
				});
				
				switch (dayOfWeek) {
				case "Monday":  mondayApps.add(btnNewButton_1);
				break;
				case "Tuesday":  tuesdayApps.add(btnNewButton_1);
				break;
				case "Wednesday":  wednesdayApps.add(btnNewButton_1);
				break;
				case "Thursday":  thursdayApps.add(btnNewButton_1);
				break;
				case "Friday":  fridayApps.add(btnNewButton_1);
				break;
				
				
				}
				
				
				
				
				
			}

			
			
		}
		
	}
	
	//Code to display all appointments
	public JPanel receptionistView() {		
		
		Appointments = Appointment.getAllAppointments();
		
		//Adds apps to the Jpanels here based on date
		
		return calendar;
	}
	
	//Code to display only dentist appointments
	public JPanel dentistView() {		
		
		Appointments = Appointment.getDentistAppointments();
		
		//Adds apps to the Jpanels here based on date
		
		return calendar;
	}

	//Code to display only hygienist appointments
	public JPanel hygienistView() {
		
		Appointments = Appointment.getHygienistAppointments();
		
		//Adds apps to the Jpanels here based on date
		
		return calendar;
	}
}
