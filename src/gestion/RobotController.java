package gestion;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import misc.TrayIconDemo;


/**
 * DEFINE
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
	 * @author b.christol
	 */
	public RobotController() {
		
		_robotModel = new RobotModel();
		_robotView = new RobotView(this);
	}


	/**
	 * 
	 * @author b.christol
	 */
   public void start()
    {
	   _robotView.afficher(true);
    }
   

	/**
	 * 
	 * @author b.christol
	 */
	public void boutonValider() throws Exception
	{
		// On récupére les valeurs des champs
		String login = _robotView.getLogin();
		String password = new String(_robotView.getTextFieldPassword().getPassword());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		String currentDate = df.format(calobj.getTime());
		
		// Si les champs login & pass sont remplis
		if((!login.isEmpty())&&(!password.isEmpty())){
			// Si le login est contenu dans la base de donnée User
			if(_robotModel.ifExistInTable("user","login", login)){		
				// Si le login correspond au password
				if(_robotModel.estValide(login,password))
				{
					// On avertit l'utilisateur
					//_robotView.afficherMessage("Connexion","Login Correct !!");
					
					RobotRun.getTi().affInfoNotif("Bienvenue "+login+" ! \r\nDate de la connexion : "+ currentDate);
					
					// On cache le message d'avertissement
					_robotView.getLblWarningAccueil().setVisible(false);
					
					// On ouvre la page bienvenue
					_robotView.getCl_Accueil().show(_robotView.getAccueil(),"welcomePanel" );
					
					// On active les onglets
				    int index = _robotView.getTabbedPane().getTabCount() - 1;
				    System.out.println(index);
				    
				    for(int i=0; i<=index;i++){
					    // Disable the tab
					    _robotView.getTabbedPane().setEnabledAt(i, true);	
				    }
				}
				// Si le login & pass ne correspondent pas, on avertit
				else _robotView.afficherMessage("Connexion","Login incorrect !! c'est pas ton compte");
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
	
	/**
	 * 
	 * @author b.christol
	 */
	public void boutonOubli()
	{
		String login = _robotView.getLogin();
		
		if(!login.isEmpty()){
			if(_robotModel.ifExistInTable("user","login", login)){			
			_robotView.getLblWarningAccueil().setVisible(false);
			System.out.println("oubli");
			_robotView.afficherMessage("Récupération password",_robotModel.oubliMP(login));
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
	
	
	/**
	 * 
	 * @author b.christol
	 */
    public void quitter()
   {
	   _robotModel.fermerConnexion();
		System.exit(1);
   }
   	

	/**
	 * Gere la déconnexion de l'utilisateur
	 * 
	 * @author b.christol
	 * 
	 */
	public void logoutGestion () {
		
		// On desactive les onglets
	    int index = _robotView.getTabbedPane().getTabCount() - 1;
	    System.out.println(index);
	    
	    for(int i=0; i<=index;i++){
		    // Disable the tab
		    _robotView.getTabbedPane().setEnabledAt(i, false);
	    }
		    
		// On ouvre la page login
		get_robotView().getCl_Accueil().show(get_robotView().getAccueil(),"loginPanel" );
		get_robotView().getTextFieldPassword().setText("");
				
	}
	
		
	/**
	 * 
	 * @author b.christol
	 */
	public void quitAllTab() {
		
		get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"ListeRobot" );
		get_robotView().getCl_Configuration().show(get_robotView().getConfiguration(), "listeUser");
		get_robotView().getCl_Planning().show(get_robotView().getPlanning(),"Planning" );
		get_robotView().getCl_Entretien().show(get_robotView().getEntretien(),"Entretien" );
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void addRobot() {
		
		// On ouvre la page detail robot
		get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"DetailRobot" );
		
		// On rafraichie le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
		
		/*ColorPicker picker = new ColorPicker(true,false);
		picker.setRGBControlsVisible(true);
		picker.setHexControlsVisible(true);
		picker.setPreviewSwatchVisible(true);
		//picker.addPropertyChangeListener(ColorPicker.SELECTED_COLOR_PROPERTY, this);*/
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void modRobot() {
			
		// On ouvre la page detail robot
		get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"DetailRobot" );
		
		// On rafraichie le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
		}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void delRobot() {
		
		// On rafraichie le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
	}
	
	/**
	 * 
	 * @author b.christol
	 */
	public void validerRobot() {

		// Initialisé à la date et l'heure courrante. 
		GregorianCalendar calendar = new java.util.GregorianCalendar(); 
		
		java.sql.Date time_use = null;
		
		// Initialisé avec une instance de Date. 
		calendar.setTime(time_use); 
		
		String identifier = _robotView.getTextField_NInterne().getText();
		String brand = _robotView.getComboBox_Marque().getSelectedItem().toString();
		String color = _robotView.getComboBox_Color().getSelectedItem().toString();
		String location = _robotView.getTextField_Emplacement().getText();
		String serial_id = _robotView.getTextField_NSerie().getText();
		Boolean state = _robotView.getChckbxEtat().isSelected(); 
		
		
		_robotModel.insererRobot(identifier, brand, color, location, time_use, serial_id, state);
		
		// On rafraichie le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
	}
	
	
	public void setDefaultValueRobot() {
		
		_robotView.getTextField_NInterne().setText("");
		_robotView.getComboBox_Marque().setSelectedIndex(-1);
		_robotView.getComboBox_Color().setSelectedIndex(-1);
		_robotView.getTextField_Emplacement().setText("");
		_robotView.getTextField_NSerie().setText("");
		_robotView.getChckbxEtat().setSelected(true); 
		
	}
	
	/**
	 * 
	 * @author b.christol
	 */
	public RobotView get_robotView() {
		return _robotView;
	}


	/**
	 * @return the _robotModel
	 */
	public RobotModel get_robotModel() {
		return _robotModel;
	}

}
