package dentist.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import dentist.entities.Patient;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class SearchResults {

	private JFrame frmSearchResults;
	private JLabel searchQ;
	private JLabel numResults;
	private JButton patient;
	private JPanel panel_1;
	private JButton btnName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the application.
	 * @param results 
	 * @param searchTerm 
	 * @wbp.parser.entryPoint
	 */
	public SearchResults(ArrayList<String> results, String searchTerm, Integer count) {
		initialize();
		frmSearchResults.setVisible(true);
		frmSearchResults.setLocationRelativeTo(null);
		searchQ.setText(""+ searchTerm +"");
		numResults.setText(""+ count +"");
		ArrayList<String> list2 = (results);
		  
		String [] resultsListArray = list2.toArray(new String[list2.size()]);
		
		List<JButton> buttonList = new ArrayList<JButton>();
		for(int i = 0; i < list2.size(); i++) {
		    JButton button = new JButton();
		    String valueOfName = resultsListArray[i].toString();
	    	String patientNumber = valueOfName.substring(valueOfName.length() - 1);
		    String buttonText = Patient.fetchForename(patientNumber) + " " + resultsListArray[i];
		    button.setText(buttonText);
		    buttonList.add(button);
		    button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Record pR = new Record(patientNumber);
					System.out.println("Open file for pn: " + patientNumber);
				}
			});
		    panel_1.add(button);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSearchResults = new JFrame();
		frmSearchResults.setTitle("Search Results");
		frmSearchResults.setBounds(100, 100, 450, 300);
		frmSearchResults.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmSearchResults.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel searchResultsL = new JLabel("There are");
		searchResultsL.setFont(new Font("Menlo", Font.PLAIN, 13));
		panel.add(searchResultsL);
		
		numResults = new JLabel("000");
		numResults.setFont(new Font("Menlo", Font.PLAIN, 13));
		panel.add(numResults);
		
		JLabel searchResultsL2 = new JLabel("result(s) for");
		searchResultsL2.setFont(new Font("Menlo", Font.PLAIN, 13));
		panel.add(searchResultsL2);
		
		searchQ = new JLabel();
		searchQ.setFont(new Font("Menlo", Font.PLAIN, 13));
		panel.add(searchQ);
		
		panel_1 = new JPanel();
		

		
		
		
		
		frmSearchResults.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		
		
		
	}
	
	

}
