package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
//import java.sql.Date;
//import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Calendar {

	
	private JPanel calendar;
	private JButton prevWeek;
	private JButton nextWeek;
	private JLabel currentDate;
	private JPanel mondayApps;
	private JPanel tuesdayApps;
	private JPanel wednesdayApps;
	private JPanel thursdayApps;
	private JPanel fridayApps;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public Calendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
        
		GregorianCalendar realCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        Date now = new Date();
        realCalendar.setTime(now);
        DateFormat dateAct = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        Date today = realCalendar.getTime();
        String dateActual = dateAct.format(realCalendar.getTime());
		
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
				realCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				realCalendar.add(Calendar.DATE, -7);

				//Display new week label here
				
				//
			}
		});
		panel.add(prevWeek, BorderLayout.WEST);
		
		nextWeek = new JButton(">");
		nextWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				realCalendar.add(Calendar.DATE, +7);

				//Display new week label here
				
				
			}
		});
		panel.add(nextWeek, BorderLayout.EAST);
		
		currentDate = new JLabel("Week");
		currentDate.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		JLabel lblMonday = new JLabel("Monday");
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
	
	public void refreshTop() {
		
	}
	
	//Code to display all appointments
	public JPanel receptionistView() {
		//Adds apps to the Jpanels here
		
		
		
		return calendar;
	}
	
	//Code to display only dentist appointments
	public JPanel dentistView() {
		//Adds apps to the Jpanels here
		
		return calendar;
	}

	//Code to display only hygienist appointments
	public JPanel hygienistView() {
		//Adds apps to the Jpanels here
		
		return calendar;
	}
}
