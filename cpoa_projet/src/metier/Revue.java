package metier;

public class Revue {
    private int id;
    private String titre;
    private String description;
    private int id_periodicite;

   public Revue(int id, String titre, String description, int id_periodicite) {
       super();
       this.id = id;
       this.titre = titre;
       this.description = description;
       this.id_periodicite = id_periodicite;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getTitre() {
       return titre;
   }

   public void setTitre(String titre) {

       if (titre==null || titre.trim().length()==0) {
           throw new IllegalArgumentException("Titre de la revue est vide !");
       }
       this.titre = titre;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {

       if (description==null || description.trim().length()==0) {
           throw new IllegalArgumentException("Description de la revue est vide !");
       }
       this.description = description;
   }

   public int getId_periodicite() {
       return id_periodicite;
   }

   public void setId_periodicite(int id_periodicite) {
       this.id_periodicite = id_periodicite;
   }

   @Override
   public String toString() {
       return "Revue [id=" + id + ", titre=" + titre + ", description=" + description + ", id_periodicite="
               + id_periodicite + "]";
   }


}