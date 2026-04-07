//Alhanouf Allazzam

import java.util.ArrayList;
import java.util.Arrays;
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

        System.out.println(numbersList);
        System.out.println(occurrences);


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

        Arrays.sort(numbers2);

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


    //EXERCISE #4
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void printArray(int[] array){
        for(int a : array){
            System.out.print(a + " ");
        }
    }

}