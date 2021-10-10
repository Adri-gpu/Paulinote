package src.main;

//@author M0riz

public class AffichageConnexion extends javax.swing.JFrame {

    /**
     * Creates new form AffichageConnexion
     */
    public AffichageConnexion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fond = new javax.swing.JPanel();
        B_Connecter = new javax.swing.JButton();
        B_Quitter = new javax.swing.JButton();
        L_Titre = new javax.swing.JLabel();
        L_Email = new javax.swing.JLabel();
        L_Mdp = new javax.swing.JLabel();
        L_Echec = new javax.swing.JLabel();
        T_Mail = new javax.swing.JTextField();
        Ps_Mdp = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Page de Connexion");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocation(new java.awt.Point(500, 500));
        setResizable(false);

        Fond.setMinimumSize(new java.awt.Dimension(250, 300));
        Fond.setPreferredSize(new java.awt.Dimension(250, 300));

        B_Connecter.setText("Se Connecter");
        B_Connecter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        B_Connecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ConnecterActionPerformed(evt);
            }
        });

        B_Quitter.setText("Quitter");
        B_Quitter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        B_Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_QuitterActionPerformed(evt);
            }
        });

        L_Titre.setText("Veuillez vous connecter ");

        L_Email.setText("Email :");

        L_Mdp.setText("Mot de passe :");

        L_Echec.setForeground(new java.awt.Color(255, 0, 0));
        L_Echec.setText("Echec de connexion");

        javax.swing.GroupLayout FondLayout = new javax.swing.GroupLayout(Fond);
        Fond.setLayout(FondLayout);
        FondLayout.setHorizontalGroup(
            FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondLayout.createSequentialGroup()
                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondLayout.createSequentialGroup()
                        .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(FondLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(L_Titre))
                            .addGroup(FondLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(L_Mdp)
                                    .addComponent(L_Email)))
                            .addGroup(FondLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(T_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 60, Short.MAX_VALUE))
                    .addGroup(FondLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondLayout.createSequentialGroup()
                                .addComponent(B_Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(B_Connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(FondLayout.createSequentialGroup()
                                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ps_Mdp, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(L_Echec, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        FondLayout.setVerticalGroup(
            FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(L_Titre)
                .addGap(18, 18, 18)
                .addComponent(L_Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(T_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(L_Mdp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ps_Mdp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(L_Echec)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(FondLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(B_Connecter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        L_Echec.getAccessibleContext().setAccessibleDescription("");
        L_Echec.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fond, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fond, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_QuitterActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_B_QuitterActionPerformed

    private void B_ConnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ConnecterActionPerformed
        // TODO add your handling code here:
        boolean existe;
        if(T_Mail.getText().equals("")){
            L_Echec.setVisible(true);
        }
        else{
            Bdd bdd = new Bdd();
            String ident = T_Mail.getText();
            String mdp = String.valueOf(Ps_Mdp.getPassword());
            //System.out.println(ident + " " + mdp);
            existe = bdd.VerificationUtilisateur(ident,mdp);
            System.out.println(existe);
            if (existe==true){
                MainReunion Aff = new MainReunion();
                Aff.setVisible(true);
                Aff.setLocationRelativeTo(null);
                this.dispose();
            }
            else {
                L_Echec.setVisible(true);
            }
        }
        
    }//GEN-LAST:event_B_ConnecterActionPerformed

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
            java.util.logging.Logger.getLogger(AffichageConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AffichageConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AffichageConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AffichageConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AffichageConnexion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Connecter;
    private javax.swing.JButton B_Quitter;
    private javax.swing.JPanel Fond;
    private javax.swing.JLabel L_Echec;
    private javax.swing.JLabel L_Email;
    private javax.swing.JLabel L_Mdp;
    private javax.swing.JLabel L_Titre;
    private javax.swing.JPasswordField Ps_Mdp;
    private javax.swing.JTextField T_Mail;
    // End of variables declaration//GEN-END:variables
}
