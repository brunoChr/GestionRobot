package gestion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;

import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.Component;

import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.Box;
import com.alee.extended.colorchooser.ColorChooserFieldType;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import com.sun.prism.j2d.paint.MultipleGradientPaint;
import java.awt.Toolkit;


//@SuppressWarnings("serial")
public class RobotView extends JFrame {

	private JPanel contentPane;
	private String html1 = "<html><body leftmargin=30 topmargin=15 marginwidth=6 marginheight=19>";
	private JTextField textFieldLogin;
	private JTable tablePlanning;
	private JTable tableEntretien;
	private JLabel lblWarningAccueil;
	private JPanel Accueil;
	private CardLayout cl_Accueil;
	private JTextField textField_NInterne;
	private JTextField textField_Emplacement;
	private JTextField textField_NSerie;
	private JTable tableEvent;
	private JTable tableTask;
	private JTable tableUsers;
	private JTextField textField_Name;
	private JTextField textField_Login;
	private JTextField textField_PwUser;
	private JTextField textField_Email;
	private JTable tableAction;
	private JTable tableRobots;
	private JTextField textField_Descriptif;
	private JTextField textField_detailEnt;
	private JTextField textField_Lieu;
	private JButton btnMotDePasse;
	private JButton btnValider;
	private JPasswordField textFieldPassword;
	private JButton btnDeconnecter;
	private JButton btnAddRobot;
	private JButton btnModifyRobot;
	private JButton btnDeleteRobot;
	private JPanel GRobots;
	private CardLayout cl_GRobots;
	private JPanel Planning;
	private JPanel Configuration;
	private CardLayout cl_Planning;
	private JPanel Entretien;
	private CardLayout cl_Entretien;
	private CardLayout cl_Configuration;
	private JButton btnValiderRobot;
	private JButton btnAnnulerRobot;
	private JButton btnAddTask;
	private JButton btnModifyTask;
	private JButton btnDeleteTask;
	private JButton btnAnnulerEvt;
	private JButton btnValiderEvt;
	private JButton btnAddMaintenance;
	private JButton btnModifyMaintenance;
	private JButton btnDeleteMaintenance;
	private JButton btnAnnulerEntretien;
	private JButton btnValiderEntretien;
	private JButton btnAddUser;
	private JButton btnModifyUser;
	private JButton btnDeleteUser;
	private JButton btnValiderUser;
	private JButton btnAnnulerUser;
	private JTabbedPane tabbedPane;
	private JComboBox comboBox_Marque;
	private JComboBox comboBox_Color;
	private JCheckBox chckbxEtat;
	private JLabel lblWarningRobot;

