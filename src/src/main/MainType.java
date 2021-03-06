package src.main;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import src.créer.CréerType;
import src.Modif.ModifType;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M0riz
 */
public class MainType extends javax.swing.JFrame {
    
    
    public Vector<Integer> type_selec = new Vector<Integer>();
    
    /**
     * Creates new form MainType
     */
    public MainType() {
        initComponents();
        AfficherTypes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        BarreMenu1 = new javax.swing.JMenuBar();
        MenuReunion1 = new javax.swing.JMenu();
        CreerReunion1 = new javax.swing.JMenuItem();
        ModifierReunion1 = new javax.swing.JMenuItem();
        SupprimerRunion1 = new javax.swing.JMenuItem();
        MenuType1 = new javax.swing.JMenu();
        CreerType1 = new javax.swing.JMenuItem();
        ModifierType1 = new javax.swing.JMenuItem();
        SupprimerType1 = new javax.swing.JMenuItem();
        MenuGroupe1 = new javax.swing.JMenu();
        CreerGroupe1 = new javax.swing.JMenuItem();
        ModifierGroupe1 = new javax.swing.JMenuItem();
        SupprimerGrope1 = new javax.swing.JMenuItem();
        MenuContact1 = new javax.swing.JMenu();
        CreerContact1 = new javax.swing.JMenuItem();
        ModifierContact1 = new javax.swing.JMenuItem();
        SupprimerContact1 = new javax.swing.JMenuItem();
        Importer1 = new javax.swing.JMenuItem();
        MenuConsulter1 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnsupp = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        nom_type = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        panel_type = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnmodif = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        BarreMenu = new javax.swing.JMenuBar();
        MenuReunion = new javax.swing.JMenu();
        MenuType = new javax.swing.JMenu();
        MenuGroupe = new javax.swing.JMenu();
        MenuContact = new javax.swing.JMenu();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BarreMenu1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        MenuReunion1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuReunion1.setText("Réunion");

        CreerReunion1.setText("Créer une réunion");
        MenuReunion1.add(CreerReunion1);

        ModifierReunion1.setText("Modifier une réunion");
        MenuReunion1.add(ModifierReunion1);

        SupprimerRunion1.setText("Supprimer une réunion");
        MenuReunion1.add(SupprimerRunion1);

        BarreMenu1.add(MenuReunion1);

        MenuType1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuType1.setText("Type");

        CreerType1.setText("Créer un type");
        MenuType1.add(CreerType1);

        ModifierType1.setText("Modifier un type");
        MenuType1.add(ModifierType1);

        SupprimerType1.setText("Supprimer un type");
        MenuType1.add(SupprimerType1);

        BarreMenu1.add(MenuType1);

        MenuGroupe1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuGroupe1.setText("Groupe");

        CreerGroupe1.setText("Créer un groupe");
        MenuGroupe1.add(CreerGroupe1);

        ModifierGroupe1.setText("Modifier un groupe");
        MenuGroupe1.add(ModifierGroupe1);

        SupprimerGrope1.setText("Supprimer un groupe");
        SupprimerGrope1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerGrope1ActionPerformed(evt);
            }
        });
        MenuGroupe1.add(SupprimerGrope1);

        BarreMenu1.add(MenuGroupe1);

        MenuContact1.setText("Contact");

        CreerContact1.setText("Créer un contact");
        CreerContact1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreerContact1ActionPerformed(evt);
            }
        });
        MenuContact1.add(CreerContact1);

        ModifierContact1.setText("Modifier un contact");
        MenuContact1.add(ModifierContact1);

        SupprimerContact1.setText("Supprimer un conatct");
        MenuContact1.add(SupprimerContact1);

        Importer1.setText("Importer");
        MenuContact1.add(Importer1);

        BarreMenu1.add(MenuContact1);

        MenuConsulter1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuConsulter1.setText("Consulter");
        BarreMenu1.add(MenuConsulter1);

        jFrame1.setJMenuBar(BarreMenu1);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des types");

        btnsupp.setText("Supprimer");
        btnsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuppActionPerformed(evt);
            }
        });

        jButton1.setText("Créer un type");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnsupp, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnsupp))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        nom_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_typeActionPerformed(evt);
            }
        });
        nom_type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nom_typeKeyReleased(evt);
            }
        });

        jLabel2.setText("Les types de réunion");

        panel_type.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_typeLayout = new javax.swing.GroupLayout(panel_type);
        panel_type.setLayout(panel_typeLayout);
        panel_typeLayout.setHorizontalGroup(
            panel_typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        panel_typeLayout.setVerticalGroup(
            panel_typeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        jLabel4.setText("Nom :");

        btnmodif.setText("Renommer");
        btnmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifActionPerformed(evt);
            }
        });

        btn_refresh.setText("Rafraichir");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nom_type, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnmodif, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 34, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nom_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh))
                .addGap(18, 18, 18)
                .addComponent(panel_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnmodif)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BarreMenu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        MenuReunion.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuReunion.setText("Réunions");
        MenuReunion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuReunionMouseClicked(evt);
            }
        });
        BarreMenu.add(MenuReunion);

        MenuType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuType.setText("Types");
        BarreMenu.add(MenuType);

        MenuGroupe.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        MenuGroupe.setText("Groupes");
        MenuGroupe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuGroupeMouseClicked(evt);
            }
        });
        BarreMenu.add(MenuGroupe);

        MenuContact.setText("Contacts");
        MenuContact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuContactMouseClicked(evt);
            }
        });
        BarreMenu.add(MenuContact);

        setJMenuBar(BarreMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CréerType Aff = new CréerType();
        Aff.setVisible(true);
        Aff.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nom_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_typeActionPerformed

    private void SupprimerGrope1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerGrope1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerGrope1ActionPerformed

    private void CreerContact1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreerContact1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreerContact1ActionPerformed

    private void btnmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifActionPerformed
        
        Bdd bdd = new Bdd();
        ArrayList<Types> liste = bdd.allTypes();
        String nom_type="";
        
        System.out.println("taille de la liste : " + liste.size());
       
        for(int i=0;i<liste.size();++i) //Pour i allant de 0 à la taille de la liste
        {
            if(type_selec.get(0).equals(liste.get(i).getId())) //si I est égal au 
            {
                nom_type=liste.get(i).getType();
                System.out.println(nom_type);
            }
           
        }
        
        ModifType Aff = new ModifType(type_selec.get(0));
        Aff.update_nom(nom_type);
        Aff.setVisible(true);
        Aff.setLocationRelativeTo(null);
        
        
        
    }//GEN-LAST:event_btnmodifActionPerformed

    private void btnsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuppActionPerformed
        Bdd bdd = new Bdd();
        bdd.Supprimer_types(type_selec);
        panel_type.removeAll();
        AfficherTypes();
    }//GEN-LAST:event_btnsuppActionPerformed

    private void nom_typeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_typeKeyReleased

        String nom_dutype = nom_type.getText();
        
        Bdd bdd = new Bdd();
        
        panel_type.removeAll();
        
        ArrayList<Types> liste  = bdd.recherche_type(nom_dutype);
        
        Affichage_type(liste);
        
         
    }//GEN-LAST:event_nom_typeKeyReleased

    private void MenuReunionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuReunionMouseClicked
        MainReunion Aff = new MainReunion();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuReunionMouseClicked

    private void MenuGroupeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuGroupeMouseClicked
        MainGroupe Aff = new MainGroupe();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuGroupeMouseClicked

    private void MenuContactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuContactMouseClicked
        MainPersonne Aff = new MainPersonne();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuContactMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        AfficherTypes();
    }//GEN-LAST:event_btn_refreshActionPerformed
    
    public void AfficherTypes(){
        //listreu.addActionListener(e->selectOptions(check_reu));
        
        btnmodif.setEnabled(false);
        btnsupp.setEnabled(false);
        
        Bdd bdd= new Bdd();

        ArrayList<Types> liste = bdd.allTypes();
        
        Affichage_type(liste);
        
        
    }
    
    public void selectOptions(Map<Integer, JCheckBox> check_type){

                Bdd bdd = new Bdd();
                
                ArrayList<Types> liste_types = bdd.allTypes();
                
                type_selec.clear();
                
		check_type.entrySet().stream().filter(e-> e.getValue().isSelected())
		          .forEach(e-> type_selec.add(liste_types.get(e.getKey()).getId()));

                System.out.println("taille vecteur après ajout / supp : " + type_selec.size());
 
                if (type_selec.size()<1)
                    btnmodif.setEnabled(false);
                else if (type_selec.size()==1){
                    btnmodif.setEnabled(true);
                    btnsupp.setEnabled(true);
                }
                else{
                    btnsupp.setEnabled(true);
                    btnmodif.setEnabled(false);
                }
    }
    
    public void Affichage_type(ArrayList<Types> liste){
        Map<Integer, JCheckBox> check_type = new HashMap<Integer, JCheckBox>() ;
        
        int x=50;
        int y=50;
        
        
        for (int i=0;i<liste.size();++i)
        {
            JLabel label1=new JLabel();
            JCheckBox check = new JCheckBox(liste.get(i).getType());
            check_type.put(i, check);
            label1.setBounds(100,y,500,30);
            check.setBounds (30,y,200,30);
            check.addActionListener(new ActionListener(){

            @Override
            public final void actionPerformed(ActionEvent e) {
                selectOptions(check_type);
            }
  
                
            
        });
            

            panel_type.add(label1);
            panel_type.add(check);

            x+=30;
            y+=30;
            
            
        }
        
        panel_type.repaint();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainType.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainType().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarreMenu;
    private javax.swing.JMenuBar BarreMenu1;
    private javax.swing.JMenuItem CreerContact1;
    private javax.swing.JMenuItem CreerGroupe1;
    private javax.swing.JMenuItem CreerReunion1;
    private javax.swing.JMenuItem CreerType1;
    private javax.swing.JMenuItem Importer1;
    private javax.swing.JMenu MenuConsulter1;
    private javax.swing.JMenu MenuContact;
    private javax.swing.JMenu MenuContact1;
    private javax.swing.JMenu MenuGroupe;
    private javax.swing.JMenu MenuGroupe1;
    private javax.swing.JMenu MenuReunion;
    private javax.swing.JMenu MenuReunion1;
    private javax.swing.JMenu MenuType;
    private javax.swing.JMenu MenuType1;
    private javax.swing.JMenuItem ModifierContact1;
    private javax.swing.JMenuItem ModifierGroupe1;
    private javax.swing.JMenuItem ModifierReunion1;
    private javax.swing.JMenuItem ModifierType1;
    private javax.swing.JMenuItem SupprimerContact1;
    private javax.swing.JMenuItem SupprimerGrope1;
    private javax.swing.JMenuItem SupprimerRunion1;
    private javax.swing.JMenuItem SupprimerType1;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnsupp;
    private javax.swing.JButton jButton1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nom_type;
    private javax.swing.JPanel panel_type;
    // End of variables declaration//GEN-END:variables
}
