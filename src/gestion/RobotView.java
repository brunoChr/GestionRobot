package gestion;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class RobotView extends JFrame {

	private JPanel contentPane;
	private String html1 = "<html><body leftmargin=30 topmargin=15 marginwidth=6 marginheight=19>";
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JButton btnShow;
	private JPanel Accueil;
	private CardLayout cl_Accueil;
	private JTextField textField_NInterne;
	private JTextField textField_Emplacement;
	private JTextField textField_NSerie;
	private JTable tableEvent;
	private JTable tableTask;
	private JTable tablePlanning;
	private JTable tableEntretien;
	private JTable tableUsers;
	private JTextField textField_Name;
	private JTextField textField_Login;
	private JTextField textField_PwUser;
	private JTextField textField_Email;
	private JTable tableAction;
	private JTable tableRobots;

	/**
	 * Create the frame.
	 */
	public RobotView(RobotController robotController) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		Accueil = new JPanel();
		tabbedPane.addTab(html1 + "Accueil</body></html>", null, Accueil, null);
		cl_Accueil = new CardLayout(0, 0);
		Accueil.setLayout(cl_Accueil);
		
		JPanel Login = new JPanel();
		Accueil.add(Login, "loginPanel");
		Login.setLayout(null);
		
		JLabel lblAccueil = new JLabel("Bienvenue sur votre plateforme de gestion");
		lblAccueil.setBounds(70, 30, 410, 50);
		Login.add(lblAccueil);
		lblAccueil.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(150, 136, 31, 16);
		Login.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(250, 130, 122, 28);
		Login.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(150, 180, 56, 16);
		Login.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(250, 174, 122, 28);
		Login.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnMotDePasse = new JButton("Mot de passe oubli\u00E9");
		btnMotDePasse.setBounds(120, 235, 139, 28);
		Login.add(btnMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(290, 235, 122, 28);
		Login.add(btnValider);
		
		btnShow = new JButton("show");
		btnShow.setBounds(322, 290, 90, 28);
		Login.add(btnShow);
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl_Accueil.show(Accueil, "welcomePanel");
			}
		});
		
		JPanel Welcome = new JPanel();
		Accueil.add(Welcome, "welcomePanel");
		Welcome.setLayout(null);
		
		JLabel label = new JLabel("Bienvenue sur votre plateforme de gestion");
		label.setBounds(70, 30, 410, 50);
		label.setFont(new Font("SansSerif", Font.BOLD, 20));
		Welcome.add(label);
		
		JLabel lblLastEvents = new JLabel("Derniers \u00E9v\u00E8nements");
		lblLastEvents.setBounds(40, 120, 129, 16);
		Welcome.add(lblLastEvents);
		
		JLabel lblTaskToCome = new JLabel("T\u00E2ches \u00E0 venir");
		lblTaskToCome.setBounds(290, 120, 89, 16);
		Welcome.add(lblTaskToCome);
		
		JScrollPane scrollPane_Events = new JScrollPane();
		scrollPane_Events.setBounds(40, 140, 220, 220);
		Welcome.add(scrollPane_Events);
		
		tableEvent = new JTable();
		tableEvent.setShowVerticalLines(true);
		tableEvent.setSurrendersFocusOnKeystroke(true);
		tableEvent.setShowHorizontalLines(true);
		tableEvent.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Events.setViewportView(tableEvent);
		
		JScrollPane scrollPane_Tasks = new JScrollPane();
		scrollPane_Tasks.setBounds(290, 140, 220, 220);
		Welcome.add(scrollPane_Tasks);
		
		tableTask = new JTable();
		tableTask.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_Tasks.setViewportView(tableTask);
		
		JPanel GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
		GRobots.setLayout(new CardLayout(0, 0));
		
		JPanel panelListe = new JPanel();
		GRobots.add(panelListe, "name_15482932351347");
		panelListe.setLayout(null);
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
		lblGestionDuParc.setBounds(130, 20, 259, 50);
		panelListe.add(lblGestionDuParc);
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnAddRobot = new JButton("Ajouter");
		btnAddRobot.setBounds(70, 80, 90, 28);
		panelListe.add(btnAddRobot);
		
		JButton btnModifyRobot = new JButton("Modifier");
		btnModifyRobot.setBounds(210, 80, 90, 28);
		panelListe.add(btnModifyRobot);
		
		JButton btnDeleteRobot = new JButton("Supprimer");
		btnDeleteRobot.setBounds(350, 80, 90, 28);
		panelListe.add(btnDeleteRobot);
		
		JLabel lblListeDesRobots = new JLabel("Liste des Robots");
		lblListeDesRobots.setBounds(40, 120, 104, 16);
		panelListe.add(lblListeDesRobots);
		
		JScrollPane scrollPane_Robots = new JScrollPane();
		scrollPane_Robots.setBounds(40, 139, 460, 221);
		panelListe.add(scrollPane_Robots);
		
		tableRobots = new JTable();
		tableRobots.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_Robots.setViewportView(tableRobots);
		
		JPanel panelDetail = new JPanel();
		GRobots.add(panelDetail, "name_15515675658776");
		panelDetail.setLayout(null);
		
		JLabel lblFicheDuRobot = new JLabel("Fiche du robot n\u00B0");
		lblFicheDuRobot.setBounds(146, 20, 208, 26);
		lblFicheDuRobot.setFont(new Font("SansSerif", Font.BOLD, 20));
		panelDetail.add(lblFicheDuRobot);
		
		JLabel lblCaractristiques = new JLabel("Caract\u00E9ristiques");
		lblCaractristiques.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblCaractristiques.setBounds(40, 80, 133, 16);
		panelDetail.add(lblCaractristiques);
		
		JLabel lblNInterne = new JLabel("N\u00B0 interne :");
		lblNInterne.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNInterne.setBounds(80, 114, 73, 16);
		panelDetail.add(lblNInterne);
		
		JLabel lblNewLabel = new JLabel("Marque :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(98, 154, 55, 16);
		panelDetail.add(lblNewLabel);
		
		JLabel lblCouleur = new JLabel("Couleur :");
		lblCouleur.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCouleur.setBounds(98, 194, 55, 16);
		panelDetail.add(lblCouleur);
		
		JLabel lblEmplacement = new JLabel("Emplacement :");
		lblEmplacement.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmplacement.setBounds(50, 234, 103, 16);
		panelDetail.add(lblEmplacement);
		
		JLabel lblNDeSerie = new JLabel("N\u00B0 de s\u00E9rie :");
		lblNDeSerie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNDeSerie.setBounds(80, 274, 73, 16);
		panelDetail.add(lblNDeSerie);
		
		textField_NInterne = new JTextField();
		textField_NInterne.setBounds(173, 108, 122, 28);
		panelDetail.add(textField_NInterne);
		textField_NInterne.setColumns(10);
		
		JComboBox comboBox_Marque = new JComboBox();
		comboBox_Marque.setBounds(173, 149, 122, 26);
		panelDetail.add(comboBox_Marque);
		
		JComboBox comboBox_Color = new JComboBox();
		comboBox_Color.setBounds(173, 189, 122, 26);
		panelDetail.add(comboBox_Color);
		
		textField_Emplacement = new JTextField();
		textField_Emplacement.setBounds(173, 228, 122, 28);
		panelDetail.add(textField_Emplacement);
		textField_Emplacement.setColumns(10);
		
		textField_NSerie = new JTextField();
		textField_NSerie.setBounds(173, 268, 122, 28);
		panelDetail.add(textField_NSerie);
		textField_NSerie.setColumns(10);
		
		JLabel lblsubtitle2 = new JLabel("Entretiens et r\u00E9parations");
		lblsubtitle2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblsubtitle2.setBounds(40, 310, 166, 16);
		panelDetail.add(lblsubtitle2);
		
		JLabel lblDernierReparation = new JLabel("Derni\u00E8re r\u00E9paration :");
		lblDernierReparation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDernierReparation.setBounds(29, 341, 123, 16);
		panelDetail.add(lblDernierReparation);
		
		JLabel lblDateRep = new JLabel("xx/xx/xxxx");
		lblDateRep.setBounds(165, 341, 87, 16);
		panelDetail.add(lblDateRep);
		
		JLabel lblProchainEntretien = new JLabel("Prochain entretien :");
		lblProchainEntretien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProchainEntretien.setBounds(264, 341, 112, 16);
		panelDetail.add(lblProchainEntretien);
		
		JLabel lblDateEntretien = new JLabel("xx/xx/xxxx");
		lblDateEntretien.setBounds(388, 341, 87, 16);
		panelDetail.add(lblDateEntretien);
		
		JLabel lblImageRobot = new JLabel("New label");
		lblImageRobot.setBounds(388, 194, 55, 16);
		panelDetail.add(lblImageRobot);
		
		JPanel Planning = new JPanel();
		tabbedPane.addTab(html1 + "Planning</body></html>", null, Planning, null);
		Planning.setLayout(null);
		
		JLabel lblPlanning = new JLabel("Planning de la semaine");
		lblPlanning.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPlanning.setBounds(90, 20, 374, 50);
		Planning.add(lblPlanning);
		
		JButton btnAddTask = new JButton("Ajouter une t\u00E2che");
		btnAddTask.setBounds(50, 80, 143, 28);
		Planning.add(btnAddTask);
		
		JButton btnModifyTask = new JButton("Modifier une t\u00E2che");
		btnModifyTask.setBounds(205, 80, 143, 28);
		Planning.add(btnModifyTask);
		
		JButton btnDeleteTask = new JButton("Supprimer une t\u00E2che");
		btnDeleteTask.setBounds(360, 80, 143, 28);
		Planning.add(btnDeleteTask);
		
		JScrollPane scrollPane_Planning = new JScrollPane();
		scrollPane_Planning.setBounds(50, 140, 460, 220);
		Planning.add(scrollPane_Planning);
		
		tablePlanning = new JTable();
		tablePlanning.setModel(new DefaultTableModel(
			new Object[][] {
				{"8h-9h", null, null, null, null, null},
				{"9h10h", null, null, null, null, null},
				{"10h-11h", null, null, null, null, null},
				{"11h-12h", null, null, null, null, null},
				{"12h-13h", null, null, null, null, null},
				{"13h-14h", null, null, null, null, null},
				{"14h-15h", null, null, null, null, null},
				{"15h-16h", null, null, null, null, null},
			},
			new String[] {
				"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
			}
		));
		scrollPane_Planning.setViewportView(tablePlanning);
		
		JPanel Entretien = new JPanel();
		tabbedPane.addTab(html1 + "Fiches d'entretien</body></html>", null, Entretien, null);
		Entretien.setLayout(null);
		
		JLabel lblEntretien = new JLabel("Gestion des fiches d'entretien");
		lblEntretien.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblEntretien.setBounds(130, 20, 299, 50);
		Entretien.add(lblEntretien);
		
		JButton btnAddMaintenance = new JButton("Ajouter");
		btnAddMaintenance.setBounds(80, 80, 90, 28);
		Entretien.add(btnAddMaintenance);
		
		JButton btnModifyMaintenance = new JButton("Modifier");
		btnModifyMaintenance.setBounds(220, 80, 90, 28);
		Entretien.add(btnModifyMaintenance);
		
		JButton btnDeleteMaintenance = new JButton("Supprimer");
		btnDeleteMaintenance.setBounds(360, 80, 90, 28);
		Entretien.add(btnDeleteMaintenance);
		
		JLabel lblListeDesFiches = new JLabel("Liste des fiches d'entretien");
		lblListeDesFiches.setBounds(50, 120, 158, 16);
		Entretien.add(lblListeDesFiches);
		
		JScrollPane scrollPane_Entretien = new JScrollPane();
		scrollPane_Entretien.setBounds(50, 140, 460, 220);
		Entretien.add(scrollPane_Entretien);
		
		tableEntretien = new JTable();
		tableEntretien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane_Entretien.setViewportView(tableEntretien);
		
		JPanel Configuration = new JPanel();
		tabbedPane.addTab(html1 + "Configuration</body></html>", null, Configuration, null);
		Configuration.setLayout(new CardLayout(0, 0));
		
		JPanel RecapUser = new JPanel();
		Configuration.add(RecapUser, "name_22457550805877");
		RecapUser.setLayout(null);
		
		JLabel lblTitleConfig = new JLabel("Gestion des utilisateurs");
		lblTitleConfig.setBounds(150, 30, 225, 50);
		RecapUser.add(lblTitleConfig);
		lblTitleConfig.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnAddUser = new JButton("Ajouter");
		btnAddUser.setBounds(80, 90, 90, 28);
		RecapUser.add(btnAddUser);
		
		JButton btnModifyUser = new JButton("Modifier");
		btnModifyUser.setBounds(220, 90, 90, 28);
		RecapUser.add(btnModifyUser);
		
		JButton btnDeleteUser = new JButton("Supprimer");
		btnDeleteUser.setBounds(360, 90, 90, 28);
		RecapUser.add(btnDeleteUser);
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(50, 130, 120, 16);
		RecapUser.add(lblListeDesUtilisateurs);
		
		JScrollPane scrollPane_Users = new JScrollPane();
		scrollPane_Users.setBounds(50, 150, 460, 220);
		RecapUser.add(scrollPane_Users);
		
		tableUsers = new JTable();
		tableUsers.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Grade"
			}
		));
		scrollPane_Users.setViewportView(tableUsers);
		
		JPanel InfoUser = new JPanel();
		Configuration.add(InfoUser, "name_22457609695790");
		InfoUser.setLayout(null);
		
		JLabel lblDescriptionDeLutilisateur = new JLabel("Description de l'utilisateur");
		lblDescriptionDeLutilisateur.setBounds(150, 30, 250, 50);
		lblDescriptionDeLutilisateur.setFont(new Font("SansSerif", Font.BOLD, 20));
		InfoUser.add(lblDescriptionDeLutilisateur);
		
		JLabel lblName = new JLabel("Nom :");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(60, 136, 55, 16);
		InfoUser.add(lblName);
		
		JLabel lblLogin_1 = new JLabel("Login :");
		lblLogin_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin_1.setBounds(60, 176, 55, 16);
		InfoUser.add(lblLogin_1);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe :");
		lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMotDePasse.setBounds(22, 216, 93, 16);
		InfoUser.add(lblMotDePasse);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(60, 256, 55, 16);
		InfoUser.add(lblEmail);
		
		JLabel lblDroit = new JLabel("Droit :");
		lblDroit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDroit.setBounds(60, 296, 55, 16);
		InfoUser.add(lblDroit);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(130, 130, 150, 28);
		InfoUser.add(textField_Name);
		textField_Name.setColumns(10);
		
		textField_Login = new JTextField();
		textField_Login.setBounds(130, 170, 150, 28);
		InfoUser.add(textField_Login);
		textField_Login.setColumns(10);
		
		textField_PwUser = new JTextField();
		textField_PwUser.setBounds(130, 210, 150, 28);
		InfoUser.add(textField_PwUser);
		textField_PwUser.setColumns(10);
		
		textField_Email = new JTextField();
		textField_Email.setBounds(130, 250, 150, 28);
		InfoUser.add(textField_Email);
		textField_Email.setColumns(10);
		
		JComboBox comboBRight = new JComboBox();
		comboBRight.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBRight.setBounds(130, 291, 150, 26);
		InfoUser.add(comboBRight);
		
		JPanel Historique = new JPanel();
		tabbedPane.addTab(html1 + "Historique</body></html>", null, Historique, null);
		Historique.setLayout(null);
		
		JLabel lblHistorique = new JLabel("Historique");
		lblHistorique.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHistorique.setBounds(210, 20, 105, 50);
		Historique.add(lblHistorique);
		
		JLabel lblListesDesActions = new JLabel("Listes des derni\u00E8res action \u00E9ffectu\u00E9es \u00E0 l'aide du logiciel");
		lblListesDesActions.setBounds(50, 120, 400, 16);
		Historique.add(lblListesDesActions);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 140, 460, 220);
		Historique.add(scrollPane);
		
		tableAction = new JTable();
		tableAction.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tableAction);
		contentPane.add(tabbedPane);
		
		
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
