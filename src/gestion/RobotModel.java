package gestion;
/**
 * 
 */


import java.sql.*;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author b.christol
 *
 */


public class RobotModel {

	private Connection _conn;

	
	/**
	 * 
	 */
	public RobotModel() {

		String nomUser = "bruno"; // Utilisateur de la BD
		String passwd = "Bruno@1552"; // Password de l'utilisateur de la BD
		String url = "jdbc:mysql://LISA-7336/"; // Serveur de la BD
		String nomBase = "gestion_robot"; // Nom de la BD sur laquelle nous allons accÃ©der
		
		_conn = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			_conn=DriverManager.getConnection(url+nomBase, nomUser, passwd);
			System.out.println("Log: connected to database " + nomBase);
		}

		catch (SQLException ex1)
		{
			System.out.println("Error: erreur de type SQL: " + ex1.getMessage());
		}
		
		catch (Exception ex2)
		{
			System.out.println("Error: erreur de type lang: " + ex2.getMessage());
		}	
	}

	public void fermerConnexion()
	{
		try
		{
			if (_conn != null)
				this._conn.close();
		}
		catch (SQLException ex1)
		{
			System.out.println("Error: erreur de type SQL: " + ex1.getMessage());
		}
	}

	public boolean estValide(String login, String mdp)
	{
		boolean trouve=false;
		try
		{
			String requete = new String("SELECT id, name, login FROM user WHERE login=? AND password=MD5(?);");
			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, login);
			stmt.setString(2, mdp);
			ResultSet rs = stmt.executeQuery();

			if (rs.next ())
			{
				trouve = true;
			}		
			
			rs.close();
			stmt.close();
		} 

		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();			
			}	
		}     
		return trouve;
	}
	
	public String oubliMP(String login)
	{

		try
		{
			String requete = new String("SELECT id, name, login,password FROM user where login=?;"); //AND mdp=MD5(?)
			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, login);
			//stmt.setString(2, mdp);
			ResultSet rs = stmt.executeQuery();
			
			//On récupère les MetaData
		    //ResultSetMetaData resultMeta = rs.getMetaData();
		      
			if (rs.next ())
			{
				return rs.getString("password");
			}		
			
			rs.close();
			stmt.close();
		} 

		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();			
			}	
		}
		return null;
	}
	
	/**
	 * Test si un élément est contenu dans une table
	 * @param table
	 * @param element
	 * @return 
	 */
	public boolean ifExistInTable(String table, String row, String element) {
		try
		{
			String requete = new String("SELECT id FROM "+ table +" WHERE "+ row +"=?;");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, element);

			System.out.println(requete);
			ResultSet rs = stmt.executeQuery();

			if (rs.next())
			{
				if(rs.getBoolean(1)) {
					System.out.println(rs.getBoolean(1));
					return true;
				}
				else return false;
			}		
			
			rs.close();
			stmt.close();
		} 

		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();			
			}	
		}
		return false;
	}
	
	/**
	 * Remplit un tableau spécifié en paramétre avec une table en bdd
	 * 
	 * @param table
	 * @param Query
	 */
	public void remplirTable(JTable table, String Query) {
		
		try {  	
			//String requete = new String("SELECT * FROM utilisateur;");
			PreparedStatement stmt = _conn.prepareStatement(Query);
	        ResultSet rs = stmt.executeQuery(Query);
		    ResultSetMetaData resultMeta = rs.getMetaData();
		    System.out.println(Query);
		    
	        int columns = resultMeta.getColumnCount();
	        String[] headers;

			headers = new String[columns];
			for (int h = 1; h <= columns; h++) 
			{
				headers[h - 1] = resultMeta.getColumnName(h);
			}
		      
		    //To remove previously added rows
	        while(table.getRowCount() > 0) 
	        {
	            ((DefaultTableModel) table.getModel()).removeRow(0);
	        }

	        while(rs.next())
	        {  
	            Object[] row = new Object[columns];
	            for (int i = 1; i <= columns; i++)
	            {  
	                row[i - 1] = rs.getObject(i);
	            }
	            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
	        }
	      }
		
	      catch(SQLException e)
	      {  
	    	  System.out.println("Error " + e);
	      }		
	}
	
	
    /**
     * Ajoute des robots dans la bdd
     * 
     * @param identifier
     * @param brand
     * @param color
     * @param location
     * @param time_use
     * @param serial
     * @param state
     * 
     * @author b.christol
     */
	
    public void insererRobot(String identifier, String brand, String color, String location, java.util.Date time_use, String serial, Boolean state)
	{	
    	try
		{	
			String requete = new String("INSERT INTO robot (`id`, `identifier`, `brand`, `color`, `location`,`time_use`,`serial_id`,`state` ) VALUES (NULL, ? , ? , ? , ?, NOW(), ?, ?);");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, identifier);
			stmt.setString(2, brand);
			stmt.setString(3, color);
			stmt.setString(4, location);
			//stmt.setDate(5, time_use);
			stmt.setString(5, serial);
			stmt.setBoolean(6, state);

			System.out.println(stmt.toString());

			stmt.executeUpdate(); 
						
		}
				
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}				
	}
    
    public void supprimerRobot(String id)
	{	
    	try
		{	
			String requete = new String("DELETE FROM `robot` WHERE `robot`.`identifier` =?;");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, id);

			System.out.println(stmt.toString());

			stmt.executeUpdate(); 
						
		}
				
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}				
	}

	/**
	 * Modifie un robot sélectionné dans la bdd
	 * 
	 * @param identifier
	 * @param brand
	 * @param color
	 * @param location
	 * @param serial_id
	 * @param state
	 */
	public void modifierRobot(String identifier, String brand, String color, String location, String serial, Boolean state) {
		// TODO Auto-generated method stub
    	try
		{	
    		String requete = new String("UPDATE `gestion_robot`.`robot` SET brand = ?, color = ?, location = ?, serial_id = ?, state = ? WHERE `robot`.`identifier` = ?;");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, brand);
			stmt.setString(2, color);
			stmt.setString(3, location);
			stmt.setString(4, serial);
			stmt.setBoolean(5, state);
			stmt.setString(6, identifier);

			System.out.println(stmt.toString());

			stmt.executeUpdate(); 
						
		}
				
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}			
	}
	
	
	public void refreshRobot(JTable table)
	{
		// On rafraichie le tableau des robots
		remplirTable(table, "SELECT identifier, brand, color, location, time_use, serial_id, state  FROM robot;");
	}
	
	
    /**
     * @param descriptif
     * @param date
     * @param lieu
     * @param type
     * 
     * @author b.christol
     */
    public void insererEvent(String descriptif, java.util.Date date, String lieu, String type, String connectedUser)
	{	
    	try
		{	
			String requete = new String("INSERT INTO event (`id`, `name`, `date`, `place`, `type`) VALUES (LAST_INSERT_ID(), ? ,NOW() , ? , ?);");

			PreparedStatement stmt = _conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, descriptif);
			//stmt.setDate(2, new java.sql.Date(date.getDate()));
			stmt.setString(2, lieu);
			stmt.setString(3, type);

			// on affiche la requete
			System.out.println("insererEvent : " + stmt.toString());

			stmt.executeUpdate(); 
			
			ResultSet idEvent = stmt.getGeneratedKeys();    

			idEvent.next();  
			int idTaskKeys = idEvent.getInt(1);
			System.out.println("Id returner : " + idTaskKeys);
			
			try
			{	
				String requete2 = new String("INSERT INTO user_has_event (`user_id`, `event_id`) VALUES (?, ?);");
			
				PreparedStatement stmt2 = _conn.prepareStatement(requete2);
				stmt2.setInt(1, getIdUser(connectedUser));
				stmt2.setInt(2, idTaskKeys);
		
				// on affiche la requete
				System.out.println("insererUserHasEvent : " + stmt2.toString());
			
				stmt2.executeUpdate(); 
			}
			catch (SQLException ex4)
			{
				while (ex4 !=null)
				{
					System.out.println(ex4.getSQLState());
					System.out.println(ex4.getMessage());
					System.out.println(ex4.getErrorCode());
					ex4=ex4.getNextException();
				}
			} 

		}
				
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}

	}
    
    
  
    /**
     * @param user
     * @return
     * 
     * @author b.christol
     */
    public int getIdUser(String user) {
    	
    	try
		{	
			String requete = new String("SELECT `id` FROM user WHERE `login`=?;");
		
			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, user);

			// on affiche la requete
			System.out.println("getIdUser query : " + stmt.toString());
			
			ResultSet rs = stmt.executeQuery();
			
	        while(rs.next())
	        {  	
	        	return rs.getInt("id");
	        }
	        
			rs.close();
			stmt.close();
		}
    	
    	
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}
		return 0;
  	}
    
    
    /**
     * @param Nametask
     * @return
     * 
     * @author b.christol
     */
    public int getIdTask(String Nametask) {
    	
    	try
		{	
			String requete = new String("SELECT `id` FROM event WHERE `name`=?;");
		
			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, Nametask);

			// on affiche la requete
			System.out.println("getIdTask query : " + stmt.toString());
			
			ResultSet rs = stmt.executeQuery();
			
	        while(rs.next())
	        {  	
	        	return rs.getInt("id");
	        }
	        
			rs.close();
			stmt.close();
		}
    	
    	
		catch (SQLException ex4)
		{
			while (ex4 !=null)
			{
				System.out.println(ex4.getSQLState());
				System.out.println(ex4.getMessage());
				System.out.println(ex4.getErrorCode());
				ex4=ex4.getNextException();
			}
		}
    	
		return 0;
    }

	/**
	 * @param descriptif
	 * @param date
	 * @param lieu
	 * @param type
	 */
	public void modifierEvent(String name, java.util.Date date, String place,String type) {
		// TODO Auto-generated method stub
	   	try
			{	
	    		String requete = new String("UPDATE `gestion_robot`.`event` SET date = ?, place = ?, type = ? WHERE `name` = ?;");

				PreparedStatement stmt = _conn.prepareStatement(requete);
				stmt.setDate(1, (java.sql.Date)date);
				stmt.setString(2, place);
				stmt.setString(3, type);
				
				System.out.println(stmt.toString());

				stmt.executeUpdate(); 
							
			}
					
			catch (SQLException ex4)
			{
				while (ex4 !=null)
				{
					System.out.println(ex4.getSQLState());
					System.out.println(ex4.getMessage());
					System.out.println(ex4.getErrorCode());
					ex4=ex4.getNextException();
				}
			}		
	}
}
