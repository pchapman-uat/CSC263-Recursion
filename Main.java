
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

    public static void main(String[] args) 
    {
        System.out.println(getSnmallestValue(643,5,6,6,7,101,5015,5325));
    }
}