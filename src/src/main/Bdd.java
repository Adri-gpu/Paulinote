package src.main;

import java.sql.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * @author louis
 */

public class Bdd {

    static Connection connection = null;
    Statement statement = null ;
    ResultSet result = null;
    
    public static String database = "jdbc:sqlite:" + Main.PathApp + "\\bdd.db";
    
    public static void main(String[] args) {
	try {
            connection= DriverManager.getConnection(database);
        } 
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public boolean VerificationUtilisateur(String _ident,String _mdp){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String sql = "SELECT identifiant FROM UTILISATEUR WHERE identifiant='" + _ident + "';";
            result = statement.executeQuery(sql);
            String ident = "";

            while (result.next()){
                ident = result.getString("identifiant");
            }
            System.out.println(ident);

            if(ident.equals(_ident)){
                System.out.println("Connexion réussie");
                statement = connection.createStatement();

                String mdp="";
                String requete_mdp = "SELECT motdepasse FROM UTILISATEUR WHERE identifiant='" + _ident + "';";
                result = statement.executeQuery(requete_mdp);

                while (result.next()){
                    mdp = result.getString("motdepasse");
                }

                if (mdp.equals(_mdp)){
                    System.out.println("Ident et mdp correct");
                    return true;
                }
                else{
                    System.out.println("mdp faux");
                    return false;
                }
            }
            else{
                return false;
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
     return false; 
    }
    
    public boolean Inscription(String _ident,String _mdp,String prenom,String nom){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            String insert="INSERT INTO UTILISATEUR VALUES ('" + _ident + "'" + "," + "'" + _mdp +"','"+ prenom + "','" + nom + "')";
            System.out.println(insert);
            statement.executeUpdate(insert);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return false;
        }
    }
    
    public ArrayList<Reunions> allReunion(String champ_recherche){
        ArrayList<Reunions> liste_reu = new ArrayList<Reunions>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
        
            if (champ_recherche.equals("")){
                String query_getReunions = "SELECT * from REUNION;";
                ResultSet rs = statement.executeQuery(query_getReunions);

                Reunions reunion;
                while (rs.next()){
                    reunion = new Reunions(rs.getInt("id_reu"),rs.getString("nom_reu"),rs.getString("date"),rs.getString("heure"),rs.getString("lieu"),rs.getBoolean("periodique"),rs.getInt("periodicite"),rs.getInt("id_type"));
                    liste_reu.add(reunion);
                }
            }
            else {
                String query_getReunions = "SELECT * from REUNION WHERE date='" + champ_recherche +"';";
                System.out.println(query_getReunions);
                ResultSet rs = statement.executeQuery(query_getReunions);
            
                Reunions reunion;
                while (rs.next()){
                    reunion = new Reunions(rs.getInt("id_reu"),rs.getString("nom_reu"),rs.getString("date"),rs.getString("heure"),rs.getString("lieu"),rs.getBoolean("periodique"),rs.getInt("periodicite"),rs.getInt("id_type"));
                    liste_reu.add(reunion);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_reu;
        }
    }
    
    public void ajouterReunion(String r_nom,String r_date,String r_heure,String r_lieu,int r_perio,int r_duree,int id_type){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
           
            String insert="INSERT INTO REUNION (nom_reu,date,heure,lieu,periodique,periodicite,id_type) VALUES" + " ( ";
            
            String query_reu = "'" + r_nom + "','" + r_date + "','" + r_heure + "','" + r_lieu + "'," + r_perio + "," + r_duree + ",'" +  id_type + "')";
            String add_reunion = insert + query_reu; 
            System.out.print(add_reunion);
            statement.execute(add_reunion);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void supprimerReunion(Vector<Integer>id_delete){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            if (id_delete.size() ==1){
                String supp_reu = "DELETE FROM REUNION WHERE id_reu='" + id_delete.get(0) + "'";
                statement.executeUpdate(supp_reu);
            }
            else{
                String req_supp="";
                for (int i=0;i<id_delete.size();++i){
                    req_supp="DELETE FROM REUNION WHERE id_reu='"+ id_delete.get(i) + "';";
                    statement.executeUpdate(req_supp);
                } 
            }          
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void Modifier_reunion(int id_reu,int r_typereu,String r_nom,String r_lieu,String r_date,String r_heure,int r_perio,int r_duree){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String update_reu= "UPDATE REUNION SET nom_reu='" + r_nom + "',date='" + r_date + "',heure='" + r_heure + "',lieu='" + r_lieu + "',periodique='" + r_perio + "',periodicite=" + r_duree + ",id_type=" + r_typereu + " WHERE id_reu=" + id_reu + ";";
            System.out.println(update_reu);
            statement.executeUpdate(update_reu);
        }   
        catch(Exception e){
            System.err.print(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public ArrayList<Reunions> getOneReu(Integer id_reu){
        ArrayList<Reunions> one_reu = new ArrayList<Reunions>();
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql_req = "SELECT * from REUNION WHERE id_reu='"+id_reu+"'";
            ResultSet rs = statement.executeQuery(sql_req);
            
            Reunions reunion;
            while (rs.next()){
                reunion = new Reunions(rs.getInt("id_reu"),rs.getString("nom_reu"),rs.getString("date"),rs.getString("heure"),rs.getString("lieu"),rs.getBoolean("periodique"),rs.getInt("periodicite"),rs.getInt("id_type"));
                one_reu.add(reunion);
            }  
        }
        catch(Exception e){
            System.out.print(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return one_reu;
        }
    }
    
    public ArrayList<Types> allTypes(){
        ArrayList<Types> liste_types = new ArrayList<Types>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
       
            String query_getTypes = "SELECT * from TYPE_REUNION;";
            ResultSet rs = statement.executeQuery(query_getTypes);
            
            Types type;
            while (rs.next()){
                System.out.println(rs.getInt("id_type") + " " + rs.getString("nom_type"));
                type = new Types(rs.getInt("id_type"),rs.getString("nom_type"));
                liste_types.add(type);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_types;
        }
    }
    
    public void ajoutType(String nom_type){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String insert="INSERT INTO TYPE_REUNION (nom_type) VALUES" + " (";
            String new_type = "'" + nom_type + "')";
            String full_type = insert + new_type;
            
            System.out.println(full_type);
           
            statement.execute(full_type);
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }

    public void Supprimer_types(Vector<Integer>id_delete){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String req_supp;
            for (int k=0;k<id_delete.size();k++){
                req_supp="DELETE FROM TYPE_REUNION WHERE id_type="+ id_delete.get(k) + ";";
                System.out.println(req_supp);
                statement.execute(req_supp);
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try {result.close();} catch (Exception e) {}
            try {statement.close();} catch (Exception e) {}
            try {connection.close();} catch (Exception e) {}
        }
    }
    
    public ArrayList<Personnes> AllContacts(int id_pers){
        ArrayList<Personnes> liste_types = new ArrayList<Personnes>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            if (id_pers==0){
                String query_getContacts = "SELECT * from PERSONNE;";
                ResultSet rs = statement.executeQuery(query_getContacts);

                Personnes personne;
                while (rs.next()){
                    personne = new Personnes(rs.getInt("id_pers"),rs.getString("email"),rs.getString("prenom_pers"),rs.getString("nom_pers"));
                    liste_types.add(personne);
                }
            }
            else {
                String query_getContacts = "SELECT * from PERSONNE WHERE id_pers=" + id_pers;
                ResultSet rs = statement.executeQuery(query_getContacts);

                Personnes personne;
                while (rs.next()){
                    personne = new Personnes(rs.getInt("id_pers"),rs.getString("email"),rs.getString("prenom_pers"),rs.getString("nom_pers"));
                    liste_types.add(personne);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_types;
        }
    }
    
    public void AjouterPersonne(String r_mail,String r_prenom,String r_nom){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
        
            String query_struct = "INSERT INTO PERSONNE (nom_pers,prenom_pers,email) VALUES ('";
            String query_util = r_nom + "','" + r_prenom + "','" + r_mail + "');";
            String query_ajoutpers = query_struct + query_util;
            statement.executeUpdate(query_ajoutpers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void SupprimerPersonne(Vector<Integer>contact_select){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
           
            if (contact_select.size()==1){
                System.out.println("une personne");
                String query_delete = "DELETE FROM PERSONNE WHERE id_pers=" + contact_select.get(0) + "";
                statement.executeUpdate(query_delete);
            }
            else{
                for (int i=0;i<contact_select.size();++i){
                    String query_delete = "DELETE FROM PERSONNE WHERE id_pers=" + contact_select.get(i) + "";
                    statement.executeUpdate(query_delete);
                } 
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void UpdatePersonne(int id_pers,String adr_mail,String prenom,String nom){
         try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
       
            String update_pers = "UPDATE PERSONNE SET nom_pers='" + nom + "',prenom_pers='"  + prenom + "',email='" + adr_mail + "' WHERE id_pers='" + id_pers + "';";    
            
            statement.executeUpdate(update_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public ArrayList<Groupes>  AllGroupes(){ 
        ArrayList<Groupes> liste_groupes = new ArrayList<Groupes>();
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
        
            String query_getGroupes = "SELECT * from GROUPE_DE_PERSONNE;";
            ResultSet rs = statement.executeQuery(query_getGroupes);
            
            Groupes groupe;
            while (rs.next()){
                groupe = new Groupes(rs.getInt("id_groupe"),rs.getString("nom_groupe"));
                liste_groupes.add(groupe);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_groupes;
        }
    }
    
    public void ModifType(String ancien_nom,String nouveau_nom){
        System.out.println("Ancien nom : " + ancien_nom );
        System.out.println("Nouveau nom : " + nouveau_nom );
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String update_type = "UPDATE TYPE_REUNION SET nom_type='" + nouveau_nom + "' WHERE nom_type='" + ancien_nom + "';";
            System.out.println(update_type);
            statement.executeUpdate(update_type);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public ArrayList<Reunions> dateSearch(String date){
        ArrayList<Reunions> liste_reunions = new ArrayList<Reunions>();

        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
        
            String query_getReunions = "SELECT * from REUNION WHERE date='" + date +"';";
            System.out.println(query_getReunions);
            ResultSet rs = statement.executeQuery(query_getReunions);
            
            Reunions reunion;
            while (rs.next()){
                reunion = new Reunions(rs.getInt("id_reu"),rs.getString("nom_reu"),rs.getString("date"),rs.getString("heure"),rs.getString("lieu"),rs.getBoolean("periodique"),rs.getInt("periodicite"),rs.getInt("id_type"));
                liste_reunions.add(reunion);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_reunions;
        }
    }
    
    public ArrayList<Personnes> recherche_personne(String nom_personne){
        ArrayList<Personnes> liste_personnes = new ArrayList<Personnes>();

        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String query_getReunions = "SELECT * from PERSONNE where nom_pers LIKE" + " '%" + nom_personne + "%'";
            System.out.println(query_getReunions);
            ResultSet rs = statement.executeQuery(query_getReunions);
            
            Personnes personne;
            while (rs.next()){
                personne = new Personnes(rs.getInt("id_pers"),rs.getString("email"),rs.getString("prenom_pers"),rs.getString("nom_pers"));
                liste_personnes.add(personne);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_personnes;
        }
        
    }
    
    public ArrayList<Types> recherche_type(String nom_type){
        ArrayList<Types> liste_types = new ArrayList<Types>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String query_getReunions = "SELECT * from TYPE_REUNION where nom_type LIKE" + " '%" + nom_type + "%'";
            System.out.println(query_getReunions);
            ResultSet rs = statement.executeQuery(query_getReunions);
            
            Types type;
            while (rs.next()){
                type = new Types(rs.getInt("id_type"),rs.getString("nom_type"));
                liste_types.add(type);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_types;
        }
    }
    
    public ArrayList<Groupes> recherche_groupe(String nom_dugroupe){
        ArrayList<Groupes> liste_groupes = new ArrayList<Groupes>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
        
            String query_getGroupes = "SELECT * from GROUPE_DE_PERSONNE where nom_groupe LIKE" + " '%" + nom_dugroupe + "%'";
            ResultSet rs = statement.executeQuery(query_getGroupes);
            
            Groupes groupe;
            while (rs.next()){
                groupe = new Groupes(rs.getInt("id_groupe"),rs.getString("nom_groupe"));
                liste_groupes.add(groupe);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_groupes;
        }
    }
    
    public void AjouterPersonneReu(int id_reu,Vector<Integer> liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            //On delete toutes les lignes avant
            String supprimer="DELETE FROM REU_PERS WHERE id_reu=" + id_reu;
            statement.executeUpdate(supprimer);
            //Puis on ajoute
            String ajouter;
            //id_reu, id_pers
            if(liste.size()==1){
                ajouter = "INSERT INTO REU_PERS VALUES (" + id_reu + "," + liste.get(0)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
            }
            else{
                for (int i=0;i<liste.size();++i){
                ajouter = "INSERT INTO REU_PERS VALUES (" + id_reu + "," + liste.get(i)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void ajouterGroupe(String nom_groupe){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String ajouter = "INSERT INTO GROUPE_DE_PERSONNE (nom_groupe) VALUES ('" + nom_groupe + "')";
            System.out.println(ajouter);
            statement.executeUpdate(ajouter);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void supprimerGroupes(Vector<Integer> liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            if (liste.size() == 1){
                String supprimer = "DELETE FROM GROUPE_DE_PERSONNE WHERE id_groupe='" + liste.get(0) + "';";
                System.out.println(supprimer);
                statement.executeUpdate(supprimer);
            }
            else{
                String supprimer;
                for (int i=0;i<liste.size();++i)
                {
                    supprimer = "DELETE FROM GROUPE_DE_PERSONNE WHERE id_groupe='" + liste.get(i) + "';";
                    System.out.println(supprimer);
                    statement.executeUpdate(supprimer);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void modifierGroupe(int id_groupe, String nom_groupe){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String update_groupe = "UPDATE GROUPE_DE_PERSONNE SET nom_groupe='" + nom_groupe + "' WHERE id_groupe=" + id_groupe + ";";
            
            statement.executeUpdate(update_groupe);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void ajouterPersGroupe(int id,Vector<Integer> personnes){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String delete = "DELETE FROM GROUPE_PERS WHERE id_groupe=" + id;
            statement.executeUpdate(delete);
            
            String update_groupe;
            if (personnes.size()==1){
                update_groupe = "INSERT INTO GROUPE_PERS VALUES (" + id + "," + personnes.get(0) + ");";
            
                statement.executeUpdate(update_groupe);
            }
            else {
                for (int i=0;i<personnes.size();++i){
                    update_groupe = "INSERT INTO GROUPE_PERS VALUES (" + id + "," + personnes.get(i) + ");";
                    statement.executeUpdate(update_groupe);
                }
                System.out.println("fin de l'ajout");
            }           
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public boolean liste_uti(String ident){
        boolean value = false;
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT identifiant FROM UTILISATEUR WHERE identifiant='" + ident + "';";
            result = statement.executeQuery(sql);

            if (result.next() == false) {
                value = true;
            }
            else {
                value = false;
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return value; 
    }
    
    public ArrayList<Integer> liste_personnes_reu(int id_reu){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT id_pers FROM REU_PERS where id_reu=" + id_reu;
            result = statement.executeQuery(sql);

            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public ArrayList<Integer> liste_personnes_groupe(int id){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT * FROM GROUPE_PERS where id_groupe=" + id;
            result = statement.executeQuery(sql);

            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public String getNomGroupe(int id){
        String nom_groupe="";
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT * from GROUPE_DE_PERSONNE WHERE id_groupe="+ id;
            result = statement.executeQuery(sql);
            while(result.next()){
                nom_groupe = result.getString("nom_groupe");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return nom_groupe;
    }
    
    
    public ArrayList<Utilisateur> getIdentUser(){ //
        ArrayList<Utilisateur> uti_infos = new ArrayList<Utilisateur>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT * from UTILISATEUR";
            result = statement.executeQuery(sql);
            
            Utilisateur utilisateur;
            while(result.next()){
                utilisateur = new Utilisateur(result.getString("identifiant"),result.getString("prenom"),result.getString("nom"),result.getString("motdepasse"));
                uti_infos.add(utilisateur);
            }
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return uti_infos;
    }
    
    public ArrayList<String> getInfosReu(int id_reu){
        ArrayList<String> liste = new ArrayList<String>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT * from REUNION where id_reu='" + id_reu + "'";
            //date, horaire, lieu
            result = statement.executeQuery(sql);
            while(result.next()){
                //liste.add(result.getString("date"),result.getString("heure"),result.getString("lieu"));
            }    
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste;
    }
    
    public ArrayList<String> getMailAdresses(String nom_reu){
        ArrayList<String> liste_adr_mail = new ArrayList<String>();
        
        try{
            
            
            //SELECT d'abord groupes
            
            
            //puis personnes
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_adr_mail;
        
    }
    
    public void ajouterGroupeType(int id,Vector<Integer>liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //On delete toutes les lignes avant
            String supprimer="DELETE FROM TYPE_GROUPE WHERE id_type=" + id;
            statement.executeUpdate(supprimer);
            String ajouter;
                //id_reu, id_pers
            if(liste.size()==1){
                ajouter = "INSERT INTO TYPE_GROUPE VALUES (" + id + "," + liste.get(0)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
            }
            else{
                for (int i=0;i<liste.size();++i){
                ajouter = "INSERT INTO TYPE_GROUPE VALUES (" + id + "," + liste.get(i)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
                }
            }
        
            System.out.println("fin de l'ajout du/des groupes");
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public void ajouterPersonneType(int id,Vector<Integer> liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //On delete toutes les lignes avant
            String supprimer="DELETE FROM TYPE_GROUPE WHERE id_type=" + id;
            statement.executeUpdate(supprimer);

            //Puis on ajoute
            String ajouter;
            //id_reu, id_pers
            if(liste.size()==1){
                ajouter = "INSERT INTO TYPE_PERS VALUES (" + id + "," + liste.get(0)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
            }
            else{
                for (int i=0;i<liste.size();++i){
                ajouter = "INSERT INTO TYPE_PERS VALUES (" + id + "," + liste.get(i)+");";
                System.out.println(ajouter);
                statement.executeUpdate(ajouter);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public ArrayList<Integer> liste_groupe_type(int id){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT * FROM TYPE_GROUPE where id_type=" + id;
            result = statement.executeQuery(sql);

            while(result.next()){
                liste_pers.add(result.getInt("id_groupe"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public ArrayList<Integer> liste_personne_type(int id){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            
            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            
            
            
            
            //Puis sortir le reste
            
            String sql = "SELECT * FROM TYPE_GROUPE where id_type=" + id;
            result = statement.executeQuery(sql);

            while(result.next()){
                liste_pers.add(result.getInt("id_groupe"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public void supprimerUneReunion(int id){
        try{
            
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            
                String supp_reu = "DELETE FROM REUNION WHERE id_reu='" + id + "'";
                statement.executeUpdate(supp_reu);
            }
        

          catch (SQLException e)
        {
            System.out.println(e);
        }
        
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
        }
    }
    
    public boolean verif_heure(String date,String heure){
        
        
        boolean possible=true;
        try{
            Vector<String> liste = new Vector<String>();
            
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String reu_days = "SELECT heure FROM REUNION WHERE date='" + date + "';";
            System.out.println(reu_days);
            
            result = statement.executeQuery(reu_days);
            
            while(result.next()){
                liste.add(result.getString("heure"));
            }
            
            System.out.println("taille de la liste : " + liste.size());
            
            if(liste.isEmpty()){
                possible = true;
            }
            else{
                LocalTime localTime = LocalTime.parse(heure, DateTimeFormatter.ofPattern("HH:mm"));
                
                System.out.println(localTime);

                if(liste.size()==1){
                    LocalTime localTime2 = LocalTime.parse(liste.get(0), DateTimeFormatter.ofPattern("HH:mm"));
                    long hoursBetween;
                    hoursBetween = ChronoUnit.MINUTES.between(localTime, localTime2);
                    System.out.println("heures entres : " + hoursBetween);
                    
                    if(hoursBetween>-60 && hoursBetween <59){
                        System.out.println("peux pas ajouter");
                        possible=false;
                    }
                    else{
                        possible=false;
                    }

                }
                else{
                    for (int i=0;i<liste.size();++i){ //on compare avec l'heure passé et si on trouve une réunion à moinns d'une heure on passe le bool en false
                        LocalTime localTime2 = LocalTime.parse(liste.get(0), DateTimeFormatter.ofPattern("HH:mm"));
                        long hoursBetween;
                        hoursBetween = ChronoUnit.MINUTES.between(localTime, localTime2);
                        
                        if(hoursBetween>-60 && hoursBetween <59){
                            System.out.println("peux pas ajouter");
                            possible=false;
                        }
                        else{
                            possible=false;
                        }
                    }
                }
            }
        }
        catch (SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            try { result.close();} catch (Exception e){}
        }
        return possible;
    }
    
        public String getDateReu(int id_reu){
        String date = "";
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT date from REUNION where id_reu='" + id_reu + "'";

            result = statement.executeQuery(sql);
            date = result.getString("date");
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return date;
    }
    
    public String getHeureReu(int id_reu){
        String heure = "";
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT heure from REUNION where id_reu='" + id_reu + "'";

            result = statement.executeQuery(sql);
            heure = result.getString("heure");
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return heure;
    }
    
    public String getLieuReu(int id_reu){
        String lieu = "";
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            String sql = "SELECT lieu from REUNION where id_reu='" + id_reu + "'";

            result = statement.executeQuery(sql);
            lieu = result.getString("lieu");
        }
        catch(Exception e){
            System.out.println("Erreur");
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return lieu;
    }
    
    public ArrayList<Personnes> liste_pers(int id){
        ArrayList<Personnes> liste_pers = new ArrayList<Personnes>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe

            //Puis sortir le reste
            String sql = "SELECT REU_pers.id_pers,email,prenom_pers,nom_pers FROM PERSONNE INNER JOIN REU_PERS ON REU_PERS.id_pers = PERSONNE.id_pers INNER JOIN REUNION ON REUNION.id_reu = REU_PERS.id_reu WHERE REUNION.id_reu=" + id;
            result = statement.executeQuery(sql);
            
            Personnes pers;
            while(result.next()){
                pers = new Personnes(result.getInt("id_pers"),result.getString("email"),result.getString("prenom_pers"),result.getString("nom_pers"));
                liste_pers.add(pers);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public ArrayList<Integer> liste_pers_temp(){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe

            //Puis sortir le reste
            
            String sql = "SELECT * FROM TEMP_PERS";
            result = statement.executeQuery(sql);
            
            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public void add_liste_pers_temp(Vector<Integer> liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            
            String delete_temp_pers = "DELETE FROM TEMP_PERS";
            statement.executeUpdate(delete_temp_pers);

            //Puis sortir le reste
            if(liste.size()==1){
                String sql = "INSERT INTO TEMP_PERS VALUES (" + liste.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else{
                String sql;
                for (int i=0;i<liste.size();++i){
                    sql = "INSERT INTO TEMP_PERS VALUES (" + liste.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public ArrayList<Integer> liste_groupe_temp(){
        ArrayList<Integer> liste_pers = new ArrayList<Integer>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe

            //Puis sortir le reste
            String sql = "SELECT * FROM TEMP_GROUPE";
            result = statement.executeQuery(sql);
            
            while(result.next()){
                liste_pers.add(result.getInt("id_groupe"));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public void add_liste_groupe_temp(Vector<Integer> liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            
            String delete_temp_pers = "DELETE FROM TEMP_GROUPE";
            statement.executeUpdate(delete_temp_pers);

            //Puis sortir le reste
            if(liste.size()==1){
                String sql = "INSERT INTO TEMP_GROUPE VALUES (" + liste.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else{
                String sql;
                for (int i=0;i<liste.size();++i){
                    sql = "INSERT INTO TEMP_GROUPE VALUES (" + liste.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void add_personne_newreu(){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            String get_max = "SELECT MAX(id_reu) FROM REUNION";
            result = statement.executeQuery(get_max);
            int max_reu = 0;
            
            while(result.next()){
                max_reu =  result.getInt("MAX(id_reu)");
            }
            System.out.println("max de la réu " + max_reu);
            String get_temp_personne = "SELECT * FROM TEMP_PERS";
            result = statement.executeQuery(get_temp_personne);
            
            Vector<Integer> liste_pers = new Vector<Integer>();
            
            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
            //Puis sortir le reste
            if(liste_pers.size()==1){
                String sql = "INSERT INTO REU_PERS VALUES (" +max_reu + "," + liste_pers.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else if(liste_pers.size()>1){
                String sql;
                for (int i=0;i<liste_pers.size();++i){
                    sql = "INSERT INTO REU_PERS VALUES ("+max_reu + "," + liste_pers.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
            
            String delete_temp_pers = "DELETE FROM TEMP_PERS";
            statement.executeUpdate(delete_temp_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void add_groupe_newreu(){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            String get_max = "SELECT MAX(id_reu) FROM REUNION";
            result = statement.executeQuery(get_max);
            int max_reu = 0;
            
            while(result.next()){
                max_reu =  result.getInt("MAX(id_reu)");
            }
            
            System.out.println("max de la réu " + max_reu);
            String get_temp_personne = "SELECT * FROM TEMP_GROUPE";
            result = statement.executeQuery(get_temp_personne);

            Vector<Integer> liste_pers = new Vector<Integer>();
            
            while(result.next()){
                liste_pers.add(result.getInt("id_groupe"));
            }
            //Puis sortir le reste
            if(liste_pers.size()==1){
                String sql = "INSERT INTO REU_GROUPE VALUES (" +max_reu + "," + liste_pers.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else if(liste_pers.size()>1){
                String sql;
                for (int i=0;i<liste_pers.size();++i){
                    sql = "INSERT INTO REU_GROUPE VALUES ("+max_reu + "," + liste_pers.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
            String delete_temp_pers = "DELETE FROM TEMP_GROUPE";
            statement.executeUpdate(delete_temp_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void add_pers_newtype(){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            String get_max = "SELECT MAX(id_type) FROM TYPE_REUNION";
            result = statement.executeQuery(get_max);
            int max_type = 0;
            
            while(result.next()){
                max_type =  result.getInt("MAX(id_type)");
            }
            
            System.out.println("max de la réu " + max_type);
            String get_temp_personne = "SELECT * FROM TEMP_PERS";
            result = statement.executeQuery(get_temp_personne);
            
            Vector<Integer> liste_pers = new Vector<Integer>();
            
            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
            //Puis sortir le reste
            if(liste_pers.size()==1){
                String sql = "INSERT INTO TYPE_PERS VALUES (" +max_type + "," + liste_pers.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else if(liste_pers.size()>1){
                String sql;
                for (int i=0;i<liste_pers.size();++i){
                    sql = "INSERT INTO TYPE_PERS VALUES ("+max_type + "," + liste_pers.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
            
            String delete_temp_pers = "DELETE FROM TEMP_PERS";
            statement.executeUpdate(delete_temp_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void add_groupe_newtype(){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            String get_max = "SELECT MAX(id_type) FROM TYPE_REUNION";
            result = statement.executeQuery(get_max);
            int max_type = 0;
            
            while(result.next()){
                max_type =  result.getInt("MAX(id_type)");
            }
            
            System.out.println("max de la réu " + max_type);
            String get_temp_personne = "SELECT * FROM TEMP_GROUPE";
            result = statement.executeQuery(get_temp_personne);
            
            Vector<Integer> liste_pers = new Vector<Integer>();
            
            while(result.next()){
                liste_pers.add(result.getInt("id_groupe"));
            }
            //Puis sortir le reste
            if(liste_pers.size()==1){
                String sql = "INSERT TYPE_GROUPE REU_GROUPE VALUES (" +max_type + "," + liste_pers.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else if(liste_pers.size()>1){
                String sql;
                for (int i=0;i<liste_pers.size();++i){
                    sql = "INSERT INTO TYPE_GROUPE VALUES ("+max_type + "," + liste_pers.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
            String delete_temp_pers = "DELETE FROM TEMP_GROUPE";
            statement.executeUpdate(delete_temp_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public void add_pers_newgroupe(){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            //D'abord vérifier qu'ils sont pas ajouté à l'aide d'un groupe
            String get_max = "SELECT MAX(id_groupe) FROM GROUPE_DE_PERSONNE";
            result = statement.executeQuery(get_max);
            int max_type = 0;
            
            while(result.next()){
                max_type =  result.getInt("MAX(id_groupe)");
            }
            
            System.out.println("max de la réu " + max_type);
            String get_temp_personne = "SELECT * FROM TEMP_PERS";
            result = statement.executeQuery(get_temp_personne);
            

            Vector<Integer> liste_pers = new Vector<Integer>();
            
            while(result.next()){
                liste_pers.add(result.getInt("id_pers"));
            }
            //Puis sortir le reste
            if(liste_pers.size()==1){
                String sql = "INSERT INTO GROUPE_PERS VALUES (" +max_type + "," + liste_pers.get(0) + ")";
                statement.executeUpdate(sql);
            }
            else if(liste_pers.size()>1){
                String sql;
                for (int i=0;i<liste_pers.size();++i){
                    sql = "INSERT INTO GROUPE_PERS VALUES ("+max_type + "," + liste_pers.get(i) + ")";
                    statement.executeUpdate(sql);
                }
            }
            String delete_temp_pers = "DELETE FROM TEMP_PERS";
            statement.executeUpdate(delete_temp_pers);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    }
    
    public ArrayList<String> liste_adr_mail(int id_reu){
        ArrayList<String> liste_pers = new ArrayList<String>();
        
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            //on récupère tous les groupes
            
            ArrayList<Groupes> liste_groupes = new ArrayList<Groupes>();
            
            String get_groupe = "SELECT * from REU_GROUPE WHERE id_reu=" + id_reu; //tous les groupes ou l'id match 
            result = statement.executeQuery(get_groupe);
            Groupes groupe;
            while(result.next()){
                groupe = new Groupes(result.getInt("id_groupe"),result.getString("nom_groupe"));
                liste_groupes.add(groupe);
            }
            
            //Une fois qu'on a les groupes, table d'asso des personnes liés au groupe
            
            ArrayList<Integer> liste_pers_groupe = new ArrayList<Integer>(); 
            if(liste_groupes.size()==1){ //si on a seulement un groupe
                String get_personnes_groupes = "SELECT * from TYPE_PERS WHERE id_type=" + liste_groupes.get(0);
                result = statement.executeQuery(get_personnes_groupes);
                
                while(result.next()){
                    liste_pers_groupe.add(result.getInt(get_groupe));
                }
                
                if(liste_pers_groupe.size()==1){
                    String get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_pers_groupe.get(0);
                    result = statement.executeQuery(get_personnes_groupes);
                    
                    while(result.next()){
                    liste_pers.add(result.getString("email"));
                    }
                }
              
                else if(liste_groupes.size()>1){ //si on a plus qu'un groupe
                    ArrayList<Integer> liste_personnes_all_groupes = new ArrayList<Integer>();
                    String get_all_id = "";

                    for (int i=0;i<liste_groupes.size();++i){
                        get_all_id = "SELECT * from TYPE_PERS WHERE id_type=" + liste_groupes.get(0);
                        result = statement.executeQuery(get_personnes_groupes);

                        while(result.next()){
                            if(liste_personnes_all_groupes.size()==1){ //si on a déjà un membre dans la liste des id
                                if(!liste_personnes_all_groupes.get(0).equals(result.getInt("id_pers"))){
                                    liste_personnes_all_groupes.add(result.getInt("id_pers"));
                                }
                            }
                            else if(liste_personnes_all_groupes.size()>1){ //si on a plus d'une personne dans l'arrayList
                                boolean ajouter = true;
                                for (int j=0;j<liste_personnes_all_groupes.size();++j){ //on vérifie qu'il y est pas dans l'arrayList
                                    if (liste_personnes_all_groupes.get(j).equals(result.getInt("id_pers"))){
                                        ajouter = false;
                                        break;
                                    }
                                    //faire dans le cas où il est y pas déjà
                                }
                                if(ajouter==true){
                                    liste_personnes_all_groupes.add(result.getInt("id_pers"));
                                }
                            }
                            else{ //si on a personne dans l'arrayList
                                liste_personnes_all_groupes.add(result.getInt("id_pers"));
                            }
                        }
                    }
                
                //maintenant on récupère les adresses mails 
                
                    String get_adr_mail = "";
                    if(liste_personnes_all_groupes.size()==1){ //si la liste d'id est égal à 1 donc 1 personne
                        get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_personnes_all_groupes.get(0);
                        result = statement.executeQuery(get_personnes_groupes);
                        while(result.next()){
                            liste_pers.add(result.getString("email"));
                        }
                    }
                
                    else if(liste_personnes_all_groupes.size()>1){ //si la liste d'id sup à 1 donc plusieurs personnes
                        for (int x=0;x<liste_personnes_all_groupes.size();++x){
                            get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_personnes_all_groupes.get(x);
                            result = statement.executeQuery(get_personnes_groupes);
                            while(result.next()){
                                liste_pers.add(result.getString("email"));
                            }
                        } 
                    }
                }
            }
            else{
                System.out.println("pas de groupe");
                String get_id_personnes  = "SELECT * FROM REU_PERS WHERE id_reu=" + id_reu;
                result = statement.executeQuery(get_id_personnes);

                ArrayList<Integer> liste_id_personnes = new ArrayList<Integer>();
                while(result.next()){
                    liste_id_personnes.add(result.getInt("id_pers"));
                }
                if(liste_id_personnes.size()==1){
                    String get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_id_personnes.get(0);
                    result = statement.executeQuery(get_adr_mail);
                    
                    while(result.next()){
                        liste_pers.add(result.getString("email"));
                    }
                }
                else if(liste_id_personnes.size()>1){
                    String get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_id_personnes.get(0);
                    result = statement.executeQuery(get_adr_mail);
                    
                    for (int j=0;j<liste_id_personnes.size();++j){
                        get_adr_mail = "SELECT * from PERSONNE WHERE id_pers=" + liste_id_personnes.get(j);
                        result = statement.executeQuery(get_adr_mail);

                        while(result.next()){
                            liste_pers.add(result.getString("email"));
                        }
                    }
                }    
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
            try { result.close();} catch (SQLException e){}
        }
        return liste_pers;
    }
    
    public void ajouterGroupeReu(int id,Vector<Integer>liste){
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();
            
            if(liste.size()==1){
                String insert_reu_groupe = "INSERT INTO REU_GROUPE VALUES (" + id + "," + liste.get(0);
                statement.executeUpdate(insert_reu_groupe);
            }
            else if(liste.size()>1){
                for (int j=0;j<liste.size();++j){
                    String insert_reu_groupe = "INSERT INTO REU_GROUPE VALUES (" + id + "," + liste.get(j);
                    statement.executeUpdate(insert_reu_groupe);
                }
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
    } 

    ArrayList<Personnes> getPersonne(int id) {
        ArrayList<Personnes> liste_personnes = new ArrayList<Personnes>();
        try{
            connection= DriverManager.getConnection(database);
            statement = connection.createStatement();

            String query_getReunions = "SELECT * from PERSONNE where id_pers=" + id;
            System.out.println(query_getReunions);
            ResultSet rs = statement.executeQuery(query_getReunions);

            Personnes personne;
            while (rs.next()){
                personne = new Personnes(rs.getInt("id_pers"),rs.getString("email"),rs.getString("prenom_pers"),rs.getString("nom_pers"));
                liste_personnes.add(personne);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { result.close();} catch (Exception e) {}
            try { statement.close();} catch (Exception e) {}
            try { connection.close();} catch (Exception e) {}
            return liste_personnes;
        }    
    }
}