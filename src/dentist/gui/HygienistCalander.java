package dentist.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
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
import java.awt.Font;

public class HygienistCalander {

	
	private JPanel calendar;
	private JButton prevWeek;
	private JButton nextWeek;
	private JLabel currentDate;
	private JLabel lblMonday;
	JPanel mondayApps;
	JPanel tuesdayApps;
	JPanel wednesdayApps;
	JPanel thursdayApps;
	JPanel fridayApps;
	
	GregorianCalendar cal = new GregorianCalendar();
	
	private ArrayList<String> Appointments;
	private JButton btnNewButton;
	private JButton btnNewButton_2;
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
	public HygienistCalander() {
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
		prevWeek.setFont(new Font("Menlo", Font.PLAIN, 13));
		prevWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cal.add(cal.WEEK_OF_YEAR, -1);
				clear();
				updateWeek();
				
			}
		});
		panel.add(prevWeek, BorderLayout.WEST);
		
		nextWeek = new JButton(">");
		nextWeek.setFont(new Font("Menlo", Font.PLAIN, 13));
		nextWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cal.add(cal.WEEK_OF_YEAR, +1);
				clear();
				updateWeek();
			}

			
		});
		panel.add(nextWeek, BorderLayout.EAST);
		
		currentDate = new JLabel("Week");
		currentDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		currentDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		//String month = realCalendar.getDisplayName(realCalendar.MONTH, realCalendar.LONG, Locale.US);
	    currentDate.setText("");
	    
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
		lblMonday.setFont(new Font("Menlo", Font.PLAIN, 10));
		GridBagConstraints gbc_lblMonday = new GridBagConstraints();
		gbc_lblMonday.insets = new Insets(10, 0, 10, 5);
		gbc_lblMonday.gridx = 0;
		gbc_lblMonday.gridy = 0;
		panel_1.add(lblMonday, gbc_lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setFont(new Font("Menlo", Font.PLAIN, 10));
		GridBagConstraints gbc_lblTuesday = new GridBagConstraints();
		gbc_lblTuesday.insets = new Insets(10, 0, 10, 5);
		gbc_lblTuesday.gridx = 1;
		gbc_lblTuesday.gridy = 0;
		panel_1.add(lblTuesday, gbc_lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setFont(new Font("Menlo", Font.PLAIN, 10));
		GridBagConstraints gbc_lblWednesday = new GridBagConstraints();
		gbc_lblWednesday.insets = new Insets(10, 0, 10, 5);
		gbc_lblWednesday.gridx = 2;
		gbc_lblWednesday.gridy = 0;
		panel_1.add(lblWednesday, gbc_lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setFont(new Font("Menlo", Font.PLAIN, 10));

		GridBagConstraints gbc_lblThursday = new GridBagConstraints();
		gbc_lblThursday.insets = new Insets(10, 0, 10, 5);
		gbc_lblThursday.gridx = 3;
		gbc_lblThursday.gridy = 0;
		panel_1.add(lblThursday, gbc_lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setFont(new Font("Menlo", Font.PLAIN, 10));

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
		updateWeek();
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
		
		clear();
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
				//System.out.println("Day Is Valid " + dateSubString);
				//System.out.println("Month int is: " + monthSubInteger);
				
				//yearSubInteger
				//monthSubInteger
				//dayOfWeekSubInteger

				    Date dateComplete = (new GregorianCalendar(yearSubInteger, (monthSubInteger -1), dayOfWeekSubInteger)).getTime();
				    //System.out.println(dateComplete);
				    String dayOfWeek = new SimpleDateFormat("EEEE").format(dateComplete);
				    
				    

				String patientNumberString = Appointment.getPatientNameFromDateAndTime(timeSub, dateSubString);    
				String patientName = Patient.fetchForename(patientNumberString);
				String whoWith = Appointment.getWhoIsTreating(timeSub, dateSubString, patientNumberString);
				
				btnNewButton_1 = new JButton("@" + timeSub);
				btnNewButton_2 = new JButton("@" + timeSub);
				btnNewButton_1.setFont(new Font("Menlo", Font.PLAIN, 9));
				if(whoWith.equals("hygienist") && (patientNumberString.equals("13"))) {
					btnNewButton_1.setText("HOLIDAY H");
					btnNewButton_2.setText("HOLIDAY H END");
				}
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AppointmentDetails a = new AppointmentDetails(patientName, timeSub, dateSubString, whoWith);
					}
				});
				
				
				// if the selected date is between holiday then add to page.
				
				ArrayList<String> list1 = (Appointment.getHolidayDates("dentist"));  
				String [] dateDentist1 = list1.toArray(new String[list1.size()]);	//list of holiday start dates and end dates

				
				// Holiday over multiple screens !! ! ! ! 
				SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
				String fullDate = sdf.format(cal.getTime());
				
				
				

				
				//String startDateHoliday = dateDentist1[b].substring(0,10);
				//System.out.println("Start date " + b + ": " + startDateHoliday);

				//String endDateHoliday = dateDentist1[b].substring(10,20);
				//System.out.println("End date " + b + ": " + endDateHoliday);
				
				
				
				if (patientName.equals("Holiday")) {
					btnNewButton_1.setBackground(Color.red);
					if ((dayOfWeek).equals("Monday")) {					
						mondayApps.add(btnNewButton_1);
					} else if ((dayOfWeek).equals("Tuesday")) {
						tuesdayApps.add(btnNewButton_1);
					} else if ((dayOfWeek).equals("Wednesday")) {
						wednesdayApps.add(btnNewButton_1);
					} else if ((dayOfWeek).equals("Thursday")) {
						thursdayApps.add(btnNewButton_1);
					} else if ((dayOfWeek).equals("Friday")) {
						fridayApps.add(btnNewButton_1);
					}
				}
				
				
				ArrayList<String> list = (Appointment.getHolidayDates("dentist"));  
				String [] dateDentist = list.toArray(new String[list.size()]);				
				for (int i1=0; i1<dateDentist.length; i1++) {
					//System.out.println(dateDentist[i1]);
					String startDateHoliday = dateDentist[i1].substring(0,10);
					//System.out.println(startDateHoliday);
					
					
					
					
					//String output = formatter.format(convertedDate);
					
					
					
					
					
					//System.out.println(startDateHoliday);
					String endDateHoliday = dateDentist[i1].substring(10,20);
					
					
					try {
						DateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
						//DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
						Date convertedDate = parser.parse(startDateHoliday);
						//System.out.println("THIS IS THE NEW START DATE" + convertedDate);
						
						DateFormat parser2 = new SimpleDateFormat("yyyy-MM-dd");
						//DateFormat formatter2 = new SimpleDateFormat("yyyy-mm-dd");
						Date convertedDate2 = parser2.parse(endDateHoliday);
						//System.out.println("THIS IS THE NEW END DATE" + convertedDate2);
						
						Date x = cal.getTime();
						
						
						GregorianCalendar calDayTwo = new GregorianCalendar();
						calDayTwo.add(calDayTwo.DAY_OF_WEEK, +1);
						Date x2 = calDayTwo.getTime();
						
						GregorianCalendar calDayThree = new GregorianCalendar();
						calDayTwo.add(calDayThree.DAY_OF_WEEK, +2);
						Date x3 = calDayThree.getTime();
						
						GregorianCalendar calDayFour = new GregorianCalendar();
						calDayTwo.add(calDayFour.DAY_OF_WEEK, +3);
						Date x4 = calDayFour.getTime();
						
						GregorianCalendar calDayFive = new GregorianCalendar();
						calDayTwo.add(calDayFive.DAY_OF_WEEK, +4);
						Date x5 = calDayFive.getTime();
						
						
						
						
						
						
						
						
					} catch (ParseException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
					
					
					
					try {
						//System.out.println("got here");
						//System.out.println((isWithinRange(dateComplete, startDateHoliday, endDateHoliday)));

						if (isWithinRange(dateComplete, startDateHoliday, endDateHoliday)) {
							if ((dayOfWeek).equals("Monday")) {	
								btnNewButton_1.setText("HOLIDAY");
								mondayApps.add(btnNewButton_1);
							} else if ((dayOfWeek).equals("Tuesday")) {
								btnNewButton_1.setText("HOLIDAY");
								tuesdayApps.add(btnNewButton_1);
							} else if ((dayOfWeek).equals("Wednesday")) {
								btnNewButton_1.setText("HOLIDAY");
								wednesdayApps.add(btnNewButton_1);
							} else if ((dayOfWeek).equals("Thursday")) {
								btnNewButton_1.setText("HOLIDAY");
								thursdayApps.add(btnNewButton_1);
							} else if ((dayOfWeek).equals("Friday")) {
								btnNewButton_1.setText("HOLIDAY");
								fridayApps.add(btnNewButton_1);
							}
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
				
				
				
				if ((dayOfWeek).equals("Monday")) {					
					mondayApps.add(btnNewButton_1);
				} else if ((dayOfWeek).equals("Tuesday")) {
					tuesdayApps.add(btnNewButton_1);
				} else if ((dayOfWeek).equals("Wednesday")) {
					wednesdayApps.add(btnNewButton_1);
				} else if ((dayOfWeek).equals("Thursday")) {
					thursdayApps.add(btnNewButton_1);
				} else if ((dayOfWeek).equals("Friday")) {
					fridayApps.add(btnNewButton_1);
				}
			}
		}		
	}
	
	
	boolean isWithinRange(Date patientStartDate, String startDate, String endDate) throws ParseException {
		Date startDateDate=new SimpleDateFormat("YYYY-MM-DD").parse(startDate);
		//System.out.println(startDateDate);
		
		Date endDateDate = new SimpleDateFormat("YYYY-MM-DD").parse(endDate);
		//System.out.println(endDateDate);
	   return !(patientStartDate.before(startDateDate) || patientStartDate.after(endDateDate));
	}
	
	boolean isWithinRange2(Date patientStartDate, Date startDate, Date endDate) throws ParseException {

	   return !(patientStartDate.before(startDate) || patientStartDate.after(endDate));
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
