package gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
/**
 * 
 */





import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



/**
 * @author b.christol
 *
 */
public class RobotEvent implements ActionListener, WindowListener, ChangeListener {

	RobotController _robotController;
	private int TabIndex = 0;
	
	/**
    *
    * Event constructor
    *
    * This methode create a instance of RobotController
    *
    * @param rc RobotController parameter
    * @since version 1.00
    * 
    * 
    */
	public RobotEvent(RobotController rc) {
		// TODO Auto-generated constructor stub
		this._robotController = rc;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton bouton = (JButton)e.getSource();
		
		if(bouton==_robotController.get_robotView().getBtnValider()){
			
			System.out.println("Bouton validé !!");
			try {
				_robotController.boutonValider();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(bouton==_robotController.get_robotView().getBtnMotDePasse()){
			
			System.out.println("Bouton mdp !!");
			_robotController.boutonOubli();
		}
		else if (bouton==_robotController.get_robotView().getBtnDeconnecter()) {
			
			System.out.println("Bouton Deconnecter !!");
			
			_robotController.logoutGestion();
		}
		
		else if (bouton==_robotController.get_robotView().getBtnAddRobot()) {
			
			System.out.println("Bouton add robot !!");

			// On ouvre la page login
			_robotController.addRobot();

		}
		else if (bouton==_robotController.get_robotView().getBtnModifyRobot()) {
			
			System.out.println("Bouton modify robot !!");

			// On ouvre la page login
			_robotController.modRobot();
		}
		else if (bouton==_robotController.get_robotView().getBtnDeleteRobot()) {
			
			System.out.println("Bouton delete robot !!");

			_robotController.delRobot();
		}
	}
	
	public void stateChanged(ChangeEvent e) {

		System.out.println(TabIndex);

		if(TabIndex++ > 0){	
			_robotController.quitAllTab();
		}
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
