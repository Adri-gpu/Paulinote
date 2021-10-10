package src.main;

// @author M0riz

import fichiersreu.*;
import Init.*;
import java.awt.AWTException;
import bdd_daemon.Bdd_daemon;
import java.io.*;
import java.net.MalformedURLException;
        
public class Main {
    public static String PathApp = "C:\\Users\\"+System.getProperty("user.name")+"\\Documents\\PaulinoteFiles";
    //Liste des dossiers 
    static File Dossier = new File(PathApp);
    static File Pdf = new File(PathApp+"\\Pdf");     
    static File OrdreDuJour = new File(PathApp+"\\SauvegardeOrdreDuJour"); 
    static File CompteRendu = new File(PathApp+"\\SauvegardeCompteRendu");
    static File CSV = new File(PathApp+"\\FichierCSV");
    
    static boolean DossierExist = Dossier.mkdir();
    static boolean PdfExist = Pdf.mkdir();
    static boolean ODJExist = OrdreDuJour.mkdir();
    static boolean CRExist = CompteRendu.mkdir();
    static boolean CSVExist = CSV.mkdir();
    
    static String[] liste = new File(PathApp+"\\").list( );
    
    public static void main(String args[]) throws AWTException, MalformedURLException, Exception {
        if(DossierExist)
            System.out.println("Le dossier global a été créé.");
        else
            System.out.println("Le dossier global existe déja.");
        if(PdfExist)
            System.out.println("Le dossier pdf a été créé.");
        else
            System.out.println("Le dossier pdf existe déja.");
        if(ODJExist)
            System.out.println("Le dossier odj a été créé.");
        else
            System.out.println("Le dossier odj existe déja.");
        if(CRExist)
            System.out.println("Le dossier cr a été créé.");
        else
            System.out.println("Le dossier cr existe déja.");
        if(CSVExist)
            System.out.println("Le dossier csv a été créé.");
        else
            System.out.println("Le dossier csv existe déja.");
        
        int NbDirectory = liste.length;
        boolean BddExist = false;
        for (int i=0; i<NbDirectory; i++){
            if(liste[i].endsWith(".db")== true){
               BddExist = true;
               break;
	    }    
        }
        Shortcut.main(args);
        
        if(BddExist == true){
            AffichageConnexion Affichage = new AffichageConnexion();
            Affichage.setVisible(true);
            Affichage.setLocationRelativeTo(null);
            Bdd_daemon.main(args);
            SaveLogo.main(args);
        }
        else{
            InitBdd.main(args);
            SaveLogo.main(args);
            Inscription Affichage = new Inscription();
            Affichage.setVisible(true);
            Affichage.setLocationRelativeTo(null);
        }
    }
}