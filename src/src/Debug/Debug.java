package src.Debug;


import java.util.ArrayList;
import java.util.Scanner;
import src.main.Bdd;
import src.main.Groupes;
import src.main.Personnes;
import src.main.Reunions;
import src.main.Types;
import java.sql.*;

/**
 * @author louis
 */

public class Debug{

    public static void main(String[] args) {

        do{
        System.out.println("1. Afficher toutes les réunions");
        System.out.println("2. Afficher tous les types");
        System.out.println("3. Afficher tous les groupes");
        System.out.println("4. Afficher toutes les personnes");
        System.out.println("5. Afficher tous les réunions groupes");
        System.out.println("6. Affiche tous les réunions personnes");
        System.out.println("7. Afficher tous les types personnes");
        System.out.println("8. Afficher tous les types groupes");
        System.out.println("9. Afficher tous les groupe_pers");

        Scanner clavier = new Scanner(System.in);
        int choix = clavier.nextInt();
        
        Bdd bdd = new Bdd();

        switch (choix) {

          case 1 :
              Connection connection = null;
              Statement statement = null;
              ResultSet rs = null;
              try{
			    connection= DriverManager.getConnection("jdbc:sqlite:bdd.db");
			    statement = connection.createStatement();
            

                            //String ajouter = "DELETE FROM REU_PERS";
                            String ajouter = "SELECT * from TYPE_REUNION";
                            //statement.executeUpdate(ajouter);
                            rs = statement.executeQuery(ajouter);
                            
                            int id_reu,id_pers = 0;
                            
                            while (rs.next())
                            {
                                /*
                                id_reu = rs.getInt("id_reu");
                                System.out.println("id de la reu" + id_reu);
                                id_pers = rs.getInt("id_pers");
                                System.out.println("id de la pers" + id_pers);*/
                                
                                System.out.println(rs.getString("id_type"));
                            }

                        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try { statement.close();} catch (SQLException e) {}
            try { connection.close();} catch (SQLException e) {}
        }
        
          case 2 :

              ArrayList<Types> liste_t = new ArrayList<Types>();
              liste_t = bdd.allTypes();

              for (int i=0;i<liste_t.size();++i)
              {
                System.out.println(liste_t.get(i));
              }
              break;
          case 3 :

              ArrayList<Groupes> liste_g = new ArrayList<Groupes>();
              liste_g = bdd.AllGroupes();
              for (int i=0;i<liste_g.size();++i)
              {
                System.out.println(liste_g.get(i));
              }
              break;
          case 4 :
              
              ArrayList<Personnes> liste_p = new ArrayList<Personnes>();
              liste_p = bdd.AllContacts(0);
              for (int i=0;i<liste_p.size();++i)
              {
                System.out.println(liste_p.get(i));
              }
              break;

          case 5 :
              ArrayList<Groupes> liste_asso1 = new ArrayList<Groupes>();
              liste_asso1 = bdd.AllGroupes();
              for (int i=0;i<liste_asso1.size();++i)
              {
                System.out.println(liste_asso1.get(i));
              }
              break;
          case 6 :
              ArrayList<String> asso2 = new ArrayList<String>();
              for (int i=0;i<asso2.size();++i)
              {
                System.out.println(asso2.get(i));
              }
              break;
          case 7 :
              ArrayList<Groupes> asso3 = new ArrayList<Groupes>();
              for (int i=0;i<asso3.size();++i)
              {
                System.out.println(asso3.get(i));
              }
              break;

          case 8 :
              ArrayList<Groupes> asso4 = new ArrayList<Groupes>();
              for (int i=0;i<asso4.size();++i)
              {
                System.out.println(asso4.get(i));
              }
              break;

          case 9 :
              ArrayList<Groupes> asso5 = new ArrayList<Groupes>();
              for (int i=0;i<asso5.size();++i)
              {
                System.out.println(asso5.get(i));
              }
              break;
          }
        } while(true);
      }
}

