package com.adepuu.exercises.session5;
import java.util.Arrays;
public class Exercise1 {
  ublic class LargestElementOfArray {
    public static void main(String[] args) {
        int[] array1 = {7,2,5,1,4};
        Arrays.sort(array1);
        int largest = array1[array1.length-1];
        System.out.println("nilai paling gede adalah: " +largest);
    }

}
