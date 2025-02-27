/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignedInHomepage extends javax.swing.JFrame {
    
    SchedulePage schedPage = new SchedulePage();
    Homepage homeP = new Homepage();
    public String username;

    /**
     * Creates new form SignedInHomepage
     */
    public SignedInHomepage() {
        initComponents();
    }
    
    public SignedInHomepage(String username) {
        initComponents();
        this.username = username;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banner = new javax.swing.JPanel();
        backgroundImgPanel = new javax.swing.JPanel();
        sloganPanel = new javax.swing.JPanel();
        lineOneSloganLbl = new javax.swing.JLabel();
        scheduleSloganBtn = new javax.swing.JButton();
        lineTwoSloganLbl = new javax.swing.JLabel();
        descriptionLbl = new javax.swing.JLabel();
        imageLbl = new javax.swing.JLabel();
        sideBanner = new javax.swing.JPanel();
        sloganSideLbl = new javax.swing.JLabel();
        titleSideLbl = new javax.swing.JLabel();
        logoLbl = new javax.swing.JLabel();
        scheduleBtn = new javax.swing.JButton();
        logoLbl1 = new javax.swing.JLabel();
        signOutBtn = new javax.swing.JButton();
        viewDashboardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        banner.setBackground(new java.awt.Color(0, 51, 102));
        banner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        backgroundImgPanel.setLayout(null);

        sloganPanel.setBackground(new java.awt.Color(255, 255, 255));

        lineOneSloganLbl.setBackground(new java.awt.Color(255, 255, 255));
        lineOneSloganLbl.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        lineOneSloganLbl.setText("Catching a sports game, but make it ");

        scheduleSloganBtn.setBackground(new java.awt.Color(204, 204, 204));
        scheduleSloganBtn.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        scheduleSloganBtn.setText("View Upcoming Games");
        scheduleSloganBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleSloganBtnActionPerformed(evt);
            }
        });

        lineTwoSloganLbl.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lineTwoSloganLbl.setForeground(new java.awt.Color(0, 51, 102));
        lineTwoSloganLbl.setText("easy & reliable");

        descriptionLbl.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        descriptionLbl.setText("SCN helps connect sports fans with reliable, affordable tickets.");

        javax.swing.GroupLayout sloganPanelLayout = new javax.swing.GroupLayout(sloganPanel);
        sloganPanel.setLayout(sloganPanelLayout);
        sloganPanelLayout.setHorizontalGroup(
            sloganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sloganPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scheduleSloganBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(366, 366, 366))
            .addGroup(sloganPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sloganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lineOneSloganLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lineTwoSloganLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sloganPanelLayout.setVerticalGroup(
            sloganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sloganPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lineOneSloganLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lineTwoSloganLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(descriptionLbl)
                .addGap(52, 52, 52)
                .addComponent(scheduleSloganBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        backgroundImgPanel.add(sloganPanel);
        sloganPanel.setBounds(160, 80, 560, 360);
        backgroundImgPanel.add(imageLbl);
        imageLbl.setBounds(0, 0, 910, 530);

        sideBanner.setBackground(new java.awt.Color(255, 255, 255));

        sloganSideLbl.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        sloganSideLbl.setText("Bringing you closer to the games that you love.");

        titleSideLbl.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        titleSideLbl.setText("SoftwareCreationNation");

        javax.swing.GroupLayout sideBannerLayout = new javax.swing.GroupLayout(sideBanner);
        sideBanner.setLayout(sideBannerLayout);
        sideBannerLayout.setHorizontalGroup(
            sideBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBannerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(sideBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sloganSideLbl)
                    .addGroup(sideBannerLayout.createSequentialGroup()
                        .addComponent(logoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titleSideLbl)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        sideBannerLayout.setVerticalGroup(
            sideBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBannerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sideBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleSideLbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoLbl, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sloganSideLbl)
                .addGap(300, 300, 300))
        );

        scheduleBtn.setBackground(new java.awt.Color(204, 204, 204));
        scheduleBtn.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        scheduleBtn.setForeground(new java.awt.Color(255, 255, 255));
        scheduleBtn.setText("Schedule");
        scheduleBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        scheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleBtnActionPerformed(evt);
            }
        });

        signOutBtn.setBackground(new java.awt.Color(204, 204, 204));
        signOutBtn.setForeground(new java.awt.Color(255, 255, 255));
        signOutBtn.setText("Sign Out");
        signOutBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        signOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutBtnActionPerformed(evt);
            }
        });

        viewDashboardBtn.setBackground(new java.awt.Color(204, 204, 204));
        viewDashboardBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewDashboardBtn.setText("View Dashboard");
        viewDashboardBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        viewDashboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDashboardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addComponent(sideBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bannerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(logoLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewDashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(signOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(bannerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backgroundImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(bannerLayout.createSequentialGroup()
                .addGroup(bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bannerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(scheduleBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewDashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(logoLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backgroundImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scheduleSloganBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleSloganBtnActionPerformed

        SchedulePage schedulePageFrame = new SchedulePage(username);
        schedulePageFrame.setVisible(rootPaneCheckingEnabled);
        setVisible(false);
    }//GEN-LAST:event_scheduleSloganBtnActionPerformed

    private void scheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleBtnActionPerformed

        SchedulePage schedulePageFrame = new SchedulePage(username);
        schedulePageFrame.setVisible(rootPaneCheckingEnabled);
        setVisible(false);
    }//GEN-LAST:event_scheduleBtnActionPerformed

    private void signOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutBtnActionPerformed
        // call sign out function, go back to old homepage ********
        
        homeP.setVisible(rootPaneCheckingEnabled);
        setVisible(false);
    }//GEN-LAST:event_signOutBtnActionPerformed

    private void viewDashboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDashboardBtnActionPerformed
        try {
            // call dashboard frame *************
            ViewDashboard viewDashboardFrame = new ViewDashboard(username);
            viewDashboardFrame.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(SignedInHomepage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_viewDashboardBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SignedInHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignedInHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignedInHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignedInHomepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignedInHomepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundImgPanel;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JLabel imageLbl;
    private javax.swing.JLabel lineOneSloganLbl;
    private javax.swing.JLabel lineTwoSloganLbl;
    private javax.swing.JLabel logoLbl;
    private javax.swing.JLabel logoLbl1;
    private javax.swing.JButton scheduleBtn;
    private javax.swing.JButton scheduleSloganBtn;
    private javax.swing.JPanel sideBanner;
    private javax.swing.JButton signOutBtn;
    private javax.swing.JPanel sloganPanel;
    private javax.swing.JLabel sloganSideLbl;
    private javax.swing.JLabel titleSideLbl;
    private javax.swing.JButton viewDashboardBtn;
    // End of variables declaration//GEN-END:variables
}
