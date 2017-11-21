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
public class ReceptionistRevised extends JFrame{

	private JFrame contentFrame;
	private JTextField txtSearchForAppointment;
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
	private JPanel dentistView; 
	private JPanel newPatientPanel;
	private JPanel hygienistView;
	private Font groupFont = new Font("Menlo", Font.PLAIN, 13);
	private int numberOfColumn = 10;
	private JTextField txtStartDate;
	private JTextField txtStartTime;
	private JPanel bookPatinetPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public ReceptionistRevised() {
		this.setLocationRelativeTo(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	// make the initialFrame
	private void makeFrame() {
		contentFrame = new JFrame();
		contentFrame.setTitle("Home");
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
	
	private void makeDentistView() {
		dentistView = new JPanel();
		dentistView.setBorder(null);
		dentistView.setLayout(null);
		tabbedPane.addTab("Dentist", null, dentistView, null);
	}
	
	private void makeHygienistView() {
		hygienistView = new JPanel();
		hygienistView.setBorder(null);
		hygienistView.setLayout(null);
		tabbedPane.addTab("Hygienist", null, hygienistView, null);
	}
	
	
	private void makeBookPatientView(JPanel p) {
		
	}
	
	private void makeAddNewPatientWindowAndFields() {
		
	}
	
	private void makeAddNewPatientWindowAndFieldButtons() {
	}
	
	private void makeSearchBarAndButton(JPanel p) {
		newPatientPanel = new JPanel();
		newPatientPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		newPatientPanel.setBackground(Color.RED);
		newPatientPanel.setForeground(Color.RED);
		newPatientPanel.setBounds(259, 59, 400, 400);
		newPatientPanel.setVisible(false);
		
		bookPatinetPanel = new JPanel();
		bookPatinetPanel.setBackground(Color.GREEN);
		bookPatinetPanel.setBounds(259, 59, 400, 400);
		bookPatinetPanel.setVisible(false);
		dentistView.add(bookPatinetPanel);
		bookPatinetPanel.setLayout(null);
		
		
		JButton cancelBookBtn = new JButton("Cancel");
		cancelBookBtn.setFont(new Font("Menlo", Font.PLAIN, 13));
		cancelBookBtn.setBounds(6, 365, 117, 29);
		cancelBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPatinetPanel.setVisible(false);
			}
		});   
		bookPatinetPanel.add(cancelBookBtn);
		
		JButton submitBookBtn = new JButton(">");
		submitBookBtn.setFont(new Font("Menlo", Font.PLAIN, 13));
		submitBookBtn.setBounds(278, 365, 117, 29);
		submitBookBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPatinetPanel.setVisible(false);
			}
		});  
		bookPatinetPanel.add(submitBookBtn);
		String[] person = {"Mr J O EVANS"}; // would be in database 
		JComboBox comboBox = new JComboBox(person);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(6, 6, 389, 27);
		bookPatinetPanel.add(comboBox);
		
		txtStartDate = new JTextField();
		txtStartDate.setText("Start date");
		txtStartDate.setBounds(7, 45, 388, 26);
		bookPatinetPanel.add(txtStartDate);
		txtStartDate.setColumns(10);
		
		txtStartTime = new JTextField();
		txtStartTime.setText("Start time");
		txtStartTime.setBounds(6, 75, 389, 26);
		bookPatinetPanel.add(txtStartTime);
		txtStartTime.setColumns(10);
		newPatientPanel.setLayout(null);
		dentistView.add(newPatientPanel);
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
		
		
		
		
		txtSearchForAppointment = new JTextField();
		txtSearchForAppointment.setForeground(Color.BLACK);
		txtSearchForAppointment.setFont(new Font("Menlo", Font.ITALIC, 13));
		txtSearchForAppointment.setText("Search For Appointment");
		txtSearchForAppointment.setBounds(19, 19, 569, 26);
		p.add(txtSearchForAppointment);
		p.add(txtSearchForAppointment);
		txtSearchForAppointment.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton.setBounds(600, 19, 117, 29);
		p.add(btnNewButton);
	}
	
	private void makeBookingButtons(JPanel p) {
		JButton btnNewButton_1 = new JButton("Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookPatinetPanel.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton_1.setBounds(6, 172, 155, 29);
		   
		p.add(btnNewButton_1);
	}
	
	private void makeCancelButton(JPanel p) {
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.setBounds(6, 202, 155, 29);

		p.add(btnCancel);
	}
	
	private void makeNewPatientButton(JPanel p) {
		JButton btnNewPatient = new JButton("New Patient");
		btnNewPatient.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewPatient.setBounds(6, 70, 155, 29);
		btnNewPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newPatientPanel.setVisible(true);
				if (bookPatinetPanel.isVisible() == true) {
					bookPatinetPanel.setVisible(false);
				}
			}
		});   
		p.add(btnNewPatient);
	}
	
	private void makeTable(JPanel p) {
		table = new JTable();
		table.setBounds(173, 53, 551, 423);
		p.add(table);
	}
	
	private void initialize() {
		makeFrame();
		makeTabFrame();
		
		makeDentistView();
		makeHygienistView();
		
		makeBookPatientView(dentistView);
		makeBookPatientView(hygienistView);
		
		makeAddNewPatientWindowAndFields();
		makeAddNewPatientWindowAndFields();
		makeAddNewPatientWindowAndFieldButtons();
		makeAddNewPatientWindowAndFieldButtons();
		
		makeSearchBarAndButton(dentistView);
		makeSearchBarAndButton(hygienistView);
		
		makeBookingButtons(dentistView);
		makeBookingButtons(hygienistView);
		
		makeCancelButton(dentistView);
		makeCancelButton(hygienistView);
		
		makeNewPatientButton(dentistView);
		makeNewPatientButton(hygienistView);
		
		makeTable(dentistView);
		makeTable(hygienistView);
		
		

	}
}
