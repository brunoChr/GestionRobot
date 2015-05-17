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
   
	public void boutonValider() throws Exception
	{
		String login = _robotView.getLogin();
		String password = _robotView.getPassword();
		
		if((!login.isEmpty())&&(!password.isEmpty())){
			if(_robotModel.ifExistInTable("user","login", login)){			
				if(_robotModel.estValide(login,password))
				{
					_robotView.afficherMessage("Login Correct !!");
					_robotView.getLblWarningAccueil().setVisible(false);
				}
				else _robotView.afficherMessage("Login incorrect !! c'est pas ton compte");
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


}
