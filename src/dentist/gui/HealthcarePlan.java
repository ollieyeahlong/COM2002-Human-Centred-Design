package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HealthcarePlan {

	private JFrame frmHealthcarePlan;

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
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(183, 35, 215, 27);
		frmHealthcarePlan.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Choose A Patient");
		lblNewLabel.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblNewLabel.setBounds(185, 63, 207, 16);
		frmHealthcarePlan.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox_1.setBounds(183, 85, 215, 27);
		frmHealthcarePlan.getContentPane().add(comboBox_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHealthcarePlan.dispose();
			}
		});
		btnCancel.setBounds(6, 243, 117, 29);
		frmHealthcarePlan.getContentPane().add(btnCancel);
		
		JButton button = new JButton(">");
		button.setFont(new Font("Menlo", Font.PLAIN, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHealthcarePlan.dispose();
			}
		});
		button.setBounds(327, 243, 117, 29);
		frmHealthcarePlan.getContentPane().add(button);
	}
}
