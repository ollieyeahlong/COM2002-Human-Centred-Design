package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import dentist.entities.HealthcarePlanE;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment {

	private JFrame frmPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @param stringRepCredits 
	 * @param stringHygCredits 
	 * @param steingCheckUpCredits 
	 * @param stringRepCredits2 
	 * @param stringHygCredits2 
	 * @wbp.parser.entryPoint
	 */
	public Payment(String patientNumber, String cost, String newstringcheckupCredits, String newstringHygCredits, String newstringRepCredits2) {
		
		
		frmPayment = new JFrame();
		frmPayment.setTitle("Payment");
		frmPayment.setBounds(100, 100, 450, 300);
		frmPayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPayment.getContentPane().setLayout(null);
		frmPayment.setVisible(true);
		frmPayment.setLocationRelativeTo(null);
		
		JLabel lblOld = new JLabel("Old Checkup Credit");
		lblOld.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblOld.setBounds(6, 6, 132, 16);
		frmPayment.getContentPane().add(lblOld);
		
		JLabel lblOldHygCredit = new JLabel("Old Hyg Credit");
		lblOldHygCredit.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblOldHygCredit.setBounds(193, 6, 121, 16);
		frmPayment.getContentPane().add(lblOldHygCredit);
		
		JLabel lblOldRepairCredit = new JLabel("Old Repair Credit");
		lblOldRepairCredit.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblOldRepairCredit.setBounds(326, 6, 118, 16);
		frmPayment.getContentPane().add(lblOldRepairCredit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText(HealthcarePlanE.fetchCheckupCredits(patientNumber));
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel.setBounds(34, 34, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setText(HealthcarePlanE.fetchHygCredits(patientNumber));
		lblNewLabel_1.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_1.setBounds(203, 34, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setText(HealthcarePlanE.fetchRepairCredits(patientNumber));
		lblNewLabel_2.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(356, 34, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewCheckupCredit = new JLabel("New Checkup Credit");
		lblNewCheckupCredit.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewCheckupCredit.setBounds(6, 131, 146, 16);
		frmPayment.getContentPane().add(lblNewCheckupCredit);
		
		JLabel lblNewHygCredit = new JLabel("New Hyg Credit");
		lblNewHygCredit.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewHygCredit.setBounds(182, 131, 111, 16);
		frmPayment.getContentPane().add(lblNewHygCredit);
		
		JLabel lblNewRepairCredit = new JLabel("New Repair Credit");
		lblNewRepairCredit.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewRepairCredit.setBounds(326, 131, 118, 16);
		frmPayment.getContentPane().add(lblNewRepairCredit);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setText(newstringcheckupCredits);
		lblNewLabel_3.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(34, 159, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setText(newstringHygCredits);
		lblNewLabel_4.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(203, 159, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setText(newstringRepCredits2);
		lblNewLabel_5.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(356, 159, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_5);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPayment.dispose();
			}
		});
		btnConfirm.setFont(new Font("Menlo", Font.PLAIN, 10));
		btnConfirm.setBounds(326, 243, 117, 29);
		frmPayment.getContentPane().add(btnConfirm);
		
		JLabel lblAmountDue = new JLabel("Amount Due");
		lblAmountDue.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblAmountDue.setBounds(143, 248, 121, 16);
		frmPayment.getContentPane().add(lblAmountDue);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setText(cost);
		lblNewLabel_6.setFont(new Font("Menlo", Font.PLAIN, 10));
		lblNewLabel_6.setBounds(250, 248, 61, 16);
		frmPayment.getContentPane().add(lblNewLabel_6);
		frmPayment.setLocationRelativeTo(null);
	}


}
