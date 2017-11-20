package dentist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame {

	private Container contentPane;
    private JLabel userLabel;

    // make the user interface
    public Login() {
        initUI();
    }
    
    // making the ui
    private void initUI() {
    	
    	setTitle("Login");
        setSize(new Dimension(500, 500));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
    	
		makeHeader();
		makeCentre();
		makeFooter();

		setVisible(true);
        
        /*
        // password enter
        // there is more stuff here potentially
        // but not much point
        JPanel passwordPanel = new JPanel(new BorderLayout(0,0));
        passwordPanel.setMaximumSize(new Dimension(350, 0));
        JPasswordField passwordField = new JPasswordField(20);

        // whenever the window is opened, it automatically puts the curser in the password field
        // so you can type straight away
        addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                passwordField.requestFocus();
            }
        }); 
        passwordPanel.add(passwordField, BorderLayout.WEST);
        
        passwordPanel.add(b1, BorderLayout.EAST);
        */        
    }
    
    private void makeHeader() {
    	// panel that contains the user name at the top
    	JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	topPanel.setMaximumSize(new Dimension(750, 0));
    	
    	userLabel = new JLabel();
        userLabel.setText("Reception");         
        userLabel.setFont (userLabel.getFont ().deriveFont (50.0f));
        userLabel.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        topPanel.add(userLabel);
        
        contentPane.add(topPanel, BorderLayout.NORTH);
    }
    
    private void makeCentre() {
    	JPanel centrePanel = new JPanel(new BorderLayout()); // panel for the dropdown
        //centrePanel.setMaximumSize(new Dimension(400, 0));
        centrePanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 15, 25)); // border around the panel
        
        String[] users = {"Reception", "Dentist", "Hygienist"}; // options in dropdown
        JComboBox userList = new JComboBox(users);
        userList.setBorder(BorderFactory.createEmptyBorder(125, 0, 125, 0));
        userList.setSelectedIndex(0); // set default selection to Reception
        userList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		userLabel.setText((String)userList.getSelectedItem());
        	}
        });
        centrePanel.add(userList, BorderLayout.CENTER); // add to the centrePanel
        
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        centrePanel.add(login, BorderLayout.SOUTH);
        
        contentPane.add(centrePanel, BorderLayout.CENTER);
    }
    
    private void makeFooter() {
    	JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	bottomPanel.setMaximumSize(new Dimension(750, 0));
        
        // Quit button
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}            
        });
        
        bottomPanel.add(quitButton);
        
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
    	Login login = new Login();
    }
    
}