	/**
	 * Create the frame.
	 */
	/**
	 * @param robotController
	 */
	public RobotView(RobotController robotController) {
		setTitle("Gestion de parc de robots");
		setIconImage(Toolkit.getDefaultToolkit().getImage(RobotView.class.getResource("/img/staubli50.png")));
		
		/* Ecouteur des événements sur la fenêtre */
		this.addWindowListener(new RobotEvent(robotController));
		
		setResizable(true);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addChangeListener(new RobotEvent(robotController));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		contentPane.add(tabbedPane);
		
		setSize(new Dimension(800, 450));

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



//=======
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
		lblLogin.setBounds(150, 136, 88, 16);
		Login.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setDragEnabled(true);
		textFieldLogin.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textFieldLogin.setBounds(250, 130, 122, 28);
		Login.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(150, 180, 88, 16);
		Login.add(lblPassword);
		
		btnMotDePasse = new JButton("Mot de passe oubli\u00E9");
		btnMotDePasse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMotDePasse.addActionListener(new RobotEvent(robotController));
		btnMotDePasse.setBounds(120, 235, 158, 28);
		Login.add(btnMotDePasse);
		
		btnValider = new JButton("Valider");
		btnValider.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnValider.addActionListener(new RobotEvent(robotController));
		btnValider.setBounds(290, 235, 122, 28);
		Login.add(btnValider);
		
		lblWarningAccueil = new JLabel("");
		lblWarningAccueil.setBounds(379, 186, 237, 16);
		Login.add(lblWarningAccueil);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setDragEnabled(true);
		textFieldPassword.setBounds(250, 174, 122, 28);
		Login.add(textFieldPassword);
		lblWarningAccueil.setVisible(false);
		
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
		
		btnDeconnecter = new JButton("");
		btnDeconnecter.setSelected(true);
		btnDeconnecter.addActionListener(new RobotEvent(robotController));
		btnDeconnecter.setContentAreaFilled(false);
		btnDeconnecter.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDeconnecter.setBorderPainted(false);
		btnDeconnecter.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnDeconnecter.setBackground(SystemColor.control);
		btnDeconnecter.setIcon(new ImageIcon(RobotView.class.getResource("/img/deconnecter.png")));
		btnDeconnecter.setBounds(585, 312, 48, 48);
		Welcome.add(btnDeconnecter);
		
		GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
		cl_GRobots = new CardLayout(0, 0);		
		GRobots.setLayout(cl_GRobots);
		
		JPanel panelListe = new JPanel();
		GRobots.add(panelListe, "ListeRobot");
		panelListe.setLayout(null);
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
		lblGestionDuParc.setBounds(130, 20, 259, 50);
		panelListe.add(lblGestionDuParc);
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		btnAddRobot = new JButton("Ajouter");
		btnAddRobot.addActionListener(new RobotEvent(robotController));
		btnAddRobot.setBounds(70, 80, 90, 28);
		panelListe.add(btnAddRobot);
		
		btnModifyRobot = new JButton("Modifier");
		btnModifyRobot.addActionListener(new RobotEvent(robotController));
		btnModifyRobot.setBounds(210, 80, 90, 28);
		panelListe.add(btnModifyRobot);
		
		btnDeleteRobot = new JButton("Supprimer");
		btnDeleteRobot.addActionListener(new RobotEvent(robotController));
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
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"N\u00B0Interne", "Marque", "Emplacement", "Etat", "Temps d'utilisation", "Couleur", "N\u00B0 de serie"
			}
		));
		scrollPane_Robots.setViewportView(tableRobots);
		
		lblWarningRobot = new JLabel("");
		lblWarningRobot.setBounds(210, 120, 230, 16);
		panelListe.add(lblWarningRobot);
		
		JPanel panelDetail = new JPanel();
		//panelDetail.setBackground(Color.LIGHT_GRAY);
		GRobots.add(panelDetail, "DetailRobot");
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
		
		comboBox_Marque = new JComboBox();
		comboBox_Marque.setModel(new DefaultComboBoxModel(Brand.values()));
		comboBox_Marque.setBounds(173, 149, 122, 26);
		panelDetail.add(comboBox_Marque);
		
		comboBox_Color = new JComboBox();
		comboBox_Color.setModel(new DefaultComboBoxModel(new String[] {"Bleu", "Rouge", "Vert", "Gris"}));
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
		lblDernierReparation.setBounds(16, 341, 123, 16);
		panelDetail.add(lblDernierReparation);
		
		JLabel lblDateRep = new JLabel("xx/xx/xxxx");
		lblDateRep.setBounds(152, 341, 60, 16);
		panelDetail.add(lblDateRep);
		
		JLabel lblProchainEntretien = new JLabel("Prochain entretien :");
		lblProchainEntretien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProchainEntretien.setBounds(224, 341, 112, 16);
		panelDetail.add(lblProchainEntretien);
		
		JLabel lblDateEntretien = new JLabel("xx/xx/xxxx");
		lblDateEntretien.setBounds(348, 341, 60, 16);
		panelDetail.add(lblDateEntretien);
		
		JLabel lblImageRobot = new JLabel("");
		lblImageRobot.setIcon(new ImageIcon(RobotView.class.getResource("/img/staubli50.png")));
		lblImageRobot.setBounds(348, 58, 246, 210);
		panelDetail.add(lblImageRobot);
		
		btnValiderRobot = new JButton("");
		btnValiderRobot.setContentAreaFilled(false);
		btnValiderRobot.setBackground(SystemColor.control);
		btnValiderRobot.setSelected(true);
		btnValiderRobot.setIcon(new ImageIcon(RobotView.class.getResource("/img/Check.png")));
		btnValiderRobot.addActionListener(new RobotEvent(robotController));
		btnValiderRobot.setBounds(468, 323, 48, 48);
		panelDetail.add(btnValiderRobot);
		
		
		btnAnnulerRobot = new JButton("");
		btnAnnulerRobot.addActionListener(new RobotEvent(robotController));
		btnAnnulerRobot.setSelected(true);
		btnAnnulerRobot.setForeground(SystemColor.control);
		btnAnnulerRobot.setContentAreaFilled(false);
		btnAnnulerRobot.setBorderPainted(false);
		btnAnnulerRobot.setIcon(new ImageIcon(RobotView.class.getResource("/img/return.png")));
		btnAnnulerRobot.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAnnulerRobot.setBackground(SystemColor.control);
		btnAnnulerRobot.setAlignmentX(0.5f);
		btnAnnulerRobot.setBounds(546, 323, 48, 48);
		panelDetail.add(btnAnnulerRobot);
		
		chckbxEtat = new JCheckBox("En fonctionnement");
		chckbxEtat.setSelected(true);
		chckbxEtat.setBounds(307, 273, 133, 18);
		panelDetail.add(chckbxEtat);
		
		Planning = new JPanel();
		tabbedPane.addTab(html1 + "Planning</body></html>", null, Planning, null);
		cl_Planning = new CardLayout(0,0);
		Planning.setLayout(cl_Planning);
		
		JPanel panelPlanning = new JPanel();
		Planning.add(panelPlanning, "Planning");
		panelPlanning.setLayout(null);
		
		JLabel lblPlanning = new JLabel("Planning de la semaine");
		lblPlanning.setBounds(80, 30, 374, 50);
		panelPlanning.add(lblPlanning);
		lblPlanning.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		btnAddTask = new JButton("Ajouter une t\u00E2che");
		btnAddTask.addActionListener(new RobotEvent(robotController));
		btnAddTask.setBounds(40, 90, 143, 28);
		panelPlanning.add(btnAddTask);
		
		btnModifyTask = new JButton("Modifier une t\u00E2che");
		btnModifyTask.addActionListener(new RobotEvent(robotController));
		btnModifyTask.setBounds(195, 90, 143, 28);
		panelPlanning.add(btnModifyTask);
		
		btnDeleteTask = new JButton("Supprimer une t\u00E2che");
		btnDeleteTask.addActionListener(new RobotEvent(robotController));
		btnDeleteTask.setBounds(350, 90, 143, 28);
		panelPlanning.add(btnDeleteTask);
		
		JScrollPane scrollPane_Planning = new JScrollPane();
		scrollPane_Planning.setBounds(40, 150, 460, 220);
		panelPlanning.add(scrollPane_Planning);
		
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
				{"16h-17h", null, null, null, null, null},
			},
			new String[] {
				"", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
			}
		));
		scrollPane_Planning.setViewportView(tablePlanning);
		
		JPanel panelAddEvt = new JPanel();
		Planning.add(panelAddEvt, "AddEv");
		panelAddEvt.setLayout(null);
		
		JLabel lblEvenement = new JLabel("Evenement");
		lblEvenement.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblEvenement.setBounds(200, 30, 130, 50);
		panelAddEvt.add(lblEvenement);
		
		JDateChooser dateChooser_Event = new JDateChooser();
		dateChooser_Event.setDateFormatString("dd/MM/yyyy");
		dateChooser_Event.setBounds(121, 175, 190, 28);
		panelAddEvt.add(dateChooser_Event);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(40, 180, 55, 16);
		panelAddEvt.add(lblDate);
		
		JLabel lblDescriptif = new JLabel("Descriptif :");
		lblDescriptif.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescriptif.setBounds(26, 130, 69, 16);
		panelAddEvt.add(lblDescriptif);
		
		textField_Descriptif = new JTextField();
		textField_Descriptif.setBounds(121, 124, 190, 28);
		panelAddEvt.add(textField_Descriptif);
		textField_Descriptif.setColumns(10);
		
		JLabel lblLieu = new JLabel("Lieu :");
		lblLieu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLieu.setBounds(40, 230, 55, 16);
		panelAddEvt.add(lblLieu);
		
		textField_Lieu = new JTextField();
		textField_Lieu.setBounds(121, 224, 190, 28);
		panelAddEvt.add(textField_Lieu);
		textField_Lieu.setColumns(10);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setBounds(40, 280, 55, 16);
		panelAddEvt.add(lblType);
		
		JComboBox comboBox_Type = new JComboBox();
		comboBox_Type.setBounds(121, 275, 190, 28);
		panelAddEvt.add(comboBox_Type);
		
		btnAnnulerEvt = new JButton("");
		btnAnnulerEvt.addActionListener(new RobotEvent(robotController));
		btnAnnulerEvt.setIcon(new ImageIcon(RobotView.class.getResource("/img/return.png")));
		btnAnnulerEvt.setSelected(true);
		btnAnnulerEvt.setForeground(SystemColor.menu);
		btnAnnulerEvt.setContentAreaFilled(false);
		btnAnnulerEvt.setBorderPainted(false);
		btnAnnulerEvt.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAnnulerEvt.setBackground(SystemColor.menu);
		btnAnnulerEvt.setAlignmentX(0.5f);
		btnAnnulerEvt.setBounds(563, 280, 48, 48);
		panelAddEvt.add(btnAnnulerEvt);
		
		btnValiderEvt = new JButton("");
		btnValiderEvt.addActionListener(new RobotEvent(robotController));
		btnValiderEvt.setIcon(new ImageIcon(RobotView.class.getResource("/img/Check.png")));
		btnValiderEvt.setSelected(true);
		btnValiderEvt.setContentAreaFilled(false);
		btnValiderEvt.setBorderPainted(false);
		btnValiderEvt.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnValiderEvt.setBounds(485, 280, 48, 48);
		panelAddEvt.add(btnValiderEvt);
		
		Entretien = new JPanel();
		tabbedPane.addTab(html1 + "Fiches d'entretien</body></html>", null, Entretien, null);
		cl_Entretien = new CardLayout(0, 0);		
		Entretien.setLayout(cl_Entretien);
		
		JPanel panelViewEntretien = new JPanel();
		Entretien.add(panelViewEntretien, "Entretien");
		panelViewEntretien.setLayout(null);
		
		JLabel lblEntretien = new JLabel("Gestion des fiches d'entretien");
		lblEntretien.setBounds(130, 30, 299, 50);
		panelViewEntretien.add(lblEntretien);
		lblEntretien.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		btnAddMaintenance = new JButton("Ajouter");
		btnAddMaintenance.addActionListener(new RobotEvent(robotController));
		btnAddMaintenance.setBounds(80, 90, 90, 28);
		panelViewEntretien.add(btnAddMaintenance);
		
		btnModifyMaintenance = new JButton("Modifier");
		btnModifyMaintenance.addActionListener(new RobotEvent(robotController));
		btnModifyMaintenance.setBounds(220, 90, 90, 28);
		panelViewEntretien.add(btnModifyMaintenance);
		
		btnDeleteMaintenance = new JButton("Supprimer");
		btnDeleteMaintenance.addActionListener(new RobotEvent(robotController));
		btnDeleteMaintenance.setBounds(360, 90, 90, 28);
		panelViewEntretien.add(btnDeleteMaintenance);
		
		JLabel lblListeDesFiches = new JLabel("Liste des fiches d'entretien");
		lblListeDesFiches.setBounds(50, 130, 158, 16);
		panelViewEntretien.add(lblListeDesFiches);
		
		JScrollPane scrollPane_Entretien = new JScrollPane();
		scrollPane_Entretien.setBounds(50, 150, 460, 220);
		panelViewEntretien.add(scrollPane_Entretien);
		
		tableEntretien = new JTable();
		tableEntretien.setModel(new DefaultTableModel(
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
				"Date", "Utilisateur", "Robot", "D\u00E9tails"
			}
		));
		scrollPane_Entretien.setViewportView(tableEntretien);
		
		JPanel panelAddEntretien = new JPanel();
		Entretien.add(panelAddEntretien, "AddEntretien");
		panelAddEntretien.setLayout(null);
		
		JLabel lblEntretien_1 = new JLabel("Entretien");
		lblEntretien_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblEntretien_1.setBounds(210, 30, 130, 50);
		panelAddEntretien.add(lblEntretien_1);
		
		JLabel lblDate_1 = new JLabel("Date Pr\u00E9vue :");
		lblDate_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate_1.setBounds(281, 104, 76, 16);
		panelAddEntretien.add(lblDate_1);
		
		JDateChooser dateChooser_PrevEnt = new JDateChooser();
		dateChooser_PrevEnt.setDateFormatString("dd/MM/yyyy");
		dateChooser_PrevEnt.setBounds(369, 99, 173, 28);
		panelAddEntretien.add(dateChooser_PrevEnt);
		
		JLabel lblNewLabel_1 = new JLabel("Utilisateur :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(6, 207, 68, 16);
		panelAddEntretien.add(lblNewLabel_1);
		
		JComboBox comboBox_UserEnt = new JComboBox();
		comboBox_UserEnt.setBounds(89, 201, 180, 28);
		panelAddEntretien.add(comboBox_UserEnt);
		
		JLabel lblRobot = new JLabel("Robot :");
		lblRobot.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRobot.setBounds(19, 257, 55, 16);
		panelAddEntretien.add(lblRobot);
		
		JLabel lblDtails = new JLabel("Intitul\u00E9 :");
		lblDtails.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDtails.setBounds(19, 107, 55, 16);
		panelAddEntretien.add(lblDtails);
		
		JComboBox comboBox_RobotEnt = new JComboBox();
		comboBox_RobotEnt.setBounds(89, 252, 180, 28);
		panelAddEntretien.add(comboBox_RobotEnt);
		
		textField_detailEnt = new JTextField();
		textField_detailEnt.setBounds(89, 101, 180, 28);
		panelAddEntretien.add(textField_detailEnt);
		textField_detailEnt.setColumns(10);
				
		JLabel lblType_1 = new JLabel("Type :");
		lblType_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType_1.setBounds(19, 157, 55, 16);
		panelAddEntretien.add(lblType_1);
		
		JComboBox comboBox_TypeEnt = new JComboBox();
		comboBox_TypeEnt.setBounds(89, 152, 180, 28);
		panelAddEntretien.add(comboBox_TypeEnt);
		
		JLabel lblDateDbut = new JLabel("Date D\u00E9but :");
		lblDateDbut.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateDbut.setBounds(281, 157, 76, 16);
		panelAddEntretien.add(lblDateDbut);
		
		JDateChooser dateChooser_DebEnt = new JDateChooser();
		dateChooser_DebEnt.setEnabled(false);
		dateChooser_DebEnt.setDateFormatString("dd/MM/yyyy");
		dateChooser_DebEnt.setBounds(369, 152, 173, 28);
		panelAddEntretien.add(dateChooser_DebEnt);
		
		JLabel lblDateFin = new JLabel("Date fin :");
		lblDateFin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateFin.setBounds(281, 206, 76, 16);
		panelAddEntretien.add(lblDateFin);
		
		JDateChooser dateChooser_FinEnt = new JDateChooser();
		dateChooser_FinEnt.setDateFormatString("dd/MM/yyyy");
		dateChooser_FinEnt.setEnabled(false);
		dateChooser_FinEnt.setBounds(369, 201, 173, 28);
		panelAddEntretien.add(dateChooser_FinEnt);
		
		JCheckBox chckbxTermine = new JCheckBox("Termin\u00E9");
		chckbxTermine.setEnabled(false);
		chckbxTermine.setBounds(369, 241, 104, 18);
		panelAddEntretien.add(chckbxTermine);
		
		btnAnnulerEntretien = new JButton("");
		btnAnnulerEntretien.addActionListener(new RobotEvent(robotController));
		btnAnnulerEntretien.setIcon(new ImageIcon(RobotView.class.getResource("/img/return.png")));
		btnAnnulerEntretien.setSelected(true);
		btnAnnulerEntretien.setForeground(SystemColor.menu);
		btnAnnulerEntretien.setContentAreaFilled(false);
		btnAnnulerEntretien.setBorderPainted(false);
		btnAnnulerEntretien.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAnnulerEntretien.setBackground(SystemColor.menu);
		btnAnnulerEntretien.setAlignmentX(0.5f);
		btnAnnulerEntretien.setBounds(494, 305, 48, 48);
		panelAddEntretien.add(btnAnnulerEntretien);
		
		btnValiderEntretien = new JButton("");
		btnValiderEntretien.addActionListener(new RobotEvent(robotController));
		btnValiderEntretien.setIcon(new ImageIcon(RobotView.class.getResource("/img/Check.png")));
		btnValiderEntretien.setSelected(true);
		btnValiderEntretien.setContentAreaFilled(false);
		btnValiderEntretien.setBorderPainted(false);
		btnValiderEntretien.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnValiderEntretien.setBounds(416, 305, 48, 48);
		panelAddEntretien.add(btnValiderEntretien);
		
		Configuration = new JPanel();
		tabbedPane.addTab(html1 + "Configuration</body></html>", null, Configuration, null);
		cl_Configuration = new CardLayout(0, 0);		
		Configuration.setLayout(cl_Configuration);
		
		JPanel RecapUser = new JPanel();
		Configuration.add(RecapUser, "listeUser");
		RecapUser.setLayout(null);
		
		JLabel lblTitleConfig = new JLabel("Gestion des utilisateurs");
		lblTitleConfig.setBounds(150, 30, 225, 50);
		RecapUser.add(lblTitleConfig);
		lblTitleConfig.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		btnAddUser = new JButton("Ajouter");
		btnAddUser.addActionListener(new RobotEvent(robotController));
		btnAddUser.setBounds(80, 90, 90, 28);
		RecapUser.add(btnAddUser);
		
		btnModifyUser = new JButton("Modifier");
		btnModifyUser.addActionListener(new RobotEvent(robotController));
		btnModifyUser.setBounds(220, 90, 90, 28);
		RecapUser.add(btnModifyUser);
		
		btnDeleteUser = new JButton("Supprimer");
		btnDeleteUser.addActionListener(new RobotEvent(robotController));
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
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nom", "Login", "Password", "Email", "Droit"
			}
		));
		scrollPane_Users.setViewportView(tableUsers);
		
		JPanel InfoUser = new JPanel();
		Configuration.add(InfoUser, "modifyUser");
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
		
		btnValiderUser = new JButton("");
		btnValiderUser.addActionListener(new RobotEvent(robotController));
		btnValiderUser.setIcon(new ImageIcon(RobotView.class.getResource("/img/Check.png")));
		btnValiderUser.setSelected(true);
		btnValiderUser.setContentAreaFilled(false);
		btnValiderUser.setBorderPainted(false);
		btnValiderUser.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnValiderUser.setBounds(406, 224, 48, 48);
		InfoUser.add(btnValiderUser);
		
		btnAnnulerUser = new JButton("");
		btnAnnulerUser.addActionListener(new RobotEvent(robotController));
		btnAnnulerUser.setIcon(new ImageIcon(RobotView.class.getResource("/img/return.png")));
		btnAnnulerUser.setSelected(true);
		btnAnnulerUser.setForeground(SystemColor.menu);
		btnAnnulerUser.setContentAreaFilled(false);
		btnAnnulerUser.setBorderPainted(false);
		btnAnnulerUser.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAnnulerUser.setBackground(SystemColor.menu);
		btnAnnulerUser.setAlignmentX(0.5f);
		btnAnnulerUser.setBounds(484, 224, 48, 48);
		InfoUser.add(btnAnnulerUser);
		
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
				"Date", "Utilisateur", "D\u00E9tails"
			}
		));
		scrollPane.setViewportView(tableAction);
		contentPane.add(tabbedPane);
		
		
	    int index = tabbedPane.getTabCount() - 1;
	    System.out.println(index);
	    
	    for(int i=0; i<=index;i++){
		    // Determine whether the tab is enabled
		    boolean enabled = tabbedPane.isEnabledAt(i);

		    // Disable the tab
		    tabbedPane.setEnabledAt(i, false);	
	    }
		
