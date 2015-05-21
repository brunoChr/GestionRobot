package gestion;
/**
 * 
 */


import it.sauronsoftware.junique.AlreadyLockedException;
import it.sauronsoftware.junique.JUnique;
import it.sauronsoftware.junique.MessageHandler;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import misc.TrayIconDemo;

/**
 * @author b.christol
 *
 */
public class RobotRun {

	private static TrayIconDemo Ti;

	/**
	 * Launch the application.
	 */
	/**
	 * @param args
	 * @return none
	 */
	public static void main(String[] args) {
		
		// Déclaration de l'id de l'application
		String appId = "gestionRobot";
		boolean alreadyRunning;

		
		// Test si une instance de Jframe est déja lancé
		try {
			JUnique.acquireLock(appId, new MessageHandler() {
				public String handle(String message) {
					// A brand new argument received! Handle it!
					return null;
				}
			});
			
			alreadyRunning = false;
		} catch (AlreadyLockedException e) {
			alreadyRunning = true;
		}
		
		// Si aucun Jframe instancié
		if (!alreadyRunning) {

			System.out.println("Aucun Jframe lancé !");
			// On lance notre programme
			try {
				UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
				//"javax.swing.plaf.nimbus.NimbusLookAndFeel"
				//"com.seaglasslookandfeel.SeaGlassLookAndFeel"
				//"com.alee.laf.WebLookAndFeel"
				//"com.pagosoft.plaf.PgsLookAndFeel"
				//"com.oyoaha.swing.plaf.oyoaha.OyoahaLookAndFeel"
				//"com.birosoft.liquid.LiquidLookAndFeel" 
			} catch (Throwable e) {
				e.printStackTrace();
			}
			EventQueue.invokeLater(new Runnable() {
				/* (non-Javadoc)
				 * @see java.lang.Runnable#run()
				 */
				public void run() {
					try {
						
						RobotController Rc = new RobotController();
						Rc.start();
						
		                Ti = new TrayIconDemo(Rc);
		                Ti.start();
		                
		                //System.out.println(Rc.get_robotView().getOwnedWindows());
						//System.out.println(java.lang.Runtime.getRuntime().maxMemory());
		                
						//RobotView frame = new RobotView();
						//frame.setVisible(true);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

		} 
		// Sinon on avertit l'utilisateur
		else {
			System.out.println("Déja lancé !!");
			
		    JOptionPane.showMessageDialog(new JFrame(), "Le logiciel de gestion est déja lancé, veuillez le fermez", "Logiciel ouvert détecté",
		            JOptionPane.ERROR_MESSAGE);	
		    
			for (int i = 0; i < args.length; i++) {
				JUnique.sendMessage(appId, args[0]);
			}
		}
	}


	/**
	 * @return the ti
	 */
	public static TrayIconDemo getTi() {
		return Ti;
	}
}
