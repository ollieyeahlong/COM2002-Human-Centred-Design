package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.UIManager;

public class Calendar {

	private JFrame frmCalendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar window = new Calendar();
					window.frmCalendar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalendar = new JFrame();
		frmCalendar.setResizable(false);
		frmCalendar.setTitle("Live Calendar Apoint");
		frmCalendar.setBounds(100, 100, 450, 300);
		frmCalendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalendar.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel navigationP = new JPanel();
		navigationP.setBackground(UIManager.getColor("Button.select"));
		frmCalendar.getContentPane().add(navigationP, BorderLayout.NORTH);
		navigationP.setLayout(new BorderLayout(0, 0));
		
		JButton button_1 = new JButton("<-");
		navigationP.add(button_1, BorderLayout.WEST);
		
		JLabel lblWeekNumber = new JLabel("1st Mon Dec 17");
		lblWeekNumber.setBackground(UIManager.getColor("Button.select"));
		lblWeekNumber.setFont(new Font("Lucida Grande", Font.ITALIC, 13));
		lblWeekNumber.setHorizontalAlignment(SwingConstants.CENTER);
		navigationP.add(lblWeekNumber, BorderLayout.CENTER);
		
		JButton button = new JButton("->");
		navigationP.add(button, BorderLayout.EAST);
		
		JPanel contentP = new JPanel();
		frmCalendar.getContentPane().add(contentP, BorderLayout.CENTER);
		contentP.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentP.add(panel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("New label New label aaa");
		lblNewLabel_1.setForeground(UIManager.getColor("Button.background"));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentP.add(panel_2, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("9:30");
		panel_2.add(btnNewButton);
		
		JButton button_2 = new JButton("12:20");
		panel_2.add(button_2);
		
		JButton button_3 = new JButton("15:00");
		panel_2.add(button_3);
		
		JPanel panel = new JPanel();
		contentP.add(panel, BorderLayout.EAST);
		
		JLabel lblNewLabel = new JLabel("New label New label aaa");
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		panel.add(lblNewLabel);
	}

}
