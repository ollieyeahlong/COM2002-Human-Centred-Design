package dentist;

import java.awt.*;

import javax.swing.*;

public class Login {

    public static void main(String[] args) {
    	// Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    	
    	// String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team022?user=dbuser&password=10060fee";
    	
        // Conn = DriverManager.getConnection(DB);
        new Login();  

    }
    Login(){  
        /* JFrame is a top level container (window)
         * where we would be adding our button
         */
        JFrame frame=new JFrame();  
        
        
                          
        // Creating Button          
        JButton b=new JButton("Reception");
        b.setBackground(Color.RED);
        b.setOpaque(true);
        JButton b2=new JButton("Other");
        b2.setBackground(Color.BLUE);
        b2.setOpaque(true);
        /* This method specifies the location and size
         * of button. In method setBounds(x, y, width, height)
         * x,y) are cordinates from the top left 
         * corner and remaining two arguments are the width
         * and height of the button.
         */

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2); 
        b.setBounds(50,50,90, 50);  
        b2.setBounds(150, 50, 90, 50); 
             
        //Adding button onto the frame
        frame.add(b);  
        frame.add(b2);
                  
        // Setting Frame size. This is the window size
        frame.setSize(300,200);  
        
        frame.setLayout(null);  
        frame.setVisible(true);  
                  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

        
                  
    }  
}
