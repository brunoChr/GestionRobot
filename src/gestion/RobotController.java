package gestion;

import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import misc.TrayIconDemo;


/**
 * @author b.christol
 *
 */
public class RobotController {

	private RobotView _robotView;
	private RobotModel _robotModel;
	private Boolean FlagRobot;
	private Boolean FlagTask;
	private String connectedUser;	// Pour savoir quelle user est connecté

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
	public void boutonValiderLogin() throws Exception
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
					
					connectedUser = login;
					
					RobotRun.getTi().affInfoNotif("Bienvenue "+connectedUser+" ! \r\nDate de la connexion : "+ currentDate);
					
					// On cache le message d'avertissement
					_robotView.getLblWarningAccueil().setVisible(false);
					
					// On ouvre la page bienvenue
					_robotView.getCl_Accueil().show(_robotView.getAccueil(),"welcomePanel" );
					
					// On active les onglets
				    int index = _robotView.getTabbedPane().getTabCount() - 1;
				    //System.out.println(index);
				    
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
	    System.out.println("Nbr onglets : " + index);
	    
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
		
		FlagRobot = true;

		get_robotView().getTextField_NInterne().setEnabled(true);			

		// On ouvre la page detail robot
		get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"DetailRobot" );
		
		// On rafraichie le tableau des robots
		//_robotModel.refreshRobot(get_robotView().getTableRobots());
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void modRobot() {
	
		FlagRobot = false;
		
		// On récupère les valeurs de la ligne du tableau selectionnee
		int ligne = _robotView.getTableRobots().getSelectedRow();
					
		try {
			if(ligne != -1){

			get_robotView().getTextField_NInterne().setEnabled(false);
			
			String identifier = _robotView.getTableRobots().getModel().getValueAt(ligne, 0).toString();
			String brand =  _robotView.getTableRobots().getModel().getValueAt(ligne, 1).toString();
			String color =  _robotView.getTableRobots().getModel().getValueAt(ligne, 2).toString();
			String location = _robotView.getTableRobots().getModel().getValueAt(ligne, 3).toString();
			String serial_id = _robotView.getTableRobots().getModel().getValueAt(ligne, 5).toString();
			Object state =  _robotView.getTableRobots().getModel().getValueAt(ligne, 6); 
			
			// On remplis les champs avec le robot selectionné
			_robotView.getTextField_NInterne().setText(identifier);
			_robotView.getComboBox_Marque().setSelectedItem(brand);
			_robotView.getComboBox_Color().setSelectedItem(color);
			_robotView.getTextField_Emplacement().setText(location);
			_robotView.getTextField_NSerie().setText(serial_id);
			System.out.println(state);
			if(!(state==null)) _robotView.getChckbxEtat().setSelected((boolean)state);
			else  _robotView.getChckbxEtat().setSelected(false);
			
			// On rafraichie le tableau des robots
			_robotModel.refreshRobot(get_robotView().getTableRobots());
			
		    //INSERT A NEW EMPTY ROW
		    //model.addRow(new Object[]{"","",""});
			
			// On cache le message d'avertissement
			_robotView.getLblWarningRobot().setVisible(false);
			
			// On ouvre la page detail robot
			get_robotView().getCl_GRobots().show(get_robotView().getGRobots(),"DetailRobot" );
			
			
			} else {
				
				// On avertit l'utilisateur de sélectionner une ligne
				_robotView.getLblWarningRobot().setVisible(true);
				_robotView.getLblWarningRobot().setForeground(Color.red);
				_robotView.getLblWarningRobot().setText("Sélectionner un robot pour le modifier");
				
				System.out.println("Veuillez selectionner une ligne pour la modifier !");
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void delRobot() {
		

		// On récupère les valeurs de la ligne du tableau selectionnee
		int ligne = _robotView.getTableRobots().getSelectedRow();
			
		try {
			if(ligne != -1){
				
			// On cache le message d'avertissement
			_robotView.getLblWarningRobot().setVisible(false);
				
			int n = JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir supprimer le robot n° " + _robotView.getTableRobots().getValueAt(_robotView.getTableRobots().getSelectedRow(), 0) + "?","",JOptionPane.YES_NO_CANCEL_OPTION);          
					           
			//the user has clicked the cross
			if(n == -1) return;
			
			//the user has clicked cancel
			if(n == 2) return;
			
			//no
			if(n == 1) return;
			
			//yes
			if(n == 0)
				{ 
			    //CREATE MODEL INSTANCE FROM EXISTING TABLE
			    DefaultTableModel model = new DefaultTableModel();
			    model = (DefaultTableModel) _robotView.getTableRobots().getModel();
			    Integer ligneSelec;
			    
			    //DELETE THE SELECTED ROW
			    if((ligneSelec = ligne) != -1)
				    {
			    	
			    	//model.removeRow(table_1.getSelectedRow());
			    	
			    	// 
			    	String id = _robotView.getTableRobots().getValueAt(ligneSelec, 0).toString();
			    	System.out.println("id : "+id);
			    	model.removeRow(ligneSelec);
			    	
			    	// On supprime le robot de la bd
			    	_robotModel.supprimerRobot(id);
			    	
			    	System.out.println("La ligne : " +ligneSelec.toString()+" a été supprimer");
				    }
			    else System.out.println("Veuillez selectionner une ligne pour la supprimer !");
			               
			    //INSERT A NEW EMPTY ROW
			    //model.addRow(new Object[]{"","",""});
				}
			
			} else {
				
				// On avertit l'utilisateur de sélectionner une ligne
				_robotView.getLblWarningRobot().setVisible(true);
				_robotView.getLblWarningRobot().setForeground(Color.red);
				_robotView.getLblWarningRobot().setText("Sélectionner un robot pour le supprimer");
				
				System.out.println("Veuillez selectionner une ligne pour la supprimer !");
			}
								
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// On rafraichie le tableau des robots
		_robotModel.refreshRobot(get_robotView().getTableRobots());
		}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void validerRobot() {

		// Si on valide un ajout de robot
		if(FlagRobot){	
					
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			
			Date time_use = new Date();
			
			// Initialisé à la date et l'heure courrante. 
			calendar.setTime(time_use); 
			// Initialisé avec une instance de Date. 
			
			System.out.println(time_use);
			
			String identifier = _robotView.getTextField_NInterne().getText();
			String brand = _robotView.getComboBox_Marque().getSelectedItem().toString();
			String color = _robotView.getComboBox_Color().getSelectedItem().toString();
			String location = _robotView.getTextField_Emplacement().getText();
			String serial_id = _robotView.getTextField_NSerie().getText();
			Boolean state = _robotView.getChckbxEtat().isSelected(); 
			
			
			_robotModel.insererRobot(identifier, brand, color, location, time_use, serial_id, state);
			
			// On rafraichie le tableau des robots
			_robotModel.refreshRobot(get_robotView().getTableRobots());
			
			quitAllTab();
			setDefaultValueRobot();
			

		}
		// Si on valide une modification de robot
		else {
			
			String identifier = _robotView.getTextField_NInterne().getText();
			String brand = _robotView.getComboBox_Marque().getSelectedItem().toString();
			String color = _robotView.getComboBox_Color().getSelectedItem().toString();
			String location = _robotView.getTextField_Emplacement().getText();
			String serial_id = _robotView.getTextField_NSerie().getText();
			Boolean state = _robotView.getChckbxEtat().isSelected(); 
			
			
			_robotModel.modifierRobot(identifier, brand, color, location, serial_id, state);
			
			// On rafraichie le tableau des robots
			_robotModel.refreshRobot(get_robotView().getTableRobots());
			
			quitAllTab();
			setDefaultValueRobot();
			
			get_robotView().getTextField_NInterne().setEnabled(true);			
		}
	}
	
	
	/**
	 * 
	 * @author b.christol
	 */
	public void addTask() {
		
		FlagTask = true;

		// On ouvre la page add tache
		_robotView.getCl_Planning().show(_robotView.getPlanning(),"AddEv" );
		
	}
	


	/**
	 * 
	 * @author b.christol
	 */
	public void modTask() {
		// TODO Auto-generated method stub
		
	}


	/**
	 * 
	 * @author b.christol
	 */
	public void delTask() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @author b.christol
	 */
	public void ValiderEvt() {

		// Si on valide un ajout d'évenement
		if(FlagTask){	
					
			GregorianCalendar calendar = new java.util.GregorianCalendar();
			
			Date time_use = new Date();
			
			// Initialisé à la date et l'heure courrante. 
			calendar.setTime(time_use); 
			// Initialisé avec une instance de Date. 
			
			System.out.println(time_use);
			
			String descriptif = _robotView.getTextField_Descriptif().getText();
			java.util.Date  date = _robotView.getDateChooser_Event().getDate();
			String lieu = _robotView.getTextField_Lieu().toString();
			String type = _robotView.getComboBox_Type().getSelectedItem().toString();
			
			
			_robotModel.insererEvent(descriptif, date, lieu, type,connectedUser);
			
			// On rafraichie le tableau des robots
			_robotModel.refreshRobot(get_robotView().getTableRobots());
			
			quitAllTab();
			setDefaultValueRobot();
		}
		// Si on valide une modification d'evenement
		else {
			
			String identifier = _robotView.getTextField_NInterne().getText();
			String brand = _robotView.getComboBox_Marque().getSelectedItem().toString();
			String color = _robotView.getComboBox_Color().getSelectedItem().toString();
			String location = _robotView.getTextField_Emplacement().getText();
			String serial_id = _robotView.getTextField_NSerie().getText();
			Boolean state = _robotView.getChckbxEtat().isSelected(); 
			
			
			_robotModel.modifierRobot(identifier, brand, color, location, serial_id, state);
			
			// On rafraichie le tableau des robots
			_robotModel.refreshRobot(get_robotView().getTableRobots());
			
			quitAllTab();
			setDefaultValueRobot();
			
		}
	}
	
	public void setDefaultValueRobot() {
		
		_robotView.getTextField_NInterne().setText("");
		_robotView.getComboBox_Marque().setSelectedIndex(0);
		_robotView.getComboBox_Color().setSelectedIndex(0);
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


	/**
	 * 
	 */
	public void setDefaultValueEvt() {
		// TODO Auto-generated method stub
		
	}


}
