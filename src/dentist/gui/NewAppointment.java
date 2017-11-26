package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import dentist.entities.Appointment;
import dentist.entities.Patient;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.HeadlessException;

public class NewAppointment {

	private JFrame frmNewAppointment;
	private JTextField txtEnterStartDate;
	private JTextField txtEnterStartTime;
	private JTextField txtEnterEndTime;
	private JTextField txtEnterEndDate;
	private JComboBox comboBox_1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public NewAppointment() {
		initialize();
		frmNewAppointment.setVisible(true);
		frmNewAppointment.setLocationRelativeTo(null);
	}
	
	public String validationPassed(String startDate, String startTime, String partner, String patientNumber) {
		// Does the patient have an appointment at this time
		if (Appointment.isPartnerBusy(partner, startDate, startTime)) {
			System.out.println("1");
			return ("Partner is Busy");
		}
		if (Appointment.isPatientBusy(patientNumber, startDate, startTime)) {
			System.out.println("2");
			return ("Patient Is Busy");
		}
		
		if (!((Appointment.isPatientBusy(patientNumber, startDate, startTime)) && !(Appointment.isPartnerBusy(partner, startDate, startTime)))){
			System.out.println("3");
			return ("Patient is Free + Partner is Free");
		}
		System.out.println("4");
		return ("error");
	}
	
	boolean isWithinRange(Date patientStartDate, String startDate, String endDate) throws ParseException {
		Date startDateDate=new SimpleDateFormat("YYYY-MM-DD").parse(startDate);
		Date endDateDate = new SimpleDateFormat("YYYY-MM-DD").parse(endDate);
	   return !(patientStartDate.before(startDateDate) || patientStartDate.after(endDateDate));
	}
	
