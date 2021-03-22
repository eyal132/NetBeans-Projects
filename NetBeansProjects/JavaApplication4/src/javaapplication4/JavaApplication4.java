/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
// this java.util line is importing special features to the code so that we can have special features like scanner etc.

import java.util.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* These strings hold the answers that the user is typing in and is being 
        put into the if else statments and gets chcked to see if the user is 
        right or wrong. Each string represents one question that is being asked to 
        the user and is beign answered. */
        String answer = "";
        String answer2 = "";
        String answer3 = "";
        String answer4 = "";
        String answer5 = "";
        String answer6 = "";
        String quit = "";
        boolean run = true;
        /* this while loop is first checking if the user is ready to start by using the method down below to check for a response, 
        the if else statments are checking if the question answered was right and printing out to the screen if the user was right or if the user was wrong.
        then it asks the user again by calling the method which changes a string that is one of the answer strings and 
        then gets checked again if it is right or wrong. */
        while (run) {
            answer = userInput("If you were my friend you would know what to answer, enter start to begin");
            answer = answer.toLowerCase();
            if (answer.equals("start")) {
                answer2 = userInput("Is Anime good?");
                answer2 = answer2.toLowerCase();
                if (answer2.equals("yes") || (answer2.equals("maybe"))) { // checks if first question is right
                    System.out.println("You are correct!");
                    answer6 = userInput("What's the most unattractive english name?");
                    answer6 = answer6.toLowerCase();
                    if (answer6.equals("keith")) { // checks if second question is right
                        System.out.println("You are correct!");
                        answer3 = userInput("Whats a goat with one horn?");
                        answer3 = answer3.toLowerCase();
                        if (answer3.equals("unigoat")) { // checks if third question is right
                            System.out.println("You are correct!");
                            answer4 = userInput("Is chicken better than lamb?");
                            answer4 = answer4.toLowerCase();
                            if (answer4.equals("no")) { // checks if fourth question is right
                                System.out.println("You are correct!");
                                answer5 = userInput("Is Eyad bad at Fortnite?");
                                answer5 = answer5.toLowerCase();
                                if (answer5.equals("yes") || (answer5.equals("yeet"))) { // checks if last question is right
                                    System.out.println("You are correct!");
                                    System.out.println("You are a good friend!");

                                } else {
                                    System.out.println("Boy I'm calling you out! You'r a bad friend!!!");

                                }
                                run = false;
                            } else {
                                System.out.println("Boy I'm calling you out! You'r a bad friend!!!");
                                quit = userInput("Do you want to restart?");
                if (quit.equals("yes") || (quit.equals("ok") || (quit.equals("sure")))) { // This checks if the user has typed either yes, ok, or sure.
                                                                                          // And will restart the quiz if the user does type it in.
                } else {
                    run = false;
                }
                            }
                        } else {
                            System.out.println("Boy I'm calling you out! You'r a bad friend!!!");
                            quit = userInput("Do you want to restart?");
                   if (quit.equals("yes") || (quit.equals("ok") || (quit.equals("sure")))) {
                  
                } else {
                    run = false;
                }
                        }
                    } else {
                        System.out.println("Boy I'm calling you out! You'r a bad friend!!!");
                        quit = userInput("Do you want to restart?");
                if (quit.equals("yes") || (quit.equals("ok") || (quit.equals("sure")))) {
                  
                } else {
                    run = false;
                }
                    }
                } else {
                    System.out.println("Boy I'm calling you out! You'r a bad friend!!!");
                    quit = userInput("Do you want to restart?");
                if (quit.equals("yes") || (quit.equals("ok") || (quit.equals("sure")))) {
                  
                } else {
                    run = false;
                }
                }
            } else {
                System.out.println("You traitor!");
                quit = userInput("Do you want to restart?");
                if (quit.equals("yes") || (quit.equals("ok") || (quit.equals("sure")))) {
                  
                } else {
                    run = false;
                }
            }
            /* these else statments are punishing the user for getting the question wrong, the last if else statement is going to close the quiz
            regardless of if you get the quesion right or wrong */

        }
    }
    // this method is getting called everytime  a question is being asked and it reads what the user is typing and sends back an answer

    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
}
