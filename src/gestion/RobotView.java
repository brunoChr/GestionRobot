package gestion;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RobotView extends JFrame {

	private JPanel contentPane;
	private String html1 = "<html><body leftmargin=30 topmargin=15 marginwidth=6 marginheight=19>";
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

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
		
		JPanel Accueil = new JPanel();
		tabbedPane.addTab(html1 + "Accueil</body></html>", null, Accueil, null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(140, 175, 31, 16);
		
		textField = new JTextField();
		textField.setBounds(240, 169, 122, 28);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 219, 56, 16);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 213, 122, 28);
		textField_1.setColumns(10);
		
		JButton btnMotDePasse = new JButton("Mot de passe oubli\u00E9");
		btnMotDePasse.setBounds(110, 274, 139, 28);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(280, 274, 122, 28);
		Accueil.setLayout(null);
		
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
		
		JPanel GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(80, 90, 90, 28);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(220, 90, 90, 28);
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
		lblGestionDuParc.setBounds(130, 30, 259, 50);
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(360, 90, 90, 28);
		
		table = new JTable();
		table.setBounds(50, 140, 440, 220);
		GRobots.setLayout(null);
		GRobots.add(lblGestionDuParc);
		GRobots.add(btnNewButton);
		GRobots.add(btnNewButton_1);
		GRobots.add(btnNewButton_2);
		GRobots.add(table);
		
		JPanel Planning = new JPanel();
		tabbedPane.addTab(html1 + "Planning</body></html>", null, Planning, null);
		Planning.setLayout(null);
		
		JPanel Entretien = new JPanel();
		tabbedPane.addTab(html1 + "Fiches d'entretien</body></html>", null, Entretien, null);
		
		JPanel Configuration = new JPanel();
		tabbedPane.addTab(html1 + "Configuration</body></html>", null, Configuration, null);
		
		JPanel Historique = new JPanel();
		tabbedPane.addTab(html1 + "Historique</body></html>", null, Historique, null);
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
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
