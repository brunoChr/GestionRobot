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
	private int TabCpt = 0;
	
	public static final int ONGLET_Accueil = 0;
	public static final int ONGLET_Robot = 1;
	public static final int ONGLET_Planning = 2;
	public static final int ONGLET_Entretien = 3;
	public static final int ONGLET_Configuration = 4;
	public static final int ONGLET_Historique = 5;

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
	
	/**
	 * 
	 * @author b.christol
	 * @author p.fauny
	 */
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
		
		else if (bouton==_robotController.get_robotView().getBtnValiderRobot()) {
					
					System.out.println("Bouton valider robot !!");
		
					_robotController.delRobot();
				}
				
		else if (bouton==_robotController.get_robotView().getBtnDeleteRobot()) {
			
			System.out.println("Bouton delete robot !!");
		
			_robotController.delRobot();
		}
		
		
		
		else if (bouton== _robotController.get_robotView().getBtnAddUser()) {
			
			System.out.println("Bouton add user !!");
			
			_robotController.addUser();
		}
		
		else if (bouton== _robotController.get_robotView().getBtnModifyUser()) {
			
			System.out.println("Bouton modify user !!");
			
			_robotController.modUser();
		}
		
		else if (bouton== _robotController.get_robotView().getBtnDeleteUser()) {
			
			System.out.println("Bouton supprimer user !!");
			
			_robotController.delUser();
		}
		
		else if (bouton== _robotController.get_robotView().getBtnValiderUser()) {
			
			System.out.println("Bouton valider user !!");
			
			_robotController.validerUser();
		}
		
		else if (bouton== _robotController.get_robotView().getBtnAnnulerUser()) {
			
			System.out.println("Bouton annuler user !!");
			
			_robotController.quitAllTab();
		}
	}
	
	/**
	 * 
	 * @author b.christol
	 * @author p.fauny
	 */
	public void stateChanged(ChangeEvent e) {

		System.out.println(TabCpt);
			
		// On ne compte pas le premier changement d'onglet qui s'effectue au démarrage
		if(TabCpt++ > 0){
			
			// On récupére l'index de l'onglet sélectionné
			int TabIndex = _robotController.get_robotView().getTabbedPane().getSelectedIndex();
			
			// On restaure la premiére page de tous les onglets
			_robotController.quitAllTab();
			
			// Détermine quel onglet est sélectionné
			switch (TabIndex) {
			case ONGLET_Accueil:
				break;
			
			case ONGLET_Robot:
				
				// On rafraichie le tableau des robots
				_robotController.get_robotModel().remplirTable(_robotController.get_robotView().getTableRobots(), "SELECT * FROM robot;");
				break;

			case ONGLET_Planning:				
				break;
				
			case ONGLET_Entretien:				
				break;
				
			case ONGLET_Configuration:
				_robotController.get_robotModel().recapUsers(_robotController.get_robotView().getTableUsers());
				break;
				
			case ONGLET_Historique:
				_robotController.get_robotModel().recapHistorique(_robotController.get_robotView().getTableAction());
				break;
				
			default:
				break;
			}
			
			System.out.println("Tab index : " + TabIndex);
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
