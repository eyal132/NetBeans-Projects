/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfeelings;

import java.io.*;

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

        feelingsSlider = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        feelingsTextBox = new javax.swing.JTextArea();
        load = new javax.swing.JButton();
        save = new javax.swing.JButton();
        Title = new javax.swing.JLabel();
        Information = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        feelingsSlider.setMaximum(10);
        feelingsSlider.setPaintLabels(true);
        feelingsSlider.setPaintTicks(true);
        feelingsSlider.setSnapToTicks(true);

        feelingsTextBox.setColumns(20);
        feelingsTextBox.setRows(5);
        jScrollPane1.setViewportView(feelingsTextBox);

        load.setText("Load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Title.setText("How do you feel?");

        Information.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(load))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feelingsSlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Title)
                        .addGap(60, 60, 60))
                    .addComponent(Information, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(feelingsSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Information)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(load)
                    .addComponent(save))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method is called to load the text file, it is called when the load
     * button is pressed. This makes a file reader which then uses a buffered
     * reader to buffer the text from the file, it then reads the first line and
     * sets that to the feelings slider and the rest gets written onto the text
     * from the file.
     *
     */
    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed

        // this is the file path
        String fileName = "C:\\Users\\Eyal Blumental Erez\\Documents\\NetBeansProjects\\MyFeelings\\src\\myfeelings\\SaveFile.txt";

        // this is used for saving each line of code and writing or reading it to the text box.
        String oneLine = "";

        try {

            FileReader fileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            boolean firstLine = true;

            /**
             * This while loop is doing a few things at once, first off its
             * making sure the variable oneLine is equal to the buffered reader
             * so that when writing to the file it's much easier to write to it.
             * it's also checking that if a line is blank then stop the while
             * loop.
             */
            while ((oneLine = bufferedReader.readLine()) != null) {

                /**
                 * This if statement is using a boolean and is checking when the
                 * firstLine boolean is true and keeps going through the if
                 * statement as long as the while loop is writing, when it reads
                 * the first line it goes to the else statement and sets the
                 * boolean to false which then reads the rest of the text which
                 * gets sent to the main text box.
                 */
                if (firstLine != true) {

                    String whatsThere = feelingsTextBox.getText();

                    if (whatsThere.equals("")) {

                        // this sets the text box with what was already there and adds the text file that was saved.
                        feelingsTextBox.setText(oneLine);

                    } else {
                        
                        if (!whatsThere.equals(oneLine)) {
                            
                            // this sets the text box with what was already there and adds the text file that was saved.
                            feelingsTextBox.setText(whatsThere + "\n" + oneLine);
                        }
                    }

                } else {

                    // this sets the value of the feelings slider
                    feelingsSlider.setValue(Integer.parseInt(oneLine));

                    firstLine = false;

                }
            }

            bufferedReader.close();

            // this changes the label named information which then changes the label to show the user that the file has been saved
            Information.setText("Successfully Loaded File!");

        } catch (FileNotFoundException ex) { // if the file is not found it will show up with this error, this is used with a try catch statement

            System.out.println("Can't open file" + fileName);

            Information.setText("File Not Found!");

        } catch (IOException ex) { // This is the input and output exception catch, which is used with a try catch statement

            Information.setText("Error Reading File!");

            System.out.println("Error reading file" + fileName);

        }
    }//GEN-LAST:event_loadActionPerformed
    /**
     * this save method is used to save the feelings slider and text box. This
     * is called when the save button is clicked, this makes a file writer and
     * then uses a buffered writer to buffer the text from the file writer, it
     * then gets the value of the feelings slider and puts that on the first
     * line, and then goes one line down with \n so that there are no issues
     * when reading the file, it then writes the rest of the text from the main
     * text box to the file.
     *
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        String fileName = "C:\\Users\\Eyal Blumental Erez\\Documents\\NetBeansProjects\\MyFeelings\\src\\myfeelings\\SaveFile.txt";

        String textBox = feelingsTextBox.getText();
        /**
         * This try catch statement is making a file writer, then making a file
         * writer and using the text in the file writer and buffers that, it
         * then writes the feelingsSlider variable to the text file, it then
         * goes down a line with the \n and then writes the rest of the text
         * which is from the main text box.
         */
        if (!textBox.equals("")) {
            try {

                FileWriter fileWriter = new FileWriter(fileName);

                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write(Integer.toString(feelingsSlider.getValue()));

                bufferedWriter.write("\n"); // writes the next line one line down, 

                bufferedWriter.write(feelingsTextBox.getText());

                bufferedWriter.close();

                Information.setText("Successfully Saved File!");

            } catch (IOException ex) { // this is catching an input and output exception with a try catch statement

                Information.setText("Error Saving File!");

                System.out.println("Error writing to file" + fileName);

            }
        } else {
            Information.setText("Error! Textbox is empty");
        }
    }//GEN-LAST:event_saveActionPerformed

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
    private javax.swing.JLabel Title;
    private javax.swing.JSlider feelingsSlider;
    private javax.swing.JTextArea feelingsTextBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton load;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}