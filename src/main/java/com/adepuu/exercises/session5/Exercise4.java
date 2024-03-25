package com.adepuu.exercises.session5;

public class Exercise4 {
  public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 1};
        int elementToRemove = 1;

        System.out.println("array awal:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();


        arr = removeAllOccurrences(arr, elementToRemove);


        System.out.println("setelah dihapus " + elementToRemove + ":");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static int[] removeAllOccurrences(int[] arr, int element) {
        int count = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count++;
            }
        }


        int[] newArray = new int[arr.length - count];
        int index = 0;


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                newArray[index++] = arr[i];
            }
        }

        return newArray;
    }
}

