package dentist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// some stupid warning kept coming up. so its been stopped
@SuppressWarnings("unchecked")

public class Login extends JFrame implements ActionListener {

    JLabel hint;

    // make the user interface
    public Login() {
        initUI();
    }

    // action detection for when the dropdown(combobox) is interacted with
    // this code should be moved next to the combo
    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource(); // fetch the combobox
        String userName = (String)cb.getSelectedItem(); // get the currently selected string 
        updateLabel(userName);
    }

    // set the large label at top to the string in dropdown box
    protected void updateLabel(String name) {
        hint.setText(name);
    }
    
    // making the ui
    private void initUI() {
        // panel that contains the user name at the top
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setMaximumSize(new Dimension(400, 0));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 0, 0));
        // labelPanel.add(userLabel, BorderLayout.NORTH);


        
        String[] users = { "Reception", "Other guys"}; // options in dropdown
        JPanel comboPanel = new JPanel(new BorderLayout()); // panel for the dropdown
        comboPanel.setMaximumSize(new Dimension(400, 0));
        comboPanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 15, 25)); // border around the panel
        // make a combobox
        JComboBox userList = new JComboBox(users);
        userList.setSelectedIndex(0); // set default selection to Reception
        userList.addActionListener(this);
        comboPanel.add(userList); // add to the comboPanel


        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);

        JPanel topPanel = new JPanel(new BorderLayout(0, 0));
        topPanel.setMaximumSize(new Dimension(750, 0));
        hint = new JLabel();
        updateLabel(users[userList.getSelectedIndex()]);
        hint.setFont (hint.getFont ().deriveFont (50.0f));
        hint.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
        topPanel.add(hint);

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
        JButton b1 = new JButton("Go");
        // when the go button is selected frame is closed
        // when there are more windows it will go to the relevant one
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        passwordPanel.add(b1, BorderLayout.EAST);

        



        JSeparator separator = new JSeparator();
        separator.setForeground(Color.gray);

        topPanel.add(separator, BorderLayout.SOUTH);
        
        basic.add(topPanel);
        basic.add(labelPanel);
        basic.add(comboPanel);
        basic.add(passwordPanel);
        // basic.add(submitButton);
        

        JPanel boxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        
        basic.add(boxPanel);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        // Quit button
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        bottom.add(quitButton);
        basic.add(bottom);

        bottom.setMaximumSize(new Dimension(750, 0));
        // details for the frame
        setTitle("Welcome");
        setSize(new Dimension(750, 500));
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    

    public static void main(String[] args) {
        // Database stuff that I was getting errors from.
        // Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    	
    	// String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team022?user=dbuser&password=10060fee";
    	
        // Conn = DriverManager.getConnection(DB);

        // apparently its better to run this way?
                SwingUtilities.invokeLater(new Runnable() {
                    
                    public void run() {
                        Login go = new Login();
                        go.setVisible(true);
                        
                    }
                });
            }
}
