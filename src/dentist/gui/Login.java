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

public class Login extends JFrame {

	private JFrame fSystemLoginRevised;
	private static JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnQuit;
	private JLabel lblNewLabel = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Login window = new Login();
				try {	
					window.fSystemLoginRevised.setVisible(true);
					// when the frame loads, set focus to the password field
					window.fSystemLoginRevised.addWindowListener( new WindowAdapter() {
			            public void windowOpened( WindowEvent e ){
			            	passwordField.requestFocus();
			            }
			        }); 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		// centre the frame
		setLocationRelativeTo(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupMainFrame();
		setupLargeCurrentlySelectedUser();
		setupComboBox();
		setupSubmitButton();
		setupPasswordField();
		setupQuitButton();
	}
	
	private void setupMainFrame() {
		// Username title
		fSystemLoginRevised = new JFrame();
		fSystemLoginRevised.setTitle("System Login");
		fSystemLoginRevised.setBounds(100, 100, 652, 593);
		fSystemLoginRevised.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fSystemLoginRevised.getContentPane().setLayout(null);
		fSystemLoginRevised.setLocationRelativeTo(null);
		fSystemLoginRevised.setVisible(true);
	}
	
	private void setupLargeCurrentlySelectedUser() {
		// setup currently selected user
		lblNewLabel.setText("Receptionist");  
		lblNewLabel.setFont(new Font("Menlo", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(118, 6, 415, 130);
		fSystemLoginRevised.getContentPane().add(lblNewLabel);
	}
	
	private void setupComboBox() {
		// setup the combo box
		String[] users = {"Receptionist", "Dentist", "Hygienist"}; // options in dropdown
		JComboBox comboBox = new JComboBox(users);
		comboBox.setFont(new Font("Menlo", Font.PLAIN, 13));
		comboBox.setBounds(167, 145, 317, 26);
		fSystemLoginRevised.getContentPane().add(comboBox);
		comboBox.setSelectedIndex(0); // set default selection to Reception
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setText((String)comboBox.getSelectedItem());
			}
		});
	}
	
	private void setupSubmitButton() {
		// setup the submit password button
		btnNewButton = new JButton(">");
		btnNewButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton.setBounds(432, 189, 52, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lblNewLabel.getText().equals("Receptionist")) {
					Receptionist receptionist = new Receptionist();
				}
				else if (lblNewLabel.getText().equals("Dentist")) {
					Dentist dentist = new Dentist();
				}
				else if (lblNewLabel.getText().equals("Hygienist")) {
					Hygienist hygienist = new Hygienist();
				}
				
				fSystemLoginRevised.dispose();
			}
		});            
		fSystemLoginRevised.getContentPane().add(btnNewButton);
	}
	
	private void setupQuitButton() {
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(6, 510, 75, 29);
		btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fSystemLoginRevised.dispose();
            }
        });
		fSystemLoginRevised.getContentPane().add(btnQuit);
	}
	
	private void setupPasswordField() {
		// setup the password field
        passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setToolTipText("Enter Password");
		passwordField.setBounds(167, 189, 264, 26);
		
		fSystemLoginRevised.getContentPane().add(passwordField);
	}
}