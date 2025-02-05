/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ijse.theaterbooking.view;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Sanu Vithanage
 */
public class FirstFilm extends javax.swing.JFrame {

    static MediaPlayerFactory mpf;
    static EmbeddedMediaPlayer emp;

    /**
     * Creates new form FirstFilm
     */
    public FirstFilm() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        screen = new javax.swing.JPanel();
        canva = new java.awt.Canvas();
        firstMovieBook = new javax.swing.JLabel();
        firstMovieImg = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        firstMovieName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        screen.setLayout(new java.awt.BorderLayout());

        canva.setBackground(new java.awt.Color(0, 0, 0));
        screen.add(canva, java.awt.BorderLayout.CENTER);

        getContentPane().add(screen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 600, 370));

        firstMovieBook.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstMovieBook.setForeground(new java.awt.Color(255, 255, 255));
        firstMovieBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstMovieBook.setText("Book Now");
        firstMovieBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                firstMovieBookMouseClicked(evt);
            }
        });
        getContentPane().add(firstMovieBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 380, 160, 60));

        firstMovieImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/movie1.jpg"))); // NOI18N
        firstMovieImg.setText("jLabel6");
        getContentPane().add(firstMovieImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 170, 280));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/ssxsxsx.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 200, 250));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ijse/theaterbooking/view/images/close.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 40));

        firstMovieName.setFont(new java.awt.Font("Tekton Pro Ext", 1, 36)); // NOI18N
        firstMovieName.setForeground(new java.awt.Color(255, 255, 255));
        firstMovieName.setText("Maya Sinhala Movie");
        getContentPane().add(firstMovieName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 640, 60));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("jLabel1");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 460));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       emp.stop();
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

    }//GEN-LAST:event_jLabel3MouseClicked

    private void firstMovieBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_firstMovieBookMouseClicked
        
    }//GEN-LAST:event_firstMovieBookMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static java.awt.Canvas canva;
    private javax.swing.JLabel firstMovieBook;
    private javax.swing.JLabel firstMovieImg;
    private javax.swing.JLabel firstMovieName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel screen;
    // End of variables declaration//GEN-END:variables

    public void play() {
        FirstFilm firstFilm = new FirstFilm();
        firstFilm.setVisible(true);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        mpf = new MediaPlayerFactory();
        emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(firstFilm));
        emp.setVideoSurface(mpf.newVideoSurface(canva));

        emp.setEnableMouseInputHandling(true);
        emp.setEnableKeyInputHandling(true);

        String File = "Movie1.mp4";
        emp.prepareMedia(File);
        emp.play();
    }
}
