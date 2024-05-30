import java.util.Scanner;

public class Main{
    static Scanner scanner = new Scanner(System.in);

    private static Integer intInput(String msg){
        System.out.println(msg);

        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return intInput(msg);
        }
    }
    private static String input(String msg){
        scanner.nextLine();
        System.out.println(msg);
        String response = scanner.nextLine();
        return response;
    }


    private static Integer getSnmallestValue(Integer ...numbers){
        return checkSmallestValue(numbers, null, null);
    }

    private static Integer checkSmallestValue(Integer[] numbers, Integer index, Integer smallest){
        if(index == null) index = 0;
        if(smallest == null) return checkSmallestValue(numbers, index + 1, numbers[index]);
        if(numbers.length == index + 1) return smallest;
        if(smallest < numbers[index]) return checkSmallestValue(numbers, index + 1, smallest);
        else return checkSmallestValue(numbers, index + 1, numbers[index]);
    }   

    private static Integer[] genRandomNumbers(Integer count, Integer... numbers){
        if(count == 0) return (Integer[]) numbers;
        Integer randomNumber = (int) Math.round(Math.random()*100);
        numbers[count-1] = randomNumber;
        return genRandomNumbers(count-1, numbers);
    }
    private static Integer[] genRandomNumbers(Integer count){
        return genRandomNumbers(count, new Integer[count]);
    }
    private static String printNumbers(Integer ...numbers){
        return printNumbers(0,"", numbers);
    }
    private static String printNumbers(Integer index, String msg, Integer ...numbers){
        if(numbers.length == index) return msg;
        return printNumbers(index+1, msg+", "+numbers[index], numbers);
    }
    public static void main(String[] args) 
    {

        Integer response = intInput("Please enter the total numbers to generate");
        Integer[] randomNumbers = genRandomNumbers(response);
        System.out.println("The Smallest Number is:"+getSnmallestValue(randomNumbers));
        
        String resultsResponce = input("Would you like to see the numbers?");
        if(resultsResponce.toLowerCase().equals("y")){
            System.out.println(printNumbers(randomNumbers));
        }
    }
}