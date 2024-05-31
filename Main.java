// The scanner is used to get input from the user.
import java.util.Scanner;

public class Main{
    // Create the scanner object
    static Scanner scanner = new Scanner(System.in);

    // An integer input function
    private static Integer intInput(String msg){
        // Print the message
        System.out.println(msg);

        // Try to get the input
        // If it is not an integer, it will throw an exception
        try {
            // Return the input
            return scanner.nextInt();
        } catch (Exception e) {
            // Advance the scanner to the next line
            scanner.nextLine();
            // Attempt the function again
            return intInput(msg);
        }
    }
    // A string input function
    private static String input(String msg){
        // Advance the scanner to the next line
        scanner.nextLine();
        // Print the message
        System.out.println(msg);
        // Return the input
        return scanner.nextLine();
    }


    // Polymorphism functions to get the smallest value
    // Only difference is the inputs
    private static Integer getSnmallestValue(Integer ...numbers){
        return checkSmallestValue(numbers, null, null);
    }

    // The recursive function to check the smallest value
    private static Integer checkSmallestValue(Integer[] numbers, Integer index, Integer smallest){
        // If the index is null, set it to 0
        if(index == null) index = 0;
        // If the smallest is null, set it to the first number
        if(smallest == null) return checkSmallestValue(numbers, index, numbers[index]);
        // If the index is out of bounds, return the smallest value
        if(numbers.length == index + 2) return smallest;
        // If the current number is smaller than the smallest, return the current number
        if(smallest < numbers[index]) return checkSmallestValue(numbers, index + 1, smallest);
        // If the current number is not smaller than the smallest, return the smallest value
        else return checkSmallestValue(numbers, index + 1, numbers[index]);
    }   

    // Polymorphism functions to generate random numbers
    private static Integer[] genRandomNumbers(Integer count, Integer... numbers){
        // If the count is 0, return the numbers
        if(count == 0) return (Integer[]) numbers;
        // Generate a random number
        Integer randomNumber = (int) Math.round(Math.random()*100);
        // Add the random number to the end of the array
        numbers[count-1] = randomNumber;
        // Return the array
        return genRandomNumbers(count-1, numbers);
    }
    // Second function that is used to create the array from the size given
    private static Integer[] genRandomNumbers(Integer count){
        return genRandomNumbers(count, new Integer[count]);
    }
    // Polymorphism function to print the numbers
    private static String printNumbers(Integer ...numbers){
        return printNumbers(0,"", numbers);
    }
    // Recursive function to print the numbers
    private static String printNumbers(Integer index, String msg, Integer ...numbers){
        // If the index is out of bounds, return the message
        
        if(numbers.length == index+1) return msg+", "+numbers[index].toString();
        // If the index is not out of bounds, return the message with the current number
        if(index == 0) return printNumbers(index+1, numbers[index].toString(),numbers);
        return printNumbers(index+1, msg+", "+numbers[index], numbers);
    }
    public static void main(String[] args) 
    {
        // Get the total numbers to generate
        Integer response = intInput("Please enter the total numbers to generate");
        // Generate the random numbers
        Integer[] randomNumbers = genRandomNumbers(response);
        // Get the smallest number and display it
        System.out.println("The Smallest Number is:"+getSnmallestValue(randomNumbers));
        // Ask the user if they want to all of the numbers
        String resultsResponce = input("Would you like to see the numbers?");
        // If the response is yes, print the numbers
        if(resultsResponce.toLowerCase().equals("y")){
            System.out.println(printNumbers(randomNumbers));
        }
    }
}