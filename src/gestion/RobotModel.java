package gestion;
/**
 * 
 */


import java.sql.*;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author b.christol
 *
 */


/**
 * @author p.fauny
 *
 */
/**
 * @author p.fauny
 *
 */
public class RobotModel {

	private Connection _conn;

	
	/**
	 * 
	 */
	public RobotModel() {
		/*
		String nomUser = "bruno"; // Utilisateur de la BD
		String passwd = "Bruno@1552"; // Password de l'utilisateur de la BD
		String url = "jdbc:mysql://LISA-7336/"; // Serveur de la BD
		String nomBase = "gestion_robot"; // Nom de la BD sur laquelle nous allons accÃ©der
		*/
		String nomUser = "root"; // Utilisateur de la BD
		String passwd = "root"; // Password de l'utilisateur de la BD
		String url = "jdbc:mysql://localhost/"; // Serveur de la BD
		String nomBase = "gestion_robots"; // Nom de la BD sur laquelle nous allons accÃ©der
		
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
			String requete = new String("SELECT " + row + " FROM "+table);
			String requete2 = new String("SELECT id FROM "+ table +" WHERE "+ row +"=?;");

			PreparedStatement stmt = _conn.prepareStatement(requete2);
			stmt.setString(1, element);

			System.out.println(requete2);
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
	
	
    public void insererRobot(String brand, String color, String location, Date time_use, boolean state)
	{	
    	try
		{	
			String requete = new String("INSERT INTO robot (`id`, `identifier`, `brand`, `color`, `location`,`time_use`,`serial_id`,`state` ) VALUES (NULL, ROUND(RAND()*99)+1 , ? , ? , ?, ?,ROUND(RAND()*99999)+1, ?);");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, brand);
			stmt.setString(2, color);
			stmt.setString(3, location);
			stmt.setDate(4, time_use);
			stmt.setBoolean(4, state);

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
    
    

    public void insererUser(String nom, String login, String motDePasse, String Email, String right)
	{	
    	try
		{	
			String requete = new String("INSERT INTO user (`id`, `name`, `login`, `password`,`email`,`create_time`,`priv` ) VALUES (NULL, ? , ? , MD5(?) , ?, NOW() , ?);");

			PreparedStatement stmt = _conn.prepareStatement(requete);
			stmt.setString(1, nom);
			stmt.setString(2, login);
			stmt.setString(3, motDePasse);
			stmt.setString(4, Email);
			stmt.setString(5, right);

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
     * @param tableaction
     * @author p.fauny
     */
    public void recapHistorique (JTable tableaction)
    {
    	String query = "SELECT date_plan, user.name, task.name FROM task JOIN task_has_user ON task.id = task_id JOIN user ON user_id = user.id; ";
    	
    	remplirTable(tableaction, query);
    }
    
}
