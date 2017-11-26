package dentist.gui;

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
public class Hygienist extends JFrame {

	private JFrame contentFrame;
	private JTextField txtSearchForAppointment;
	private JTable table;
	
	private HygienistCalander calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Hygienist window = new Hygienist();
		window.contentFrame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Hygienist() {
		setLocationRelativeTo(null);
		initialize();
	}
	
	// make the initialFrame
	private void makeFrame() {
		contentFrame = new JFrame();
		contentFrame.setTitle("Hygienist");
		contentFrame.setBounds(100, 100, 763, 560);
		contentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentFrame.getContentPane().setLayout(null);
		contentFrame.setLocationRelativeTo(null);		
	}
	
	private void makeAppointmentsView() {
		
		txtSearchForAppointment = new JTextField();
		txtSearchForAppointment.setEditable(false);
		txtSearchForAppointment.setEnabled(false);
		txtSearchForAppointment.setBackground(Color.LIGHT_GRAY);
		txtSearchForAppointment.setForeground(Color.BLACK);
		txtSearchForAppointment.setFont(new Font("Menlo", Font.ITALIC, 13));
		txtSearchForAppointment.setBounds(6, 19, 751, 26);
		txtSearchForAppointment.setColumns(10);
		contentFrame.getContentPane().add(txtSearchForAppointment);
		//__________________________________________________________________________
		
		JButton finishedButton = new JButton("Finished Appointment");
		finishedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RecordTreatment r = new RecordTreatment();
			}
		});
		finishedButton.setFont(new Font("Menlo", Font.PLAIN, 10));
		finishedButton.setBounds(6, 202, 155, 29);
		contentFrame.getContentPane().add(finishedButton);
		//__________________________________________________________________________
		
		calendar = new HygienistCalander();
		contentFrame.getContentPane().add(calendar.hygienistView());
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
		contentFrame.getContentPane().add(logoutButton);
		//__________________________________________________________________________
		
		contentFrame.setVisible(true);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		makeFrame();
		
		makeAppointmentsView();
	}
}
