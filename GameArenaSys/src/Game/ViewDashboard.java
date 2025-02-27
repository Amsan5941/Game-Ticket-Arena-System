/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewDashboard extends javax.swing.JFrame {
    
    public String username;
    public ArrayList<Ticket.TicketItem> tickets = new ArrayList<Ticket.TicketItem>();
    /**
     * Creates new form ViewDashboard
     */
    public ViewDashboard() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }
    
    public ViewDashboard(String username) throws SQLException {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.username = username;
        System.out.println(username);
        if (username == null){
            information.setText("Username: " + username);
        }
        else{
            information.setText("Username: " + username);
            
            //get user_id from users table with username
            Customer customerInfo = new Customer(username);
            int user_id = customerInfo.getCustomerId(username);
            Ticket ticket = new Ticket();
            tickets = ticket.getPurchaseFromUser(user_id);
            for (int i = 0; i < tickets.size(); i++){
                displayInfo.append(tickets.get(i).toStringUserId() + "\n");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Banner = new javax.swing.JPanel();
        creationNation1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        informationLabel = new javax.swing.JLabel();
        purchaseLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        displayInfo = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        information = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1110, 700));
        setSize(new java.awt.Dimension(1110, 700));

        Banner.setBackground(new java.awt.Color(8, 52, 108));

        creationNation1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        creationNation1.setForeground(new java.awt.Color(255, 255, 255));
        creationNation1.setText("SoftwareCreationNation");

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/helentran/NetBeansProjects/GameArenaSys/Images/LogoBanner.png")); // NOI18N

        javax.swing.GroupLayout BannerLayout = new javax.swing.GroupLayout(Banner);
        Banner.setLayout(BannerLayout);
        BannerLayout.setHorizontalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creationNation1)
                .addContainerGap(746, Short.MAX_VALUE))
        );
        BannerLayout.setVerticalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addGroup(BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BannerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6))
                    .addGroup(BannerLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(creationNation1)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        informationLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        informationLabel.setText("Information");

        purchaseLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        purchaseLabel.setText("Purchases");

        displayInfo.setColumns(20);
        displayInfo.setRows(5);
        jScrollPane2.setViewportView(displayInfo);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(purchaseLabel)
                    .addComponent(informationLabel)
                    .addComponent(information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(informationLabel)
                .addGap(18, 18, 18)
                .addComponent(information)
                .addGap(27, 27, 27)
                .addComponent(purchaseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Redirect back to SignedInHomepage
        SignedInHomepage signedInHomepageFrame = new SignedInHomepage(username);
        signedInHomepageFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Banner;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel creationNation1;
    private javax.swing.JTextArea displayInfo;
    private javax.swing.JLabel information;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel purchaseLabel;
    // End of variables declaration//GEN-END:variables
}
