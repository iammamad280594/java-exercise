package com.adepuu.exercises.session5;
import java.util.Arrays;
import java.util.Collections;

public class Exercise5 {
  public static void main(String[] args) {
        int[] inputArray = {8, 7, 5, 2};
        String direction1 = "asc";
        String direction2 = "desc";

        System.out.println("Input: " + Arrays.toString(inputArray));

   
        int[] sortedAsc = sortArray(inputArray, direction1);
        System.out.println("Output (Ascending): " + Arrays.toString(sortedAsc));

      
        int[] sortedDesc = sortArray(inputArray, direction2);
        System.out.println("Output (Descending): " + Arrays.toString(sortedDesc));
    }

    public static int[] sortArray(int[] arr, String direction) {
        if (direction.equals("asc")) {
            Arrays.sort(arr); 
        } else if (direction.equals("desc")) {
            
            Integer[] integerArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            Arrays.sort(integerArray, Collections.reverseOrder());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = integerArray[i];
            }
        }
        return arr;
    }
}
