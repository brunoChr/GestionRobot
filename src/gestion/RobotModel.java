package gestion;
/**
 * 
 */


import java.sql.*;

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
	 * @return
	 * 
	 * @author p.fauny
	 */
	public Object[][] recapHistorique()
	{
		Object[][] data = new Object[12][3];
		try {
			
			String requeteHisto = new String("SELECT date_plan, user.name, task.name FROM task JOIN task_has_user ON task.id = task_id JOIN user ON user_id = user.id; ");
			PreparedStatement stmt = _conn.prepareStatement(requeteHisto);
			ResultSet rs = stmt.executeQuery();
			
			
			int i=0;
			
			while (rs.next ())
			{
				for(int j=0; j<3; j++)
				{
					data[i][j] = rs.getObject(j+1).toString();
					System.out.println(rs.getObject(j+1).toString());
				}
				i++;
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException ex3)		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();			
			}	
		}
		return data;
	}
}
