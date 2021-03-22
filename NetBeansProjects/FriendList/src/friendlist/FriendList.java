/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendlist;

import java.util.*;

/**
 *
 * @author Eyal Blumental Erez
 */
public class FriendList {

    public static String[] friends = new String[4];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean Questions = true;
        String userAnswer = "";
        int numberFriends = 0;
        String prefixNumber = "";

        while (Questions) {
            if (numberFriends < 4) {
                if (numberFriends == 0) {
                    prefixNumber = "st";
                } else if (numberFriends == 1) {
                    prefixNumber = "nd";
                } else if (numberFriends == 2) {
                    prefixNumber = "rd";
                } else if (numberFriends == 3) {
                    prefixNumber = "th";
                }
                friends[numberFriends] = userInput("Who is your " + (numberFriends + 1) + prefixNumber + " friend");
                friends[numberFriends] = friends[numberFriends].toLowerCase();
                numberFriends++;
            } else {
                userAnswer = userInput("Do you want to see your list of friends?");
                if (userAnswer.equals("yes") || userAnswer.equals("sure") || userAnswer.equals("ok")) {
                    friendList();
                    Questions = false;
                } else {
                    System.out.println("Closing");
                    Questions = false;
                }
            }
        }
    }

    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public static void friendList() {
        System.out.println("Your friends are");
        for (int i = 0; i < friends.length; i++) {
            System.out.println(friends[i]);
        }
    }
}