//>>>>>>> refs/heads/viewBuilder
	}
	
	public JLabel getLblWarningAccueil() {
		return lblWarningAccueil;
	}

	public void setLblWarningAccueil(JLabel lblWarningAccueil) {
		this.lblWarningAccueil = lblWarningAccueil;
	}

	public JButton getBtnMotDePasse() {
		return btnMotDePasse;
	}

	public void setBtnMotDePasse(JButton btnMotDePasse) {
		this.btnMotDePasse = btnMotDePasse;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}

	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
	
	public void afficherMessage(String title, String msg)
	{	
		JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);		
	}
	
	public String getLogin()
	{
		return textFieldLogin.getText().toString();
	}
	
	/**
	 * @return cl_Accueil
	 */
	public CardLayout getCl_Accueil() {
		return cl_Accueil;
	}

	/**
	 * @param cl_Accueil
	 */
	public void setCl_Accueil(CardLayout cl_Accueil) {
		this.cl_Accueil = cl_Accueil;
	}

	/**
	 * @return Accueil
	 */
	public JPanel getAccueil() {
		return Accueil;
	}

	/**
	 * @param accueil
	 */
	public void setAccueil(JPanel accueil) {
		Accueil = accueil;
	}

	/**
	 * @return btnDeconnecter
	 */
	public JButton getBtnDeconnecter() {
		return btnDeconnecter;
	}

	/**
	 * @return the btnAddRobot
	 */
	public JButton getBtnAddRobot() {
		return btnAddRobot;
	}

	/**
	 * @return the btnModifyRobot
	 */
	public JButton getBtnModifyRobot() {
		return btnModifyRobot;
	}

	/**
	 * @return the btnDeleteRobot
	 */
	public JButton getBtnDeleteRobot() {
		return btnDeleteRobot;
	}

	/**
	 * @return the textFieldPassword
	 */
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}

	/**
	 * @param textFieldPassword the textFieldPassword to set
	 */
	public void setTextFieldPassword(JPasswordField textFieldPassword) {
		this.textFieldPassword = textFieldPassword;
	}

	/**
	 * @return the contentPane
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * @return the textFieldLogin
	 */
	public JTextField getTextFieldLogin() {
		return textFieldLogin;
	}

	/**
	 * @return the tablePlanning
	 */
	public JTable getTablePlanning() {
		return tablePlanning;
	}

	/**
	 * @return the tableEntretien
	 */
	public JTable getTableEntretien() {
		return tableEntretien;
	}

	/**
	 * @return the textField_NInterne
	 */
	public JTextField getTextField_NInterne() {
		return textField_NInterne;
	}

	/**
	 * @return the textField_Emplacement
	 */
	public JTextField getTextField_Emplacement() {
		return textField_Emplacement;
	}

	/**
	 * @return the textField_NSerie
	 */
	public JTextField getTextField_NSerie() {
		return textField_NSerie;
	}

	/**
	 * @return the tableEvent
	 */
	public JTable getTableEvent() {
		return tableEvent;
	}

	/**
	 * @return the tableTask
	 */
	public JTable getTableTask() {
		return tableTask;
	}

	/**
	 * @return the tableUsers
	 */
	public JTable getTableUsers() {
		return tableUsers;
	}

	/**
	 * @return the textField_Name
	 */
	public JTextField getTextField_Name() {
		return textField_Name;
	}

	/**
	 * @return the textField_Login
	 */
	public JTextField getTextField_Login() {
		return textField_Login;
	}

	/**
	 * @return the textField_PwUser
	 */
	public JTextField getTextField_PwUser() {
		return textField_PwUser;
	}

	/**
	 * @return the textField_Email
	 */
	public JTextField getTextField_Email() {
		return textField_Email;
	}

	/**
	 * @return the tableAction
	 */
	public JTable getTableAction() {
		return tableAction;
	}

	/**
	 * @return the tableRobots
	 */
	public JTable getTableRobots() {
		return tableRobots;
	}

	/**
	 * @return the textField_Descriptif
	 */
	public JTextField getTextField_Descriptif() {
		return textField_Descriptif;
	}

	/**
	 * @return the textField_detailEnt
	 */
	public JTextField getTextField_detailEnt() {
		return textField_detailEnt;
	}

	/**
	 * @return the textField_Lieu
	 */
	public JTextField getTextField_Lieu() {
		return textField_Lieu;
	}

	/**
	 * @return the gRobots
	 */
	public JPanel getGRobots() {
		return GRobots;
	}

	/**
	 * @return the cl_GRobots
	 */
	public CardLayout getCl_GRobots() {
		return cl_GRobots;
	}

	/**
	 * @return the planning
	 */
	public JPanel getPlanning() {
		return Planning;
	}

	/**
	 * @return the configuration
	 */
	public JPanel getConfiguration() {
		return Configuration;
	}

	/**
	 * @return the cl_Planning
	 */
	public CardLayout getCl_Planning() {
		return cl_Planning;
	}

	/**
	 * @return the entretien
	 */
	public JPanel getEntretien() {
		return Entretien;
	}

	/**
	 * @return the cl_Entretien
	 */
	public CardLayout getCl_Entretien() {
		return cl_Entretien;
	}

	/**
	 * @return the cl_Configuration
	 */
	public CardLayout getCl_Configuration() {
		return cl_Configuration;
	}

	/**
	 * @return the html1
	 */
	public String getHtml1() {
		return html1;
	}

	/**
	 * @return the btnValiderRobot
	 */
	public JButton getBtnValiderRobot() {
		return btnValiderRobot;
	}

	/**
	 * @return the btnAnnulerRobot
	 */
	public JButton getBtnAnnulerRobot() {
		return btnAnnulerRobot;
	}

	/**
	 * @return the btnAddTask
	 */
	public JButton getBtnAddTask() {
		return btnAddTask;
	}

	/**
	 * @return the btnModifyTask
	 */
	public JButton getBtnModifyTask() {
		return btnModifyTask;
	}

	/**
	 * @return the btnDeleteTask
	 */
	public JButton getBtnDeleteTask() {
		return btnDeleteTask;
	}

	/**
	 * @return the btnAnnulerEvt
	 */
	public JButton getBtnAnnulerEvt() {
		return btnAnnulerEvt;
	}

	/**
	 * @return the btnValiderEvt
	 */
	public JButton getBtnValiderEvt() {
		return btnValiderEvt;
	}

	/**
	 * @return the btnAddMaintenance
	 */
	public JButton getBtnAddMaintenance() {
		return btnAddMaintenance;
	}

	/**
	 * @return the btnModifyMaintenance
	 */
	public JButton getBtnModifyMaintenance() {
		return btnModifyMaintenance;
	}

	/**
	 * @return the btnDeleteMaintenance
	 */
	public JButton getBtnDeleteMaintenance() {
		return btnDeleteMaintenance;
	}

	/**
	 * @return the btnAnnulerEntretien
	 */
	public JButton getBtnAnnulerEntretien() {
		return btnAnnulerEntretien;
	}

	/**
	 * @return the btnValiderEntretien
	 */
	public JButton getBtnValiderEntretien() {
		return btnValiderEntretien;
	}

	/**
	 * @return the btnAddUser
	 */
	public JButton getBtnAddUser() {
		return btnAddUser;
	}

	/**
	 * @return the btnModifyUser
	 */
	public JButton getBtnModifyUser() {
		return btnModifyUser;
	}

	/**
	 * @return the btnDeleteUser
	 */
	public JButton getBtnDeleteUser() {
		return btnDeleteUser;
	}

	/**
	 * @return the btnValiderUser
	 */
	public JButton getBtnValiderUser() {
		return btnValiderUser;
	}

	/**
	 * @return the btnAnnulerUser
	 */
	public JButton getBtnAnnulerUser() {
		return btnAnnulerUser;
	}

	/**
	 * @return the tabbedPane
	 */
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	/**
	 * @return the comboBox_Marque
	 */
	public JComboBox getComboBox_Marque() {
		return comboBox_Marque;
	}

	/**
	 * @return the comboBox_Color
	 */
	public JComboBox getComboBox_Color() {
		return comboBox_Color;
	}

	/**
	 * @return the chckbxEtat
	 */
	public JCheckBox getChckbxEtat() {
		return chckbxEtat;
	}

	/**
	 * @return the lblWarningRobot
	 */
	public JLabel getLblWarningRobot() {
		return lblWarningRobot;
	}
}
