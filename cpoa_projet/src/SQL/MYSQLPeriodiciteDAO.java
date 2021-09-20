package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.Dao;
import metier.Periodicite;

public class MYSQLPeriodiciteDAO implements Dao<Periodicite> {

	
	private static MYSQLPeriodiciteDAO instance;
	private MYSQLPeriodiciteDAO() {}
	
	@Override
	public Periodicite getById(int id) {
		Periodicite periodicite =null;
		try {
			Connection laConnexion = creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("select * from periodicite where id_periodicite=?");
			requete.setInt(1, id);
			ResultSet res =requete.executeQuery();
			
			if (res.next()) {
                int cle = res.getInt(1);
                System.out.println(cle);
            }
			return periodicite;
            // Fermetures

            if (res != null)
                res.close();
            if (requete != null)
                requete.close();
            
		}catch (SQLException sqle) {

            System.out.println("Pb select" + sqle.getMessage());
        }
		
		
	}

	@Override
	public boolean create(Periodicite objet) {
		PreparedStatement requete = laConnexion.prepareStatement("insert into Periodicite(libelle)from etudiant where id_periodicite=?");
				requete.setInt(1, id);
				int nbLignes = requete.executeUpdate();
				return nbLignes==1;
	}

	@Override
	public boolean update(Periodicite objet) {
		PreparedStatement requete = 
				laConnexion.prepareStatement("delete from etudiant where promo_etudiant=?");
				requete.setInt(1, id);
				int nbLignes = requete.executeUpdate();
				return nbLignes==1;
	}

	@Override
	public boolean delete(Periodicite objet) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static MYSQLPeriodiciteDAO getInstance() {
		if (instance==null) {
			instance = new MYSQLPeriodiciteDAO();
		}
		return instance;
	}

}
