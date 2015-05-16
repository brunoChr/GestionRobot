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

public class RobotView extends JFrame {

	private JPanel contentPane;
	private String html1 = "<html><body leftmargin=30 topmargin=15 marginwidth=6 marginheight=19>";
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTable tableRobot;
	private JTable tablePlanning;
	private JTable tableEntretien;
	private JTable tableUser;
	private JTable table;
	private JTable tableEvents;
	private JTable tableTask;
	private JButton btnShow;
	private JPanel Acceuil;
	private CardLayout cl_Acceuil;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		
		Acceuil = new JPanel();
		tabbedPane.addTab(html1 + "Acceuil</body></html>", null, Acceuil, null);
		cl_Acceuil = new CardLayout(0, 0);
		Acceuil.setLayout(cl_Acceuil);
		
		JPanel Login = new JPanel();
		Acceuil.add(Login, "loginPanel");
		Login.setLayout(null);
		
		JLabel lblAcceuil = new JLabel("Bienvenue sur votre plateforme de gestion");
		lblAcceuil.setBounds(70, 30, 410, 50);
		Login.add(lblAcceuil);
		lblAcceuil.setFont(new Font("SansSerif", Font.BOLD, 20));
		
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
				cl_Acceuil.show(Acceuil, "welcomePanel");
			}
		});
		
		JPanel Welcome = new JPanel();
		Acceuil.add(Welcome, "welcomePanel");
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
		
		tableEvents = new JTable();
		tableEvents.setBounds(40, 140, 220, 200);
		Welcome.add(tableEvents);
		
		tableTask = new JTable();
		tableTask.setBounds(290, 140, 220, 200);
		Welcome.add(tableTask);
		
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
		
		tableRobot = new JTable();
		tableRobot.setBounds(40, 140, 460, 220);
		panelListe.add(tableRobot);
		
		JLabel lblListeDesRobots = new JLabel("Liste des Robots");
		lblListeDesRobots.setBounds(40, 120, 104, 16);
		panelListe.add(lblListeDesRobots);
		
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
		
		JLabel lblNDeSrie = new JLabel("N\u00B0 de s\u00E9rie :");
		lblNDeSrie.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNDeSrie.setBounds(80, 274, 73, 16);
		panelDetail.add(lblNDeSrie);
		
		textField = new JTextField();
		textField.setBounds(173, 108, 122, 28);
		panelDetail.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(173, 149, 122, 26);
		panelDetail.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(173, 189, 122, 26);
		panelDetail.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 228, 122, 28);
		panelDetail.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 268, 122, 28);
		panelDetail.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Entretiens et r\u00E9parations");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(40, 310, 166, 16);
		panelDetail.add(lblNewLabel_2);
		
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
		
		tablePlanning = new JTable();
		tablePlanning.setBounds(50, 140, 460, 220);
		Planning.add(tablePlanning);
		
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
		
		tableEntretien = new JTable();
		tableEntretien.setBounds(50, 140, 460, 220);
		Entretien.add(tableEntretien);
		
		JLabel lblListeDesFiches = new JLabel("Liste des fiches d'entretien");
		lblListeDesFiches.setBounds(50, 120, 158, 16);
		Entretien.add(lblListeDesFiches);
		
		JPanel Configuration = new JPanel();
		tabbedPane.addTab(html1 + "Configuration</body></html>", null, Configuration, null);
		Configuration.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des utilisateurs");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 20, 225, 50);
		Configuration.add(lblNewLabel_1);
		
		JButton btnAddUser = new JButton("Ajouter");
		btnAddUser.setBounds(80, 80, 90, 28);
		Configuration.add(btnAddUser);
		
		JButton btnModifyUser = new JButton("Modifier");
		btnModifyUser.setBounds(220, 80, 90, 28);
		Configuration.add(btnModifyUser);
		
		JButton btnDeleteUser = new JButton("Supprimer");
		btnDeleteUser.setBounds(360, 80, 90, 28);
		Configuration.add(btnDeleteUser);
		
		tableUser = new JTable();
		tableUser.setBounds(50, 140, 460, 220);
		Configuration.add(tableUser);
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(50, 120, 120, 16);
		Configuration.add(lblListeDesUtilisateurs);
		
		JPanel Historique = new JPanel();
		tabbedPane.addTab(html1 + "Historique</body></html>", null, Historique, null);
		Historique.setLayout(null);
		
		JLabel lblHistorique = new JLabel("Historique");
		lblHistorique.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHistorique.setBounds(210, 20, 105, 50);
		Historique.add(lblHistorique);
		
		table = new JTable();
		table.setBounds(50, 140, 460, 220);
		Historique.add(table);
		
		JLabel lblListesDesDernires = new JLabel("Listes des derni\u00E8res action \u00E9ffectu\u00E9es \u00E0 l'aide du logiciel");
		lblListesDesDernires.setBounds(50, 120, 400, 16);
		Historique.add(lblListesDesDernires);
		contentPane.add(tabbedPane);
		
		
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
