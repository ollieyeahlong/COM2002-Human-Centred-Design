package dentist;

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

public class LoginRevised extends JFrame {

	private JFrame fSystemLoginRevised;
	private static JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnQuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginRevised window = new LoginRevised();
					window.fSystemLoginRevised.setVisible(true);
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
	public LoginRevised() {
		this.setLocationRelativeTo(null);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
            	btnNewButton.requestFocus();
            }
        }); 
		
		
		fSystemLoginRevised = new JFrame();
		fSystemLoginRevised.setForeground(Color.YELLOW);
		fSystemLoginRevised.getContentPane().setForeground(Color.YELLOW);
		fSystemLoginRevised.setTitle("System LoginRevised");
		fSystemLoginRevised.setBounds(100, 100, 652, 593);
		fSystemLoginRevised.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fSystemLoginRevised.getContentPane().setLayout(null);
		fSystemLoginRevised.setLocationRelativeTo(null);
		
		// setup currently selected user
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setText("Reception");  
		lblNewLabel.setFont(new Font("Menlo", Font.BOLD, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 6, 337, 130);
		fSystemLoginRevised.getContentPane().add(lblNewLabel);

		       
		// setup the combo box
		String[] users = {"Reception", "Dentist", "Hygienist"}; // options in dropdown
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
        
        
		
		
		
        passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setToolTipText("Enter Password");
		passwordField.setText("Enter Password");
		passwordField.setBounds(167, 189, 264, 26);
		
		fSystemLoginRevised.getContentPane().add(passwordField);
		
		
		btnNewButton = new JButton(">");
		btnNewButton.setFont(new Font("Menlo", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fSystemLoginRevised.dispose();
            }
        });
		
		
		
		btnNewButton.setBounds(432, 189, 52, 29);
		fSystemLoginRevised.getContentPane().add(btnNewButton);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(6, 536, 75, 29);
		btnQuit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fSystemLoginRevised.dispose();
            }
        });
		
		
		
		fSystemLoginRevised.getContentPane().add(btnQuit);
	}
}
