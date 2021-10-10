
package src.main;

/**
 * @author louis
 */
public class TempContact {
    
    private int id; 
    
    public TempContact(int id){
        this.id=id;
    }
    
    public int getListe(){
        return id;
    }
    
    public void setListe(int liste){
        this.id=liste;
    }
}
