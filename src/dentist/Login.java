package dentist;

import java.awt.*;

import javax.swing.*;

public class Login {

    public static void main(String[] args) {
    	Class.forName("org.gjt.mm.mysql.Driver").newInstance();
    	
    	String DB="jdbc:mysql://stusql.dcs.shef.ac.uk/team022?user=dbuser&password=10060fee";
    	
    	Conn = DriverManager.getConnection(DB);
    	
    }

}
