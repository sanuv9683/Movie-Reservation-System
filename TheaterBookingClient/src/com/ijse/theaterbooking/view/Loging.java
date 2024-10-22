/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.view;

import com.ijse.theaterbooking.connector.ServerConnector;
import com.ijse.theaterbooking.controller.UserController;
import com.ijse.theaterbooking.model.Users;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Sanu Vithanage
 */
public class Loging extends javax.swing.JFrame {

    private String user;
    private String stUserName;
    private String stUserID;
    private Calendar cal;
    private String day_night;
    private String time1;

    /**
     * Creates new form Loging
     */
    public Loging() {
        initComponents();
        setTimeD();
        setDateD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        load = new javax.swing.JLabel();
        closeL = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        userNameTxt = new javax.swing.JTextField();
        passWordTxt = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        registerBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        todayD = new javax.swing.JLabel();
        todayT = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        logingBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        animationL = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        load.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/h6viz.gif"))); // NOI18N
        getContentPane().add(load, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 180, 40));

        closeL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/close.png"))); // NOI18N
        closeL.setText("jLabel11");
        closeL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLMouseClicked(evt);
            }
        });
        getContentPane().add(closeL, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 40, 30));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/wddss.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 150));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/userName-icon.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 40, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/lkr.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 50, 60));

        userNameTxt.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(userNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 420, 50));

        passWordTxt.setBackground(new java.awt.Color(153, 153, 153));
        getContentPane().add(passWordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 420, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/usr.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 480, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/usr.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 480, 70));

        registerBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/erererer.png"))); // NOI18N
        registerBtn.setContentAreaFilled(false);
        registerBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerBtnMouseClicked(evt);
            }
        });
        registerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerBtnActionPerformed(evt);
            }
        });
        getContentPane().add(registerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 140, 70));

        jLabel11.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 40)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 204));
        jLabel11.setText("o");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 50, 50));

        jLabel12.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 255));
        jLabel12.setText("c");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 70, 90));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 80)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Savoy 3D");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 430, 80));

        todayD.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        todayD.setForeground(new java.awt.Color(204, 204, 204));
        todayD.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        todayD.setText("2016-07-08");
        getContentPane().add(todayD, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 150, 50));

        todayT.setFont(new java.awt.Font("Eras Medium ITC", 0, 36)); // NOI18N
        todayT.setForeground(new java.awt.Color(255, 255, 255));
        todayT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        todayT.setText("02 : 10 PM");
        getContentPane().add(todayT, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 190, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/wR.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 330, 190));

        jLabel14.setBackground(new java.awt.Color(204, 255, 255));
        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Upcoming Movies");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 200, 20));

        jLabel13.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Fantastic Beasts English Movie");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/sry1.png"))); // NOI18N
        jLabel3.setText("close");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 990, 230));

        jLabel15.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Chennai 600028 II Second Innings");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 450, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setText("Befikre Tamil Movie");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 153, 153));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("**Savoy will be closed on  29 and 23 of December**");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 330, -1));

        jLabel21.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 204, 255));
        jLabel21.setText("30");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 260, 70, 90));

        jLabel20.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 48)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 204));
        jLabel20.setText("70");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 80, 80));

        jLabel16.setFont(new java.awt.Font("Yu Gothic Medium", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 153, 153));
        jLabel16.setText("MOANA Kids Movie");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, -1, -1));

        logingBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/fdfdfd.png"))); // NOI18N
        logingBtn.setContentAreaFilled(false);
        logingBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logingBtnMouseClicked(evt);
            }
        });
        logingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logingBtnActionPerformed(evt);
            }
        });
        getContentPane().add(logingBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 140, 70));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/dada copy.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 380, 490));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/dada.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 600, 390));

        animationL.setBackground(new java.awt.Color(0, 0, 0));
        animationL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/dnvd.gif"))); // NOI18N
        getContentPane().add(animationL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/closeB.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        jPanel1.setVisible(false);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void logingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logingBtnActionPerformed

    }//GEN-LAST:event_logingBtnActionPerformed

    private void registerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerBtnActionPerformed

    }//GEN-LAST:event_registerBtnActionPerformed

    private void logingBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logingBtnMouseClicked

        String uName = userNameTxt.getText();
        String pWord = passWordTxt.getText();

        try {
            UserController userController = ServerConnector.getServerConnector().getUserController();
            boolean res = userController.checkRegisteredUser(uName, pWord);
            if (res) {
                this.dispose();
                Users checkUserName = userController.checkUserName(uName);
                if (checkUserName != null) {
                    stUserName = checkUserName.getUserName();
                    stUserID = checkUserName.getUserID();
                }
                HomePage main = new HomePage(stUserName, stUserID);
                main.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Your Username Or Password is Wrong..");
            }

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Loging.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException | SQLException | ParseException ex) {
            Logger.getLogger(Loging.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Loging.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logingBtnMouseClicked

    private void registerBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerBtnMouseClicked
        new com.ijse.theaterbooking.view.Register().setVisible(true);
    }//GEN-LAST:event_registerBtnMouseClicked

    private void closeLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeLMouseClicked
    public void update(String message) {
        JOptionPane.showMessageDialog(this, message);
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
            java.util.logging.Logger.getLogger(Loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loging().setVisible(true);
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel animationL;
    private javax.swing.JLabel closeL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel load;
    private javax.swing.JButton logingBtn;
    private javax.swing.JPasswordField passWordTxt;
    private javax.swing.JButton registerBtn;
    private javax.swing.JLabel todayD;
    private javax.swing.JLabel todayT;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
 int timeRun = 0;

    private void setTimeD() {
        new Thread() {
            public void run() {
                while (timeRun == 0) {

                    cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);

                    day_night = "";
                    if (AM_PM == 1) {
                        day_night = "PM";
                    } else {
                        day_night = "AM";
                    }

                    time1 = hour + ":" + min + ":" + sec + " " + day_night;
                    todayT.setText(time1);

                }
            }
        }.start();
    }

    private void setDateD() {
        Date today = new Date();

        todayD.setText(DateFormat.getDateInstance().format(today));
    }
}
