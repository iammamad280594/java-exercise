package com.adepuu.exercises.session5;
import java.util.HashSet;
import java.util.Set;
public class Exercise3 {
     public static void main(String[] args) {
        int[] arr1 = {1,2,3,1};
        int[] arr2 = {1,2,3,4};
        int[] arr3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println("ini duplikat? " + containsDuplicates(arr1));
        System.out.println("ini duplikat? " + containsDuplicates(arr2));
        System.out.println("ini duplikat? " + containsDuplicates(arr3));
    }

    public static boolean containsDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {
                return true; // Duplicate found
            } else {
                set.add(num);
            }
        }

        return false; // No duplicates found
    }
}


    }
}
