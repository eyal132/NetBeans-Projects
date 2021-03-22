/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;
// this java.util.* is importing special features such as keyboard scanner and random.

import java.util.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class GuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean incorrect = true;
        /* this random dice chunk of code is creating a random number that is chosen by the user with the difficulty easy, medium, or hard. The int answer is
    just storing the integer and then gets used in another bit of code. */
        Random dice = new Random();
        int answer = dice.nextInt(1000) + 1;
        int attempts = 15;
        String write = "";
        int guess = 0;
        int tries = 0;
        int difficulty = 0;
        String restart = "restart";
        String restartAnswer = "";
        write = userInput("Choose a difficulty, Easy, Medium, or Hard.");
        write = write.toLowerCase();
        if (write.equals("medium")) {
            difficulty = 1000;
            answer = dice.nextInt(difficulty) + 1;
            write = userInput("Guess a number between 0 and " + difficulty);
        } else if (write.equals("easy")) {
            difficulty = 100;
            answer = dice.nextInt(difficulty) + 1;
            write = userInput("Guess a number between 0 and " + difficulty);
        } else if (write.equals("hard")) {
            difficulty = 10000;
            answer = dice.nextInt(difficulty) + 1;
            write = userInput("Guess a number between 0 and " + difficulty);
        }
        guess = Integer.parseInt(write);

        while (incorrect) {
            if (attempts <= 5) {
                System.out.println("Warning " + attempts + " attempts left!");
            }
            attempts = attempts - 1;
            /* this if satement is asking a similar question to the if statement below that is asking to restart,
            this if statement is also asking if the user wants to restart but because he/she is out of guesses.
            
             */
            if (attempts < 0) {
                restartAnswer = userInput("You are out of guesses! Type restart to play again...");
                restartAnswer = restartAnswer.toLowerCase();
                if (restartAnswer.equals(restart)) {
                    attempts = 15;
                    tries = 0;
                    guess = 0;
                    guess = Integer.parseInt(write);
                    answer = dice.nextInt(difficulty) + 1;
                    write = userInput("Choose a difficulty, Easy, Medium, or Hard.");
                    write = write.toLowerCase();
                    // this if else if statement is asking the difficulty that the user wants and changes the random integer to the chosen difficulty.
                    if (write.equals("medium")) {
                        difficulty = 1000;
                        answer = dice.nextInt(difficulty) + 1;
                        write = userInput("Guess a number between 0 and 1,000");
                    } else if (write.equals("easy")) {
                        difficulty = 100;
                        answer = dice.nextInt(difficulty) + 1;
                        write = userInput("Guess a number between 0 and 100");
                    } else if (write.equals("hard")) {
                        difficulty = 10000;
                        answer = dice.nextInt(difficulty) + 1;
                        write = userInput("Guess a number between 0 and 10,000");
                    }
                } else {
                    System.out.println("Closing...");
                    incorrect = false;
                }
            } else {
                if (answer < guess) {
                    write = userInput("Your chosen number is too high! try again...");
                    guess = Integer.parseInt(write);
                    tries = tries + 1;
                } else if (answer > guess) {
                    write = userInput("Your chosen number is too low! try again...");
                    guess = Integer.parseInt(write);
                    tries = tries + 1;
                } else {
                    restartAnswer = userInput("You found the correct number in " + tries + " tries. Type restart to play again...");
                    /* this if statement is simply checking if the question above asked to the user is equal to restart which then asks the user another
                    question what difficulty it wants and changes the randon number to the number the user wants. */
                    if (restartAnswer.equals("restart")) {
                        attempts = 15;
                        tries = 0;
                        System.out.println("Restarting...");
                        write = userInput("Choose a difficulty, Easy, Medium, or Hard.");
                        write = write.toLowerCase();
                        if (write.equals("medium")) {
                            difficulty = 1000;
                            answer = dice.nextInt(difficulty) + 1;
                            write = userInput("Guess a number between 0 and 1,000");
                        } else if (write.equals("easy")) {
                            difficulty = 100;
                            answer = dice.nextInt(difficulty) + 1;
                            write = userInput("Guess a number between 0 and 100");
                        } else if (write.equals("hard")) {
                            difficulty = 10000;
                            answer = dice.nextInt(difficulty) + 1;
                            write = userInput("Guess a number between 0 and 10,000");
                        }
                    } else {
                        System.out.println("Closing...");
                        incorrect = false;
                    }
                }
            }
        }

    }
// This public static method is asking the user a question and is scanning the keyboard for an answer and sending it back as a string to the main method

    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

}
