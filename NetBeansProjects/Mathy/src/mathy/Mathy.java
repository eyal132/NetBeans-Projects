/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathy;

import java.util.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class Mathy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     userInput();
     addition();
    }

    public static void addition() {
        double myAge = 0;
        double my2Age = 0;
        double theirAge = 99;
        double calcAge = (myAge/2) + 7;
        double minAge = calcAge - 1;
        double maxAge = calcAge + 1;
        
        if (calcAge > theirAge) {
           System.out.println("You are too old..." + "their age is " + theirAge + " years old");
        } else if (calcAge < theirAge) {
            System.out.println("You are too young..." + " their age is " + theirAge + " years old");
        } else if (calcAge > minAge || calcAge < maxAge){
            System.out.println("You are a perfect age, go ask them out." + " their age is " + theirAge + " years old");
        } else {
            System.out.println("Don't do it!");
        }
    }
        public static int userInput() {
        System.out.println("Enter your age to find a perfect match: ");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }
    
}
