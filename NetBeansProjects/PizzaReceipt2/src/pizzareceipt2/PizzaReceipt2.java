/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzareceipt2;

import java.util.*;
// This import is importing important features to the code so that the feature scanner for example will work, 

/**
 * Version 1: Basic questions working, add, and quit working, display Work In
 * Progress , quit Work In Progress, no money calculations.
 *
 * Version 2: Added money to receipt including cost when displaying, added pizza
 * options and thickness options with calculations to change price to thickness
 * options. Added reset option to clean the receipt. 4 options on the menu.
 * Remove pizza option removes price in relation to what type of pizza is
 * getting removed.
 *
 * Version 3: fixed lots of bugs in code such as removing pizza that don't exist
 * etc. tweaked the finding and removing chunks of code to have and error
 * message when there is no pizza found with that name. Added more user-friendly
 * visual look and easier to read the program when running. Added limit to
 * receipt of 10 pizza.
 *
 * Version 4: added a more complex version of finding and removing a pizza, this
 * makes the orders more flexible by doing as said, to add a pizza it takes the
 * user's answer and find an open slot in the array which is "" and then adds
 * the user's answer to that open slot, before it was just ask for pizza and
 * paste into array. To remove it find takes the user's answer and goes through
 * the whole array looking for the same string and then sets that to "" which
 * then makes that array slot open again. Even more bug fixes eg: saying you
 * want to remove "" pizza, simplified code by making more methods to make code
 * more readable, comments added, made reset method more flexible by setting
 * every slot to "" and not null.
 *
 * Version 5: Simplified the code with more methods to make it easier to
 * understand when programming, added Add() void method, added Remove() void
 * method which both used to be embedded in the code, removed thickness of pizza
 * due to complexity of price change, more bug fixes E.G: won't let user reset
 * receipt if it is full, made remove method more flexible by only removing one
 * pizza of the same type E.G: removing the first jumbo pizza on the receipt and
 * not all of them. Added Clear void method which makes the output for the user
 * more visually pleasing and is easier to read and less clustered.
 *
 * Version 6: Added save and load options to the menu but if program is closed
 * save of array is deleted, reorganized code due to the very large size and
 * hard to understand. Fixed more bugs for example the code wouldn't load or
 * save an array if the pizza receipt is full. Made finished code in new file
 * due to testing on other file.
 */
public class PizzaReceipt2 {

    public static int numberOfPizzas = 0; // this variable is keeping track of the amount of pizzas that are in the receipt

    public static int orderSize = 10; // size of the array

    public static String[] pizzaNumber = new String[orderSize]; // creates the array to store pizzas

    public static String[] pizzaNumberSave = new String[orderSize]; // creates a save variable for pizzaNumber for saving and loading a pizza receipt

    public static double totalPizzaPrice = 0; // total pizza price listed at the end of the pizza list

    public static double totalPizzaPriceSave = 0; // creates a save variable for totalPizzaPrice for saving and loading the cost

    public static int numberOfPizzasSave = 0; // creates a save variable for numberOfPizzas for saving and loading the amount of pizzas in the receipt

    public static String userAnswer = ""; // stors user's answers

    /**
     * this integer is making sure that any loop that is looking through the
     * code for something doesn't try to read more than the actual array size,
     * this causes the program to crash so this integer is going up when the add
     * or remove method is running up to the orderSize integer which then stops
     * the loop at the end of the array which is almost like a fail safe if the
     * user types an invalid name or the receipt is full. Without this integer
     * the code would crash everytime the user wants to save, load, add, or
     * remove anything from the receipt. This integer is used in calculations
     * which is reliant on the size of the actual array size so the array size
     * can be changed very easily and will not affect the code.
     */
    public static int numberLoop = 0;

    public static boolean foundPizza = false;

