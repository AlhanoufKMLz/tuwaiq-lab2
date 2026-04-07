//Alhanouf Allazzam

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        1.Write a program to find all of the longest word in a given dictionary.
//        Example:
//        { "cat", "dog", "red", "is", "am" }
//        Expected Output:
//        "cat", "dog", "red"
        System.out.println("-----------------------");
        System.out.println("EXERCISE #1");
        System.out.println("-----------------------");

        String[] dictionary = {"cat", "dog", "red", "is", "am"};

        ArrayList<String> longestWords = findLongestWords(dictionary);//method finds the longest words

        System.out.print("Longest words are: ");
        printWords(longestWords);//method to print the words



//        2. Write a program that displays the number of occurrences of an element in the array.
//        Original Array:
//        [1,1,1,3,3,5]
//        Sample Output:
//        3 occurs 2 times
//        1 occurs 3 times
//        9 occurs 0 time
        System.out.println("\n\n-----------------------");
        System.out.println("EXERCISE #2");
        System.out.println("-----------------------");

        int[] numbers = {1, 1, 1, 3, 3, 5};

        System.out.print("Please enter number: ");
        int userNumber = input.nextInt();

        System.out.println("Number " + userNumber + " occurs " + countOccurrences(userNumber,numbers) + " times");


        //EXTRA for EX2 - display the number of occurrences for every number in the array
        ArrayList<Integer>  numbersList = new ArrayList<>();
        ArrayList<Integer>  occurrences = new ArrayList<>();

        findAllOccurrences(numbers, numbersList, occurrences);

        System.out.println();
        printOccurrences(numbersList, occurrences);



//        3. Write a program to find the k largest elements in a given array. Elements in the array can be in any order.
//        Original Array:
//        [1, 4, 17, 7, 25, 3, 100]
//        Expected Output:
//        3 largest elements of the said array are:
//        100 25 17
        System.out.println("\n-----------------------");
        System.out.println("EXERCISE #3");
        System.out.println("-----------------------");

        int[] numbers2 = {1, 4, 17, 7, 25, 3, 100};
        System.out.print("Please enter how many numbers you want: ");
        int k = input.nextInt();

        sortElements(numbers2);

        System.out.print(k + " largest elements of the said array are: ");
        for(int i = 0; i < k; i++){
            System.out.print(numbers2[numbers2.length-1-i] + " ");
        }



//        4. Create a method to reverse an array of integers. Implement the method without creating a new array.
//        Original Array:
//        [5,4,3,2,1]
//        Expected Output:
//        Reversed Array: 12345
        System.out.println("\n\n-----------------------");
        System.out.println("EXERCISE #4");
        System.out.println("-----------------------");

        int[] array = {5, 4, 3, 2, 1};
        reverse(array);
        System.out.print("Reversed Array: ");
        printArray(array);



