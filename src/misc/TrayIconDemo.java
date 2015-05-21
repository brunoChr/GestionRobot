
package misc;  
/*
 * TrayIconDemo.java
 */

import gestion.RobotController;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;



/**
 * @author b.christol
 *
 */
public class TrayIconDemo {
    
	static RobotController _robotController;
    private static final java.awt.TrayIcon trayIcon = new java.awt.TrayIcon(createImage("../img/staubli16.png", "tray icon"));
    
    /**
	 * @param rc
	 */
	public TrayIconDemo(RobotController rc) {
		// TODO Auto-generated constructor stub
		TrayIconDemo._robotController = rc;
	}
	

	/**
     *  Créer la popup dans le systray
     */
    private static void createAndShowGUI() {
    	
        //Check the SystemTray support
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported");
            return;
        }
        
        final PopupMenu popup = new PopupMenu();

        final SystemTray tray = SystemTray.getSystemTray();
        
        // Create a popup menu components
        MenuItem aboutItem = new MenuItem("About");
        Menu displayMenu = new Menu("Display");
        MenuItem errorItem = new MenuItem("Error");
        MenuItem warningItem = new MenuItem("Warning");
        MenuItem infoItem = new MenuItem("Info");
        MenuItem noneItem = new MenuItem("None");
        MenuItem exitItem = new MenuItem("Exit");
        
        //Add components to popup menu
        popup.add(aboutItem);
        popup.addSeparator();
        popup.addSeparator();
        popup.add(displayMenu);
        displayMenu.add(errorItem);
        displayMenu.add(warningItem);
        displayMenu.add(infoItem);
        displayMenu.add(noneItem);
        popup.add(exitItem);
        
        trayIcon.setPopupMenu(popup);
        trayIcon.setToolTip("Gestion de robots");
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("TrayIcon could not be added.");
            return;
        }
        
        trayIcon.addActionListener(new trayIconActionListener());
        
        aboutItem.addActionListener(new ActionListener() {
            /* (non-Javadoc)
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Logiciel de gestion de parc de robots");
            }
        });
        
        
        ActionListener listener = new ActionListener() {
            /* (non-Javadoc)
             * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            public void actionPerformed(ActionEvent e) {
                MenuItem item = (MenuItem)e.getSource();
                //TrayIcon.MessageType type = null;
                System.out.println(item.getLabel());
                if ("Error".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.ERROR;
                    trayIcon.displayMessage("Gestion de robots",
                            "This is an error message", java.awt.TrayIcon.MessageType.ERROR);
                    
                } else if ("Warning".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.WARNING;
                    trayIcon.displayMessage("Gestion de robots",
                            "Vous devriez prévoir une maintenance pour le robot n°45", java.awt.TrayIcon.MessageType.WARNING);
                    
                } else if ("Info".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.INFO;
                    trayIcon.displayMessage("Gestion de robots",
                            "This is an info message", java.awt.TrayIcon.MessageType.INFO);
                    
                } else if ("None".equals(item.getLabel())) {
                    //type = TrayIcon.MessageType.NONE;
                    trayIcon.displayMessage("Gestion de robots",
                            "This is an ordinary message", java.awt.TrayIcon.MessageType.NONE);
                }
            }
        };
        
        errorItem.addActionListener(listener);
        warningItem.addActionListener(listener);
        infoItem.addActionListener(listener);
        noneItem.addActionListener(listener);
        
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tray.remove(trayIcon);
                //System.exit(0);
                
                System.out.println("Quit the programm");
        		_robotController.quitter();
            }
        });
    }
    
    
    /**
     * Obtain the image URL
     * 
     * @param path
     * @param description
     * @return
     */
    protected static Image createImage(String path, String description) {
        URL imageURL = TrayIconDemo.class.getResource(path);
        
        if (imageURL == null) {
            System.err.println("Resource not found: " + path);
            return null;
        } else {
            return (new ImageIcon(imageURL, description)).getImage();
        }
    }
    
    /**
     *	Créer le popup dans le systray
     */
    public void start()
    {
    	createAndShowGUI();
    }
    
    
    public void affInfoNotif(String message) {
    	
        trayIcon.displayMessage("Gestion de robots",
        		message, java.awt.TrayIcon.MessageType.INFO);
	}
    

	
	/**
	 * Quand on double clique sur l'icone
	 * 
	 * @author b.christol
	 *
	 */
	private static class trayIconActionListener implements ActionListener {
		/* (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		public void actionPerformed(ActionEvent arg0) {
			
			// Si la fenetre est minimiser -> on maximise
			if(_robotController.get_robotView().getState() == _robotController.get_robotView().NORMAL){
			System.out.println("On restaure la fenetre");
			_robotController.get_robotView().setState(_robotController.get_robotView().NORMAL);
			_robotController.get_robotView().setVisible(true);
			}
		}
	}


	/**
	 * @return the trayicon
	 */
	public static java.awt.TrayIcon getTrayicon() {
		return trayIcon;
	}
}
