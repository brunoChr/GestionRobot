package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 
 */

import javax.swing.JButton;



/**
 * @author b.christol
 *
 */
public class RobotEvent implements ActionListener, WindowListener {

	RobotController _robotController;

	/**
    *
    * Event constructor
    *
    * This methode create a instance of RobotController
    *
    * @param rc RobotController parameter
    * @since version 1.00
    * 
    */
	public RobotEvent(RobotController rc) {
		// TODO Auto-generated constructor stub
		this._robotController = rc;
	}
	public void actionPerformed(ActionEvent e) {
		
		JButton bouton = (JButton)e.getSource();
			
		   String command = ((JButton) e.getSource()).getName();
		   //System.out.println(command);
		   
		   if(bouton==_robotController.get_robotView().getBtnValider()) System.out.println("Bouton validé !!");
		   //if(command.equals("btnMotDePasse")) System.out.println("Bouton mdp oublié !!");
		   //else if (command.equals("btnValider")) System.out.println("Bouton validé !!");
			   
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("Quit the programm");
		_robotController.quitter();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
