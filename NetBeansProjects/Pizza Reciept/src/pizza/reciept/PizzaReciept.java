/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizza.reciept;

import java.util.*;
// This import is importing important features to the code so that the feature scanner for example will work, 

/**
 * Version 1: Basic questions working, add, and quit working, display Work In
 * Progress , quit Work In Progress, no money calculations.
 *
 * Version 2: Added money to receipt including cost when displaying, added pizza
 * options and thickness options with calculations to change price to thickness
 * options. Added restart option to clean the receipt. 4 options on the menu.
 * Remove pizza option removes price in relation to what type of pizza is
 * getting removed.
 *
 * Version 3: fixed lots of bugs in code such as removing pizza that don't exist
 * etc. tweaked the finding and removing chunks of code to have and error
 * message when there is no pizza found with that name. Added more user-friendly
 * visual look and easier to read the program when running. Added limit to
 * receipt of 10 pizza
 *
 * Version 4: added a more complex version of finding and removing a pizza, this
 * makes the orders more flexible by doing as said, to add a pizza it takes the
 * user's answer and find an open slot in the array which is "" and then adds
 * the user's answer to that open slot, before it was just ask for pizza and
 * paste into array. To remove it find takes the user's answer and goes through
 * the whole array looking for the same string and then sets that to "" which
 * then makes that array slot open. Even more bug fixes eg: saying you want to
 * remove "" pizza, simplified code by making more methods to make code more
 * readable, comments added, made restart method more flexible by setting every
 * slot to "" and not null.
 *
 * Version 5: Simplified the code with more methods to make it easier to
 * understand when programming, added Add() void method, added Remove() void
 * method which both used to be embedded in the code, removed thickness of pizza
 * due to complexity of price change, more bug fixes E.G: won't let user restart
 * receipt if it is full, made remove method more flexible by only removing one
 * pizza of the same type E.G: removing the first jumbo pizza on the receipt and
 * not all of them. Added Clear void method which makes the output for the user
 * more visually pleasing and is easier to read and less clustered.
 *
 * @author Eyal Blumental Erez
 */
public class PizzaReciept {

    public static int numberOfPizzas = 0; // this variable is keeping track of the amount of pizzas that are in the receipt

    public static int orderSize = 10; // size of the array

    public static String[] pizzaNumber = new String[orderSize]; // creates the array to store pizzas

    public static double totalPizzaPrice = 0;

    public static String userAnswer = ""; // stors user's answers

    public static int numberWhile = 0;
    /* this integer is making sure that the add and remove methods don't try to read more than the actual array size,
    this causes the program to crash so this integer is going up when the add or remove method is running up to the orderSize integer which then stops
    the loop at the end of the array which is almost like a fail safe if the user types an invalied name or the receipt is full. */

    public static boolean foundPizza = false; // this true/false tells the code if the user's answer is found when searching for the pizza or option if
    // the boolean equals false then it will tell the user that the option/pizza is not found

