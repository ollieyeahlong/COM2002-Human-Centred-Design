package dentist;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.*;

public class Receptionist extends JFrame {

	private Container contentPane;
	
	public static void main(String[] args) {
		
	}
	
	public Receptionist() {
		// centre the frame
		this.setLocationRelativeTo(null);
		initialize();
	}
	
	private void initialize() {
		setTitle("Receptionist");
        setSize(new Dimension(500, 500));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        contentPane = getContentPane();
        
		makeTabs();

		setVisible(true);
	}
	
	private void makeTabs() {
		JTabbedPane tabbedPane = new JTabbedPane();
		
		makeAppointments(tabbedPane);
		makePatients(tabbedPane);
		
		contentPane.add(tabbedPane);
	}
	
	private void makeAppointments(JTabbedPane tabbedPane) {
		JPanel appointmentsTab = new JPanel(new BorderLayout());
		
		GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		Date now = new Date();
		Date today = calendar.getTime();
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String fullDate = format.format(calendar.getTime());
        calendar.setTime(now);        
		
		tabbedPane.addTab("Appointments", appointmentsTab);
	}
	
	private void makePatients(JTabbedPane tabbedPane) {
		JPanel patientsTab = new JPanel(new BorderLayout());
		
		tabbedPane.addTab("Patients", patientsTab);
	}
}
