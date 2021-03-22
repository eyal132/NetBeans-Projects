/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofuser;

    import java.io.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class ListOfUser {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI UI = new GUI();
        UI.setVisible(true);
    }

    public static void Writer(String wordsToPrint) {

try {

    BufferedWriter writer = new BufferedWriter(new FileWriter("src/listOfUser/information.txt"));

writer.write(wordsToPrint);

writer.close();

} catch (IOException ex) {

    System.out.println("An Error Occured");

}

}

    public static void Reader() {

    try {

         BufferedReader reader = new BufferedReader(new FileReader("src/listOfUser/information.txt"));

         String line = "null";
         String message = "";
        while ((line = reader.readLine()) != null) {

        message += line;

        }
        
        System.out.println(message);
        
        GUI.setDetails(message);
         
    } catch (IOException ex) {

    }

}

}
