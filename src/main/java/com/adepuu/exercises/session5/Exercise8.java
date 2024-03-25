package com.adepuu.exercises.session5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise8 {
    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        int[] nums2 = {1, 1, 2};
        int[] nums3 = {1};

        System.out.println("Example 1:");
        System.out.println("Input: nums = " + arrayToString(nums1));
        System.out.println("Output: " + arrayToString(findDuplicates(nums1)));

        System.out.println("\nExample 2:");
        System.out.println("Input: nums = " + arrayToString(nums2));
        System.out.println("Output: " + arrayToString(findDuplicates(nums2)));

        System.out.println("\nExample 3:");
        System.out.println("Input: nums = " + arrayToString(nums3));
        System.out.println("Output: " + arrayToString(findDuplicates(nums3)));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Count occurrences of each element
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Add elements with count > 1 to the result list
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    public static String arrayToString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String arrayToString(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i));
            if (i != nums.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