    /* this true/false tells the code if the user's answer is found when searching for the pizza or option if
    * the boolean equals false then it will tell the user that the option/pizza is not found */
    /**
     * @param args the command line arguments
     */
    /**
     * this is the main method, it runs all the logic code and calls any other
     * methods if said so in code. If this method is finished the whole program
     * finishes.
     */
    public static void main(String[] args) {

        boolean running = true; // this is the true/false loop that is running all the code and is set to false when wanted to close the program
        boolean savedReceipt = false;

        /**
         * this while loop is setting all the slots in the array to "" because
         * if nothing is assigned to the array it is null and the code can't
         * detect null so it is all set to ""
         */
        while (numberLoop <= (orderSize - 1)) {
            pizzaNumber[numberLoop] = "";
            numberLoop++;
        }
        numberLoop = 0;

        while (numberLoop <= (orderSize - 1)) { // sets all array slots in the array so that the code can read the array slots as open or closed.
            pizzaNumberSave[numberLoop] = "";
            numberLoop++;
        }

        numberLoop = 0;

        System.out.println("Welcome to Bob's Big Pizzas in Boston");
        Clear();

        /**
         * this while loop runs the whole code and sets running to false to
         * close the loop, this makes it easier to close the loop when needed or
         * loop back to the start of the code.
         */
        while (running) {

            /**
             * this if statement is making sure that the program doesn't crash
             * by checking that the number of pizzas in the receipt isn't larger
             * than the array size, if it is it tells the user the receipt is
             * full.
             */
            if (numberOfPizzas < orderSize) {

                userAnswer = userInput("Type ADD , REMOVE, RESET (clean receipt), DISPLAY (all pizzas on receipt), QUIT, SAVE, or LOAD");
                userAnswer = userAnswer.toLowerCase();
                /**
                 * these series of if statements are checking for user's
                 * answer's and doing what the user wants, eg: add pizza
                 */
                //-------------------------------------------------------------
                if (userAnswer.equals("add")) {

                    Clear();
                    System.out.println("Pepperoni $3.00"); // prints out the menu for adding pizza

                    System.out.println("Margarita $3.00");

                    System.out.println("Meat Lovers $5.00");

                    System.out.println("Jumbo $7.00");

                    Clear();
                    userAnswer = userInput("What pizza do you want to add?");
                    userAnswer = userAnswer.toLowerCase();
                    numberLoop = 0;

                    if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita") || userAnswer.equals("meat lovers") || userAnswer.equals("jumbo")) {

                        if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita")) { // this is checking for a valid answer
                            totalPizzaPrice = totalPizzaPrice + 3; // this is too add the price

                        } else if (userAnswer.equals("meat lovers")) {
                            totalPizzaPrice = totalPizzaPrice + 5;

                        } else if (userAnswer.equals("jumbo")) {
                            totalPizzaPrice = totalPizzaPrice + 7;

                        }

                        Add();

                        /**
                         * this is the boolean which tells the code that if it
                         * cannot add or remove a pizza it says pizza not found.
                         */
                        if (foundPizza == false) {
                            Clear();
                            System.out.println("Error! Pizza not found");
                            Clear();
                        }
                        // if user types a non-valid word it says error, this stops any logical error bugs in the code.
                    } else {
                        Clear();
                        System.out.println("Error! Pizza/Option not found");
                        Clear();
                    }
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("quit")) {
                    Clear();
                    System.out.println("Closing");
                    running = false;
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("display")) {
                    /**
                     * goes to a void method that doesn't return anything and is
                     * creating a loop which is printing out anything that has a
                     * pizza order all the other array slots are not printed out
                     */
                    List();
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("remove")) {

                    if (numberOfPizzas > 0) {

                        Clear();
                        userAnswer = userInput("What is the name of the pizza you want to remove?");
                        userAnswer = userAnswer.toLowerCase();
                        Remove();

                        if (foundPizza) {

                            /**
                             * same as adding pizza price this removes pizza
                             * price when removing pizza, price is reduced to
                             * the total price due to pizza that the user has
                             * teken out of the receipt
                             */
                            if (userAnswer.equals("pepperoni") || userAnswer.equals("margarita")) {
                                totalPizzaPrice = totalPizzaPrice - 3;

                            } else if (userAnswer.equals("meat lovers")) {
                                totalPizzaPrice = totalPizzaPrice - 5;

                            } else if (userAnswer.equals("jumbo")) {
                                totalPizzaPrice = totalPizzaPrice - 7;

                            }
                        }
                    } else { // if there are no pizzas on the list then it print to the user that
                        Clear();
                        System.out.println("Error! There are no pizzas on the list");
                        Clear();
                    }

                    /**
                     * if user types reset it sets the price and all array slots
                     * to "" and not to null because the code wouldn't recognise
                     * that as an open slot to insert a pizza in
                     */
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("reset")) {

                    totalPizzaPrice = 0;
                    numberLoop = 0;
                    numberOfPizzas = 0;
                    while (numberLoop <= (orderSize - 1)) {

                        pizzaNumber[numberLoop] = "";
                        numberLoop++;
                    }
                    numberLoop = 0;
                    Clear();
                    System.out.println("Receipt is cleaned");
                    Clear();

                    /**
                     * this goes through the whole pizzaNumber array and copies
                     * every slot to the pizzaNumberSave array and copies the
                     * cost and number of pizzas to the save variables. This
                     * means that you can load an old pizza receipt while
                     * working on a different one
                     */
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("save")) {

                    if (numberOfPizzas > 0) {
                        numberLoop = 0;

                        while (numberLoop <= (orderSize - 1)) {
                            pizzaNumberSave[numberLoop] = pizzaNumber[numberLoop];
                            numberLoop++;
                        }

                        numberOfPizzasSave = numberOfPizzas;
                        totalPizzaPriceSave = totalPizzaPrice;
                        Clear();
                        System.out.println("Saved pizza receipt");
                        Clear();
                        numberLoop = 0;
                        savedReceipt = true;

                    } else {
                        Clear();
                        System.out.println("Error! Cannot save nothing");
                        Clear();
                    }
                    /**
                     * this does the exact same thing as the save but opposite
                     * it copies the pizzaNumberSave array to the pizzaNumber
                     * array and the cost and number of pizzas do that too.
                     */
                    //-------------------------------------------------------------
                } else if (userAnswer.equals("load")) {

                    if (savedReceipt) {
                        numberLoop = 0;

                        while (numberLoop <= (orderSize - 1)) {
                            pizzaNumber[numberLoop] = pizzaNumberSave[numberLoop];
                            numberLoop++;
                        }
                        totalPizzaPrice = totalPizzaPriceSave;
                        numberOfPizzas = numberOfPizzasSave;
                        Clear();
                        System.out.println("Loaded pizza receipt");
                        Clear();
                        numberLoop = 0;

                    } else {
                        Clear();
                        System.out.println("Error! Cannot load nothing");
                        Clear();
                    }
                    // if the user types an unexpected input it will give an error message to the user.
                    //-------------------------------------------------------------
                } else {
                    Clear();
                    System.out.println("Error! Option not found");
                    Clear();
                }

                /**
                 * when receipt is full you cannot add anymore pizzas this is
                 * when numberOfPizzas equals orderSize
                 */
            } else if (numberOfPizzas >= (orderSize - 1)) {

                userAnswer = userInput("Receipt is full would you like to QUIT, REMOVE, RESET (clean receipt), DISPLAY (all pizzas on receipt), LOAD, or SAVE?");
                userAnswer = userAnswer.toLowerCase();

                if (userAnswer.equals("quit")) {

                    /**
                     * all these if statements are very similar to the other if
                     * statements that are checking for the user's answer of
                     * load or save or example, but here there is no option to
                     * add a pizza because the receipt is full and it would
                     * crash the program if they had that option to add more
                     * pizzas than the array size
                     */
                    System.out.println("Closing");
                    running = false;

                    /**
                     * checks if user typed display it calls the list void
                     * method which displays the receipt by looking through the
                     * whole array with the pointer integer and prints
                     * everything in the array except for empty slots to keep
                     * the receipt clean and easy to read
                     */
                } else if (userAnswer.equals("display")) {

                    List();

                } else if (userAnswer.equals("remove")) { // checks if user typed remove
                    if (numberOfPizzas >= 0) {

                        userAnswer = userInput("What is the name of the pizza you want to remove?");
                        userAnswer = userAnswer.toLowerCase();
                        Remove();

                        /**
                         * if the user tries to remove a pizza when there are no
                         * pizzas on the receipt it goes to this else statement
                         * and goes back to the start of the loop
                         */
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

                    /**
                     * checks if user typed reset and sets all the variables for
                     * example total pizza cost, number of pizzas etc. all to 0
                     * and clears the array by going through all the slots with
                     * the pointer and setting it to ""
                     */
                } else if (userAnswer.equals("reset")) {

                    totalPizzaPrice = 0;
                    numberLoop = 0;
                    numberOfPizzas = 0;
                    
                    while (numberLoop <= (orderSize - 1)) {
                        
                        pizzaNumber[numberLoop] = "";
                        numberLoop++;
                    }
                    
                    numberLoop = 0;

                    Clear();
                    System.out.println("Receipt is cleaned");
                    Clear();

                    /**
                     * this is checking if the user typed save and is checking
                     * before it saves the receipt if there is anything even on
                     * the receipt, if there is something on the receipt it
                     * saves all the variables to a "save" variable which is
                     * identical to it's original. It then saves all the array
                     * slots into a "save" array and then prints out a line
                     * which says saved pizza receipt
                     */
                } else if (userAnswer.equals("save")) {

                    numberLoop = 0;

                    while (numberLoop <= (orderSize - 1)) {
                        pizzaNumberSave[numberLoop] = pizzaNumber[numberLoop];
                        numberLoop++;
                    }

                    numberOfPizzasSave = numberOfPizzas;
                    totalPizzaPriceSave = totalPizzaPrice;
                    totalPizzaPrice = 0;
                    Clear();
                    System.out.println("Saved pizza receipt");
                    Clear();

                    numberLoop = 0;
                    savedReceipt = true; // if a receipt is saved then it will set this variable to true and helps prevent logic errors in loading receipts
                    /**
                     * checks if user typed load and checks if anything is in
                     * the receipt and then loads it in, it takes all the "save"
                     * variables and copies those integers into the original
                     * variables, the same thing is occuring with the array, the
                     * "save" array is using a for loop to prevent the program
                     * from crashing and loads the "save" variables to the
                     * original variables.
                     */

                } else if (userAnswer.equals("load")) {

                    if (savedReceipt) {
                        numberLoop = 0;

                        while (numberLoop <= (orderSize - 1)) {
                            pizzaNumber[numberLoop] = pizzaNumberSave[numberLoop];
                            numberLoop++;
                        }

                        totalPizzaPrice = totalPizzaPriceSave;
                        numberOfPizzas = numberOfPizzasSave;
                        Clear();
                        System.out.println("Loaded pizza receipt");
                        Clear();
                        numberLoop = 0;
                        // if user types a non-valid word it says error, this stops any logical error bugs in the code when trying to load nothing

                    } else {
                        Clear();
                        System.out.println("Error! Cannot load nothing");
                        Clear();
                    }
                    // if user types a non-valid word it says error, this stops any logical error bugs in the code if there is an unexpected input
                } else {
                    Clear();
                    System.out.println("Error! Not an option");
                    Clear();
                }
                // if user types a non-valid word it says error, this stops any logical error bugs in the code if there are no pizzas on the receipt
            } else {
                Clear();
                System.out.println("Error! There are no pizzas on the receipt");
                Clear();
            }
        }
    }

    /**
     *
     * This is a scanner for the user's input and returns to the main method
     * what the user typed in to the userInput and it saved into a string or
     * integer variable so that this scanner method can be used again for
     * another user's input
     */
    public static String userInput(String msg) {
        System.out.println(msg);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    /**
     * This list void method is going through the whole array with the pointer
     * and prints out anything that is in the array except for empty slots or in
     * the code its "". it has a for loop to stop the pointer from crashing by
     * program by looking through a part of the array that doesn't exist.
     */
    public static void List() {
        Clear();
        for (int i = 0; i < pizzaNumber.length; i++) {
            if (!pizzaNumber[i].equals("")) {
                System.out.println("Pizza: " + pizzaNumber[i]);
            }
        }
        System.out.println("Price is: " + "$" + totalPizzaPrice);
        Clear();
    }

    /**
     * this remove void method is looking in the array for the user's answer and
     * goes through all the slots up until it reaches the end of the array, if
     * it doesn't find the users answer in the array it will tell the user
     * Error! Pizza not found, but if it finds it, it sets that specific slot to
     * "" which therefore makes it an open slot and can be used for adding, this
     * way makes the add and remove methods very flexible and is able to remove
     * and add a pizza in any position in the array.
     */
    public static void Remove() {
        numberLoop = 0;
        foundPizza = false;
        if (!userAnswer.equals("")) {

            while (numberLoop <= (orderSize - 1)) {

                if (userAnswer.equals(pizzaNumber[numberLoop])) {

                    pizzaNumber[numberLoop] = "";
                    Clear();
                    System.out.println("Removed " + userAnswer + " from the receipt");
                    foundPizza = true;
                    Clear();
                    numberOfPizzas--;
                    numberLoop = orderSize;
                }
                numberLoop++;
            }
        }

        if (foundPizza == false) {
            System.out.println("Error! Pizza not found");
            Clear();
        }
    }

    /**
     * this add void method is very similar to the remove void method but
     * instead of finding the users answer in the array it finds an open slot in
     * the array regardless of where it is, this open slot equals "" and is not
     * null because at the start of the code all the array slots are set to ""
     * so that null isn't anywhere in the array so that the code can recognise
     * the array slots as open or closed, this method finds an open slot "" and
     * adds the user's answer to that specific array slot, if the array is full
     * it will print out to the user that the receipt is full.
     */
    public static void Add() {

        numberLoop = 0;
        foundPizza = false;

        /**
         * this while loop is running through all the array slots and looks for
         * a free slot which is "" and adds the user's answer to that array
         * slot, this way it can add pizza to previously removed array slots
         * because when a pizza is removed it is set to "" and therefore turns
         * it into an open slot in the array.
         */
        while (numberLoop <= (orderSize - 1)) {

            if (pizzaNumber[numberLoop].equals("")) {
                pizzaNumber[numberLoop] = userAnswer;
                Clear();
                System.out.println("Added " + userAnswer + " to the receipt");
                System.out.println((numberOfPizzas + 1) + " pizzas on the receipt");
                foundPizza = true; // if a pizza is added there will be no error message sent to the user,
                Clear();
                numberOfPizzas++;
                numberLoop = orderSize;
            }

            numberLoop++;
        }

        if (foundPizza == false) {
            System.out.println("Error! Pizza not found");
            Clear();
        }
    }

    /**
     * this Clear method is just creating a new empty line so that the output
     * for the user is nicer and more readable.
     */
    public static void Clear() {
        numberLoop = 0;
        while (numberLoop <= 0) {
            System.out.println("");
            numberLoop++;
        }
    }
}