package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import dentist.entities.Patient;
import dentist.entities.Treatment;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PatientRecord {

	private JFrame frmPatientRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 * @param patientNumber 
	 * @wbp.parser.entryPoint
	 */
	public PatientRecord(String patientNumber) {
		initialize(patientNumber);
		frmPatientRecord.setVisible(true);
		frmPatientRecord.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param patientNumber 
	 */
	private void initialize(String patientNumber) {
		frmPatientRecord = new JFrame();
		frmPatientRecord.setTitle(Patient.fetchForename(patientNumber) + " " + Patient.fetchSurname(patientNumber) + " Record");
		frmPatientRecord.setBounds(100, 100, 715, 483);
		frmPatientRecord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientRecord.getContentPane().setLayout(new BorderLayout(0, 0));

		
		
		
		
		ArrayList<String> list2 = (Treatment.getPatientTreatment(patientNumber));
		  
		String [] resultsListArray = list2.toArray(new String[list2.size()]);
		for(int i = 0; i < list2.size(); i++) {
			JPanel groupT = new JPanel();
			frmPatientRecord.getContentPane().add(groupT, BorderLayout.CENTER);
			JPanel singleCont = new JPanel();
			groupT.add(singleCont);
			
			JPanel treatmentContainer = new JPanel();
			singleCont.add(treatmentContainer);
			
			JLabel lblNewLabel = new JLabel("Treatment name: ");
			lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 14));
			treatmentContainer.add(lblNewLabel);
			
			
			
			
			JLabel treatmentName = new JLabel("N O N E");
			
			JPanel indivCost = new JPanel();
			singleCont.add(indivCost);
			
			JLabel lblCostPer = new JLabel("Cost Per: ");
			lblCostPer.setFont(new Font("Menlo", Font.PLAIN, 14));
			indivCost.add(lblCostPer);
			
			JLabel TreatmentP = new JLabel("New label");
			TreatmentP.setText(Treatment.fetchTreatmentCost(resultsListArray[i]));
			TreatmentP.setFont(new Font("Menlo", Font.PLAIN, 14));
			indivCost.add(TreatmentP);
			
			treatmentName.setText(resultsListArray[i]);
			
		    treatmentContainer.add(treatmentName);
		    treatmentName.setFont(new Font("Menlo", Font.PLAIN, 14));
			treatmentContainer.add(treatmentName);
			
			JPanel PrePaid = new JPanel();
			singleCont.add(PrePaid);
			
			JLabel lblNewLabel_1 = new JLabel("Pre paid");
			lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 14));
			PrePaid.add(lblNewLabel_1);
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			chckbxNewCheckBox.setFont(new Font("Menlo", Font.PLAIN, 14));
			if (Treatment.fetchIfPrePaid(patientNumber)) {
				chckbxNewCheckBox.setSelected(true);
			} else {
				chckbxNewCheckBox.setSelected(false);
			}
			chckbxNewCheckBox.setEnabled(false);
			PrePaid.add(chckbxNewCheckBox);
		    
		}
		
		
		
		
		
		
		
		
		JPanel titleThings = new JPanel();
		frmPatientRecord.getContentPane().add(titleThings, BorderLayout.NORTH);
		
		JLabel lblPatientName = new JLabel("Patient Name: ");
		lblPatientName.setFont(new Font("Menlo", Font.ITALIC, 14));
		titleThings.add(lblPatientName);
		
		JLabel lblNewLabel_2 = new JLabel("NAME");
		lblNewLabel_2.setText(Patient.fetchForename(patientNumber) + " " + Patient.fetchSurname(patientNumber));
		lblNewLabel_2.setFont(new Font("Menlo", Font.ITALIC, 14));
		titleThings.add(lblNewLabel_2);
		
		JLabel label = new JLabel("     /     ");
		label.setFont(new Font("Menlo", Font.ITALIC, 14));
		titleThings.add(label);
		
		JLabel lblPatientNumber = new JLabel("Patient Number: ");
		lblPatientNumber.setFont(new Font("Menlo", Font.ITALIC, 14));
		titleThings.add(lblPatientNumber);
		
		JLabel lblNum = new JLabel("NUM");
		lblNum.setText(patientNumber);
		lblNum.setFont(new Font("Menlo", Font.ITALIC, 14));
		titleThings.add(lblNum);
		
		JPanel totalCostPanel = new JPanel();
		frmPatientRecord.getContentPane().add(totalCostPanel, BorderLayout.SOUTH);
		totalCostPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblTotalCostWith = new JLabel("Total Cost With Discount");
		lblTotalCostWith.setFont(new Font("Menlo", Font.PLAIN, 14));
		lblTotalCostWith.setHorizontalAlignment(SwingConstants.RIGHT);
		totalCostPanel.add(lblTotalCostWith);
		
		JLabel lblXxx = new JLabel("XXX");
		lblXxx.setFont(new Font("Menlo", Font.PLAIN, 14));
		lblXxx.setHorizontalAlignment(SwingConstants.RIGHT);
		totalCostPanel.add(lblXxx);
	}
}
