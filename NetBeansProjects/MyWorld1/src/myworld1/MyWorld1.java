/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myworld1;

import java.util.*;

/**
 * Version 4
 *
 * @author Eyal Blumental Erez
 */
public class MyWorld1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String correctName = "eyal";
        String name = "";
        int alertNumber = 6;
        int Num = 3;
        boolean running = true;
// This While loop Asks for user input and has a correct name which it checks and says if you are right or wrong, there is a 3 attempt warning
        while (running) {
            name = userInput();
            name = name.toLowerCase();
            if (name.equals(correctName)) {
                System.out.println("Your name is " + name);
                System.out.println("You are awesome " + name);
            } else if (name.equals("quit")) {
                running = false;
            } else {
                System.out.println("Your name is " + name);
                System.out.println("You are bad " + name);
                alertNumber = alertNumber - 1;
                if (alertNumber < 3) {
                    System.out.println("Alert: " + Num + " Attempts Left!");
                    Num = Num - 1;
                    if (alertNumber < 0) {
                        System.out.println("Error! 0 Attempts Left! ");
                        running = false;
                    }
                }
            }
        }
    }
    
    public static String userInput() {
        System.out.println("Enter your name or type quit: ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
    
}