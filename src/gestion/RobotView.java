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
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
		JPanel Acceuil = new JPanel();
		tabbedPane.addTab(html1 + "Acceuil</body></html>", null, Acceuil, null);
		Acceuil.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(140, 175, 31, 16);
		Acceuil.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(240, 169, 122, 28);
		Acceuil.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 219, 56, 16);
		Acceuil.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 213, 122, 28);
		Acceuil.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnMotDePasse = new JButton("Mot de passe oubli\u00E9");
		btnMotDePasse.setBounds(110, 274, 139, 28);
		Acceuil.add(btnMotDePasse);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(280, 274, 122, 28);
		Acceuil.add(btnValider);
		
		JLabel lblNewLabel = new JLabel("Bienvenue sur votre platforme de gestion");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblNewLabel.setBounds(80, 60, 402, 50);
		Acceuil.add(lblNewLabel);
		
		JPanel GRobots = new JPanel();
		tabbedPane.addTab(html1 + "Gestion Robots</body></html>", null, GRobots, null);
		GRobots.setLayout(null);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(80, 90, 90, 28);
		GRobots.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(220, 90, 90, 28);
		GRobots.add(btnNewButton_1);
		
		JLabel lblGestionDuParc = new JLabel("Gestion du parc de robots");
		lblGestionDuParc.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblGestionDuParc.setBounds(130, 30, 259, 50);
		GRobots.add(lblGestionDuParc);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(360, 90, 90, 28);
		GRobots.add(btnNewButton_2);
		
		table = new JTable();
		table.setBounds(50, 140, 440, 220);
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
		contentPane.add(tabbedPane);
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
