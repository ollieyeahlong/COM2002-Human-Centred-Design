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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		if (Appointment.isPatientBusy(patientNumber, startDate, startTime)) {
			return ("Patient Is Busy");
		} else if (Appointment.isPartnerBusy(partner, startDate, startTime)) {
			return ("Partner is Busy");
		} else {
			return ("Patient is Free");
		}

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAppointment = new JFrame();
		frmNewAppointment.setTitle("New Appointment");
		frmNewAppointment.setBounds(100, 100, 450, 437);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewAppointment.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewAppointment.dispose();
			}
		});
		btnCancel.setBounds(6, 380, 117, 29);
		frmNewAppointment.getContentPane().add(btnCancel);
		
		JButton btnGo = new JButton(">");
		btnGo.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnGo.setBounds(327, 380, 117, 29);
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String startDate =  txtEnterStartDate.getText();
				String endDate = txtEnterEndDate.getText();
				String startTime = txtEnterStartTime.getText();
				String endTime = txtEnterEndTime.getText();
				String partner = (String) comboBox_1.getSelectedItem();
				String patientNumberLong = (String) comboBox.getSelectedItem();
				String patientNumber = patientNumberLong.substring(patientNumberLong.length() -1 , patientNumberLong.length());
				
				if (validationPassed(startDate, startTime, partner, patientNumber).equals("Patient is Free")) {
					frmNewAppointment.dispose();
					Appointment.setNewAppointment(startDate, endDate, startTime, endTime, partner, patientNumber);
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), "Patient appointment added!" + startDate + " at " + startTime);		
				} else if (validationPassed(startDate, startTime, partner, patientNumber).equals("Partner is Busy")) {
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), "Partner is busy at this time.");		
				} else if (validationPassed(startDate, startTime, partner, patientNumber).equals("Patient Is Busy")) {
					JOptionPane.showMessageDialog((frmNewAppointment.getContentPane()), "Patient has an appointment at this time.");				
				}
			}
		});
		frmNewAppointment.getContentPane().add(btnGo);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(49, 10, 104, 16);
		frmNewAppointment.getContentPane().add(lblPatientName);
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(165, 6, 237, 27);
		frmNewAppointment.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 12));
		lblNewLabel.setBounds(64, 38, 95, 16);
		frmNewAppointment.getContentPane().add(lblNewLabel);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblStartTime.setBounds(43, 146, 104, 16);
		frmNewAppointment.getContentPane().add(lblStartTime);
		
		txtEnterStartDate = new JTextField();
		txtEnterStartDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartDate.setText("Enter Start Date");
		txtEnterStartDate.setBounds(171, 38, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartDate);
		txtEnterStartDate.setColumns(10);
		
		txtEnterStartTime = new JTextField();
		txtEnterStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartTime.setText("Enter Start Time");
		txtEnterStartTime.setBounds(159, 146, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartTime);
		txtEnterStartTime.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" (YYYY-MM-DD)");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(49, 57, 95, 16);
		frmNewAppointment.getContentPane().add(lblNewLabel_1);
		
		JLabel lblHhmm = new JLabel("HH:MM:SS");
		lblHhmm.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblHhmm.setBounds(43, 165, 80, 16);
		frmNewAppointment.getContentPane().add(lblHhmm);
		
		JLabel lblPartner = new JLabel("Partner");
		lblPartner.setBounds(63, 273, 61, 16);
		frmNewAppointment.getContentPane().add(lblPartner);
		
		 
		String[] prac = { "dentist", "hygienist" };
		comboBox_1 = new JComboBox(prac);

		comboBox_1.setBounds(160, 269, 237, 27);
		frmNewAppointment.getContentPane().add(comboBox_1);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblEndTime.setBounds(42, 206, 81, 16);
		frmNewAppointment.getContentPane().add(lblEndTime);
		
		txtEnterEndTime = new JTextField();
		txtEnterEndTime.setText("Enter End Time");
		txtEnterEndTime.setBounds(162, 201, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterEndTime);
		txtEnterEndTime.setColumns(10);
		
		JLabel label = new JLabel("HH:MM:SS");
		label.setFont(new Font("Menlo", Font.PLAIN, 13));
		label.setBounds(43, 221, 80, 16);
		frmNewAppointment.getContentPane().add(label);
		
		txtEnterEndDate = new JTextField();
		txtEnterEndDate.setText("Enter End Date");
		txtEnterEndDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterEndDate.setColumns(10);
		txtEnterEndDate.setBounds(165, 76, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterEndDate);
		
		JLabel label_1 = new JLabel(" (YYYY-MM-DD)");
		label_1.setFont(new Font("Menlo", Font.PLAIN, 12));
		label_1.setBounds(43, 95, 95, 16);
		frmNewAppointment.getContentPane().add(label_1);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Menlo", Font.PLAIN, 12));
		lblEndDate.setBounds(58, 76, 95, 16);
		frmNewAppointment.getContentPane().add(lblEndDate);
	}
}
