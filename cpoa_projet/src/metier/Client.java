package metier;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String rue;
	private String postal;
	private String ville;
	private String Pays;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if (nom == null || nom.trim().length()==0) {
			throw new IllegalArgumentException("nom vide");
		}
		
			this.nom = nom;
		
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		
		if (prenom == null || prenom.trim().length()==0) {
			throw new IllegalArgumentException("Libelle vide");
		}
		
		this.prenom = prenom;
	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", rue=" + rue + ", postal=" + postal
				+ ", ville=" + ville + ", Pays=" + Pays + "]";
	}
		//Constructeur
	public Client(int id, String nom, String prenom, String rue, String postal, String ville, String pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.postal = postal;
		this.ville = ville;
		Pays = pays;
	}
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
}
