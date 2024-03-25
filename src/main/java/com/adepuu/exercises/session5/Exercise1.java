package com.adepuu.exercises.session5;
import java.util.Arrays;

public class LargestElementOfArray {
    public static void main(String[] args) {
        int[] array = {7,2,5,1,4};
        Arrays.sort(array);
        int largest = array[array.length-1];
        System.out.println("nilai paling gede adalah: " +largest);
    }
}

