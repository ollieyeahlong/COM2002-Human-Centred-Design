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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class HealthcarePlan {

	private JFrame frmHealthcarePlan;
	private JButton btnUnsubscribe;
	private JLabel remCreditCheckup;
	private JLabel remCreditHyg;
	private JLabel remCreditRepair;
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
		frmHealthcarePlan.setBounds(100, 100, 450, 255);
		frmHealthcarePlan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHealthcarePlan.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(59, 67, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblPatientName);
		
		JLabel lblCurrentPlan = new JLabel("Current Plan");
		lblCurrentPlan.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblCurrentPlan.setBounds(59, 91, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblCurrentPlan);
		
		JLabel lblNewPlan = new JLabel("New Plan");
		lblNewPlan.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewPlan.setBounds(60, 117, 121, 16);
		frmHealthcarePlan.getContentPane().add(lblNewPlan);
		
		
		ArrayList<String> list = (Patient.getAllPatientNames());  
		String [] names = list.toArray(new String[list.size()]);
		
		JComboBox patientNames = new JComboBox(names);
		
		patientNames.setFont(new Font("Menlo", Font.PLAIN, 13));
		patientNames.setBounds(190, 67, 215, 27);
		
		frmHealthcarePlan.getContentPane().add(patientNames);
		
		JLabel currentPlanLabel = new JLabel("Choose A Patient");
		currentPlanLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		currentPlanLabel.setBounds(195, 93, 207, 16);
		frmHealthcarePlan.getContentPane().add(currentPlanLabel);
		
    	String valueOfName = patientNames.getSelectedItem().toString();
    	
    	String patientNumber = valueOfName.substring(valueOfName.length() - 1); 
		
		currentPlanLabel.setText(HealthcarePlanE.getCurrentMedicalPlan(patientNumber));
		
		remCreditCheckup = new JLabel((HealthcarePlanE.fetchCheckupCredits(patientNumber)));
		
		JLabel label = new JLabel("-1");
		label.setFont(new Font("Menlo", Font.PLAIN, 13));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(52, 6, 61, 16);
		frmHealthcarePlan.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("-1");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(198, 6, 61, 16);
		frmHealthcarePlan.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("-1");
		label_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(331, 7, 61, 16);
		frmHealthcarePlan.getContentPane().add(label_1);
		
		

		patientNames.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	String valueOfName = patientNames.getSelectedItem().toString();		    	
		    	String patientNumber = valueOfName.substring(valueOfName.length() - 1); 
		    	
		    	
		    	String hyg = HealthcarePlanE.fetchHygCredits(patientNumber);
		    	String che = HealthcarePlanE.fetchCheckupCredits(patientNumber);
		    	String rep = HealthcarePlanE.fetchRepairCredits(patientNumber);
		    	
		    	label.setText(hyg);
		    	lblNewLabel.setText(che);
		    	label_1.setText(rep);

		    	SwingUtilities.updateComponentTreeUI(frmHealthcarePlan);

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
		newPlanList.setBounds(190, 113, 215, 27);
		frmHealthcarePlan.getContentPane().add(newPlanList);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHealthcarePlan.dispose();
			}
		});
		btnCancel.setBounds(8, 198, 117, 29);
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
		
		
		
		btnSubscribe.setBounds(329, 198, 117, 29);
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
		btnUnsubscribe.setBounds(200, 198, 117, 29);
		frmHealthcarePlan.getContentPane().add(btnUnsubscribe);
		
		JLabel lblIfNothingIn = new JLabel("If nothing in current plan then the patient is not on a plan");
		lblIfNothingIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfNothingIn.setFont(new Font("Menlo", Font.PLAIN, 8));
		lblIfNothingIn.setBounds(8, 170, 438, 16);
		frmHealthcarePlan.getContentPane().add(lblIfNothingIn);
		
		JLabel lblNewLabel_1 = new JLabel("Checkup Credits");
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(39, 27, 143, 16);
		frmHealthcarePlan.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hygeine Credits");
		lblNewLabel_2.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(182, 27, 129, 16);
		frmHealthcarePlan.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Repair Credit");
		lblNewLabel_3.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(316, 27, 136, 16);
		frmHealthcarePlan.getContentPane().add(lblNewLabel_3);
		
		
		
		
		btnUnsubscribe.setVisible(false);
		
	}
}
