/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagetranslator;

//This imports the packages that we need for arrayLists and readers etc.
import java.util.*;
import java.io.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class LanguageTranslator {

    public static int languagePointer = 0;

    //This arrayList is created to keep all the split words for translation and printing
    public static ArrayList<String> splitWords = new ArrayList<String>();

    //This changes to which radio button is pressed so that the code knows which language to translate from.
    public static String languageOption = "ENGLISH";

    //This array has punctuation which is used to make sure that it doesn't affect translation when it is seen in text, array used in GUI.java.
    public static final String[] PUNCTUATION = {".", ",", "!", "?", ";", ":"};

    //This creates a new 2d array to store all the words that the code will look for to translate
    public static String WORDS_TO_CHECK[][] = new String[39][2];

    public static String[][] EXTRA_WORDS = new String[9][5];

    /**
     * this reader method splits up the words in the sentence of whatsThere, it
     * then adds the words into the splitWords arrayList in the for loop, it
     * then calls the method checkTranslate to translate any words that are
     * needing to get translated
     *
     * @param whatsThere 
     */
    public static void Reader(String whatsThere) {

        wordsToAdd();

// this is splitting up words from the whatsThere string into individual words to the words[] array
        String words[] = whatsThere.split(" |(?=\\.)|(?=\\,)|(?=\\!)|(?=\\?)|(?=\\;)|(?=\\:)");

        // clears array of split words
        splitWords.clear();

        // this adds words in the array from the textbox
        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            splitWords.add(word);

            System.out.println(word);
        }

        splitWords.add(" ");

        splitWords.add(" ");

        splitWords.add(" ");

        Translate();

    }

    /**
     * This method is creating all the words needed in the 2d array in order to
     * be able to recognize them for translation.
     */
    public static void wordsToAdd() {

        WORDS_TO_CHECK[0][0] = "ONE";
        WORDS_TO_CHECK[1][0] = "TWO";
        WORDS_TO_CHECK[2][0] = "THREE";
        WORDS_TO_CHECK[3][0] = "FOUR";
        WORDS_TO_CHECK[4][0] = "FIVE";
        WORDS_TO_CHECK[5][0] = "CIRCLE";
        WORDS_TO_CHECK[6][0] = "SQUARE";
        WORDS_TO_CHECK[7][0] = "RECTANGLE";
        WORDS_TO_CHECK[8][0] = "BLUE";
        WORDS_TO_CHECK[9][0] = "GREEN";
        WORDS_TO_CHECK[10][0] = "YELLOW";
        WORDS_TO_CHECK[11][0] = "WHITE";
        WORDS_TO_CHECK[12][0] = "ONE";
        WORDS_TO_CHECK[13][0] = "CIRClE";
        WORDS_TO_CHECK[14][0] = "TEN";
        WORDS_TO_CHECK[15][0] = "SIX";
        WORDS_TO_CHECK[16][0] = "SEVEN";
        WORDS_TO_CHECK[17][0] = "EIGHT";
        WORDS_TO_CHECK[18][0] = "NINE";
        WORDS_TO_CHECK[19][0] = "TWENTY";
        WORDS_TO_CHECK[20][0] = "THIRTY";
        WORDS_TO_CHECK[21][0] = "FOURTY";
        WORDS_TO_CHECK[22][0] = "FIFTY";
        WORDS_TO_CHECK[23][0] = "SIXTY";
        WORDS_TO_CHECK[24][0] = "SEVENTY";
        WORDS_TO_CHECK[25][0] = "EIGHTY";
        WORDS_TO_CHECK[26][0] = "NINETY";
        WORDS_TO_CHECK[27][0] = "ELEVEN";
        WORDS_TO_CHECK[28][0] = "TWELVE";
        WORDS_TO_CHECK[29][0] = "THIRTEEN";
        WORDS_TO_CHECK[30][0] = "FOURTEEN";
        WORDS_TO_CHECK[31][0] = "FIFTEEN";
        WORDS_TO_CHECK[32][0] = "SIXTEEN";
        WORDS_TO_CHECK[33][0] = "SEVENTEEN";
        WORDS_TO_CHECK[34][0] = "EIGHTEEN";
        WORDS_TO_CHECK[35][0] = "NINETEEN";
        WORDS_TO_CHECK[36][0] = "TRIANGLE";
        WORDS_TO_CHECK[37][1] = "OVAL";
        WORDS_TO_CHECK[38][1] = "OVAL";
        WORDS_TO_CHECK[0][1] = "TAHI";
        WORDS_TO_CHECK[1][1] = "RUA";
        WORDS_TO_CHECK[2][1] = "TORU";
        WORDS_TO_CHECK[3][1] = "WHA";
        WORDS_TO_CHECK[4][1] = "RIMA";
        WORDS_TO_CHECK[5][1] = "POROHITA";
        WORDS_TO_CHECK[6][1] = "TAPAWHA";
        WORDS_TO_CHECK[7][1] = "TAAPIRI";
        WORDS_TO_CHECK[8][1] = "PURU";
        WORDS_TO_CHECK[9][1] = "MATOMATO";
        WORDS_TO_CHECK[10][1] = "KOWHAI";
        WORDS_TO_CHECK[11][1] = "MA";
        WORDS_TO_CHECK[12][1] = "KOTAHI";
        WORDS_TO_CHECK[13][1] = "AWHIO";
        WORDS_TO_CHECK[14][1] = "TEKAU";
        WORDS_TO_CHECK[15][1] = "ONO";
        WORDS_TO_CHECK[16][1] = "WHITU";
        WORDS_TO_CHECK[17][1] = "WARU";
        WORDS_TO_CHECK[18][1] = "IWA";
        WORDS_TO_CHECK[19][1] = "RUA TEKAU";
        WORDS_TO_CHECK[20][1] = "TORU TEKAU";
        WORDS_TO_CHECK[21][1] = "WHA TEKAU";
        WORDS_TO_CHECK[22][1] = "RIMA TEKAU";
        WORDS_TO_CHECK[23][1] = "ONO TEKAU";
        WORDS_TO_CHECK[24][1] = "WHITU TEKAU";
        WORDS_TO_CHECK[25][1] = "WARU TEKAU";
        WORDS_TO_CHECK[26][1] = "IWA TEKAU";
        WORDS_TO_CHECK[27][1] = "TEKAU MA TAHI";
        WORDS_TO_CHECK[28][1] = "TEKAU MA RUA";
        WORDS_TO_CHECK[29][1] = "TEKAU MA TORU";
        WORDS_TO_CHECK[30][1] = "TEKAU MA WHA";
        WORDS_TO_CHECK[31][1] = "TEKAU MA RIMA";
        WORDS_TO_CHECK[32][1] = "TEKAU MA ONO";
        WORDS_TO_CHECK[33][1] = "TEKAU MA WHITU";
        WORDS_TO_CHECK[34][1] = "TEKAU MA WARU";
        WORDS_TO_CHECK[35][1] = "TEKAU MA IWA";
        WORDS_TO_CHECK[36][1] = "TAPATORU";
        WORDS_TO_CHECK[37][1] = "POROHEMA";
        WORDS_TO_CHECK[38][1] = "POROTITAHA";

        EXTRA_WORDS[0][0] = "TEKAU";
        EXTRA_WORDS[1][0] = "RUA";
        EXTRA_WORDS[2][0] = "TORU";
        EXTRA_WORDS[3][0] = "WHA";
        EXTRA_WORDS[4][0] = "RIMA";
        EXTRA_WORDS[5][0] = "ONO";
        EXTRA_WORDS[6][0] = "WHITU";
        EXTRA_WORDS[7][0] = "WARU";
        EXTRA_WORDS[8][0] = "IWA";
        EXTRA_WORDS[0][1] = "TAHI";
        EXTRA_WORDS[1][1] = "RUA";
        EXTRA_WORDS[2][1] = "TORU";
        EXTRA_WORDS[3][1] = "WHA";
        EXTRA_WORDS[4][1] = "RIMA";
        EXTRA_WORDS[5][1] = "ONO";
        EXTRA_WORDS[6][1] = "WHITU";
        EXTRA_WORDS[7][1] = "WARU";
        EXTRA_WORDS[8][1] = "IWA";
        EXTRA_WORDS[0][2] = "ELEVEN";
        EXTRA_WORDS[1][2] = "TWELVE";
        EXTRA_WORDS[2][2] = "THIRTEEN";
        EXTRA_WORDS[3][2] = "FOURTEEN";
        EXTRA_WORDS[4][2] = "FIFTEEN";
        EXTRA_WORDS[5][2] = "SIXTEEN";
        EXTRA_WORDS[6][2] = "SEVENTEEN";
        EXTRA_WORDS[7][2] = "EIGHTEEN";
        EXTRA_WORDS[8][2] = "NINETEEN";
        EXTRA_WORDS[0][3] = "TWENTY";
        EXTRA_WORDS[1][3] = "THIRTY";
        EXTRA_WORDS[2][3] = "FOURTY";
        EXTRA_WORDS[3][3] = "FIFTY";
        EXTRA_WORDS[4][3] = "SIXTY";
        EXTRA_WORDS[5][3] = "SEVENTY";
        EXTRA_WORDS[6][3] = "EIGHTY";
        EXTRA_WORDS[7][3] = "NINETY";
        EXTRA_WORDS[8][3] = " ";
        EXTRA_WORDS[0][4] = "ONE";
        EXTRA_WORDS[1][4] = "TWO";
        EXTRA_WORDS[2][4] = "THREE";
        EXTRA_WORDS[3][4] = "FOUR";
        EXTRA_WORDS[4][4] = "FIVE";
        EXTRA_WORDS[5][4] = "SIX";
        EXTRA_WORDS[6][4] = "SEVEN";
        EXTRA_WORDS[7][4] = "EIGHT";
        EXTRA_WORDS[8][4] = "NINE";

    }

    /**
     * This goes through an algorithm that checks if a words needs to be
     * translated and exactly which word needs to be swapped out. It then takes
     * the opposing array and swaps out the word in the splitWords array in
     * order to translate. If it is a number it goes through a separate
     * algorithm which looks at another 2d array which has different numbers in
     * different places in order to translate numbers up to 99.
     */
    public static void Translate() {

        /**
         * this checks which radio button has been chosen, in this case if it is
         * English it goes through this part of the translator
         */
        if (languageOption.equals("ENGLISH")) {

            languagePointer = 0;

        } else if (languageOption.equals("MAORI")) {

            languagePointer = 1;

        }

        // this selects a positioin in the array to help translate the word
        int pointer = 0;

        int wordPointer = 0;

        // this tells the checkTranslate while loop to stop looping when the translated word is found
        boolean foundWord = false;

        /**
         * This for loop is going through all the words in the splitWords array
         * to make sure that they are all checked and translated, there are a
         * few more for loops in this loop which is to check which column in the
         * 2d array needs to be selected and which word it is which is the rows
         * in the 2d array. There is also another process that the words go
         * through which is the number for loops which are in an if statement
         * that check if that specific word is a number and if it is it needs to
         * go through the number algorithm that checks what number is written
         * down with the use of i+2 and i+3 to check ahead of the word, this
         * algorithm relies on both EXTRA_WORDS 2d array and WORDS_TO_CHECK
         * array.
         */
        for (int i = 0; i < splitWords.size(); i++) {

            foundWord = false;

            for (wordPointer = 0; wordPointer < (WORDS_TO_CHECK.length); wordPointer++) {

                String extraLetterCheck = WORDS_TO_CHECK[wordPointer][languagePointer] + "S";

                if (Arrays.asList(WORDS_TO_CHECK[wordPointer][languagePointer]).contains(splitWords.get(i).toUpperCase())) {

                    pointer = wordPointer;

                    foundWord = true;

                    int extraWordPointer = 0;

                    boolean extraFoundWord = false;

                    int languageChecker = 0;

                    boolean wordChecker = false;

                    int secondLanguagePointer = 0;

                    secondLanguagePointer = languagePointer;

                    for (int b = 0; b < EXTRA_WORDS.length; b++) {

                        if (EXTRA_WORDS[b][languageChecker].contains(WORDS_TO_CHECK[pointer][languagePointer])) {

                            wordChecker = true;

                            b = EXTRA_WORDS.length;

                        } else if (b == EXTRA_WORDS.length - 1 && languageChecker < 3) {

                            languageChecker++;

                            b = -1;

                        } else if (b == EXTRA_WORDS.length - 1 && languageChecker <= 4) {

                            if (secondLanguagePointer == 0) {

                                secondLanguagePointer = 1;

                            } else if (secondLanguagePointer == 1) {

                                secondLanguagePointer = 0;

                            }

                            splitWords.set(i, WORDS_TO_CHECK[pointer][secondLanguagePointer].toLowerCase());

                            b = EXTRA_WORDS.length;

                        }

                    }

                    if (languagePointer == 1 && wordChecker == true) {

                        extraWordPointer = 1;

                        extraFoundWord = false;

                        for (int p = 0; p < EXTRA_WORDS.length; p++) {

                            if (WORDS_TO_CHECK[pointer][1].toUpperCase().contains(EXTRA_WORDS[p][extraWordPointer].toUpperCase()) && extraFoundWord == false) {

                                if (extraWordPointer == 0) {

                                    extraWordPointer = 1;
                                }

                                for (int q = 0; q < EXTRA_WORDS.length; q++) {

                                    try {

                                        if (p == 0 && splitWords.get(i + 1).toUpperCase().equals("TEKAU")) {

                                        } else {

                                            try {

                                                if (splitWords.get(i + 1).toUpperCase().equals("TEKAU") && splitWords.get(i + 2).equals("ma") == false && splitWords.get(i + 3).equals("ma") == false) {

                                                    splitWords.set(i, EXTRA_WORDS[p - 1][3].toLowerCase());

                                                    splitWords.remove(i + 1);

                                                    q = EXTRA_WORDS.length;

                                                }
                                            } catch (IndexOutOfBoundsException ex) {

                                            }

                                            if (!splitWords.get(i + 2).equals("") || !splitWords.get(i + 3).equals("")) {

                                                if (splitWords.get(i + 3).toUpperCase().contains(EXTRA_WORDS[q][extraWordPointer].toUpperCase()) || splitWords.get(i + 2).toUpperCase().contains(EXTRA_WORDS[q][extraWordPointer].toUpperCase())) {

                                                    if ((splitWords.get(i + 2)).equals("ma") && p > 0) {

                                                        splitWords.set(i, EXTRA_WORDS[p - 1][3].toLowerCase() + " " + EXTRA_WORDS[q][4].toLowerCase());

                                                        splitWords.remove(i + 3);

                                                        splitWords.remove(i + 2);

                                                        splitWords.remove(i + 1);

                                                        q = EXTRA_WORDS.length;

                                                        extraFoundWord = true;

                                                    } else if ((splitWords.get(i + 1)).equals("ma")) {

                                                        splitWords.set(i, EXTRA_WORDS[q][2].toLowerCase());

                                                        System.out.println(splitWords.get(i));

                                                        splitWords.remove(i + 1);

                                                        splitWords.remove(i + 2);

                                                        q = EXTRA_WORDS.length - 1;

                                                        extraFoundWord = true;

                                                    }

                                                }
                                            }
                                        }

                                    } catch (IndexOutOfBoundsException ex) {

                                        System.out.println("Error!");

                                    }

                                    if (q == EXTRA_WORDS.length - 1 && extraFoundWord == false) {

                                        splitWords.set(i, WORDS_TO_CHECK[pointer][0].toLowerCase());

                                        extraFoundWord = true;

                                    }

                                }

                            }

                        }

                    } else if (wordChecker == true) {

                        for (int p = 0; p < EXTRA_WORDS.length - 1; p++) {

                            extraWordPointer = 2;

                            extraFoundWord = false;

                            if (WORDS_TO_CHECK[pointer][0].toUpperCase().contains(EXTRA_WORDS[p][extraWordPointer + 1].toUpperCase()) && extraFoundWord == false) {

                                if (extraWordPointer == 2) {

                                    extraWordPointer = 1;

                                }

                                for (int q = 0; q < EXTRA_WORDS.length; q++) {

                                    try {
                                        
                                        if (splitWords.get(i + 1).toUpperCase().contains(EXTRA_WORDS[q][4].toUpperCase())) {

                                            splitWords.set(i, EXTRA_WORDS[p + 1][0].toLowerCase() + " tekau ma " + EXTRA_WORDS[q][1].toLowerCase());

                                            extraFoundWord = true;

                                            splitWords.remove(i + 1);

                                            q = EXTRA_WORDS.length;

                                            p = EXTRA_WORDS.length;

                                        }
                                        
                                    } catch (IndexOutOfBoundsException ex) {

                                        System.out.println("Error!");

                                    }

                                }

                            } else if (p == EXTRA_WORDS.length - 3 && p > 6) {

                                splitWords.set(i, WORDS_TO_CHECK[pointer][1].toLowerCase());

                                pointer = 0;

                                wordPointer = WORDS_TO_CHECK.length + 1;

                            } else if (WORDS_TO_CHECK[pointer][0].toUpperCase().contains(EXTRA_WORDS[p][extraWordPointer].toUpperCase()) && extraFoundWord == false) {

                                splitWords.set(i, WORDS_TO_CHECK[pointer][1].toLowerCase());

                            }

                        }

                    }

                } else if (extraLetterCheck.equals(splitWords.get(i).toUpperCase())) {

                    String word = splitWords.get(i);

                    String singleWord = splitWords.get(i).substring(0, word.length() - 1);

                    splitWords.set(i, singleWord);

                    wordPointer--;

                }

            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI UI = new GUI();
        UI.setVisible(true);
    }

}