//        5. Write a menu driven Java program with following option:
//        1. Accept elements of an array
//        2. Display elements of an array
//        3. Search the element within array
//        4. Sort the array
//        5. To Stop the size of the array should be entered by the user.
        System.out.println("\n\n-----------------------");
        System.out.println("EXERCISE #5");
        System.out.println("-----------------------");

        System.out.print("Please enter array size: ");
        int size = input.nextInt();
        input.nextLine();//clean buffer

        int[] elements = new int[size];
        boolean isFilled = false;

        String choice;
        do{

            printMenu();
            System.out.print("Please choose from the menu or enter \"exit\" to quit: ");
            choice = input.nextLine();

            switch (choice){
                case "1":
                    acceptElements(elements, input);
                    isFilled = true;
                    break;
                case "2":
                    if(!isFilled){
                        System.out.println("Array is empty, please fill the array first.");
                        break;
                    }

                    System.out.println("Elements: ");
                    displayElements(elements);
                    break;

                case "3":
                    if(!isFilled){
                        System.out.println("Array is empty, please fill the array first.");
                        break;
                    }

                    System.out.print("Please enter the element you want to search: ");
                    int element = Integer.parseInt(input.nextLine());

                    int elementIndex = searchElement(elements, element);

                    if (elementIndex == -1)
                        System.out.println(element + " not found in the array.");
                    else
                        System.out.println(element + " found at index " + elementIndex + ".");
                    break;

                case "4":
                    if(!isFilled){
                        System.out.println("Array is empty, please fill the array first.");
                        break;
                    }

                    sortElements(elements);
                    System.out.println("Elements after sort: ");
                    displayElements(elements);
                    break;

                case "exit":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }while(!choice.equalsIgnoreCase("exit"));



//        6. Create a method that generates a random number within a given range. Allow the user to specify the range and call the method to display random numbers.
//                Hint: use Random class
//        Sample Output:
//        2
//        Enter the minimum value of the range: 10
//        Enter the maximum value of the range: 100
//        Enter the number of random numbers to generate: 5
//        Random numbers within the specified range:
//        71 - 98 - 96 - 71 - 71
        System.out.println("\n-----------------------");
        System.out.println("EXERCISE #6");
        System.out.println("-----------------------");

        System.out.print("Enter the minimum value of the range: ");
        int min = input.nextInt();
        System.out.print("Enter the maximum value of the range: ");
        int max = input.nextInt();
        System.out.print("Enter the number of random numbers to generate: ");
        int count = input.nextInt();

        System.out.println("Random numbers within the specified range: ");
        for(int i = 1; i <= count; i++){
            if (i == count) //in case it's the last word no need to add -
                System.out.print(generateRandom(min, max));
            else
                System.out.print(generateRandom(min, max) + " - ");
        }



//        7. Write a program that checks the strength of a password. Create a method that evaluates a password based on criteria like length, inclusion of special characters, and uppercase/lowercase letters.
//                - We have three methods: checkLength, checkSpecialCharacters, and checkUpperCaseLowerCase, each of which assigns a score based on specific criteria.
//                The totalScore is calculated by adding the scores from these methods.
//                - Classify the password as strong (8 or more), moderately strong (5 or more), or weak based on the totalScore.
//                - The criteria for scoring:
//                    Length: 0-5 characters (0 points), 6-7 characters (2 points), 8 or more characters (3 points).
//                    Special characters: Absence (0 points), Presence (2 points).
//                    Uppercase and lowercase letters: Absence of both (0 points), presence of both (3 points).
//        Example:
//        Enter a password: 3456
//        Expected Output:
//        Password is weak.
        System.out.println("\n\n-----------------------");
        System.out.println("EXERCISE #7");
        System.out.println("-----------------------");

        System.out.print("Please enter a password: ");
        input.nextLine();
        String password = input.nextLine();

        int totalScore = checkLength(password) + checkSpecialCharacters(password) + checkUpperCaseLowerCase(password);

        if(totalScore >= 8)
            System.out.println("Password is strong");
        else if(totalScore >= 5)
            System.out.println("Password is moderately strong");
        else System.out.println("Password is weak");



//        8. Create a method that generates the Fibonacci sequence up to a specified number of terms.
//        Hint: The Fibonacci sequence is a mathematical sequence of numbers that starts with 0 and 1, and each subsequent number in the sequence is the sum of the two preceding ones.
//        Example:
//        Enter the number of Fibonacci terms to generate: 10
//        Expected Output:
//        Fibonacci sequence with 10 terms:
//        0 1 1 2 3 5 8 13 21 34
        System.out.println("\n-----------------------");
        System.out.println("EXERCISE #8");
        System.out.println("-----------------------");

        System.out.print("Enter the number of Fibonacci terms to generate: ");
        int terms = input.nextInt();

        int[] fibonacci = generateFibonacci(terms);

        System.out.println("Fibonacci sequence with " + terms + " terms:");
        printArray(fibonacci);

    }



    //EXERCISE #1
    public static ArrayList<String> findLongestWords(String[] dictionary){
        ArrayList<String> longestWords = new ArrayList<>();
        int longestLength = 0;

        for(String word: dictionary){
            if(longestLength == word.length()){
                longestWords.add(word);
            } else if(longestLength < word.length()){
                longestLength = word.length();
                longestWords.clear();
                longestWords.add(word);
            }
        }

        return longestWords;
    }

    public static void printWords(ArrayList<String> words){
        for (int i = 0; i < words.size(); i++) {
            if (i == words.size() - 1) //in case it's the last word no need to add comma
                System.out.print("\"" + words.get(i) + "\"");
            else
                System.out.print("\"" + words.get(i) + "\", ");
        }
    }


    //EXERCISE #2
    public static int countOccurrences(int number, int[] numbers){
        int occurrences = 0;
        for(int n : numbers){
            if(n == number)
                occurrences++;
        }
        return occurrences;
    }

    //EXTRA for EX2
    public static void findAllOccurrences(int[] numbers, ArrayList<Integer> numbersList, ArrayList<Integer>  occurrences){
        for(int n : numbers){
            int numberIndex = findInNumbersList(n,numbersList);
            if(numberIndex == -1){
                numbersList.add(n);
                occurrences.add(1);
            } else {
                occurrences.set(numberIndex, occurrences.get(numberIndex) + 1);
            }
        }
    }

    public static void printOccurrences(ArrayList<Integer> numbersList, ArrayList<Integer>  occurrences){
        for(int i = 0; i < numbersList.size(); i++){
            System.out.println(numbersList.get(i) + " occurred " + occurrences.get(i) + " times");
        }
    }

    public static int findInNumbersList(int number, ArrayList<Integer> numbersList){
        for(int i = 0; i < numbersList.size(); i++){
            if(numbersList.get(i).equals(number)){
                return i;
            }
        }
        return -1;
    }


    //EXERCISE #4
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
                //used in ex 4 and 8
    public static void printArray(int[] array){
        for(int a : array){
            System.out.print(a + " ");
        }
    }


    //EXERCISE #5
    public static void printMenu(){

        System.out.println("\n    MENU");
        System.out.println("---------------");
        System.out.println("1. Accept elements\n" +
                           "2. Display elements\n" +
                           "3. Search for element\n" +
                           "4. Sort the array");
    }

    public static void acceptElements(int[] elements, Scanner input){
        for(int i = 0; i < elements.length; i++){
            System.out.print("Please enter element to add: ");
            elements[i] = Integer.parseInt(input.nextLine());
            System.out.println("element added successfully.");
        }

    }

    public static void displayElements(int[] elements){
        System.out.print("[");
        for (int i = 0; i < elements.length; i++) {
            if (i == elements.length - 1)
                System.out.print(elements[i]);
            else
                System.out.print(elements[i] + ", ");
        }
        System.out.println("]");
    }

    public static int searchElement(int[] elements, int element){
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == element)
                return i;
        }
        return -1;
    }
                //used in ex 5 and 3
    public static void sortElements(int[] elements){
        for (int i = 0; i < elements.length; i++) {
            for (int j = i; j < elements.length; j++) {
                if (elements[i] > elements[j ]) {
                    int temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }


    //EXERCISE #6
    public static int generateRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(min, max+1);
    }


    //EXERCISE #7
    public static int checkLength(String password){
        if(password.length() <= 5)
            return 0;
        if(password.length() <= 7)
            return 2;
        return 3;
    }

    public static int checkSpecialCharacters(String password){
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i)))
                return 2;
        }
        return 0;
    }

    public static int checkUpperCaseLowerCase(String password){
        boolean hasUpper = false;
        boolean hasLower = false;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i)))
                hasUpper = true;
            if (Character.isLowerCase(password.charAt(i)))
                hasLower = true;
        }

        return (hasUpper && hasLower) ? 3 : 0;
    }


    //EXERCISE #8
    public static int[] generateFibonacci(int terms) {
        int[] fib = new int[terms];

        fib[0] = 0;
        if (terms > 1) fib[1] = 1;

        for (int i = 2; i < terms; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib;
    }

}