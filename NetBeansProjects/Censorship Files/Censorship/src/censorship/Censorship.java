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
// this array is storing banned words that will get censored if it recognises any of them in the txt file.  it is final because the words do not change
    private static final String[] censoredWords = {"RICKY", "CHOCOLATE", "KEITH", "CORBAN", "APPLE", "HAM", "SCHOOL", "PARIN", "TRASH", "CHICKEN", "SCHOOL"};

// this arrayList has all the words in the txt message.
    public static ArrayList<String> splitWords = new ArrayList<String>();

    // this String contains the option that wants to be censored as.
    public static String censorOption = "*****";

    public static void main(String[] args) {
        // This makes the GUI visible when running the code
        GUI UI = new GUI();
        UI.setVisible(true);
    }

    /**
     * This reader file is being called from the GUI.java file and reads the txt
     * message which then gets buffered and is then split up into individual
     * words, this then calls the censor method and the write a file method
     * which creates a new file and adds the censored words into that.
     */
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

            writeAFile(file.getName(), file.getParentFile().getPath());

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

    public static void writeAFile(String existingFileName, String path) {

        String newFileName = "CENSORED_" + existingFileName;

        File censoredFile = new File(path + File.separator + newFileName);

        try {

            if (!censoredFile.exists()) {

                censoredFile.createNewFile();

            }

            FileWriter fw = new FileWriter(censoredFile);

            BufferedWriter bw = new BufferedWriter(fw);

            String censoredText = " ";

            for (int i = 0; i < splitWords.size(); i++) {

                censoredText = censoredText + " " + splitWords.get(i);

            }

            bw.write(censoredText);

            bw.close();

        } catch (IOException ex) {

            System.out.println("Error writing file " + newFileName + " " + ex);

        }
    }

}
