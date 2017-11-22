package dentist;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Receptionist extends JFrame {

	private JFrame contentFrame;
	private JTextField txtSearchForAppointment;
	private JTextField txtSearchForPatient;
	private JTable table;
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
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); // ! not sure where the tabbed pane should go
	private JPanel appointmentsView; 
	private JPanel newPatientPanel;
	private JPanel patientsView;
	private Font groupFont = new Font("Menlo", Font.PLAIN, 13);
	private int numberOfColumn = 10;
	private JTextField txtStartDate;
	private JTextField txtStartTime;
	private JPanel bookPatientPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Receptionist window = new Receptionist();
		window.contentFrame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Receptionist() {
		this.setLocationRelativeTo(null);
		initialize();
	}

	
	// make the initialFrame
	private void makeFrame() {
		contentFrame = new JFrame();
		contentFrame.setTitle("Reception");
		contentFrame.setBounds(100, 100, 763, 560);
		contentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentFrame.getContentPane().setLayout(null);
		contentFrame.setLocationRelativeTo(null);
		contentFrame.setVisible(true);
	}
	
	private void makeTabFrame() {
		tabbedPane.setBounds(6, 0, 751, 532);
		contentFrame.getContentPane().add(tabbedPane);
	}
	
	private void makeAppointmentsView() {
		appointmentsView = new JPanel();
		appointmentsView.setBorder(null);
		appointmentsView.setLayout(null);
		tabbedPane.addTab("Appointments", appointmentsView);
		//__________________________________________________________________________
		
		txtSearchForAppointment = new JTextField();
		txtSearchForAppointment.setForeground(Color.BLACK);
		txtSearchForAppointment.setFont(new Font("Menlo", Font.ITALIC, 13));
		txtSearchForAppointment.setText("Search For Appointment");
		txtSearchForAppointment.setBounds(19, 19, 569, 26);
		txtSearchForAppointment.setColumns(10);
		appointmentsView.add(txtSearchForAppointment);	
		//__________________________________________________________________________
				
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		searchButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		searchButton.setBounds(600, 19, 117, 29);
		appointmentsView.add(searchButton);
		//__________________________________________________________________________
		
		JButton bookButton = new JButton("New Appointment");
		bookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		bookButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		bookButton.setBounds(6, 172, 155, 29);	   
		appointmentsView.add(bookButton);
		//__________________________________________________________________________
		
		JButton cancelButton = new JButton("Cancel/Re-Book Appointment");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		cancelButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		cancelButton.setBounds(6, 202, 155, 29);
		appointmentsView.add(cancelButton);
		//__________________________________________________________________________
		
		table = new JTable();
		table.setBounds(173, 53, 551, 423);
		appointmentsView.add(table);
		//__________________________________________________________________________
	}
	
	private void makePatientsView() {
		patientsView = new JPanel();
		patientsView.setBorder(null);
		patientsView.setLayout(null);
		tabbedPane.addTab("Patients", patientsView);
		//__________________________________________________________________________
		
		txtSearchForPatient = new JTextField();
		txtSearchForPatient.setForeground(Color.BLACK);
		txtSearchForPatient.setFont(new Font("Menlo", Font.ITALIC, 13));
		txtSearchForPatient.setText("Search For Patient");
		txtSearchForPatient.setBounds(19, 19, 569, 26);
		txtSearchForPatient.setColumns(10);
		patientsView.add(txtSearchForPatient);
		//__________________________________________________________________________
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		searchButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		searchButton.setBounds(600, 19, 117, 29);
		patientsView.add(searchButton);
		//__________________________________________________________________________
		
		JButton registerButton = new JButton("Register Patient");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		registerButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		registerButton.setBounds(6, 172, 155, 29);	   
		patientsView.add(registerButton);
		//__________________________________________________________________________
		
		JButton amendButton = new JButton("Amend Patient");
		amendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentFrame.dispose();
			}
		});
		amendButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		amendButton.setBounds(6, 202, 155, 29);
		patientsView.add(amendButton);
		//__________________________________________________________________________
		
		table = new JTable();
		table.setBounds(173, 53, 551, 423);
		patientsView.add(table);
		//__________________________________________________________________________
	}

	
	
	/*
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
	*/
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		makeFrame();
		makeTabFrame();
		
		makeAppointmentsView();
		makePatientsView();
	}
}
