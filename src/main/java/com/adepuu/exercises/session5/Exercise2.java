package com.adepuu.exercises.session5;
import java.util.Arrays;
public class Exercise2 {
     public static void main(String[] args) {
        int[] array1 = {7,2,5,1,4};
        Arrays.sort(array1);
        int largest = array1[array1.length-1];
        System.out.println("nilai paling gede adalah: " +largest);

     {
            int[] arr = {1,2,3,4,5,6,7};
            int rotateby = 2;

            int[] rotatedArr = rotateArray(arr, rotateby);

            for (int num : rotatedArr) {
                System.out.print(num );

            }}

    }
    public static int[] rotateArray(int[] arr, int rotateBy){
        int len = arr.length;
        int[] rotatedArr = new int[len];

        for (int i = 0; i < len - rotateBy; i++) {
            rotatedArr[i] = arr[i + rotateBy];

        }

        for (int i = 0; i < rotateBy; i++) {
            rotatedArr[len - rotateBy + i] = arr[i];
        }

        return rotatedArr;
    }
}

}
