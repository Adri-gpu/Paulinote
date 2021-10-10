package src.main;

/**
 *
 * @author Morgan
 */
public class Utilisateur {
    
    
    private static String identifiant,prenom,nom,mdp;
    
    public Utilisateur(String identifiant,String prenom,String nom,String mdp){
        this.identifiant=identifiant;
        this.prenom = prenom;
        this.nom= nom;
        this.mdp=mdp;
    }
    
    public static String getMail(){
        return identifiant;
    }
    public static String getPrenom(){
        return prenom;
    }
    
    public static String getNom(){
        return nom;
    }
    
    public static String getMdp(){
        return mdp;
    }
}
