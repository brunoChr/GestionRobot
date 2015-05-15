/**
 * 
 */


import java.awt.EventQueue;

import javax.swing.UIManager;

/**
 * @author b.christol
 *
 */
public class RobotRun {

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					RobotController rC = new RobotController();
					rC.start();
					
					//RobotView frame = new RobotView();
					//frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
