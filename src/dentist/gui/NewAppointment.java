package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import dentist.entities.Patient;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class NewAppointment {

	private JFrame frmNewAppointment;
	private JTextField txtEnterStartDate;
	private JTextField txtEnterStartTime;

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewAppointment = new JFrame();
		frmNewAppointment.setTitle("New Appointment");
		frmNewAppointment.setBounds(100, 100, 450, 300);
		frmNewAppointment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewAppointment.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewAppointment.dispose();
			}
		});
		btnCancel.setBounds(6, 243, 117, 29);
		frmNewAppointment.getContentPane().add(btnCancel);
		
		JButton btnGo = new JButton(">");
		btnGo.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnGo.setBounds(327, 243, 117, 29);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewAppointment.dispose();
			}
		});
		frmNewAppointment.getContentPane().add(btnGo);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(43, 54, 104, 16);
		frmNewAppointment.getContentPane().add(lblPatientName);
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		JComboBox comboBox = new JComboBox(names);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(159, 50, 237, 27);
		frmNewAppointment.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(43, 104, 104, 16);
		frmNewAppointment.getContentPane().add(lblNewLabel);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblStartTime.setBounds(43, 151, 104, 16);
		frmNewAppointment.getContentPane().add(lblStartTime);
		
		txtEnterStartDate = new JTextField();
		txtEnterStartDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartDate.setText("Enter Start Date");
		txtEnterStartDate.setBounds(159, 99, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartDate);
		txtEnterStartDate.setColumns(10);
		
		txtEnterStartTime = new JTextField();
		txtEnterStartTime.setFont(new Font("Menlo", Font.PLAIN, 13));
		txtEnterStartTime.setText("Enter Start Time");
		txtEnterStartTime.setBounds(159, 146, 237, 26);
		frmNewAppointment.getContentPane().add(txtEnterStartTime);
		txtEnterStartTime.setColumns(10);
	}
}
