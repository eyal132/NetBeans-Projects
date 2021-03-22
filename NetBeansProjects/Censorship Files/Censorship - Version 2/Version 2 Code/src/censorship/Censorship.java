/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censorship;

import java.io.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class Censorship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // This makes the GUI visible when running the code
         GUI UI = new GUI();
        UI.setVisible(true);
    }
    
    
     public static void Reader(File file) {
                // this is used for saving each line of code and writing or reading it to the text box.
        String oneLine = "";

        try {

            FileReader fileReader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((oneLine = bufferedReader.readLine()) != null) {

                // this sets the text box with what was already there and adds the text file that was saved.
               // outputTextBox.setText(oneLine);

              //  arrayWriter();
                
            }

            bufferedReader.close();

        } catch (FileNotFoundException ex) { // if the file is not found it will show up with this error, this is used with a try catch statement

            System.out.println("Can't open file" + file);

        } catch (IOException ex) { // This is the input and output exception catch, which is used with a try catch statement

            System.out.println("Error reading file" + file);

        }
     }
    
}
