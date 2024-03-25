package com.adepuu.exercises.session5;
import java.util.Arrays;
public class Exercise1 {

    public static void main(String[] args) {
        int[] array1 = {7,2,5,1,4};
        Arrays.sort(array1);
        int largest = array1[array1.length-1];
        System.out.println("nilai paling gede adalah: " +largest);

     {
            int[] array2 = {1,2,3,4,5,6,7};
            int rotationSteps = 2;

            System.out.println("original array: " + Arrays.toString(array2));
            rotateArray(array2, rotationSteps);

    }


    }
    public static void rotateArray(int[] array, int steps){
        int length = array.length;
        steps = steps % length;
        int[] tempArray = new int[steps];
        System.arraycopy(array, 0, array, steps, length-steps);
        System.arraycopy(tempArray,0, array,0, steps);
    }
}




}
