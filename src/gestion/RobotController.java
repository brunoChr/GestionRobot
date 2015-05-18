package gestion;

import java.awt.Color;

/**
 * 
 */


/**
 * @author b.christol
 *
 */
public class RobotController {

	private RobotView _robotView;
	private RobotModel _robotModel;


	/**
	 * 
	 */
	public RobotController() {
		
		_robotModel = new RobotModel();
		_robotView = new RobotView(this);
	}

	
   public void start()
    {
	   _robotView.afficher(true);
    }
   

	/**
	 * 
	 * @throws Exception
	 */
	public void boutonValider() throws Exception
	{
		// On récupére les valeurs des champs
		String login = _robotView.getLogin();
		String password = _robotView.getTextFieldPassword().getText();
		
		// Si les champs login & pass sont remplis
		if((!login.isEmpty())&&(!password.isEmpty())){
			// Si le login est contenu dans la base de donnée User
			if(_robotModel.ifExistInTable("user","login", login)){		
				// Si le login correspond au password
				if(_robotModel.estValide(login,password))
				{
					// On avertit l'utilisateur
					_robotView.afficherMessage("Login Correct !!");
					// On cache le message d'avertissement
					_robotView.getLblWarningAccueil().setVisible(false);
					
					// On ouvre la page bienvenue
					_robotView.getCl_Accueil().show(_robotView.getAccueil(),"welcomePanel" );
				}
				// Si le login & pass ne correspondent pas, on avertit
				else _robotView.afficherMessage("Login incorrect !! c'est pas ton compte");
			}
			// Si le login n'existe pas dans la table
			else {
				_robotView.getLblWarningAccueil().setVisible(true);
				_robotView.getLblWarningAccueil().setForeground(Color.red);
				_robotView.getLblWarningAccueil().setText("Compte introuvable");
			}
		}
		// Si les champs sont vides
		else {
			_robotView.getLblWarningAccueil().setVisible(true);
			_robotView.getLblWarningAccueil().setForeground(Color.red);
			_robotView.getLblWarningAccueil().setText("Tout les champs doivent être remplis");
		}
	}
	
	public void boutonOubli()
	{
		String login = _robotView.getLogin();
		
		if(!login.isEmpty()){
			if(_robotModel.ifExistInTable("user","login", login)){			
			_robotView.getLblWarningAccueil().setVisible(false);
			System.out.println("oubli");
			_robotView.afficherMessage(_robotModel.oubliMP(login));
			}
			else {
				_robotView.getLblWarningAccueil().setVisible(true);
				_robotView.getLblWarningAccueil().setForeground(Color.red);
				_robotView.getLblWarningAccueil().setText("Compte introuvable");
			}
		}
		else {
			_robotView.getLblWarningAccueil().setVisible(true);
			_robotView.getLblWarningAccueil().setForeground(Color.red);
			_robotView.getLblWarningAccueil().setText("Le champs login doit être rempli");
		}
	}
	
    public void quitter()
   {
	   _robotModel.fermerConnexion();
		System.exit(1);
   }
   	
	public RobotView get_robotView() {
		return _robotView;
	}

	public void logoutGestion () {
		// On ouvre la page login
		get_robotView().getCl_Accueil().show(get_robotView().getAccueil(),"loginPanel" );
		get_robotView().getTextFieldPassword().setText("");
	}
	
	public void addRobot() {
		
		// On ouvre la page detail robot
		get_robotView().getCl_Accueil().show(get_robotView().getAccueil(),"loginPanel" );
	}
	
	public void modRobot() {
			
		// On ouvre la page detail robot
		get_robotView().getCl_Accueil().show(get_robotView().getAccueil(),"loginPanel" );
		}
	
	public void delRobot() {
		
	}
}