	boolean checkValid(String startDate, String partner) throws ParseException {
		Date patientStartDate2 = new SimpleDateFormat("YYYY-MM-DD").parse(startDate);
		
		if (partner.equals("dentist")) {
			ArrayList<String> list = (Appointment.getHolidayDates("dentist"));  
			String [] dateDentist = list.toArray(new String[list.size()]);
			for (int i=0; i<dateDentist.length; i++) {
				System.out.println(dateDentist[i]);
				String startDateHoliday = dateDentist[i].substring(0,10);
				String endDateHoliday = dateDentist[i].substring(10,20);
				if (isWithinRange(patientStartDate2, startDateHoliday, endDateHoliday)) {
					return false;
				}
			}
		} else if (partner.equals("hygienist")) {
			ArrayList<String> list = (Appointment.getHolidayDates("hygienist"));  
			String [] dateDentist = list.toArray(new String[list.size()]);
			for (int i=0; i<dateDentist.length; i++) {
				System.out.println(dateDentist[i]);
				String startDateHoliday = dateDentist[i].substring(0,10);
				String endDateHoliday = dateDentist[i].substring(10,20);
				if (isWithinRange(patientStartDate2, startDateHoliday, endDateHoliday)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAppointment = new JFrame();
		frmNewAppointment.setTitle("New Appointment");
		frmNewAppointment.setBounds(100, 100, 450, 342);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewAppointment.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewAppointment.dispose();
			}
		});
		btnCancel.setBounds(6, 283, 117, 29);
		frmNewAppointment.getContentPane().add(btnCancel);
		
		JButton btnGo = new JButton(">");
		btnGo.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnGo.setBounds(327, 283, 117, 29);
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startDate =  txtEnterStartDate.getText();
				String endDate = txtEnterEndDate.getText();
				String startTime = txtEnterStartTime.getText();
				String endTime = txtEnterEndTime.getText();
				String partner = (String) comboBox_1.getSelectedItem();
				String patientNumberLong = (String) comboBox.getSelectedItem();
				String patientNumber = patientNumberLong.substring(patientNumberLong.length() -1 , patientNumberLong.length());
				
				
				// Check to see if holiday has been booked here
				// Check to see if a patient already has an appointment here
				System.out.println(Appointment.isPartnerBusy(partner, startDate, startTime));
				if(validationPassed(startDate, startTime, partner, patientNumber).equals("Patient is Free + Partner is Free")) {
					System.out.print("Appointment will be added to the calander");
					Appointment.setNewAppointment(startDate,endDate,startTime, endTime, partner, patientNumber);
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), patientNumberLong + " has been booked with " + partner + " at " + startDate + " @ " + startTime);
					frmNewAppointment.dispose();
					Receptionist r = new Receptionist();
				}
				
				else if(validationPassed(startDate, startTime, partner, patientNumber).equals("Patient Is Busy")) {
					System.out.println("Patient already has an appointment at this time & date.");
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), patientNumberLong + " has an appointment at this time & date.");
					frmNewAppointment.dispose();
				}
				
				else if(validationPassed(startDate, startTime, partner, patientNumber).equals("Partner is Busy")) {
					System.out.println("Partner already has an appointment at this time & date.");
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), partner + " has an appointment at this time & date.");
					frmNewAppointment.dispose();
					
				} else {
					System.out.println("Something went wrong.");
				}
				
				

				
				
				
			}
		});
		frmNewAppointment.getContentPane().add(btnGo);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(6, 10, 104, 16);
		frmNewAppointment.getContentPane().add(lblPatientName);
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(122, 6, 322, 27);
		frmNewAppointment.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 38, 104, 16);
		frmNewAppointment.getContentPane().add(lblNewLabel);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblStartTime.setBounds(6, 141, 104, 16);
		frmNewAppointment.getContentPane().add(lblStartTime);
		
		txtEnterStartDate = new JTextField();
		txtEnterStartDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartDate.setText("Enter Start Date");
		txtEnterStartDate.setBounds(122, 40, 322, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartDate);
		txtEnterStartDate.setColumns(10);
		
		txtEnterStartTime = new JTextField();
		txtEnterStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartTime.setText("Enter Start Time");
		txtEnterStartTime.setBounds(122, 136, 322, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartTime);
		txtEnterStartTime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" (YYYY-MM-DD)");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(6, 58, 104, 16);
		frmNewAppointment.getContentPane().add(lblNewLabel_1);
		
		JLabel lblHhmm = new JLabel("HH:MM:SS");
		lblHhmm.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblHhmm.setBounds(6, 158, 80, 16);
		frmNewAppointment.getContentPane().add(lblHhmm);
		
		JLabel lblPartner = new JLabel("Partner");
		lblPartner.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPartner.setBounds(6, 233, 61, 16);
		frmNewAppointment.getContentPane().add(lblPartner);
		
		 
		String[] prac = { "dentist", "hygienist" };
		comboBox_1 = new JComboBox(prac);
		comboBox_1.setFont(new Font("Menlo", Font.PLAIN, 13));

		comboBox_1.setBounds(122, 229, 322, 27);
		frmNewAppointment.getContentPane().add(comboBox_1);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblEndTime.setBounds(6, 186, 81, 16);
		frmNewAppointment.getContentPane().add(lblEndTime);
		
		txtEnterEndTime = new JTextField();
		txtEnterEndTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterEndTime.setText("Enter End Time");
		txtEnterEndTime.setBounds(122, 182, 322, 26);
		frmNewAppointment.getContentPane().add(txtEnterEndTime);
		txtEnterEndTime.setColumns(10);
		
		JLabel label = new JLabel("HH:MM:SS");
		label.setFont(new Font("Menlo", Font.PLAIN, 13));
		label.setBounds(7, 201, 80, 16);
		frmNewAppointment.getContentPane().add(label);
		
		txtEnterEndDate = new JTextField();
		txtEnterEndDate.setText("Enter End Date");
		txtEnterEndDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterEndDate.setColumns(10);
		txtEnterEndDate.setBounds(122, 89, 322, 26);
		frmNewAppointment.getContentPane().add(txtEnterEndDate);
		
		JLabel label_1 = new JLabel(" (YYYY-MM-DD)");
		label_1.setFont(new Font("Menlo", Font.PLAIN, 12));
		label_1.setBounds(6, 104, 95, 16);
		frmNewAppointment.getContentPane().add(label_1);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblEndDate.setBounds(6, 86, 95, 16);
		frmNewAppointment.getContentPane().add(lblEndDate);
	}
}
