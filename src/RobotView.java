

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class RobotView extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public RobotView(RobotController robotController) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	public void afficher(boolean visible)
    {
        this.setVisible(visible);
    }
}
