package Init;

import java.sql.*;
import static src.main.Bdd.database;

//@author louis

public class InitBdd{
    
    public static void main(String [] args){
        Connection conn = null;
        Statement statement = null;
        
        try{
            conn = DriverManager.getConnection(database);
            statement = conn.createStatement();
            
            String sql = "CREATE TABLE UTILISATEUR (identifiant varchar(100) PRIMARY KEY, motdepasse varchar(128),prenom varchar(100), nom varchar(100))";
            statement.execute(sql);
            
            sql = "CREATE TABLE PERSONNE (id_pers INTEGER PRIMARY KEY AUTOINCREMENT,nom_pers varchar(100) NULL,prenom_pers varchar(80) NULL,email varchar(80) NOT NULL)";
            statement.execute(sql);
            
            sql = "CREATE TABLE TYPE_REUNION (id_type INTEGER PRIMARY KEY AUTOINCREMENT,nom_type varchar(100) NOT NULL UNIQUE)";
            statement.execute(sql);
            
            sql = "CREATE TABLE GROUPE_DE_PERSONNE (id_groupe INTEGER PRIMARY KEY AUTOINCREMENT,nom_groupe varchar(254) NOT NULL UNIQUE)";
            statement.execute(sql);
            
            sql = "CREATE TABLE REUNION (id_reu INTEGER PRIMARY KEY AUTOINCREMENT,nom_reu varchar(254) NOT NULL,date date NULL,heure time NULL,lieu varchar(255) NULL,periodique boolean DEFAULT FALSE,periodicite INTEGER NULL, id_type INTEGER, FOREIGN KEY(id_type) REFERENCES TYPE_REUNION(id_type))";
            statement.execute(sql);
           
            sql = "CREATE TABLE REU_GROUPE (id_reu INTEGER,id_groupe INTEGER, primary key(id_reu,id_groupe), FOREIGN KEY (id_reu) REFERENCES REUNION(id_reu) on update cascade on delete cascade,FOREIGN KEY (id_groupe) REFERENCES GROUPE_DE_PERSONNES(id_groupe) on update cascade on delete cascade)";
            statement.execute(sql);
            
            sql = "CREATE TABLE REU_PERS (id_reu INTEGER,id_pers INTEGER,primary key(id_reu,id_pers), FOREIGN KEY (id_reu) REFERENCES REUNION(id_reu) on update cascade on delete cascade,FOREIGN KEY (id_pers) REFERENCES PERSONNE(id_pers) on update cascade on delete cascade)";
            statement.execute(sql);
            
            sql = "CREATE TABLE TYPE_GROUPE (id_type INTEGER,id_groupe INTEGER,primary key(id_type,id_groupe), FOREIGN KEY (id_type) REFERENCES TYPE_REUNION(id_type) on update cascade on delete cascade,FOREIGN KEY (id_groupe) REFERENCES GROUPE_DE_PERSONNES(id_groupe) on update cascade on delete cascade)";
            statement.execute(sql);
            
            sql = "CREATE TABLE TYPE_PERS (id_type INTEGER,id_pers INTEGER,primary key(id_type,id_pers), FOREIGN KEY (id_type) REFERENCES TYPE_REUNION(id_type) on update cascade on delete cascade,FOREIGN KEY (id_pers) REFERENCES PERSONNE(id_pers) on update cascade on delete cascade)";
            statement.execute(sql);
            
            sql = "CREATE TABLE GROUPE_PERS (id_groupe INTEGER,id_pers INTEGER,primary key(id_groupe,id_pers), FOREIGN KEY (id_groupe) REFERENCES GROUPE_DE_PERSONNE(id_groupe) on update cascade on delete cascade,FOREIGN KEY (id_pers) REFERENCES PERSONNE(id_pers) on update cascade on delete cascade)";
            statement.execute(sql);
            
            sql = "CREATE TABLE TEMP_PERS (id_pers INTEGER PRIMARY KEY)";
            statement.execute(sql);
            
            sql = "CREATE TABLE TEMP_GROUPE (id_groupe INTEGER PRIMARY KEY)";
            statement.execute(sql);
            
            sql = "INSERT INTO TYPE_REUNION VALUES(1,'Pas de type')";
            statement.executeUpdate(sql);
        }
        catch(SQLException e){
        }
        finally{
            try { statement.close(); } catch (SQLException e) {}
            try { conn.close(); } catch (SQLException e) {}
        }
    }
}
