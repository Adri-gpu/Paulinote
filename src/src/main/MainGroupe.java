package src.main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author M0riz
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.*;
import src.Modif.ModifGroupe;
import src.créer.CréerGroupe;

public class MainGroupe extends javax.swing.JFrame {

    public Vector<Integer> groupe_selec = new Vector<Integer>();
    /**
     * Creates new form MainGroupe
     */
    public MainGroupe() {
        initComponents();
        AllContacts();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panel_groupe = new javax.swing.JPanel();
        nom_groupe = new javax.swing.JTextField();
        btnsupp = new javax.swing.JButton();
        btnmodif = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des groupes");

        jLabel1.setText("Liste des groupes :");

        jButton1.setText("Créer un groupe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panel_groupe.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_groupeLayout = new javax.swing.GroupLayout(panel_groupe);
        panel_groupe.setLayout(panel_groupeLayout);
        panel_groupeLayout.setHorizontalGroup(
            panel_groupeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        panel_groupeLayout.setVerticalGroup(
            panel_groupeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        nom_groupe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_groupeActionPerformed(evt);
            }
        });
        nom_groupe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nom_groupeKeyReleased(evt);
            }
        });

        btnsupp.setText("Supprimer");
        btnsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuppActionPerformed(evt);
            }
        });

        btnmodif.setText("Modifier");
        btnmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifActionPerformed(evt);
            }
        });

        jLabel2.setText("Nom :");

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
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nom_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnmodif)
                        .addGap(96, 96, 96)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsupp)
                        .addGap(27, 27, 27))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nom_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_refresh)))
                .addGap(18, 18, 18)
                .addComponent(panel_groupe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnmodif)
                    .addComponent(btnsupp)
                    .addComponent(jButton1))
                .addGap(31, 31, 31))
        );

        jMenu1.setText("Réunions");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Types");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Groupes");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Contacts");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifActionPerformed
        int id_groupe = groupe_selec.get(0);
        ModifGroupe Aff = new ModifGroupe(id_groupe);
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
    }//GEN-LAST:event_btnmodifActionPerformed

    private void nom_groupeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_groupeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_groupeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CréerGroupe Aff = new CréerGroupe();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nom_groupeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nom_groupeKeyReleased
        System.out.println("Appui sur une touche");
        
        String nom_dugroupe = nom_groupe.getText();
        Bdd bdd = new Bdd();
        
        ArrayList<Groupes> liste = bdd.recherche_groupe(nom_dugroupe);
        
        Affichage_groupe(liste);
        
        
    }//GEN-LAST:event_nom_groupeKeyReleased

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        MainReunion Aff = new MainReunion();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        MainType Aff = new MainType();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        MainPersonne Aff = new MainPersonne();
        Aff.setLocationRelativeTo(null);
        Aff.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void btnsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuppActionPerformed
        
        Bdd bdd = new Bdd();
        
        bdd.supprimerGroupes(groupe_selec);
        
        panel_groupe.removeAll();
        AllContacts();
    }//GEN-LAST:event_btnsuppActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        AllContacts();
    }//GEN-LAST:event_btn_refreshActionPerformed
    
    public void AllContacts()
    {
        btnmodif.setEnabled(false);
        btnsupp.setEnabled(false);

        
        Bdd bdd= new Bdd();

        ArrayList<Groupes> liste = bdd.AllGroupes();
        
        Affichage_groupe(liste);

    }
    
    public void selectOptions(Map<Integer, JCheckBox> check_groupe){

               Bdd bdd = new Bdd();
               
               ArrayList<Groupes> liste_groupe = bdd.AllGroupes();
               
                groupe_selec.clear();
                
		check_groupe.entrySet().stream().filter(e-> e.getValue().isSelected())
		          .forEach(e-> groupe_selec.add(liste_groupe.get(e.getKey()).getId()));
                

                System.out.println("taille vecteur après ajout / supp : " + groupe_selec.size());
                
                if (groupe_selec.size()<1)
                    btnmodif.setEnabled(false);
                else if (groupe_selec.size()==1){
                    btnmodif.setEnabled(true);
                    btnsupp.setEnabled(true);
                }
                else{
                    btnsupp.setEnabled(true);
                    btnmodif.setEnabled(false);
                }
                
    }
    
    public void Affichage_groupe(ArrayList<Groupes> liste){
        Map<Integer, JCheckBox> check_groupe = new HashMap<Integer, JCheckBox>() ;
        int x=50;
        int y=50;
        
        
        for (int i=0;i<liste.size();++i)
        {
            JLabel label1=new JLabel();
            JCheckBox check = new JCheckBox(liste.get(i).getNomGroupe());
            check_groupe.put(i, check);
            label1.setBounds(100,y,500,30);
            check.setBounds (30,y,500,30);
            check.addActionListener(new ActionListener(){

            @Override
            public final void actionPerformed(ActionEvent e) {
                selectOptions(check_groupe);
            }
  
        });
            

            panel_groupe.add(label1);
            panel_groupe.add(check);

            x+=30;
            y+=30;
        }
        
        
        repaint();
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
            java.util.logging.Logger.getLogger(MainGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGroupe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MainGroupe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btnmodif;
    private javax.swing.JButton btnsupp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nom_groupe;
    private javax.swing.JPanel panel_groupe;
    // End of variables declaration//GEN-END:variables
}
