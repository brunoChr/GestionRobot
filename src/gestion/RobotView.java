package gestion;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnMotDePasse;
	private JButton btnValider;
	private JLabel lblWarningAccueil;

	/**
	 * Create the frame.
	 */
	public RobotView(RobotController robotController) {
		
		/* Ecouteur des événements sur la fenêtre */
		this.addWindowListener(new RobotEvent(robotController));
		
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel Acceuil = new JPanel();
		tabbedPane.addTab(html1 + "Acceuil</body></html>", null, Acceuil, null);
		Acceuil.setLayout(null);
		
		JLabel lblAcceuil = new JLabel("Bienvenue sur votre plateforme de gestion");
		lblAcceuil.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblAcceuil.setBounds(80, 60, 411, 50);
		Acceuil.add(lblAcceuil);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(140, 175, 31, 16);
		Acceuil.add(lblLogin);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(240, 169, 122, 28);
		Acceuil.add(textFieldLogin);
		textFieldLogin.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 219, 88, 16);
		Acceuil.add(lblPassword);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(240, 213, 122, 28);
		Acceuil.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		btnMotDePasse = new JButton("Mot de passe oubli\u00E9");
		btnMotDePasse.setPreferredSize(new Dimension(140, 30));
		btnMotDePasse.setName("btnMotDePasse");
		btnMotDePasse.addActionListener(new RobotEvent(robotController));
		
		btnMotDePasse.setBounds(110, 274, 158, 28);
		Acceuil.add(btnMotDePasse);
		
		btnValider = new JButton("Valider");
		btnValider.setName("btnValider");
		btnValider.addActionListener(new RobotEvent(robotController));
		btnValider.setBounds(280, 274, 122, 28);
		Acceuil.add(btnValider);
		
		lblWarningAccueil = new JLabel("");
		lblWarningAccueil.setVisible(false);
		lblWarningAccueil.setBounds(374, 219, 237, 16);
		Acceuil.add(lblWarningAccueil);
		
		JPanel GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
		GRobots.setLayout(null);
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblGestionDuParc.setBounds(140, 30, 259, 50);
		GRobots.add(lblGestionDuParc);
		
		JButton btnAddRobot = new JButton("Ajouter");
		btnAddRobot.setBounds(80, 90, 90, 28);
		GRobots.add(btnAddRobot);
		
		JButton btnModifyRobot = new JButton("Modifier");
		btnModifyRobot.setBounds(220, 90, 90, 28);
		GRobots.add(btnModifyRobot);
		
		JButton btnDeleteRobot = new JButton("Supprimer");
		btnDeleteRobot.setBounds(360, 90, 90, 28);
		GRobots.add(btnDeleteRobot);
		
		tableRobot = new JTable();
		tableRobot.setBounds(50, 140, 460, 220);
		GRobots.add(tableRobot);
		
		JPanel Planning = new JPanel();
		tabbedPane.addTab(html1 + "Planning</body></html>", null, Planning, null);
		Planning.setLayout(null);
		
		JLabel lblPlanning = new JLabel("Planning de la semaine");
		lblPlanning.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPlanning.setBounds(90, 30, 374, 50);
		Planning.add(lblPlanning);
		
		JButton btnAddTask = new JButton("Ajouter une t\u00E2che");
		btnAddTask.setBounds(50, 90, 143, 28);
		Planning.add(btnAddTask);
		
		JButton btnModifyTask = new JButton("Modifier une t\u00E2che");
		btnModifyTask.setBounds(205, 90, 143, 28);
		Planning.add(btnModifyTask);
		
		JButton btnDeleteTask = new JButton("Supprimer une t\u00E2che");
		btnDeleteTask.setBounds(360, 90, 143, 28);
		Planning.add(btnDeleteTask);
		
		tablePlanning = new JTable();
		tablePlanning.setBounds(50, 140, 460, 220);
		Planning.add(tablePlanning);
		
		JPanel Entretien = new JPanel();
		tabbedPane.addTab(html1 + "Fiches d'entretien</body></html>", null, Entretien, null);
		Entretien.setLayout(null);
		
		JLabel lblEntretien = new JLabel("Gestion des fiches d'entretien");
		lblEntretien.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblEntretien.setBounds(130, 30, 299, 50);
		Entretien.add(lblEntretien);
		
		JButton btnAddMaintenance = new JButton("Ajouter");
		btnAddMaintenance.setBounds(80, 90, 90, 28);
		Entretien.add(btnAddMaintenance);
		
		JButton btnModifyMaintenance = new JButton("Modifier");
		btnModifyMaintenance.setBounds(220, 90, 90, 28);
		Entretien.add(btnModifyMaintenance);
		
		JButton btnDeleteMaintenance = new JButton("Supprimer");
		btnDeleteMaintenance.setBounds(360, 90, 90, 28);
		Entretien.add(btnDeleteMaintenance);
		
		tableEntretien = new JTable();
		tableEntretien.setBounds(50, 140, 460, 220);
		Entretien.add(tableEntretien);
		
		JPanel Configuration = new JPanel();
		tabbedPane.addTab(html1 + "Configuration</body></html>", null, Configuration, null);
		Configuration.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion des utilisateurs");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel_1.setBounds(150, 30, 225, 50);
		Configuration.add(lblNewLabel_1);
		
		JButton btnAddUser = new JButton("Ajouter");
		btnAddUser.setBounds(80, 90, 90, 28);
		Configuration.add(btnAddUser);
		
		JButton btnModifyUser = new JButton("Modifier");
		btnModifyUser.setBounds(220, 90, 90, 28);
		Configuration.add(btnModifyUser);
		
		JButton btnDeleteUser = new JButton("Supprimer");
		btnDeleteUser.setBounds(360, 90, 90, 28);
		Configuration.add(btnDeleteUser);
		
		tableUser = new JTable();
		tableUser.setBounds(50, 140, 460, 220);
		Configuration.add(tableUser);
		
		JPanel Historique = new JPanel();
		tabbedPane.addTab(html1 + "Historique</body></html>", null, Historique, null);
		Historique.setLayout(null);
		
		JLabel lblHistorique = new JLabel("Historique");
		lblHistorique.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblHistorique.setBounds(210, 30, 105, 50);
		Historique.add(lblHistorique);
		
		table = new JTable();
		table.setBounds(50, 140, 460, 220);
		Historique.add(table);
		contentPane.add(tabbedPane);
		
		setSize(new Dimension(800, 450));

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
	
	public void afficherMessage(String msg)
	{	
		JOptionPane.showMessageDialog(this, msg, "Information", JOptionPane.INFORMATION_MESSAGE);		
	}
	
	public String getLogin()
	{
		return textFieldLogin.getText().toString();
	}
	
	public String getPassword()
	{
		return textFieldPassword.getText().toString();
	}
}
