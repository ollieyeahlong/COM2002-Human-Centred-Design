package dentist.gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import dentist.entities.Patient;
import dentist.entities.PatientRecord;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RecordTreatment {

	private JFrame frame;
	private JTextField appDateField;
	private JTextField appTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public RecordTreatment() {
		initialize();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 177);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblPatientName.setBounds(6, 6, 115, 16);
		frame.getContentPane().add(lblPatientName);
		
		ArrayList<String> arrayListAllPatientNames = (Patient.getAllPatientNames());  
		String [] allPatientNames = arrayListAllPatientNames.toArray(new String[arrayListAllPatientNames.size()]);
		
		JComboBox comboBox = new JComboBox(allPatientNames);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(129, 2, 315, 27);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Appointment Date");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel.setBounds(6, 34, 115, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAppointmentTime = new JLabel("Appointment Time");
		lblAppointmentTime.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblAppointmentTime.setBounds(6, 62, 115, 16);
		frame.getContentPane().add(lblAppointmentTime);
		
		appDateField = new JTextField();
		appDateField.setFont(new Font("Menlo", Font.PLAIN, 13));
		appDateField.setBounds(129, 29, 315, 26);
		frame.getContentPane().add(appDateField);
		appDateField.setColumns(10);
		
		appTextField = new JTextField();
		appTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		appTextField.setBounds(128, 57, 316, 26);
		frame.getContentPane().add(appTextField);
		appTextField.setColumns(10);
		
		String[] treatment = new String[]{"hygiene", "check-up", "silver amalgam filling", "white composite resin filling", "gold crown filling"};
		JComboBox comboBox_1 = new JComboBox(treatment);
		comboBox_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox_1.setBounds(129, 92, 315, 27);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String patientNumberLong = (String) comboBox.getSelectedItem();
				String patientNumber = patientNumberLong.substring(patientNumberLong.length() -1 , patientNumberLong.length());
				
				String treatmentGiven = (String) comboBox_1.getSelectedItem();
				
				PatientRecord.setNewPatientRecord(appDateField.getText(), appTextField.getText(), treatmentGiven, patientNumber);
				JOptionPane.showMessageDialog((frame.getContentPane()), treatmentGiven + " has been added to patient(" + patientNumberLong + ") record.");	
			}
		});
		btnNewButton.setBounds(327, 120, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(4, 120, 117, 29);
		frame.getContentPane().add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Treatment Given");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(6, 92, 115, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}
}
