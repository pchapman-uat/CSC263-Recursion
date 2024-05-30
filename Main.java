
public class Main{
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
    public static void main(String[] args) 
    {
        Integer[] randomNumbers = genRandomNumbers(20);
        System.out.println(getSnmallestValue(randomNumbers));
    }
}