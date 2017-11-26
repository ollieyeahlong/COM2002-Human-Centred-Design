package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import dentist.entities.Appointment;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookHoliday {

	private JFrame frmBookHoliday;
	private JTextField txtYyyymmdd_1;
	private JTextField txtYyyymmdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 */
	public BookHoliday() {
		initialize();
		this.frmBookHoliday.setVisible(true);
		frmBookHoliday.setLocationRelativeTo(null);
		frmBookHoliday.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBookHoliday = new JFrame();
		frmBookHoliday.setTitle("Book Holiday");
		frmBookHoliday.setBounds(100, 100, 450, 198);
		frmBookHoliday.setDefaultCloseOperation(frmBookHoliday.EXIT_ON_CLOSE);
		frmBookHoliday.getContentPane().setLayout(null);
		
		JLabel lblPartner = new JLabel("Partner");
		lblPartner.setFont(new Font("Menlo", Font.PLAIN, 11));
		lblPartner.setBounds(6, 10, 61, 16);
		frmBookHoliday.getContentPane().add(lblPartner);
		
		JRadioButton rdbtnDentist = new JRadioButton("dentist");
		rdbtnDentist.setFont(new Font("Menlo", Font.PLAIN, 11));
		rdbtnDentist.setBounds(151, 6, 82, 23);
		frmBookHoliday.getContentPane().add(rdbtnDentist);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("hygienist");
		rdbtnNewRadioButton.setFont(new Font("Menlo", Font.PLAIN, 11));
		rdbtnNewRadioButton.setBounds(303, 6, 141, 23);
		frmBookHoliday.getContentPane().add(rdbtnNewRadioButton);
		
		JLabel lblStartDate = new JLabel("Start date");
		lblStartDate.setFont(new Font("Menlo", Font.PLAIN, 11));
		lblStartDate.setBounds(6, 53, 90, 16);
		frmBookHoliday.getContentPane().add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End date");
		lblEndDate.setFont(new Font("Menlo", Font.PLAIN, 11));
		lblEndDate.setBounds(6, 95, 61, 16);
		frmBookHoliday.getContentPane().add(lblEndDate);
		
		JButton btnSubmit = new JButton(">");
		
		btnSubmit.setFont(new Font("Menlo", Font.PLAIN, 11));
		btnSubmit.setBounds(327, 138, 117, 29);
		frmBookHoliday.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBookHoliday.dispose();
			}
		});
		btnCancel.setFont(new Font("Menlo", Font.PLAIN, 11));
		btnCancel.setBounds(6, 138, 117, 29);
		frmBookHoliday.getContentPane().add(btnCancel);
		
		txtYyyymmdd_1 = new JTextField();
		txtYyyymmdd_1.setFont(new Font("Menlo", Font.PLAIN, 11));
		txtYyyymmdd_1.setText("YYYY-MM-DD");
		txtYyyymmdd_1.setBounds(134, 48, 259, 26);
		frmBookHoliday.getContentPane().add(txtYyyymmdd_1);
		txtYyyymmdd_1.setColumns(10);
		
		txtYyyymmdd = new JTextField();
		txtYyyymmdd.setFont(new Font("Menlo", Font.PLAIN, 11));
		txtYyyymmdd.setText("YYYY-MM-DD");
		txtYyyymmdd.setBounds(134, 90, 259, 26);
		frmBookHoliday.getContentPane().add(txtYyyymmdd);
		txtYyyymmdd.setColumns(10);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String startDate = txtYyyymmdd_1.getText();
				String endDate = txtYyyymmdd.getText();
				
				
				if (rdbtnDentist.isSelected() && rdbtnNewRadioButton.isSelected()) {
					JOptionPane.showMessageDialog((frmBookHoliday.getContentPane()), "Please only choose one partner for holiday at a time");	
				}
				if (rdbtnDentist.isSelected()) {
					Appointment.setNewHoliday(startDate, endDate, "dentist");
					JOptionPane.showMessageDialog((frmBookHoliday.getContentPane()), "Holiday added from " + startDate + " til the " + endDate + " for the dentist.");	
				} else if (rdbtnNewRadioButton.isSelected()) {
					Appointment.setNewHoliday(startDate, endDate, "hygienist");
					JOptionPane.showMessageDialog((frmBookHoliday.getContentPane()), "Holiday added from " + startDate + " til the " + endDate + " for the hygienist.");	
				}
				
				
			}
		});
	}
}
