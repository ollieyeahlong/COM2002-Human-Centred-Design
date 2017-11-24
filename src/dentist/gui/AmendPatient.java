package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dentist.entities.Patient;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AmendPatient {

	private JFrame frmAmendPatientDetails;
	private JTextField newInfo;
	private JComboBox patientList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
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
		
		newInfo = new JTextField();
		newInfo.setFont(new Font("Menlo", Font.PLAIN, 13));
		newInfo.setBounds(207, 124, 181, 26);
		frmAmendPatientDetails.getContentPane().add(newInfo);
		newInfo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(210, 102, 172, 16);
		frmAmendPatientDetails.getContentPane().add(lblNewLabel);
		
		JLabel lblDetailsToChange = new JLabel("Details to change");
		lblNewLabel.setText(Patient.getOldInfo("Title", "1"));
		lblDetailsToChange.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblDetailsToChange.setBounds(55, 74, 143, 16);
		frmAmendPatientDetails.getContentPane().add(lblDetailsToChange);
		
		
		String[] optionsToAmend = {"Title", "Forename", "Surname", "D.O.B", "Contact Number"}; // options in dropdown
		@SuppressWarnings("unchecked")
		JComboBox detailsToChange = new JComboBox(optionsToAmend);
		detailsToChange.setFont(new Font("Menlo", Font.PLAIN, 13));
		detailsToChange.setBounds(207, 70, 181, 27);
		detailsToChange.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        
		    	String value = detailsToChange.getSelectedItem().toString();
		    	String valueOfName = patientList.getSelectedItem().toString();
		    	
		    	String patientNumber = valueOfName.substring(valueOfName.length() - 1); 
		    	
		    	lblNewLabel.setText(Patient.getOldInfo(value, patientNumber));
		    	
		    	
		    	
		    }
		});
		
		
		frmAmendPatientDetails.getContentPane().add(detailsToChange);
		
		JButton button = new JButton(">");
		button.setFont(new Font("Menlo", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newInfoString = newInfo.getText();	
				String value = detailsToChange.getSelectedItem().toString();
				String valueOfName = patientList.getSelectedItem().toString();
				String patientNumber = valueOfName.substring(valueOfName.length() - 1);
				if (!(newInfoString.isEmpty())) {
					
					Patient.setNewInformation(newInfoString, value, patientNumber);
					JOptionPane.showMessageDialog(frmAmendPatientDetails.getContentPane(), "Success. " + value + " Changed to " + newInfoString + ".");
					
				}
				
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
		
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		
		
		
		patientList = new JComboBox<Object>(names);
		patientList.setBounds(207, 46, 181, 27);
		frmAmendPatientDetails.getContentPane().add(patientList);
	}
}
