/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Game;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class Purchase extends javax.swing.JFrame {
    private String gameIdNumber;
    private String seatIdNumber;
    private double priceValue;
    public ArrayList<Seat> seats = new ArrayList<Seat>();
    private int gameNum;
    private String username;
    public double price;
    public double price1 = 0;
    public double price2 = 0;
    public double price3 = 0;
    public double price4 = 0;
    public int seatId1;
    public int seatId2;
    public int seatId3;
    public int seatId4;
    public String status1;
    public String status2;
    public String status3;
    public String status4;
    
    /**
     * Creates new form Purchase
     */
    public Purchase() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
    }
    
    public Purchase(ArrayList<Seat> seats, int gameNum){
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.gameNum = gameNum;
        // Displays the seats that are available
        for (int i = 0; i < seats.size(); i++){
            Seat seat = seats.get(i);
            int id = seat.getId();
            String section = seat.getSection();
            double price = seat.getPrice();
            priceValue = seat.getPrice();
            seatIdNumber = Integer.toString(seat.getId());
            String status = seat.getStatus();
            if (i == 0 && status.equals("available")){
                price1 = priceValue;
                seatId1 = id;
                status1 = status;
                seatInfo1.setText(seat.toString());
                addToCart1.setText("Add to cart");
            }
            else if (i == 1 && status.equals("available")){
                price2 = priceValue;
                seatId2 = id;
                status2 = status;
                seatInfo2.setText(seat.toString());
                addToCart2.setText("Add to cart");
            }
            else if (i == 2 && status.equals("available")){
                price3 = priceValue;
                seatId3 = id;
                status3 = status;
                seatInfo3.setText(seat.toString());
                addToCart3.setText("Add to cart");
            }
            else if (i == 3 && status.equals("available")){
                price4 = priceValue;
                seatId4 = id;
                status4 = status;
                seatInfo4.setText(seat.toString());
                addToCart4.setText("Add to cart");
            }
        }
    }
    
    public Purchase(ArrayList<Seat> seats, int gameNum, String username){
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.username = username;
        this.gameNum = gameNum;
        // Displays the seats that are available
        for (int i = 0; i < seats.size(); i++){
            Seat seat = seats.get(i);
            int id = seat.getId();
            String section = seat.getSection();
            double price = seat.getPrice();
            priceValue = seat.getPrice();
            seatIdNumber = Integer.toString(seat.getId());
            String status = seat.getStatus();
            if (i == 0 && status.equals("available")){
                price1 = priceValue;
                seatId1 = id;
                status1 = status;
                seatInfo1.setText(seat.toString());
                addToCart1.setText("Add to cart");
            }
            else if (i == 1 && status.equals("available")){
                price2 = priceValue;
                seatId2 = id;
                status2 = status;
                seatInfo2.setText(seat.toString());
                addToCart2.setText("Add to cart");
            }
            else if (i == 2 && status.equals("available")){
                price3 = priceValue;
                seatId3 = id;
                status3 = status;
                seatInfo3.setText(seat.toString());
                addToCart3.setText("Add to cart");
            }
            else if (i == 3 && status.equals("available")){
                price4 = priceValue;
                seatId4 = id;
                status4 = status;
                seatInfo4.setText(seat.toString());
                addToCart4.setText("Add to cart");
            }
        }
    }
    
    public Purchase(ArrayList<Seat> seats, int gameNum, int seatId, double price, String username){
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        this.username = username;
        this.gameNum = gameNum;
        // Displays the seats that are available
        for (int i = 0; i < seats.size(); i++){
            Seat seat = seats.get(i);
            int id = seat.getId();
            String section = seat.getSection();
            this.price = price;
            priceValue = seat.getPrice();
            seatIdNumber = Integer.toString(seat.getId());
            String status = seat.getStatus();
            if (i == 0 && status.equals("available")){
                price1 = priceValue;
                seatId1 = id;
                status1 = status;
                seatInfo1.setText(seat.toString());
                addToCart1.setText("Add to cart");
            }
            else if (i == 1 && status.equals("available")){
                price2 = priceValue;
                seatId2 = id;
                status2 = status;
                seatInfo2.setText(seat.toString());
                addToCart2.setText("Add to cart");
            }
            else if (i == 2 && status.equals("available")){
                price3 = priceValue;
                seatId3 = id;
                status3 = status;
                seatInfo3.setText(seat.toString());
                addToCart3.setText("Add to cart");
            }
            else if (i == 3 && status.equals("available")){
                price4 = priceValue;
                seatId4 = id;
                status4 = status;
                seatInfo4.setText(seat.toString());
                addToCart4.setText("Add to cart");
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
        creationNation = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Seats = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        seatInfo1 = new javax.swing.JLabel();
        seatInfo2 = new javax.swing.JLabel();
        seatInfo3 = new javax.swing.JLabel();
        seatInfo4 = new javax.swing.JLabel();
        addToCart1 = new javax.swing.JButton();
        addToCart2 = new javax.swing.JButton();
        addToCart3 = new javax.swing.JButton();
        addToCart4 = new javax.swing.JButton();
        errorMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1110, 700));
        setSize(new java.awt.Dimension(1110, 700));

        Banner.setBackground(new java.awt.Color(8, 52, 108));

        creationNation.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        creationNation.setForeground(new java.awt.Color(255, 255, 255));
        creationNation.setText("SoftwareCreationNation");

        jLabel5.setIcon(new javax.swing.ImageIcon("/Users/helentran/NetBeansProjects/GameArenaSys/Images/LogoBanner.png")); // NOI18N

        javax.swing.GroupLayout BannerLayout = new javax.swing.GroupLayout(Banner);
        Banner.setLayout(BannerLayout);
        BannerLayout.setHorizontalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creationNation)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BannerLayout.setVerticalGroup(
            BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BannerLayout.createSequentialGroup()
                .addGroup(BannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BannerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(BannerLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(creationNation)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        Seats.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        Seats.setText("Seats");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        seatInfo1.setText("unavailable");

        seatInfo2.setText("unavailable");

        seatInfo3.setText("unavailable");

        seatInfo4.setText("unavailable");

        addToCart1.setText("unavailable");
        addToCart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCart1ActionPerformed(evt);
            }
        });

        addToCart2.setText("unavailable");
        addToCart2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCart2ActionPerformed(evt);
            }
        });

        addToCart3.setText("unavailable");
        addToCart3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCart3ActionPerformed(evt);
            }
        });

        addToCart4.setText("unavailable");
        addToCart4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCart4ActionPerformed(evt);
            }
        });

        errorMsg.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seats)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seatInfo3)
                            .addComponent(seatInfo4)
                            .addComponent(seatInfo2)
                            .addComponent(seatInfo1))))
                .addGap(311, 447, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addToCart2)
                            .addComponent(addToCart1)
                            .addComponent(addToCart4)
                            .addComponent(addToCart3))
                        .addGap(202, 202, 202))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errorMsg)
                        .addGap(154, 154, 154))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seats)
                    .addComponent(errorMsg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addToCart1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToCart2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToCart3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addToCart4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(seatInfo1)
                                .addGap(18, 18, 18)
                                .addComponent(seatInfo2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(seatInfo3)))
                        .addGap(18, 18, 18)
                        .addComponent(seatInfo4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Redirects back to the Seating page
        try {
            Seating seatingFrame = new Seating(gameNum, username);
            seatingFrame.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void addToCart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCart1ActionPerformed
        // Sets an error message if user is not logged in. Otherwise, adds seat to cart
        if (username == null){
            errorMsg.setText("Please sign in to purchase a ticket");
        }
        if (status1 == null){
            errorMsg.setText("Seat is not available");
        }
        else{
            try {
                Cart cartFrame = new Cart(seats, gameNum, seatId1, price1, username);
                cartFrame.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addToCart1ActionPerformed

    private void addToCart2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCart2ActionPerformed
        // Sets an error message if user is not logged in. Otherwise, adds seat to cart
        if (username == null){
            errorMsg.setText("Please sign in to purchase a ticket");
        }
        if (status2 == null){
            errorMsg.setText("Seat is not available");
        }
        else{
            try {
                Cart cartFrame = new Cart(seats, gameNum, seatId2, price2, username);
                cartFrame.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addToCart2ActionPerformed

    private void addToCart3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCart3ActionPerformed
        // Sets an error message if user is not logged in. Otherwise, adds seat to cart
        if (username == null){
            errorMsg.setText("Please sign in to purchase a ticket");
        }
        if (status3 == null){
            errorMsg.setText("Seat is not available");
        }
        else{
            try {
                Cart cartFrame = new Cart(seats, gameNum, seatId3, price3, username);
                cartFrame.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addToCart3ActionPerformed

    private void addToCart4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCart4ActionPerformed
        // Sets an error message if user is not logged in. Otherwise, adds seat to cart
        if (username == null){
            errorMsg.setText("Please sign in to purchase a ticket");
        }
        if (status4 == null){
            errorMsg.setText("Seat is not available");
        }
        else{
            try {
                Cart cartFrame = new Cart(seats, gameNum, seatId4, price4, username);
                cartFrame.setVisible(true);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(Purchase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addToCart4ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Purchase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Banner;
    private javax.swing.JLabel Seats;
    private javax.swing.JButton addToCart1;
    private javax.swing.JButton addToCart2;
    private javax.swing.JButton addToCart3;
    private javax.swing.JButton addToCart4;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel creationNation;
    private javax.swing.JLabel errorMsg;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel seatInfo1;
    private javax.swing.JLabel seatInfo2;
    private javax.swing.JLabel seatInfo3;
    private javax.swing.JLabel seatInfo4;
    // End of variables declaration//GEN-END:variables

}

