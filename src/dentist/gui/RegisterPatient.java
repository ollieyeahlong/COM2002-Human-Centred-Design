package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dentist.entities.Address;
import dentist.entities.Patient;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class RegisterPatient {
	
	private JFrame frmRegisterNewPatient;
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblSurname;
	private JLabel lblDob;
	private JLabel lblNewLabel_2;
	private JLabel lblHouseNo;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblCityName;
	private JLabel lblPostcode;
	private JTextField titleTextField;
	private JTextField forenameTextField;
	private JTextField surnameTextField;
	private JTextField dobTextField;
	private JTextField contactNumberTextField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JButton btnCancel;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}
	


	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public RegisterPatient() {
		initialize();
		frmRegisterNewPatient.setVisible(true);
		frmRegisterNewPatient.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisterNewPatient = new JFrame();
		frmRegisterNewPatient.setTitle("Register New Patient");
		frmRegisterNewPatient.setBounds(100, 100, 450, 390);
		frmRegisterNewPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegisterNewPatient.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(48, 22, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Forename");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(48, 50, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblNewLabel_1);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblSurname.setBounds(48, 78, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblSurname);
		
		lblDob = new JLabel("D.O.B");
		lblDob.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblDob.setBounds(48, 106, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblDob);
		
		lblNewLabel_2 = new JLabel("Contact Number");
		lblNewLabel_2.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(48, 134, 130, 16);
		frmRegisterNewPatient.getContentPane().add(lblNewLabel_2);
		
		titleTextField = new JTextField();
		titleTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		titleTextField.setBounds(174, 17, 239, 26);
		frmRegisterNewPatient.getContentPane().add(titleTextField);
		titleTextField.setColumns(10);
		
		forenameTextField = new JTextField();
		forenameTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		forenameTextField.setBounds(173, 45, 239, 26);
		frmRegisterNewPatient.getContentPane().add(forenameTextField);
		forenameTextField.setColumns(10);
		
		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		surnameTextField.setBounds(174, 73, 239, 26);
		frmRegisterNewPatient.getContentPane().add(surnameTextField);
		surnameTextField.setColumns(10);
		
		dobTextField = new JTextField();
		dobTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		dobTextField.setBounds(174, 101, 239, 26);
		frmRegisterNewPatient.getContentPane().add(dobTextField);
		dobTextField.setColumns(10);
		
		contactNumberTextField = new JTextField();
		contactNumberTextField.setFont(new Font("Menlo", Font.PLAIN, 13));
		contactNumberTextField.setBounds(174, 129, 239, 26);
		frmRegisterNewPatient.getContentPane().add(contactNumberTextField);
		contactNumberTextField.setColumns(10);
		
		lblHouseNo = new JLabel("House Number");
		lblHouseNo.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblHouseNo.setBounds(48, 162, 110, 16);
		frmRegisterNewPatient.getContentPane().add(lblHouseNo);
		
		lblNewLabel_3 = new JLabel("Street Name");
		lblNewLabel_3.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(48, 190, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("District Name");
		lblNewLabel_4.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(48, 218, 130, 16);
		frmRegisterNewPatient.getContentPane().add(lblNewLabel_4);
		
		lblCityName = new JLabel("City Name");
		lblCityName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblCityName.setBounds(48, 246, 110, 16);
		frmRegisterNewPatient.getContentPane().add(lblCityName);
		
		lblPostcode = new JLabel("Postcode");
		lblPostcode.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPostcode.setBounds(48, 274, 103, 16);
		frmRegisterNewPatient.getContentPane().add(lblPostcode);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_5.setBounds(174, 157, 239, 26);
		frmRegisterNewPatient.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_6.setBounds(174, 185, 239, 26);
		frmRegisterNewPatient.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_7.setBounds(174, 213, 239, 26);
		frmRegisterNewPatient.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_8.setBounds(174, 241, 239, 26);
		frmRegisterNewPatient.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_9.setBounds(174, 269, 239, 26);
		frmRegisterNewPatient.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegisterNewPatient.dispose();
			}
		});
		btnCancel.setBounds(6, 333, 117, 29);
		frmRegisterNewPatient.getContentPane().add(btnCancel);
		
		
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = titleTextField.getText();
		        String forename = forenameTextField.getText();
		        String surname = surnameTextField.getText();		   
		        String dobString = dobTextField.getText();		
		        String contactNo = contactNumberTextField.getText(); 
		        int houseNo = Integer.parseInt(textField_5.getText());
		        String street = textField_6.getText();
		        String district = textField_6.getText();
		        String city = textField_6.getText();
		        String postcode = textField_6.getText();
		        
		        try {
	            	Address address = new Address(houseNo, street, city, district, postcode);
	                Patient patient = new Patient(title, forename, surname, dobString, contactNo, address);
	            } catch (Exception ex) {
	                System.out.println(ex.toString());
	            }
		            
			}
		});
		btnSubmit.setBounds(327, 333, 117, 29);
		frmRegisterNewPatient.getContentPane().add(btnSubmit);
	}

}
