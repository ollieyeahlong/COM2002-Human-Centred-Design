package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppointmentDetails {

	private JFrame frmAppointmentDetails;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @param whoWith 
	 * @param dateSubString 
	 * @param timeSub 
	 * @param patientName 
	 * @wbp.parser.entryPoint
	 */
	public AppointmentDetails(String patientName, String timeSub, String dateSubString, String whoWith) {
		initialize(patientName, timeSub, dateSubString, whoWith);
		frmAppointmentDetails.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String patientName, String timeSub, String dateSubString, String whoWith) {
		frmAppointmentDetails = new JFrame();
		frmAppointmentDetails.setResizable(false);
		frmAppointmentDetails.setTitle("Appointment Details");
		frmAppointmentDetails.setBounds(100, 100, 450, 159);
		frmAppointmentDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppointmentDetails.getContentPane().setLayout(null);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAppointmentDetails.dispose();
			}
		});
		btnClose.setBounds(351, 101, 93, 29);
		frmAppointmentDetails.getContentPane().add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Patient Name");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(6, 6, 98, 16);
		frmAppointmentDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblStartTime.setBounds(6, 34, 98, 16);
		frmAppointmentDetails.getContentPane().add(lblStartTime);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblStartDate.setBounds(6, 62, 86, 16);
		frmAppointmentDetails.getContentPane().add(lblStartDate);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setText(patientName);
		lblNewLabel_1.setBounds(134, 6, 281, 16);
		frmAppointmentDetails.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setText(timeSub);
		lblNewLabel_2.setBounds(131, 34, 313, 16);
		frmAppointmentDetails.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		
		lblNewLabel_3.setBounds(134, 62, 318, 16);
		frmAppointmentDetails.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setText(dateSubString);
		JLabel lblPartner = new JLabel("Partner");
		lblPartner.setBounds(6, 90, 61, 16);
		frmAppointmentDetails.getContentPane().add(lblPartner);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setText(whoWith);
		lblNewLabel_4.setBounds(134, 90, 61, 16);
		frmAppointmentDetails.getContentPane().add(lblNewLabel_4);
	}

}
