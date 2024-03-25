package com.adepuu.exercises.session5;

import java.util.Arrays;

public class exercise4 {
    public static void main(String[] args) {
        int[] inputArray = {1, 2, 2, 3, 3, 3, 4, 5};

        System.out.println("Input: " + Arrays.toString(inputArray));

        int[] outputArray = removeDuplicates(inputArray);

        System.out.println("Output: " + Arrays.toString(outputArray));
    }

    public static int[] removeDuplicates(int[] arr) {
      
        Arrays.sort(arr);

        int uniqueCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                uniqueCount++;
            }
        }

        uniqueCount++;
        int[] result = new int[uniqueCount];
        int index = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                result[index++] = arr[i];
            }
        }

        result[index] = arr[arr.length - 1];

        return result;
    }
}

