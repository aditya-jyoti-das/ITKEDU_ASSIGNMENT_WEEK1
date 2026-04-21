package assignment_2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    private <T> Map<T,Long> frequencyCounter(T[] arr){
        return Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {

        Main main = new Main();
        Map<Integer, Long> integerLongMap = main.frequencyCounter(new Integer[]{1, 2, 3, 4, 1, 2, 3});
        System.out.println(integerLongMap);

        Map<String, Long> stringLongMap = main.frequencyCounter(new String[]{"hey", "hey", "I", "sure", "yesterday", "sure", "I"});
        System.out.println(stringLongMap);


    }
}
