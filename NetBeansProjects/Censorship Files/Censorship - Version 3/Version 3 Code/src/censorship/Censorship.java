/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package censorship;

import java.io.*;
import java.util.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class Censorship {

    /**
     * @param args the command line arguments
     */
    private static final String[] censoredWords = {"RICKY", "CHOCOLATE", "KEITH", "CORBAN", "APPLE", "HAM", "SCHOOL", "PARIN", "TRASH", "CHICKEN", "SCHOOL"};

    public static ArrayList<String> splitWords = new ArrayList<String>();
    
    public static String censorOption = "*****";
    
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

                String words[] = oneLine.split(" ");

                for (int i = 0; i < words.length; i++) {

                    String word = words[i];

                    splitWords.add(word);

                }

                censorThis();

            }

            bufferedReader.close();
            
        } catch (FileNotFoundException ex) { // if the file is not found it will show up with this error, this is used with a try catch statement

            System.out.println("Can't open file" + file);

        } catch (IOException ex) { // This is the input and output exception catch, which is used with a try catch statement

            System.out.println("Error reading file" + file);

        }
    }

    public static void censorThis() {
        
        for (int i = 0; i < splitWords.size(); i++) {
            
            if (Arrays.asList(censoredWords).contains(splitWords.get(i).toUpperCase())) {
                
              splitWords.set(i, censorOption);
              
              System.out.println(splitWords.get(i));
                
            } else {
                
                System.out.println(splitWords.get(i));
            }
        }
    }

}
