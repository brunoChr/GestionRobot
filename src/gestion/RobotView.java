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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class RobotView extends JFrame {

	private JPanel contentPane;
	private String html1 = "<html><body leftmargin=30 topmargin=15 marginwidth=6 marginheight=19>";
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTable table;
	private JButton btnShow;
	private JPanel Accueil;
	private CardLayout cl_Accueil;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table_1;
	private JTable tableEvent;
	private JTable tableTask;
	private JTable tablePlanning;
	private JTable tableEntretien;
	private JTable tableUser;

	/**
	 * Create the frame.
	 */
	public RobotView(RobotController robotController) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
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
		
<<<<<<< HEAD
		JLabel lblNewLabel = new JLabel("Bienvenue sur votre platforme de gestion");
		lblNewLabel.setBounds(80, 60, 402, 50);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		Accueil.add(lblNewLabel);
		Accueil.add(lblLogin);
		Accueil.add(textField);
		Accueil.add(lblPassword);
		Accueil.add(textField_1);
		Accueil.add(btnMotDePasse);
		Accueil.add(btnValider);
=======
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 140, 220, 200);
		Welcome.add(scrollPane_1);
		
		tableEvent = new JTable();
		tableEvent.setModel(new DefaultTableModel(
			new Object[][] {
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
		scrollPane_1.setViewportView(tableEvent);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(290, 140, 220, 200);
		Welcome.add(scrollPane_2);
		
		tableTask = new JTable();
		tableTask.setModel(new DefaultTableModel(
			new Object[][] {
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
		scrollPane_2.setViewportView(tableTask);
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		
		JPanel GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
<<<<<<< HEAD
=======
		GRobots.setLayout(new CardLayout(0, 0));
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		
<<<<<<< HEAD
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(80, 90, 90, 28);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(220, 90, 90, 28);
=======
		JPanel panelListe = new JPanel();
		GRobots.add(panelListe, "name_15482932351347");
		panelListe.setLayout(null);
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
<<<<<<< HEAD
		lblGestionDuParc.setBounds(130, 30, 259, 50);
=======
		lblGestionDuParc.setBounds(130, 20, 259, 50);
		panelListe.add(lblGestionDuParc);
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
<<<<<<< HEAD
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(360, 90, 90, 28);
=======
		JButton btnAddRobot = new JButton("Ajouter");
		btnAddRobot.setBounds(70, 80, 90, 28);
		panelListe.add(btnAddRobot);
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		
<<<<<<< HEAD
		table = new JTable();
		table.setBounds(50, 140, 440, 220);
		GRobots.setLayout(null);
		GRobots.add(lblGestionDuParc);
		GRobots.add(btnNewButton);
		GRobots.add(btnNewButton_1);
		GRobots.add(btnNewButton_2);
		GRobots.add(table);
=======
		JButton btnModifyRobot = new JButton("Modifier");
		btnModifyRobot.setBounds(210, 80, 90, 28);
		panelListe.add(btnModifyRobot);
		
		JButton btnDeleteRobot = new JButton("Supprimer");
		btnDeleteRobot.setBounds(350, 80, 90, 28);
		panelListe.add(btnDeleteRobot);
		
		JLabel lblListeDesRobots = new JLabel("Liste des Robots");
		lblListeDesRobots.setBounds(40, 120, 104, 16);
		panelListe.add(lblListeDesRobots);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 139, 460, 221);
		panelListe.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"yo", "New column", "New column", "New column"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table_1);
		
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
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
		
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
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(50, 140, 460, 220);
		Planning.add(scrollPane_3);
		
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
		scrollPane_3.setViewportView(tablePlanning);
		
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
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(50, 140, 460, 220);
		Entretien.add(scrollPane_4);
		
		tableEntretien = new JTable();
		tableEntretien.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane_4.setViewportView(tableEntretien);
		
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
		
		JLabel lblListeDesUtilisateurs = new JLabel("Liste des utilisateurs");
		lblListeDesUtilisateurs.setBounds(50, 120, 120, 16);
		Configuration.add(lblListeDesUtilisateurs);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(50, 140, 460, 220);
		Configuration.add(scrollPane_5);
		
		tableUser = new JTable();
		tableUser.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nom", "Pr\u00E9nom", "Grade"
			}
		));
		scrollPane_5.setViewportView(tableUser);
		
		JPanel Historique = new JPanel();
		tabbedPane.addTab(html1 + "Historique</body></html>", null, Historique, null);
<<<<<<< HEAD
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);
=======
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
		
		
>>>>>>> branch 'viewBuilder' of https://github.com/brunoChr/GestionRobot.git
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
