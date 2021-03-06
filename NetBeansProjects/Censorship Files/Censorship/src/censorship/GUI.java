/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censorship;

import static censorship.Censorship.splitWords;
import java.io.*;
import java.util.*;


/**
 *
 * @author Eyal Blumental Erez
 */
public class GUI extends javax.swing.JFrame {



    /**
     * Creates new form GUI
     */
    public GUI() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        censorFileChooser = new javax.swing.JFileChooser();
        messageCensorship = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTextBox = new javax.swing.JTextArea();
        censoredOutput = new javax.swing.JLabel();
        censorRadio = new javax.swing.JRadioButton();
        xRadio = new javax.swing.JRadioButton();
        Information = new javax.swing.JLabel();
        fileChooserBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        messageCensorship.setFont(new java.awt.Font("FrankRuehl", 1, 24)); // NOI18N
        messageCensorship.setText("Message Censorship");

        outputTextBox.setEditable(false);
        outputTextBox.setColumns(20);
        outputTextBox.setRows(5);
        jScrollPane1.setViewportView(outputTextBox);

        censoredOutput.setFont(new java.awt.Font("FrankRuehl", 0, 18)); // NOI18N
        censoredOutput.setText("Censored Output");

        buttonGroup1.add(censorRadio);
        censorRadio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        censorRadio.setText("Censor with \"Censored\"");
        censorRadio.setActionCommand("");
        censorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                censorRadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(xRadio);
        xRadio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xRadio.setSelected(true);
        xRadio.setText("Censor with *");
        xRadio.setActionCommand("");
        xRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRadioActionPerformed(evt);
            }
        });

        Information.setFont(new java.awt.Font("FrankRuehl", 0, 13)); // NOI18N

        fileChooserBtn.setFont(new java.awt.Font("FrankRuehl", 0, 13)); // NOI18N
        fileChooserBtn.setText("Choose File");
        fileChooserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(censoredOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(fileChooserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(274, 274, 274))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(xRadio)
                            .addComponent(censorRadio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(messageCensorship)))
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(messageCensorship)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileChooserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(xRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(censorRadio)
                .addGap(21, 21, 21)
                .addComponent(censoredOutput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Information, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void censorRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_censorRadioActionPerformed
        Censorship.censorOption = "CENSORED";
    }//GEN-LAST:event_censorRadioActionPerformed

    private void xRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRadioActionPerformed
        Censorship.censorOption = "****";
    }//GEN-LAST:event_xRadioActionPerformed

    private void fileChooserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserBtnActionPerformed
        
        int returnVal = censorFileChooser.showOpenDialog(GUI.this);
        
        if (returnVal == censorFileChooser.APPROVE_OPTION) {
    
            File file = censorFileChooser.getSelectedFile ();
            
             if (file.getName().endsWith(".txt")) { 
                 
            Information.setText("The file you chose is " + file.getName());
            
            Censorship.Reader(file);
            
            outputTextBox.setText("");
            
            String whatsThere = "";
            
                   for (int i = 0; i < splitWords.size(); i++) {
                   
                   whatsThere = outputTextBox.getText();

                   outputTextBox.setText(whatsThere + splitWords.get(i) + " ");

                }   
                                      
               splitWords.clear();
 
        } else if (!file.getName().endsWith(".txt")) {
            
            Information.setText("Error! Wrong file type, it must be .txt");
            
        } else {
            
            Information.setText("You cancelled choosing a file");
        }
        }
    }//GEN-LAST:event_fileChooserBtnActionPerformed


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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Information;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser censorFileChooser;
    private javax.swing.JRadioButton censorRadio;
    private javax.swing.JLabel censoredOutput;
    private javax.swing.JButton fileChooserBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageCensorship;
    public javax.swing.JTextArea outputTextBox;
    private javax.swing.JRadioButton xRadio;
    // End of variables declaration//GEN-END:variables
}
