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

//




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
}