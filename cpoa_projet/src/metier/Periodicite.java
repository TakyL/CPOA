package metier;

public class Periodicite {

	private int id ;
	private String libelle;
		//Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		if (libelle == null || libelle.trim().length()==0) {
			throw new IllegalArgumentException("Libelle vide");
		}
		this.libelle = libelle;
	}
		//Constructeur
	public Periodicite(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
		public Periodicite(String libelle) {
			super();
			this.libelle = libelle;
		}

		//String
	@Override
	public String toString() {
		return "Periodicite [id=" + id + ", libelle=" + libelle + "]";
	}
	

}
