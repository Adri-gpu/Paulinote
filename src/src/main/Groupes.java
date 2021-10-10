/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main;

/**
 *
 * @author louis
 */
public class Groupes {
    private int id_groupe;
    private String nom_groupe;
    
    public Groupes(int id_groupe,String nom_groupe)
    {
        this.id_groupe=id_groupe;
        this.nom_groupe = nom_groupe;
    }
    
    public int getId(){return id_groupe;}
    
    public String getNomGroupe(){return nom_groupe;}
   
    
}
