package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class CancelReBook {

	private JFrame frmRebookCancel;
	private JPanel panelRebook;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	}

	/**
	 * Create the application.
	 */
	public CancelReBook() {
		initialize();
		frmRebookCancel.setVisible(true);
		frmRebookCancel.setLocationRelativeTo(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRebookCancel = new JFrame();
		frmRebookCancel.setTitle("Cancel & Rebooking");
		frmRebookCancel.setBounds(100, 100, 450, 373);
		frmRebookCancel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRebookCancel.getContentPane().setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblPatientName.setBounds(43, 54, 113, 16);
		frmRebookCancel.getContentPane().add(lblPatientName);
		
		JLabel lblAppointmentDate = new JLabel("Appointment Date");
		lblAppointmentDate.setFont(new Font("Menlo", Font.PLAIN, 13));
		lblAppointmentDate.setBounds(43, 104, 187, 16);
		frmRebookCancel.getContentPane().add(lblAppointmentDate);
		
		JRadioButton rdbtnRebook = new JRadioButton("Rebooking Required");
		rdbtnRebook.setFont(new Font("Menlo", Font.PLAIN, 13));
		rdbtnRebook.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRebook.setBounds(120, 149, 209, 23);
		rdbtnRebook.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	if(panelRebook.isVisible()) {
		    		panelRebook.setVisible(false);
		    	} else {
		    		panelRebook.setVisible(true);
		    	}
		    }
		});
		frmRebookCancel.getContentPane().add(rdbtnRebook);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(178, 50, 222, 27);
		frmRebookCancel.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox_1.setBounds(178, 100, 222, 27);
		frmRebookCancel.getContentPane().add(comboBox_1);
		
		panelRebook = new JPanel();
		panelRebook.setVisible(false);
		panelRebook.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelRebook.setBackground(SystemColor.window);
		panelRebook.setBounds(6, 184, 438, 121);
		frmRebookCancel.getContentPane().add(panelRebook);
		panelRebook.setLayout(null);
		
		JLabel label = new JLabel("Start Time");
		label.setFont(new Font("Menlo", Font.PLAIN, 13));
		label.setBounds(35, 70, 104, 16);
		panelRebook.add(label);
		
		textField = new JTextField();
		textField.setText("Enter Start Time");
		textField.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(151, 65, 237, 26);
		panelRebook.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("Enter Start Date");
		textField_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(151, 18, 237, 26);
		panelRebook.add(textField_1);
		
		JLabel label_1 = new JLabel("Start Date");
		label_1.setFont(new Font("Menlo", Font.PLAIN, 13));
		label_1.setBounds(35, 23, 104, 16);
		panelRebook.add(label_1);
		
		
		JButton button = new JButton(">");
		button.setBounds(327, 311, 117, 29);
		button.addActionListener(new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		    	frmRebookCancel.dispose();
		    }
		});
		frmRebookCancel.getContentPane().add(button);
		
		JButton btnCancel_1 = new JButton("Cancel");
		btnCancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRebookCancel.dispose();
			}
		});
		btnCancel_1.setBounds(6, 311, 117, 29);
		frmRebookCancel.getContentPane().add(btnCancel_1);
	}
}
