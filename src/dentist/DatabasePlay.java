package dentist;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DatabasePlay {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatabasePlay window = new DatabasePlay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DatabasePlay() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Connection conn = Database.getConnection();
        PreparedStatement stmt = null;
        
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnPush = new JButton("Check if here");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ResultSet res = stmt.executeQuery("SELECT * FROM Patient where forename='James'");
					while (res.next()) {
						String forename = res.getString("forename");
						System.out.println("James is here.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					 Database.closeStatement(conn, stmt);
				}
				
				
				
			}
		});
		frame.getContentPane().add(btnPush, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("Inserst");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String forename1 = "James";
				PreparedStatement stmt2 = null;
				try {
					stmt2 = conn.prepareStatement("INSERT INTO Patient (forename) VALUES ( ?)");
					stmt2.setString(1, forename1);
					stmt2.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					 Database.closeStatement(conn, stmt2);
				}
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.NORTH);
	}

}
