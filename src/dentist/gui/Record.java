package dentist.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import dentist.entities.Appointment;
import dentist.entities.HealthcarePlanE;
import dentist.entities.Patient;
import dentist.entities.Treatment;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Record {

	private JFrame frame;

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
	public Record(String patientNumber) {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 461);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.ITALIC, 10));
		panel_3.add(lblPatientName);
		
		String name = Patient.fetchForename(patientNumber) + " " + Patient.fetchSurname(patientNumber);
		
		JLabel label = new JLabel(name);
		label.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_3.add(label);
		
		JLabel lblPatientNumber = new JLabel("Patient Number");
		lblPatientNumber.setFont(new Font("Menlo", Font.ITALIC, 10));
		panel_3.add(lblPatientNumber);
		
		JLabel label_1 = new JLabel(patientNumber);
		label_1.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_3.add(label_1);
		
		JLabel lblPatientPlan = new JLabel("Patient Plan");
		lblPatientPlan.setFont(new Font("Menlo", Font.ITALIC, 10));
		panel_3.add(lblPatientPlan);
		
		JLabel label_2 = new JLabel(HealthcarePlanE.getCurrentMedicalPlan(patientNumber));
		label_2.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Select Appointment Date");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_4.add(lblNewLabel);
		
		ArrayList<String> list = (Appointment.getAllAppointmentForPatient(patientNumber));  
		String [] names = list.toArray(new String[list.size()]);
		
		JComboBox comboBox = new JComboBox(names);
		
		String date = (String) comboBox.getSelectedItem();
		ArrayList<String> treatments = Appointment.getAllTreatmentsForDateAndPatient(date, patientNumber); 
		
		panel_4.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.WEST);
		
		JLabel lblTotalCost = new JLabel("Total Cost");
		lblTotalCost.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_5.add(lblTotalCost);
		
		JLabel label_3 = new JLabel("0000");
		label_3.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_5.add(label_3);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6, BorderLayout.CENTER);
		
		JLabel lblAdjustedCost = new JLabel("Adjusted Cost w Plan");
		lblAdjustedCost.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_6.add(lblAdjustedCost);
		
		JLabel label_4 = new JLabel("0000");
		label_4.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_6.add(label_4);
		
		JPanel panel_7 = new JPanel();
		panel_1.add(panel_7, BorderLayout.EAST);
		
		JButton btnPayment = new JButton("Payment");
		
		btnPayment.setFont(new Font("Menlo", Font.PLAIN, 10));
		panel_7.add(btnPayment);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		JPanel TreatmentPanel = new JPanel();
		panel_2.add(TreatmentPanel);
		
		JLabel lblTreatmentName = new JLabel("Treatment Name");
		//TreatmentPanel.add(lblTreatmentName);
		
		JLabel lblTreatmentCost = new JLabel("Treatment Cost");
		//TreatmentPanel.add(lblTreatmentCost);

		ArrayList<String> TotalCost = new ArrayList<String>();
		
				
				
				String [] b = treatments.toArray(new String[treatments.size()]);
				System.out.println(b);
				
				for (int i = 0; i < b.length; i++) {
					JPanel Panel = new JPanel();
					TreatmentPanel.add(lblTreatmentName);
					JLabel lblXxx = new JLabel(b[i]);
					Panel.add(lblXxx);
					TreatmentPanel.add(lblTreatmentCost);
					JLabel label_5 = new JLabel(Treatment.fetchTreatmentCost(b[i]));
					TotalCost.add(label_5.getText());
					Panel.add(label_5);
					panel_2.add(Panel);
				}
				
				
				String [] totalCost = TotalCost.toArray(new String[TotalCost.size()]);
				Integer costInteger = 0;
				for (int i = 0; i < totalCost.length; i++){
					int cost1 = Integer.parseInt(totalCost[i]);
					costInteger = costInteger + cost1;
				}
				String result = Integer.toString(costInteger);
		    	label_3.setText(result);
		    	
		    

		    	
		    	String steingCheckUpCredits = HealthcarePlanE.fetchCheckupCredits(patientNumber);
		    	Integer intCheckUpCredits = Integer.parseInt(steingCheckUpCredits);
		    	
		    	String stringHygCredits = HealthcarePlanE.fetchHygCredits(patientNumber);
		    	Integer intHygCredits = Integer.parseInt(stringHygCredits);
		    	
		    	String stringRepCredits = HealthcarePlanE.fetchRepairCredits(patientNumber);
		    	Integer intRepCredits = Integer.parseInt(stringRepCredits);
		    	

		    	if ((intCheckUpCredits > 0) || (intHygCredits > 0) || (intRepCredits > 0)){
		    		label_4.setText("£0");
		    		System.out.println("reset");
		    	} else {
		    		label_4.setText(result);
		    	}
		
		    	ArrayList<String> Tlist = (Treatment.getPatientTreatment(patientNumber));  
				String [] arrayTList = Tlist.toArray(new String[Tlist.size()]);
				for (int i = 0; i < arrayTList.length; i++) {
					System.out.println("-> " + arrayTList[i]);
					if (arrayTList[i].equals("check-up") && ((intCheckUpCredits > 0))) {
						intCheckUpCredits = intCheckUpCredits - 1;
					}
					
					if (arrayTList[i].equals("hygeine") && ((intHygCredits > 0))) {
						intHygCredits = intHygCredits - 1;
						System.out.println(arrayTList[i]);
					}
					
					if (arrayTList[i].equals("silver amalgam filling") && ((intRepCredits > 0))) {
						intRepCredits = intRepCredits - 1;
						System.out.println(arrayTList[i]);
					}
				}
				
				String checkUp = Integer.toString(intCheckUpCredits);
				String hyg = Integer.toString(intHygCredits);
				String rep = Integer.toString(intRepCredits);
			
				System.out.println(checkUp);
				System.out.println(hyg);
				System.out.println(rep);
				
				
		    	btnPayment.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {			
						 
						
						
						if (HealthcarePlanE.patientOnPlan(patientNumber)) {							
							Payment go = new Payment(patientNumber, "0", checkUp, hyg, rep);													
						} else {
							JOptionPane.showMessageDialog((frame.getContentPane()), "Payment Complete!");
						}
					}
				});
		

		
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	
	}
	
	
	

}
