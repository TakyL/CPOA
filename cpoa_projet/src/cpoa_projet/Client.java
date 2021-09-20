package cpoa_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Client {

	public void add_client(String nom,String prenom) {
        try {
        	
            Connexion laConnexion = new Connexion();
            laConnexion.creeConnexion();
            // Ajout périodicité avec retour de la clé générée
            // brut
            // PreparedStatement requete = laConnexion.prepareStatement( "insert into
            // Periodicite (id_periodicite,libelle) values(?,?)",
            // Statement.RETURN_GENERATED_KEYS);

            // Auto générération de l'id
            PreparedStatement requete = ((Connection) laConnexion).prepareStatement("insert into Client (nom,prenom) values(?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            requete.setString(1, nom);
            requete.setString(2, prenom);


            int lignes = requete.executeUpdate();

            // resultat
            ResultSet res = requete.getGeneratedKeys();
            if (res.next()) {
                int cle = res.getInt(1);
                System.out.println(cle);
            }

            // Fermetures

            if (res != null)
                res.close();
            if (requete != null)
                requete.close();

            if (laConnexion != null)
                laConnexion.close();

        } catch (SQLException sqle) {

            System.out.println("Pb select" + sqle.getMessage());
        }
    }
    
    public void del_client(String nom,String prenom) {
        try {
        	Connexion laConnexion = new Connexion();
            laConnexion.creeConnexion();
            // Ajout périodicité avec retour de la clé générée
            PreparedStatement requete = ((Connection) laConnexion).prepareStatement("delete from Client where nom=? and prenom=?");
            requete.setString(1, nom);
            requete.setString(2, prenom);

            int lignes = requete.executeUpdate();

            // Note: Affichage du msg d'erreur

        } catch (SQLException sqle) {

            System.out.println("Pb select:" + sqle.getMessage());
        }
    }
    
    public void upd_client(int id, String no_rue,String voie,String postal,String ville,String pays) {
        try {
        	Connexion Co = new Connexion();
            Co.creeConnexion();
            
                    
                //Requête
            PreparedStatement requete = ((Connection) Co)
                    .prepareStatement("update Client  set no_rue=? ,voie=?,code_postal=?,ville=?,pays=? where id_client = ?");
            requete.setString(1, no_rue );
            requete.setString(2, voie );
            requete.setString(3, postal );
            requete.setString(4, ville );
            requete.setString(5, pays);
            requete.setInt(6,id);
            

                
                
            
            int lignes = requete.executeUpdate();

            if (Co != null)
                Co.close();

        } catch (SQLException sqle) {

            System.out.println("Pb select" + sqle.getMessage());
        }

    }
}
