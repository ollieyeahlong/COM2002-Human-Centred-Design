package dentist;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterPatient {
	private JTextField txtTitle;
	private JTextField txtForename;
	private JTextField txtSurname;
	private JTextField txtDateOfBirth;
	private JTextField txtContactNumber;
	private JTextField txtHouseNumber;
	private JTextField txtStreetName;
	private JTextField txtDistrictName;
	private JTextField txtCityName;
	private JTextField txtPostCode;
	private JButton btnSubmit;
	private JButton btnCancelNewPatient;
	private JPanel newPatientPanel;
	private Font groupFont = new Font("Menlo", Font.PLAIN, 13);
	private int numberOfColumn = 10;
	private JTextField txtStartDate;
	private JTextField txtStartTime;
	private JPanel bookPatientPanel;
	
	private void makeSearchBarAndButton(JPanel p) {
		
		newPatientPanel = new JPanel();
		newPatientPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		newPatientPanel.setBackground(Color.RED);
		newPatientPanel.setForeground(Color.RED);
		newPatientPanel.setBounds(259, 59, 400, 400);
		newPatientPanel.setVisible(true);
		
		bookPatientPanel = new JPanel();
		bookPatientPanel.setBackground(Color.GREEN);
		bookPatientPanel.setBounds(259, 59, 400, 400);
		bookPatientPanel.setVisible(true);
		appointmentsView.add(bookPatientPanel);
		bookPatientPanel.setLayout(null);
		
		
		JButton cancelBookBtn = new JButton("Cancel/Re-Book Appointment");
		cancelBookBtn.setFont(new Font("Menlo", Font.PLAIN, 13));
		cancelBookBtn.setBounds(6, 365, 117, 29);
		cancelBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});   
		bookPatientPanel.add(cancelBookBtn);
		
		
		JButton submitBookBtn = new JButton(">");
		submitBookBtn.setFont(new Font("Menlo", Font.PLAIN, 13));
		submitBookBtn.setBounds(278, 365, 117, 29);
		submitBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPatientPanel.setVisible(false);
			}
		});  
		bookPatientPanel.add(submitBookBtn);
		String[] person = {"Mr J O EVANS"}; // would be in database 
		JComboBox comboBox = new JComboBox(person);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(6, 6, 389, 27);
		bookPatientPanel.add(comboBox);
		
		txtStartDate = new JTextField();
		txtStartDate.setText("Start date");
		txtStartDate.setBounds(7, 45, 388, 26);
		bookPatientPanel.add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtStartTime = new JTextField();
		txtStartTime.setText("Start time");
		txtStartTime.setBounds(6, 75, 389, 26);
		bookPatientPanel.add(txtStartTime);
		txtStartTime.setColumns(10);
		newPatientPanel.setLayout(null);
		appointmentsView.add(newPatientPanel);
		// Field for patient title
		txtTitle = new JTextField();
		txtTitle.setFont(groupFont);
		txtTitle.setText("Title");
		txtTitle.setColumns(numberOfColumn);
		txtTitle.setBounds(7, 12, 388, 26);
		newPatientPanel.add(txtTitle);
		
		// Field for forename
		txtForename = new JTextField();
		txtForename.setFont(groupFont);
		txtForename.setText("Forename");
		txtForename.setBounds(7, 41, 388, 26);
		newPatientPanel.add(txtForename);
		txtForename.setColumns(numberOfColumn);
		
		// Field for surname
		txtSurname = new JTextField();
		txtSurname.setFont(groupFont);
		txtSurname.setText("Surname");
		txtSurname.setBounds(7, 69, 388, 26);
		newPatientPanel.add(txtSurname);
		txtSurname.setColumns(numberOfColumn);
		
		// Field for DOB
		txtDateOfBirth = new JTextField();
		txtDateOfBirth.setFont(groupFont);
		txtDateOfBirth.setText("Date Of Birth");
		txtDateOfBirth.setBounds(7, 97, 388, 26);
		newPatientPanel.add(txtDateOfBirth);
		txtDateOfBirth.setColumns(10);
		
		// Field for contact number
		txtContactNumber = new JTextField();
		txtContactNumber.setFont(groupFont);
		txtContactNumber.setText("Contact Number");
		txtContactNumber.setBounds(7, 125, 388, 26);
		newPatientPanel.add(txtContactNumber);
		txtContactNumber.setColumns(10);
		
		// Field for house number
		txtHouseNumber = new JTextField();
		txtHouseNumber.setFont(groupFont);
		txtHouseNumber.setText("House Number");
		txtHouseNumber.setBounds(6, 202, 380, 26);
		newPatientPanel.add(txtHouseNumber);
		txtHouseNumber.setColumns(10);
		
		// Field for street name
		txtStreetName = new JTextField();
		txtStreetName.setFont(groupFont);
		txtStreetName.setText("Street Name");
		txtStreetName.setBounds(6, 229, 382, 26);
		newPatientPanel.add(txtStreetName);
		txtStreetName.setColumns(10);
		
		// Field for district name
		txtDistrictName = new JTextField();
		txtDistrictName.setFont(groupFont);
		txtDistrictName.setText("District Name");
		txtDistrictName.setBounds(6, 258, 382, 26);
		newPatientPanel.add(txtDistrictName);
		txtDistrictName.setColumns(10);
		
		// Field for city name
		txtCityName = new JTextField();
		txtCityName.setFont(groupFont);
		txtCityName.setText("City Name");
		txtCityName.setBounds(6, 286, 378, 26);
		newPatientPanel.add(txtCityName);
		txtCityName.setColumns(10);
		
		// Field for post code
		txtPostCode = new JTextField();
		txtPostCode.setFont(groupFont);
		txtPostCode.setText("Postcode");
		txtPostCode.setBounds(6, 311, 375, 26);
		newPatientPanel.add(txtPostCode);
		txtPostCode.setColumns(10);
		// Submit buttons
		btnSubmit = new JButton(">");
		btnSubmit.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnSubmit.setBounds(278, 365, 117, 29);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPatientPanel.setVisible(false);
			}
		});   
		newPatientPanel.add(btnSubmit);
		
		btnCancelNewPatient = new JButton("Cancel");
		btnCancelNewPatient.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancelNewPatient.setBounds(6, 365, 117, 29);
		btnCancelNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPatientPanel.setVisible(false);
			}
		});   
		newPatientPanel.add(btnCancelNewPatient);
		
	}
}
