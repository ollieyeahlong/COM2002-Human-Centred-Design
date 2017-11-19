package dentist;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@SuppressWarnings("unchecked")

public class Login extends JFrame implements ActionListener {

    JLabel hint;

    public Login() {
        initUI();
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox cb = (JComboBox)e.getSource();
        String userName = (String)cb.getSelectedItem();
        updateLabel(userName);
    }

    protected void updateLabel(String name) {
        hint.setText(name);
    }


    //Make textField get the focus whenever frame is activated.
    
    private void initUI() {

        JFrame f = new JFrame("Welcome");

        //JLabel userLabel = new JLabel("Select user");

        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.setMaximumSize(new Dimension(400, 0));
        labelPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 0, 0));
        // labelPanel.add(userLabel, BorderLayout.NORTH);



        String[] users = { "Reception", "Other guys"};
        // -- main show start
        // make a panel
        JPanel comboPanel = new JPanel(new BorderLayout());
        comboPanel.setMaximumSize(new Dimension(400, 0));
        comboPanel.setBorder(BorderFactory.createEmptyBorder(5, 25, 15, 25));
        // make a combobox
        JComboBox userList = new JComboBox(users);
        userList.setSelectedIndex(0);
        userList.addActionListener(this);
        comboPanel.add(userList);
        
        // -- main show end

        

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
        JPanel passwordPanel = new JPanel(new BorderLayout(0,0));
        passwordPanel.setMaximumSize(new Dimension(350, 0));
        JPasswordField passwordField = new JPasswordField(20);


        addWindowListener( new WindowAdapter() {
            public void windowOpened( WindowEvent e ){
                passwordField.requestFocus();
            }
        }); 
        passwordPanel.add(passwordField, BorderLayout.WEST);
        JButton b1 = new JButton("Go");
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        passwordPanel.add(b1, BorderLayout.EAST);
        // b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales

        



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
        
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });

        bottom.add(quitButton);
        basic.add(bottom);

        bottom.setMaximumSize(new Dimension(750, 0));

        setTitle("Welcome");
        setSize(new Dimension(750, 500));
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    

    public static void main(String[] args) {

        // Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    	
    	// String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team022?user=dbuser&password=10060fee";
    	
        // Conn = DriverManager.getConnection(DB);
        
                SwingUtilities.invokeLater(new Runnable() {
        
                    public void run() {
                        Login go = new Login();
                        go.setVisible(true);
                        
                    }
                });
            }
}
