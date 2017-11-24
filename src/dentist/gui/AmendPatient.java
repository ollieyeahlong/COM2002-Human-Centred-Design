package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AmendPatient {

	private JFrame frmAmendPatientDetails;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public AmendPatient() {
		initialize();
		frmAmendPatientDetails.setVisible(true);
		frmAmendPatientDetails.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmendPatientDetails = new JFrame();
		frmAmendPatientDetails.setTitle("Amend Patient Details");
		frmAmendPatientDetails.setBounds(100, 100, 450, 257);
		frmAmendPatientDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmendPatientDetails.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(55, 50, 112, 16);
		frmAmendPatientDetails.getContentPane().add(lblPatientName);
		
		JLabel lblOldInformation = new JLabel("Old Information");
		lblOldInformation.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblOldInformation.setBounds(55, 102, 143, 16);
		frmAmendPatientDetails.getContentPane().add(lblOldInformation);
		
		JLabel lblNewInformation = new JLabel("New Information");
		lblNewInformation.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewInformation.setBounds(55, 129, 158, 16);
		frmAmendPatientDetails.getContentPane().add(lblNewInformation);
		
		textField = new JTextField();
		textField.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField.setBounds(207, 124, 181, 26);
		frmAmendPatientDetails.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(210, 102, 172, 16);
		frmAmendPatientDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblDetailsToChange = new JLabel("Details to change");
		lblDetailsToChange.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblDetailsToChange.setBounds(55, 74, 143, 16);
		frmAmendPatientDetails.getContentPane().add(lblDetailsToChange);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(211, 50, 177, 16);
		frmAmendPatientDetails.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(207, 70, 181, 27);
		frmAmendPatientDetails.getContentPane().add(comboBox);
		
		JButton button = new JButton(">");
		button.setFont(new Font("Menlo", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmendPatientDetails.dispose();
			}
		});
		button.setBounds(333, 200, 117, 29);
		frmAmendPatientDetails.getContentPane().add(button);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAmendPatientDetails.dispose();
			}
		});
		btnCancel.setBounds(6, 200, 117, 29);
		frmAmendPatientDetails.getContentPane().add(btnCancel);
	}

}
