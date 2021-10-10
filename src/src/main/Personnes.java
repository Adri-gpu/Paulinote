package src.main;

/**
 *
 * @author louis
 */
public class Personnes {
    private int id_pers;
    private String nom_pers,prenom_pers,email;
    
    public Personnes(int id_pers,String email, String prenom_pers,String nom_pers)
    {
        this.id_pers=id_pers;
        this.email = email;
        this.prenom_pers=prenom_pers;
        this.nom_pers=nom_pers;
    }
    
    public int getId(){return id_pers;}
    
    public String getMail(){return email;}
    
    public String getPrenom(){return prenom_pers;}
    
    public String getNom(){return nom_pers;}
    
}
