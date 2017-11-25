package dentist.gui;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

public class CalPractice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalPractice window = new CalPractice();
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
	public CalPractice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
		GregorianCalendar calendar = new GregorianCalendar(2013,1,28,13,24,56);

		int year       = calendar.get(calendar.YEAR);
		int month      = calendar.get(calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);
		int dayOfWeek  = calendar.get(calendar.DAY_OF_WEEK);
		int weekOfYear = calendar.get(calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar.get(calendar.WEEK_OF_MONTH);

		int hour       = calendar.get(calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar.get(calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar.get(calendar.MINUTE);
		int second     = calendar.get(calendar.SECOND);
		int millisecond= calendar.get(calendar.MILLISECOND);

		System.out.println(sdf.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);
	}

}
