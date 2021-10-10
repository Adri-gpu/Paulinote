package src.main;

/**
@author louis
 */
public class Reunions {
    
    private int id_reu,periodicite,id_type;
    private String nom_reu,heure,lieu,date;
    private boolean periodique;
    
    
    public Reunions(int id_reu,String nom_reu,String date,String heure,String lieu, boolean periodique, int periodicite, int id_type)
    {
        this.id_reu=id_reu;
        this.nom_reu=nom_reu;
        this.date=date;
        this.heure=heure;
        this.lieu=lieu;
        this.periodicite=periodicite;
        this.periodique=periodique;
        this.id_type=id_type;
    }
    
    public int getId(){return id_reu;}
    
    public String getNom(){return nom_reu;}
    
    public String getDate(){return date;}
    
    public String getHeure(){return heure;}
    
    public String getLieu(){ return lieu;}
    
    public int getPeridiocite(){ return periodicite;}
    
    public boolean getPeriodique(){ return periodique;}
    
    public int getId_type(){return id_type;}
    
    
    
}
