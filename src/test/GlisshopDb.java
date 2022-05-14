package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import objects.Utilisateur;

public class GlisshopDb {
	Connection con;
	
	public GlisshopDb () {
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/glisshop","root","");
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("show databases;");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
	}
	
	public boolean estConnecte() throws SQLException {
		 Statement stmt = con.createStatement();  
         ResultSet rs = stmt.executeQuery("show databases;");
         rs=stmt.executeQuery("show databases;");
         return true;
	}
	
	public Utilisateur getUtilisateur(int id) throws SQLException {
		Statement stmt = con.createStatement(); 
		String requete = "Select * from utilisateurs where id =" +id;
		ResultSet rs = stmt.executeQuery(requete);
		if(rs.next())
		{
			Utilisateur utilisateur = new Utilisateur(rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
				rs.getString("telephone"), rs.getString("mdp"), rs.getString("numAdresse"), rs.getString("nomAdresse"), 
				rs.getString("cpAdresse"), rs.getString("villeAdresse"));
			return utilisateur;
		}else
		{
		    return null;
		}
	}
	public String getRecherche(int id) throws SQLException {
		Statement stmt = con.createStatement(); 
		String requete = "Select * from recherche where id =" +id;
		ResultSet rs = stmt.executeQuery(requete);
		if(rs.next())
		{
			return rs.getString("label");
		}else
		{
		    return null;
		}
		
	}
	public int getQuantiteRecherche(int id) throws SQLException {
		Statement stmt = con.createStatement(); 
		String requete = "Select * from recherche where id =" +id;
		ResultSet rs = stmt.executeQuery(requete);
		if(rs.next())
		{
			return rs.getInt("quantite");
		}else
		{
		    return 1;
		}
	}
	
 
}
