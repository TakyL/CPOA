package cpoa_projet;

import java.sql.Connection;
import java.sql.Time;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

public class Connexion {

	public Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/leduc41u_basecpoa";
		url += "?serverTimezone=Europe/Paris";
		String login = "leduc41u_appli";
		String pwd = "32010660";
		Connection maConnexion = null;

		try {
			maConnexion = DriverManager.getConnection(url, login, pwd);
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;
	}

	/*
	 * public void uneRequete() { try { Connection laConnexion = creeConnexion();
	 * Statement requete = laConnexion.createStatement(); ResultSet res =
	 * requete.executeQuery("select id_periodicite,libelle from Periodicite"); while
	 * (res.next()) { int no = res.getInt(1); String nom = res.getString("libelle");
	 * System.out.println(nom); }
	 * 
	 * if (res != null) res.close(); if (requete != null) requete.close(); if
	 * (laConnexion != null) laConnexion.close(); } catch (SQLException sqle) {
	 * System.out.println("Pb select" + sqle.getMessage()); } }
	 */

	public void add_abonnement(String datedeb, String datefin, int id_cl, int id_revue) {
		try {
			Connection laConnexion = creeConnexion();
			// Formatage de date
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate DateDebut = LocalDate.parse(datedeb, formatage);
			LocalDate DateFin = LocalDate.parse(datefin, formatage);

			PreparedStatement requete = laConnexion.prepareStatement(
					"insert into Abonnement (date_debut,date_fin,id_client,id_revue) values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			requete.setDate(1, java.sql.Date.valueOf(DateDebut)); // Conversion des dates locales en date
			requete.setDate(2, java.sql.Date.valueOf(DateFin));
			requete.setInt(3, id_cl);
			requete.setInt(4, id_revue);
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

	public void del_abonnement(String datedeb, String datefin, int id_cl, int id_revue) {
		try {
			Connection laConnexion = creeConnexion();

			// Formatage de date
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate DateDebut = LocalDate.parse(datedeb, formatage);
			LocalDate DateFin = LocalDate.parse(datefin, formatage);

			// Ajout périodicité avec retour de la clé générée
			PreparedStatement requete = laConnexion.prepareStatement(
					"delete from Abonnement where date_debut=? and date_fin=? and id_client=? and id_revue=?");
			requete.setDate(1, java.sql.Date.valueOf(DateDebut)); // Conversion des dates locales en date
			requete.setDate(2, java.sql.Date.valueOf(DateFin));

			requete.setInt(3, id_cl);
			requete.setInt(4, id_revue);

			int lignes = requete.executeUpdate();
			// Note: Affichage du msg d'erreur

		} catch (SQLException sqle) {

			System.out.println("Pb select:" + sqle.getMessage());
		}
	}

	public void upd_abonnement(int id_a, String datedeb, String datefin, int id_cl, int id_revue) {
		try {
			Connection laConnexion = creeConnexion();

			// Formatage de date
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate DateDebut = LocalDate.parse(datedeb, formatage);
			LocalDate DateFin = LocalDate.parse(datefin, formatage);

			// Requête
			PreparedStatement requete = laConnexion.prepareStatement(
					"update Abonnement  set date_debut=? ,date_fin=?,id_client=?,id_revue=? where id_abonnement = ?");

			requete.setDate(1, java.sql.Date.valueOf(DateDebut)); // Conversion des dates locales en date
			requete.setDate(2, java.sql.Date.valueOf(DateFin));
			requete.setInt(3, id_cl);
			requete.setInt(4, id_revue);
			requete.setInt(5, id_a);

			int lignes = requete.executeUpdate();

			if (laConnexion != null)
				laConnexion.close();

		} catch (SQLException sqle) {

			System.out.println("Pb select" + sqle.getMessage());
		}

	}

	public void close() {
		close();
	}
	
	

}