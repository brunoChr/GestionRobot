package gestion;
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
		if(_robotModel.estValide(_robotView.getLogin(),_robotView.getPassword()))
		{
			_robotView.afficherMessage("Login Correct !!");
			
			//_applicontroller = new AppliController();
			
			//this.stop();
			
			/*if ( Desktop.isDesktopSupported() ) {
				// On récupère l'instance du desktop :
				Desktop desktop = Desktop.getDesktop();
			 
				// On vérifie que la fonction browse est bien supportée :
				if (desktop.isSupported(Desktop.Action.BROWSE)) {
					// Et on lance l'application associé au protocole :
					desktop.browse(new URI("https://smsapi.free-mobile.fr/sendmsg?user=10517589&pass=F79pUES5PIZu7g&msg=Conneectéé%20...%20"));
				}
			}*/
		}
		else _robotView.afficherMessage("Login incorrect !! c'est pas ton compte");
	}
	
	public void boutonOubli()
	{
		System.out.println("oubli");
		_robotView.afficherMessage(_robotModel.oubliMP(_robotView.getLogin()));
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
