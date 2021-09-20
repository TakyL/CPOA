package cpoa_projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Periodicite extends Connexion {
	
	//Ajouter periodicite
    public void add_periodicite(String mod_libelle) {
        try {
            Connection laConnexion = creeConnexion();
            // Ajout périodicité avec retour de la clé générée
            // brut
            // PreparedStatement requete = laConnexion.prepareStatement( "insert into
            // Periodicite (id_periodicite,libelle) values(?,?)",
            // Statement.RETURN_GENERATED_KEYS);

            // Auto générération de l'id
            PreparedStatement requete = laConnexion.prepareStatement("insert into Periodicite (libelle) values(?)",
                    Statement.RETURN_GENERATED_KEYS);

            requete.setString(1, mod_libelle);

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

    // Supprimer periodicite
    public void del_periodicite(String libelle) {
        try {
            Connection laConnexion = creeConnexion();
            // Ajout périodicité avec retour de la clé générée
            PreparedStatement requete = laConnexion.prepareStatement("delete from Periodicite where libelle=?");
            requete.setString(1, libelle);

            int lignes = requete.executeUpdate();

            // Note: Affichage du msg d'erreur

        } catch (SQLException sqle) {

            System.out.println("Pb select:" + sqle.getMessage());
        }
    }
            //Modifier périodicite
    public void upd_periodicite(int id, String mod_libelle) {
        try {
            Connection laConnexion = creeConnexion();
                    
                //Requête
            PreparedStatement requete = laConnexion
                    .prepareStatement("update Periodicite  set libelle=? where id_periodicite = ?");
            requete.setString(1, mod_libelle );
            requete.setInt(2, id);

                
                
            
            int lignes = requete.executeUpdate();

            if (laConnexion != null)
                laConnexion.close();

        } catch (SQLException sqle) {

            System.out.println("Pb select" + sqle.getMessage());
        }

    }
    }
