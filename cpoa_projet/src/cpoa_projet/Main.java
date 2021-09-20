package cpoa_projet;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Connexion co = new Connexion();
        co.creeConnexion();
        //co.uneRequete();
       // co.add_client( "Hel","Quasatan");
        //co.del_client("Hel","Quasatan");
       // co.upd_client(4,"bon","bonsoir","05","lilo","tchit");
        co.add_abonnement("22/08/2040", "10/04/2040", 1, 0);
        co.del_abonnement("22/08/2040", "10/04/2040", 1, 0);
        //co.upd_abonnement(3,"22/08/2040", "10/04/2040", 1, 3);
    }

}
