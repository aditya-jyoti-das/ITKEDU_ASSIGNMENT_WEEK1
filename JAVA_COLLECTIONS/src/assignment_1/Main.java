package assignment_1;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

public class Main {


    private <T> T[] filter(T[] arr, Function<T,T> filterObj){

        if(arr==null) return null;
        ArrayList<T> filteredList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            T resI=filterObj.apply(arr[i]);
            if(resI!=null){
                filteredList.add(resI);
            }
        }
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) Array.newInstance(arr.getClass().getComponentType(), filteredList.size());
        return filteredList.toArray(resultArray);
    }

    public static void main(String[] args) {

        Main main = new Main();

        Integer[] filter = main.filter(
                new Integer[]{12, 3, 4, 5},
                x -> (x > 4 ? x : null));
        System.out.println(Arrays.toString(filter));

        String[] filter1 = main.filter(
                new String[]{"helo", "I", "am"},
                x -> (x.length() >= 2 ? x : null));
        System.out.println(Arrays.toString(filter1));
    }
}
