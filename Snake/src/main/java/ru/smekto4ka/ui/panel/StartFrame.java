/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.smekto4ka.ui.panel;

/**
 *
 * @author smekto4ka
 */
public class StartFrame extends javax.swing.JFrame {

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        xSpiner = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        ySpiner = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(500, 400));
        setMinimumSize(new java.awt.Dimension(500, 400));
        setPreferredSize(new java.awt.Dimension(500, 400));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new java.awt.GridBagConstraints());

        jLabel5.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        startButton.setText("Запуск");
        jPanel2.add(startButton);

        jLabel2.setText("x");
        jPanel2.add(jLabel2);

        xSpiner.setModel(new javax.swing.SpinnerNumberModel(4, 4, null, 1));
        xSpiner.setToolTipText("x");
        xSpiner.setMinimumSize(new java.awt.Dimension(50, 30));
        xSpiner.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel2.add(xSpiner);

        jLabel3.setText("y");
        jPanel2.add(jLabel3);

        ySpiner.setModel(new javax.swing.SpinnerNumberModel(4, 4, null, 1));
        ySpiner.setToolTipText("y");
        ySpiner.setMinimumSize(new java.awt.Dimension(50, 30));
        ySpiner.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel2.add(ySpiner);

        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startButton;
    private javax.swing.JSpinner xSpiner;
    private javax.swing.JSpinner ySpiner;
    // End of variables declaration//GEN-END:variables
}
