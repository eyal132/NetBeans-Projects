package sorting;

import java.util.*;

/**
 * Initial versions of the sorting and searching algorithms were taken from
 * https://www.javatpoint.com Rewording, layout changes and subsequent coding by
 * me.
 *
 * @version 11 quick sort and shell sort unimplemented at this stage
 * @author Mr Hansen
 */
public class Sorting {

    public static int swap = 0;
    public static int compare = 0;

    /**
     * This is the main method which makes use of bubbleSort method.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //------------RANDOM------------------
        Random gen = new Random();
        // make 10 items, duplicates and omissions allowed 
        int smallRandomListOfNumbers[] = new int[10];
        for (int i = 0; i < smallRandomListOfNumbers.length; i++) {
            smallRandomListOfNumbers[i] = gen.nextInt(10);
        }
        // make 50 items, duplicates and omissions allowed 
        int largeRandomListOfNumbers[] = new int[50];
        for (int i = 0; i < largeRandomListOfNumbers.length; i++) {
            largeRandomListOfNumbers[i] = gen.nextInt(50);
        }

        //------------ORDERED-----------------
        // make 10 items 1 - 10 in order
        int smallOrderedListOfNumbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // make 50 items 1 - 50 in order
        int largeOrderedListOfNumbers[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
            19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41,
            42, 43, 44, 45, 46, 47, 48, 49, 50};

        //------------REVERSE ORDER-----------
        // make 10 items 10 - 1 in reverse order
        int smallReverseListOfNumbers[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        // make 50 items 50 - 1 in reverse order
        int largeReverseListOfNumbers[] = {50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36,
            35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13,
            12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        // variables for running program and holding user input
        boolean running = true;
        String choice = "";

        // start the loop
        while (running) {
            // give the user 3 choices for input
            choice = userInput("You can choose to SORT, SEARCH or QUIT");
            /**
             *************************************************************
             * SORT 
             * ***********************************************************
             */
            if (choice.equalsIgnoreCase("SORT")) {
                System.out.println("You chose to sort");

                choice = userInput("You can choose RANDOM or BEST or WORST for the order of numbers");
                /*
                 RANDOM
                 */
                if (choice.equalsIgnoreCase("RANDOM") || choice.equalsIgnoreCase("R")) {
                    System.out.println("You chose random order");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[smallRandomListOfNumbers.length];
                        for (int i = 0; i < smallRandomListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallRandomListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[largeRandomListOfNumbers.length];
                        for (int i = 0; i < largeRandomListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeRandomListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);
                    }
                    /*
                     BEST
                     */
                } else if (choice.equalsIgnoreCase("BEST") || choice.equalsIgnoreCase("B")) {
                    System.out.println("You chose already ordered");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[smallOrderedListOfNumbers.length];
                        for (int i = 0; i < smallOrderedListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallOrderedListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[largeOrderedListOfNumbers.length];
                        for (int i = 0; i < largeOrderedListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeOrderedListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);
                    }
                    /*
                     REVERSE
                     */
                } else {
                    System.out.println("You chose reverse/worst order");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[smallReverseListOfNumbers.length];
                        for (int i = 0; i < smallReverseListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallReverseListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // swap the correct array into the list of numbers array
                        int[] listOfNumbers = new int[largeReverseListOfNumbers.length];
                        for (int i = 0; i < largeReverseListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeReverseListOfNumbers[i];
                        }
                        System.out.println("Unsorted list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 3 sorting algorithms - insertion sort is the default choice
                        choice = userInput("You can choose BUBBLE or SELECTION or INSERTION for the sorting algorithm");
                        if (choice.equalsIgnoreCase("BUBBLE") || choice.equalsIgnoreCase("B")) {
                            System.out.println("You chose Bubble sort");
                            bubbleSort(listOfNumbers);
                        } else if (choice.equalsIgnoreCase("SELECTION") || choice.equalsIgnoreCase("S")) {
                            System.out.println("You chose Selection sort");
                            selectionSort(listOfNumbers);
                        } else {
                            System.out.println("You chose Insertion sort");
                            insertionSort(listOfNumbers);
                        }
                        System.out.println("Sorted list");

                        // print the array for the user
                        listArray(listOfNumbers);
                    }
                }

                // print the number of comparisons and swaps for each sort
                System.out.println("\n" + compare + " comparisons to see if it was the correct value");
                System.out.println(swap + " swaps to sort the list");

                /**
                 **************************************************************
                 * SEARCH
                 * ***********************************************************
                 */
            } else if (choice.equalsIgnoreCase("SEARCH")) {
                System.out.println("You chose to search");
                choice = userInput("You can choose RANDOM or BEST or WORST for the order of numbers");
                /*
                 RANDOM
                 */
                if (choice.equalsIgnoreCase("RANDOM") || choice.equalsIgnoreCase("R")) {
                    System.out.println("You chose random order");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(10);
                        int[] listOfNumbers = new int[smallRandomListOfNumbers.length];
                        for (int i = 0; i < smallRandomListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallRandomListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            // let user know this type of search algorithm doesn't work with random lists
                            System.out.println("Binary search cant search a random list of numbers");
                        }

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(50);
                        int[] listOfNumbers = new int[largeRandomListOfNumbers.length];
                        for (int i = 0; i < largeRandomListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeRandomListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            System.out.println("Binary search cant search a random list of numbers");
                        }
                    }
                    /*
                     BEST
                     */
                } else if (choice.equalsIgnoreCase("BEST") || choice.equalsIgnoreCase("B")) {
                    System.out.println("You chose already ordered");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(10);
                        int[] listOfNumbers = new int[smallOrderedListOfNumbers.length];
                        for (int i = 0; i < smallOrderedListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallOrderedListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            System.out.println("You chose Binary search. your key is " + key);
                            binarySearch(listOfNumbers, key);
                        }

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(50);
                        int[] listOfNumbers = new int[largeOrderedListOfNumbers.length];
                        for (int i = 0; i < largeOrderedListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeOrderedListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            System.out.println("You chose Binary search. your key is " + key);
                            binarySearch(listOfNumbers, key);
                        }
                    }
                    /*
                     REVERSE
                     */
                } else {
                    System.out.println("You chose reverse/worst order");

                    /*
                     10 ITEMS
                     */
                    choice = userInput("You can choose a SMALL or LARGE list of numbers");
                    if (choice.equalsIgnoreCase("SMALL") || choice.equalsIgnoreCase("S")) {
                        System.out.println("You chose 10 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(10);
                        int[] listOfNumbers = new int[smallReverseListOfNumbers.length];
                        for (int i = 0; i < smallReverseListOfNumbers.length; i++) {
                            listOfNumbers[i] = smallReverseListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            System.out.println("You chose Binary search. your key is " + key);
                            binarySearch(listOfNumbers, key);
                        }

                        /*
                         50 ITEMS
                         */
                    } else {
                        System.out.println("You chose 50 items to sort");

                        // pick a key, and swap the correct array into the list of numbers array
                        int key = gen.nextInt(50);
                        int[] listOfNumbers = new int[largeReverseListOfNumbers.length];
                        for (int i = 0; i < largeReverseListOfNumbers.length; i++) {
                            listOfNumbers[i] = largeReverseListOfNumbers[i];
                        }
                        System.out.println("Unsearched list");

                        // print the array for the user
                        listArray(listOfNumbers);

                        // run one of the 2 searching algorithms - binary sort is the default choice
                        choice = userInput("You can choose LINEAR or BINARY for the search algorithm");
                        if (choice.equalsIgnoreCase("LINEAR") || choice.equalsIgnoreCase("L")) {
                            System.out.println("You chose Linear search. your key is " + key);
                            linearSearch(listOfNumbers, key);
                        } else {
                            System.out.println("You chose Binary search. your key is " + key);
                            binarySearch(listOfNumbers, key);
                        }
                    }
                }

                System.out.println("\n" + compare + " comparisons to see if it was the correct value");

                /**
                 *************************************************************
                 * QUIT
                 * ***********************************************************
                 */
            } else {
                // NB: if the user types anything but sort or search they are assumed to be quitting
                System.out.println("Quiting");
                running = false;
            }
            // reset swap and compare variables back to 0
            reset();
        }
    }

    /**
     * Bubble sort algorithm, updates the comparisons and swaps as it sorts an
     * array. https://www.javatpoint.com/bubble-sort-in-java
     *
     * O(n2) average performance https://en.wikipedia.org/wiki/Bubble_sort
     *
     * @param listOfNumbers the array to sort
     */
    public static void bubbleSort(int[] listOfNumbers) {
        // What does this do?
        int listLength = listOfNumbers.length;
        int temp = 0;

        // What does this do?
        for (int i = 0; i < listLength; i++) {
            // What does this do?
            for (int j = 1; j < (listLength - i); j++) {
                // What does this do?
                if (listOfNumbers[j - 1] > listOfNumbers[j]) {

                    // What does this do?
                    temp = listOfNumbers[j - 1];
                    listOfNumbers[j - 1] = listOfNumbers[j];
                    listOfNumbers[j] = temp;

                    //update swap count
                    swap++;
                }
                //update compare count
                compare++;
            }
        }
    }

    /**
     * Selection sort algorithm, updates the comparisons and swaps as it sorts
     * an array. https://www.javatpoint.com/selection-sort-in-java
     *
     * O(n) & O(n2) average performance
     * https://en.wikipedia.org/wiki/Selection_sort
     *
     * @param listOfNumbers the array to sort
     */
    public static void selectionSort(int[] listOfNumbers) {
        // What does this do?
        int listLength = listOfNumbers.length;

        // What does this do?
        for (int i = 0; i < listLength - 1; i++) {

            // What does this do?
            int index = i;

            // What does this do?
            for (int j = i + 1; j < listLength; j++) {

                // searching for lowest index
                if (listOfNumbers[j] < listOfNumbers[index]) {
                    index = j;
                }

                //update compare count
                compare++;
            }

            // What does this do?
            int smallerNumber = listOfNumbers[index];
            listOfNumbers[index] = listOfNumbers[i];
            listOfNumbers[i] = smallerNumber;

            //update swap count
            swap++;
        }
    }

    /**
     * Insertion sort algorithm, updates the comparisons and swaps as it sorts
     * an array. https://www.javatpoint.com/insertion-sort-in-java
     *
     * O(n2) average performance https://en.wikipedia.org/wiki/Insertion_sort
     *
     * @param listOfNumbers the array to sort
     */
    public static void insertionSort(int[] listOfNumbers) {
        // What does this do?
        int listLength = listOfNumbers.length;

        // What does this do?
        for (int j = 1; j < listLength; j++) {

            // What does this do?
            int key = listOfNumbers[j];
            int i = j - 1;

            // What does this do?
            while ((i > -1) && (listOfNumbers[i] > key)) {

                // What does this do?
                listOfNumbers[i + 1] = listOfNumbers[i];
                i--;
                //update swap count
                swap++;
            }
            //update compare count
            compare++;

            // What does this do?
            listOfNumbers[i + 1] = key;
        }
    }

    /**
     * quick sort algorithm, not yet implemented
     *
     * O(n log n) average performance https://en.wikipedia.org/wiki/Quicksort
     *
     * @param listOfNumbers the array to sort
     */
    public static void quickSort(int[] listOfNumbers) {

    }

    /**
     * shell sort algorithm, not yet implemented
     *
     * between O(n log n) and O(n) average performance
     * https://en.wikipedia.org/wiki/Shellsort
     *
     * @param listOfNumbers the array to sort
     */
    public static void shellSort(int[] listOfNumbers) {

    }

    /**
     * Binary search algorithm, prints where the key was found or that it wasn't
     * found.
     *
     * O(log n) average performance
     * https://en.wikipedia.org/wiki/Binary_search_algorithm
     *
     * @param listOfNumbers the array to search
     * @param key the number to search for
     */
    public static void binarySearch(int[] listOfNumbers, int key) {
        // What does this do?
        int left = 0;
        int right = listOfNumbers.length - 1;
        int mid = 99;

        // What does this do?
        while (left <= right) {

            //update compare count
            compare++;

            // What does this do?
            mid = left + ((right - left) / 2);

            // What does this do?
            if (listOfNumbers[mid] == key) {
                System.out.println("The key was found in the list of numbers at index " + mid);
                break;

                // What does this do?
            } else if (key < listOfNumbers[mid]) {
                right = mid - 1;

                // What does this do?    
            } else {
                left = mid + 1;
            }
        }

        // What does this do?
        if (listOfNumbers[mid] != key) {
            System.out.println("The key is not in the list of numbers");
        }
    }

    /**
     * Linear search algorithm, prints where the key was found or that it wasn't
     * found.
     *
     * O(n) average performance. https://en.wikipedia.org/wiki/Linear_search
     *
     * @param listOfNumbers the array to search
     * @param key the number to search for
     */
    public static void linearSearch(int[] listOfNumbers, int key) {

        // What does this do?
        int i = 99999;

        // What does this do?
        for (i = 0; i < listOfNumbers.length; i++) {

            //update compare count
            compare++;

            // What does this do?
            if (listOfNumbers[i] == key) {
                System.out.println("The key was found in the list of numbers at index " + i);
                break;
            }
        }

        // What does this do?
        if (i == listOfNumbers.length) {
            System.out.println("The key is not in the list of numbers");
        }
    }

    /**
     * Resets the swap and compare variables.
     */
    public static void reset() {
        swap = 0;
        compare = 0;

        //any other variables we need to reset could go here
    }

    /**
     * Print the numbers in an array followed by a blank line.
     *
     * @param listOfNumbers the array to list
     */
    public static void listArray(int[] listOfNumbers) {
        // loop through an array printing each value then a space
        for (int i = 0; i < listOfNumbers.length; i++) {
            System.out.print(listOfNumbers[i] + " ");
        }

        // put a blank line
        System.out.println();
    }

    /**
     * Prompt the user to type a sentence and return that sentence.
     *
     * @param msg print this in the output window
     * @return The next line of typing
     */
    public static String userInput(String msg) {
        // print a message for the user
        System.out.println(msg);

        // scan for input through the keyboard
        Scanner keyboard = new Scanner(System.in);

        //return the last line of typing 
        return keyboard.nextLine();
    }
}
