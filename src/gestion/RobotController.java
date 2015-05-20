package gestion;

import java.awt.Color;

import javax.swing.JOptionPane;
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
		String password = _robotView.getTextFieldPassword().getText();
		
		// Si les champs login & pass sont remplis
		if((!login.isEmpty())&&(!password.isEmpty())){
			// Si le login est contenu dans la base de donnée User
			if(_robotModel.ifExistInTable("user","login", login)){		
				// Si le login correspond au password
				if(_robotModel.estValide(login,password))
				{
					// On avertit l'utilisateur
					_robotView.afficherMessage("Connexion","Login Correct !!");
					// On cache le message d'avertissement
					_robotView.getLblWarningAccueil().setVisible(false);
					
					// On ouvre la page bienvenue
					_robotView.getCl_Accueil().show(_robotView.getAccueil(),"welcomePanel" );
					
					// On active les onglets
				    int index = _robotView.getTabbedPane().getTabCount() - 1;
				    System.out.println(index);
				    
				    for(int i=0; i<=index;i++){
					    // Determine whether the tab is enabled
					    boolean enabled = _robotView.getTabbedPane().isEnabledAt(i);

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
		    // Determine whether the tab is enabled
		    boolean enabled = _robotView.getTabbedPane().isEnabledAt(i);

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
	 * @author p.fauny
	 */
	public void setDefaultValueUser() {
		
		_robotView.getTextField_Name().setText("");
		_robotView.getTextField_Login().setText("");
		_robotView.getTextField_PwUser().setText("");
		_robotView.getTextField_Email().setText("");
		_robotView.getComboBox_Right().setSelectedIndex(-1);
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void addRobot() {
		
		// On ouvre la page detail robot
		get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"DetailRobot" );
		
		// On rafraichit le tableau des robots
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
		
		// On rafraichit le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void delRobot() {
		
		// On rafraichit le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void validerRobot() {
		
		//_robotModel.insererRobot(_robotView.getTextField_NInterne(), _robo, _robotView.getComboBox_Marque(), location, time_use, state);
		
		// On rafraichit le tableau des robots
		get_robotModel().remplirTable(get_robotView().getTableRobots(), "SELECT * FROM robot;");
	}
	
	
	/**
	 * @author p.fauny
	 */
	public void addUser() {
		
		// On ouvre la page detail de l'utilisateur
		_robotView.getCl_Configuration().show(get_robotView().getConfiguration(),"modifyUser" );
	}
	
	
	/**
	 * @author p.fauny
	 */
	public void modUser() {
		
		if(_robotView.getTableUsers().getSelectedRow() != -1)
		{
			// On récupère les valeurs de la ligne du tableau selectionnee
			int ligne = _robotView.getTableUsers().getSelectedRow();
			
			String nom = _robotView.getTableUsers().getValueAt(ligne,0).toString();
			String login = _robotView.getTableUsers().getValueAt(ligne,1).toString();
			String password = _robotView.getTableUsers().getValueAt(ligne,2).toString();
			String email = _robotView.getTableUsers().getValueAt(ligne,3).toString();
			String droit = _robotView.getTableUsers().getValueAt(ligne,4).toString();
			
			// On remplis les champs avec l'utilisateur selectionne
			_robotView.getTextField_Name().setText(nom);
			_robotView.getTextField_Login().setText(login);
			_robotView.getTextField_PwUser().setText(password);
			_robotView.getTextField_Email().setText(email);
			_robotView.getComboBox_Right().setSelectedItem(droit);
			
			// On ouvre la page detail de l'utilisateur
			_robotView.getCl_Configuration().show(_robotView.getConfiguration(),"modifyUser" );
		}else{
			System.out.println("Veuillez selectionner une ligne");
		}
	}
	
	
	/**
	 * @author p.fauny
	 */
	public void delUser() {
		
		if(_robotView.getTableUsers().getSelectedRow() != -1)
		{
			int n = JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir supprimer – " + _robotView.getTableUsers().getValueAt(_robotView.getTableUsers().getSelectedRow(), 0) + "?","",JOptionPane.YES_NO_CANCEL_OPTION);          
	           
			//the user has clicked the cross
			if(n == -1) return;
			
			//the user has clicked cancel
			if(n == 2) return;
			
			//no
			if(n == 1) return;
			
			//yes
			if(n == 0)
			{
				// Recuperation de la case selectionnee
				int ligne = _robotView.getTableUsers().getSelectedRow();
				//int colonne = get_robotView().getTableUsers().getSelectedColumn();
	
				Object cellule = _robotView.getTableUsers().getValueAt(ligne,0);
				_robotModel.deleteUser(cellule.toString());
				System.out.println(cellule.toString());
				
				// On rafraichit le tableau des robots
				String query = "SELECT name, login, password, email, priv FROM user;";
				_robotModel.remplirTable(get_robotView().getTableUsers(), query);
			}
		}else{
			System.out.println("Veuillez selectionner une ligne");
		}
	}
	
	
	/**
	 * @author p.fauny
	 */
	public void validerUser() {
		
		// On insert les donnees saisies dans la BDD
		_robotModel.insererUser(_robotView.getTextField_Name().getText(), _robotView.getTextField_Login().getText(), _robotView.getTextField_PwUser().getText(), _robotView.getTextField_Email().getText(), _robotView.getComboBox_Right().getSelectedItem().toString());
		
		// On rafraichit le tableau des robots
		String query = "SELECT name, login, password, email, priv FROM user;";
		_robotModel.remplirTable(_robotView.getTableUsers(), query);
		
		// On revient à l'interface de recap user
		quitAllTab();
		setDefaultValueUser();
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
