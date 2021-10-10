package src.main;

/**
 *
 * @author louis
 */
public class Types {
    
    private int id_type;
    private String nom_type;
    
    public Types(int id_type, String nom_type)
    {

        this.id_type=id_type;
        this.nom_type=nom_type;
    }
    
    public int getId(){return id_type;}
    
    public String getType(){return nom_type;}

    

}
