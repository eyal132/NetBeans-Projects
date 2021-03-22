/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detention;

import java.util.*;

/**
 * version 1
 *
 * @author Eyal Blumental Erez
 */
public class Detention {

    public static int classSize = 30;
    public static String[] classNumber = new String[classSize];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numberOfPeople = 0;
        boolean running = true;
        String userAnswer = "";
        int numberWhile = 0;
        while (numberWhile <= (classSize - 1)) {
            classNumber[numberWhile] = "";
            numberWhile++;
        }
        numberWhile = 0;
        while (running) {
            if (numberOfPeople < classSize) {
                userAnswer = userInput("Type add to add students, type remove to remove students, type display to show all students in detention, or type quit to stop");
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("add")) {
                    userAnswer = userInput("What's the name of the student you want to add?");
                    userAnswer = userAnswer.toLowerCase();
                    numberWhile = 0;
                    while (numberWhile <= (classSize - 1)) {
                        if (classNumber[numberWhile].equals("")) {
                            classNumber[numberWhile] = userAnswer;
                            System.out.println("Added " + userAnswer + " to the detention list");
                            System.out.println((numberOfPeople + 1) + " students are in detention");
                            numberOfPeople++;
                            numberWhile = classSize;
                        }
                        numberWhile++;
                    }
                } else if (userAnswer.equals("quit")) {
                    System.out.println("Closing");
                    running = false;
                } else if (userAnswer.equals("display")) {
                    List();
                } else if (userAnswer.equals("remove")) {
                    userAnswer = userInput("What is the name of the student you want to remove?");
                    userAnswer = userAnswer.toLowerCase();
                    numberWhile = 0;
                    while (numberWhile <= (classSize - 1)) {
                        if (userAnswer.equals(classNumber[numberWhile])) {
                            classNumber[numberWhile] = "";
                            System.out.println(userAnswer + " has been removed from the list");
                            numberOfPeople--;
                            numberWhile = classSize;
                        }
                        numberWhile++;
                    }
                } else {
                    System.out.println("Error! Not an User/Option not found");
                }
            } else if (numberOfPeople >= (classSize - 1)) {
                userAnswer = userInput("Class is full would you like to QUIT, REMOVE someone, or DISPLAY all people in detention?");
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("quit")) {
                    System.out.println("Closing");
                    running = false;
                } else if (userAnswer.equals("display")) {
                    List();
                } else if (userAnswer.equals("remove")) {
                    userAnswer = userInput("What is the name of the student you want to remove?");
                    userAnswer = userAnswer.toLowerCase();
                    numberWhile = 0;
                    while (numberWhile <= (classSize - 1)) {
                        if (userAnswer.equals(classNumber[numberWhile])) {
                            classNumber[numberWhile] = "";
                            System.out.println("Removed " + userAnswer + " from the detention list");
                            numberOfPeople--;
                            numberWhile = classSize;
                        }
                        numberWhile++;
                    }

                } else {
                    System.out.println("Error! Not an option");
                }
            }
        }
    }

    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public static void List() {
        for (int i = 0; i < classNumber.length; i++) {
            if (classNumber[i].equals("")) {
                break;
            }
            System.out.println("Student: " + classNumber[i]);
        }
    }

}
