package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dentist.entities.HealthcarePlanE;
import dentist.entities.Patient;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class HealthcarePlan {

	private JFrame frmHealthcarePlan;
	private JButton btnUnsubscribe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public HealthcarePlan() {
		initialize();
		frmHealthcarePlan.setLocationRelativeTo(null);
		frmHealthcarePlan.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHealthcarePlan = new JFrame();
		frmHealthcarePlan.setResizable(false);
		frmHealthcarePlan.setTitle("Healthcare Plan");
		frmHealthcarePlan.setBounds(100, 100, 450, 300);
		frmHealthcarePlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHealthcarePlan.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(52, 39, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblPatientName);
		
		JLabel lblCurrentPlan = new JLabel("Current Plan");
		lblCurrentPlan.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblCurrentPlan.setBounds(52, 63, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblCurrentPlan);
		
		JLabel lblNewPlan = new JLabel("New Plan");
		lblNewPlan.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewPlan.setBounds(53, 89, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblNewPlan);
		
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		
		JComboBox patientNames = new JComboBox(names);
		patientNames.setFont(new Font("Menlo", Font.PLAIN, 13));
		patientNames.setBounds(183, 35, 215, 27);
		
		frmHealthcarePlan.getContentPane().add(patientNames);
		
		JLabel currentPlanLabel = new JLabel("Choose A Patient");
		currentPlanLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		currentPlanLabel.setBounds(185, 63, 207, 16);
		frmHealthcarePlan.getContentPane().add(currentPlanLabel);
		
    	String valueOfName = patientNames.getSelectedItem().toString();
    	
    	String patientNumber = valueOfName.substring(valueOfName.length() - 1); 
		
		currentPlanLabel.setText(HealthcarePlanE.getCurrentMedicalPlan(patientNumber));
		
		patientNames.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	String valueOfName = patientNames.getSelectedItem().toString();
		    	
		    	String patientNumber = valueOfName.substring(valueOfName.length() - 1); 
				
				currentPlanLabel.setText(HealthcarePlanE.getCurrentMedicalPlan(patientNumber));
				if (HealthcarePlanE.patientOnPlan(patientNumber)) {
		    		btnUnsubscribe.setVisible(true);
		    	} else {
		    		btnUnsubscribe.setVisible(false);
		    	}
		    	
		    	
		    	
		    }
		});
		
		ArrayList<String> planList = (HealthcarePlanE.getAllHealthcarePlans());  
		String [] namesPlanList = planList.toArray(new String[planList.size()]);
		
		JComboBox newPlanList = new JComboBox(namesPlanList);
		newPlanList.setFont(new Font("Menlo", Font.PLAIN, 13));
		newPlanList.setBounds(183, 85, 215, 27);
		frmHealthcarePlan.getContentPane().add(newPlanList);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHealthcarePlan.dispose();
			}
		});
		btnCancel.setBounds(6, 243, 117, 29);
		frmHealthcarePlan.getContentPane().add(btnCancel);
		
		JButton btnSubscribe = new JButton("Subscribe");
		btnSubscribe.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnSubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newPlan = newPlanList.getSelectedItem().toString();
				String name = patientNames.getSelectedItem().toString();
				
				String patientNumber = name.substring(name.length() - 1);
				HealthcarePlanE.addToPlan(patientNumber, newPlan);
				JOptionPane.showMessageDialog(frmHealthcarePlan.getContentPane(), "Success. " + name + " Added to " + newPlan + ".");
				frmHealthcarePlan.dispose();
				
				
				
				
				
			}
		});
		btnSubscribe.setBounds(327, 243, 117, 29);
		frmHealthcarePlan.getContentPane().add(btnSubscribe);
		
		btnUnsubscribe = new JButton("Un Subscribe");
		
		btnUnsubscribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oldPlan = currentPlanLabel.getText();
				String name = patientNames.getSelectedItem().toString();
				
				String patientNumber = name.substring(name.length() - 1);
				HealthcarePlanE.removeFromPlan(patientNumber, oldPlan);
				JOptionPane.showMessageDialog(frmHealthcarePlan.getContentPane(), "Success. " + name + " Un subscribed from " + oldPlan + ".");
				frmHealthcarePlan.dispose();
				
			}
		});
		btnUnsubscribe.setBounds(198, 243, 117, 29);
		frmHealthcarePlan.getContentPane().add(btnUnsubscribe);
		btnUnsubscribe.setVisible(false);
	}
}