    /**
     * this integer helps the add and remove while loop to not go over the array
     * size and also helps to scroll through the array which is looking for the
     * user's answer or looking for an open space in the array.
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean running = true; // this is the ture/false loop that is running all the code and is set to false when wanted to close the program
        while (numberWhile <= (orderSize - 1)) { // this while loop is setting all the slots in the array to "" because if nothing is asigned to the
            // array it is null and the code can't detect null so it is all set to ""
            pizzaNumber[numberWhile] = "";
            numberWhile++;
        }
        numberWhile = 0;
        System.out.println("Welcome to Bob's Big Pizzas in Boston");
        Clear();
        while (running) { // this while loop runs the whole code and sets running to false to close the loop
            if (numberOfPizzas < orderSize) { // this if statement is making sure that the program doesn't crash
                userAnswer = userInput("Type ADD to add pizza, type REMOVE to remove pizza, type RESTART to clean the receipt, type DISPLAY to show all pizzas on receipt, or type QUIT to close");
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("add")) { // these series of if statements are checking for user's answer's and doing what the user wants, eg: add pizza
                    Clear();
                    System.out.println("Pepperoni $3.00");
                    System.out.println("Margarita $3.00");
                    System.out.println("Meat Lovers $5.00");
                    System.out.println("Jumbo $7.00");
                    userAnswer = userInput("What pizza do you want to add?");
                    userAnswer = userAnswer.toLowerCase();
                    numberWhile = 0;
                    if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita") || userAnswer.equals("meat lovers") || userAnswer.equals("jumbo")) {
                        if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita")) { // this is checking for a valid answer
                            totalPizzaPrice = totalPizzaPrice + 3; // this is too add the price
                        } else if (userAnswer.equals("meat lovers")) {
                            totalPizzaPrice = totalPizzaPrice + 5;
                        } else if (userAnswer.equals("jumbo")) {
                            totalPizzaPrice = totalPizzaPrice + 7;
                        }
                        Add();
                        if (foundPizza == false) { // this is the boolean which tells the code that if it cannot add or remove a pizza it says pizza not found.
                            Clear();
                            System.out.println("Error! Pizza not found");
                            Clear();
                        }
                    } else { // if user types a non-valid word it says error
                        Clear();
                        System.out.println("Error! Pizza/Option not found");
                        Clear();
                    }
                } else if (userAnswer.equals("quit")) {
                    Clear();
                    System.out.println("Closing");
                    running = false;
                } else if (userAnswer.equals("display")) {
                    Clear();
                    List(); // goes to a void method that doesn't return anything and is creating a loop which is printing out anything that has a pizza
                    // order in
                } else if (userAnswer.equals("remove")) {
                    if (numberOfPizzas > 0) {
                        Clear();
                        userAnswer = userInput("What is the name of the pizza you want to remove?");
                        userAnswer = userAnswer.toLowerCase();
                        Remove();
                        if (foundPizza) {
                            if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita")) { // same as adding pizza price this removes pizza price
                                // when removing pizza, price is reduced to the total price due to pizza that the user has teken out of the receipt
                                totalPizzaPrice = totalPizzaPrice - 3;
                            } else if (userAnswer.equals("meat lovers")) {
                                totalPizzaPrice = totalPizzaPrice - 5;
                            } else if (userAnswer.equals("jumbo")) {
                                totalPizzaPrice = totalPizzaPrice - 7;
                            }
                        }
                    } else {
                        Clear();
                        System.out.println("Error! There are no pizzas on the list");
                        Clear();
                    }
                } else if (userAnswer.equals("restart")) { // if user types restart it sets the price and all array slots to "" and not to null because
                    // the code wouldn't recognise that as an open slot to insert a pizza in
                    totalPizzaPrice = 0;
                    numberWhile = 0;
                    numberOfPizzas = 0;
                    while (numberWhile <= (orderSize - 1)) {
                        pizzaNumber[numberWhile] = "";
                        numberWhile++;
                    }
                    numberWhile = 0;
                    System.out.println("Receipt is cleaned");
                    Clear();
                } else {
                    Clear();
                    System.out.println("Error! Option not found");
                    Clear();
                }
            } else if (numberOfPizzas >= (orderSize - 1)) { // when receipt is full you cannot add anymore pizzas this is when 
                // numberOfPizzas equals orderSize
                userAnswer = userInput("Receipt is full would you like to QUIT, REMOVE a pizza, RESTART, or DISPLAY all pizzas on the receipt?");
                userAnswer = userAnswer.toLowerCase();
                if (userAnswer.equals("quit")) {
                    System.out.println("Closing");
                    running = false;
                } else if (userAnswer.equals("display")) {
                    List();
                } else if (userAnswer.equals("remove")) {
                    if (numberOfPizzas >= 0) {
                        userAnswer = userInput("What is the name of the pizza you want to remove?");
                        userAnswer = userAnswer.toLowerCase();
                        Remove();
                    } else {
                        Clear();
                        System.out.println("Error! Can't remove nothing");
                        Clear();
                    }
                    if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita")) {
                        totalPizzaPrice = totalPizzaPrice - 3;
                    } else if (userAnswer.equals("meat lovers")) {
                        totalPizzaPrice = totalPizzaPrice - 5;
                    } else if (userAnswer.equals("jumbo")) {
                        totalPizzaPrice = totalPizzaPrice - 7;
                    }

                } else if (userAnswer.equals("restart")) {
                    totalPizzaPrice = 0;
                    numberWhile = 0;
                    numberOfPizzas = 0;
                    while (numberWhile <= (orderSize - 1)) {
                        pizzaNumber[numberWhile] = "";
                        numberWhile++;
                    }
                    numberWhile = 0;
                    System.out.println("Receipt is cleaned");
                    Clear();
                } else {
                    Clear();
                    System.out.println("Error! Not an option");
                    Clear();
                }
            } else {
                Clear();
                System.out.println("Error! There are no pizzas on the receipt");
                Clear();
            }
        }
    }

    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public static void List() {
        for (int i = 0; i < pizzaNumber.length; i++) {
            if (!pizzaNumber[i].equals("")) {
                System.out.println("Pizza: " + pizzaNumber[i]);
            }
        }
        System.out.println("Price is: " + "$" + totalPizzaPrice);
    }

    public static void Remove() {
        /* this remove void method is looking in the array for the user's answer and goes through all the slots up until
        it reaches the end of the array, if it doesn't find the users answer in the array it will tell the user Error! Pizza not found, but if it finds it,
        it sets that specific slot to "" which therefore makes it an open slot and can be used for adding, this way makes the add and remove methods very
        flexible and is able to remove and add a pizza in any position in the array. */
        numberWhile = 0;
        foundPizza = false;
        if (!userAnswer.equals("")) {
            while (numberWhile <= (orderSize - 1)) {
                if (userAnswer.equals(pizzaNumber[numberWhile])) {
                    pizzaNumber[numberWhile] = "";
                    Clear();
                    System.out.println("Removed " + userAnswer + " from the receipt");
                    foundPizza = true;
                    Clear();
                    numberOfPizzas--;
                    numberWhile = orderSize;
                }
                numberWhile++;
            }
        }
        if (foundPizza == false) {
            Clear();
            System.out.println("Error! Pizza not found");
            Clear();
        }
    }

    public static void Add() {
        /* this add void method is very similar to the remove void method but instead of finding the users answer in the array
        it finds an open slot in the array regardless of where it is, this open slot equals "" and is not null because at the start of the code all
        the array slots are set to "" so that null isn't anywhere in the array so that the code can recognise the array slots as open or closed,
        this method finds an open slot "" and adds the user's answer to that specific array slot, if the array is full it will print out to the user that the
        receipt is full. */
        numberWhile = 0;
        foundPizza = false;
        while (numberWhile <= (orderSize - 1)) {
            /**
             * this while loop is running through all the array slots and looks
             * for a free slot which is "" and adds the user's answer to that
             * array slot, this way it can add pizza to previously removed array
             * slots because when a pizza is removed it is set to "" and
             * therefore turns it into an open slot in the array.
             */
            if (pizzaNumber[numberWhile].equals("")) {
                pizzaNumber[numberWhile] = userAnswer;
                Clear();
                System.out.println("Added " + userAnswer + " to the receipt");
                System.out.println((numberOfPizzas + 1) + " pizzas on the receipt");
                foundPizza = true; // if a pizza is added there will be no error message sent to the user,
                Clear();
                numberOfPizzas++;
                numberWhile = orderSize;
            }
            numberWhile++;
        }
        if (foundPizza == false) {
            Clear();
            System.out.println("Error! Pizza not found");
            Clear();
        }
    }

    public static void Clear() {
        numberWhile = 0;
        while (numberWhile <= 0) {
            System.out.println("");
            numberWhile++;
        }
    }
}