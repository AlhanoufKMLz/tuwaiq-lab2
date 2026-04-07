//Alhanouf Allazzam

import java.util.ArrayList;
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
        System.out.println("-----------------------");
        System.out.println("EXERCISE #2");
        System.out.println("-----------------------");

        int[] numbers = {1, 1, 1, 3, 3, 5};

        System.out.print("Please enter number: ");
        int userNumber = input.nextInt();

        System.out.println("Number " + userNumber + " occurs " + numberOfOccurrences(userNumber,numbers) + " times");


        //EXTRA for EX2 - display the number of occurrences for every number in the array
        ArrayList<Integer>  numbersList = new ArrayList<>();
        ArrayList<Integer>  occurrences = new ArrayList<>();

        findAllOccurrences(numbers, numbersList, occurrences);

        System.out.println(numbersList);
        System.out.println(occurrences);






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
    public static int numberOfOccurrences(int number, int[] numbers){
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
            if( numberIndex == -1){
                numbersList.add(n);
                occurrences.add(1);
            } else {
                occurrences.set(numberIndex, occurrences.get(numberIndex) + 1);
            }
        }
    }

    public static int findInNumbersList(int number, ArrayList<Integer> numbersList){
        for(int i = 0; i < numbersList.size(); i++){
            if(numbersList.get(i) == number){
                return i;
            }
        }
        return -1;
    }


}