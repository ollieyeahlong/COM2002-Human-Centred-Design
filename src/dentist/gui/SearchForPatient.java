package dentist.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SearchForPatient {

	private JFrame frmResults;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchForPatient window = new SearchForPatient();
					window.frmResults.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SearchForPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmResults = new JFrame();
		frmResults.setResizable(false);
		frmResults.setTitle("Results");
		frmResults.setBounds(100, 100, 450, 300);
		frmResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmResults.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		frmResults.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNumberOfResults = new JLabel("There Are");
		panel_1.add(lblNumberOfResults);
		
		JLabel lblX = new JLabel("X");
		panel_1.add(lblX);
		
		JLabel lblResults = new JLabel("Results");
		panel_1.add(lblResults);
		
		JPanel panel = new JPanel();
		frmResults.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPatient = new JButton("Patient 1");
		panel.add(btnPatient);
	}

}
