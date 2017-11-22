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
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); // ! not sure where the tabbed pane should go
	private JPanel appointmentsView; 	
	private JPanel patientsView;
	

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
		setLocationRelativeTo(null);
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
				//contentFrame.dispose();
				NewAppointment n = new NewAppointment();
			}
		});
		bookButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		bookButton.setBounds(6, 172, 155, 29);	   
		appointmentsView.add(bookButton);
		//__________________________________________________________________________
		
		JButton cancelButton = new JButton("Cancel/Re-Book");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelReBook cRB = new CancelReBook();
			}
		});
		cancelButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		cancelButton.setBounds(6, 202, 155, 29);
		appointmentsView.add(cancelButton);
		//__________________________________________________________________________
		
		table = new JTable();
		table.setBounds(173, 55, 551, 423);
		appointmentsView.add(table);
		//__________________________________________________________________________
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Login window = new Login();         	
            	contentFrame.dispose();
            }
        });
		logoutButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		logoutButton.setBounds(6, 400, 155, 29);
		appointmentsView.add(logoutButton);
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
				RegisterPatient rP = new RegisterPatient();
			}
		});
		registerButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		registerButton.setBounds(6, 172, 155, 29);	   
		patientsView.add(registerButton);
		//__________________________________________________________________________
		
		JButton amendButton = new JButton("Amend Patient");
		amendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AmendPatient ap = new AmendPatient();
			}
		});
		amendButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		amendButton.setBounds(6, 202, 155, 29);
		patientsView.add(amendButton);
		//__________________________________________________________________________
		
		table = new JTable();
		table.setBounds(173, 55, 551, 423);
		patientsView.add(table);
		//__________________________________________________________________________
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Login window = new Login();         	
            	contentFrame.dispose();
            }
        });
		logoutButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		logoutButton.setBounds(6, 400, 155, 29);
		patientsView.add(logoutButton);
		//__________________________________________________________________________
	}
	
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
