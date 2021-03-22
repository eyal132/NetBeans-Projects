/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungry;

import java.util.*;
/**
 *
 * @author Eyal Blumental Erez
 */
public class Hungry {
public static String[] stomach = new String[5];
// this array is visible to all methods in the code and creates 5 slots in the array called stomach which expects strings
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        stomach[3] = "pizza";
        int stomachFull = 0;
        boolean hungry = true;
        while (hungry) {
        if (stomachFull < 5) {
         stomach[stomachFull] = userInput("What did you last eat?");
         // this asks the user the question and stores in the number that stomachFull is which in this case is or 0, 1, 2, 3, or 4, and saves the users
         // input as a string in the array
         stomachFull++;
        } else {
            digest();
            stomachFull = 0;
        }
        if (stomachFull < 5){
         String typing = userInput("Are you full? y/n");
         typing = typing.toLowerCase();
         if(typing.equals("y") || typing.equals("yes")) {
             hungry = false;
         }
        }
       }
    }
    // when the user eats 5 foods the code replies and says what the user has eaten and resets the array.
    public static void digest(){
        for(int i = 0; i < stomach.length; i++) {
            System.out.println("You ate " + stomach[i]);
                        stomach[i] = "acid";
        }
    }
    
    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }
    
}
