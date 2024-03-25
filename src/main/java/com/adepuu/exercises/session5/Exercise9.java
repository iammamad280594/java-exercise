package com.adepuu.exercises.session5;
 import java.util.ArrayDeque;
import java.util.Deque;
public class Exercise9 {
    public static void main(String[] args) {
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures2 = {30, 40, 50, 60};
        int[] temperatures3 = {30, 60, 90};

        System.out.println("Example 1:");
        System.out.println("Input: temperatures = " + arrayToString(temperatures1));
        System.out.println("Output: " + arrayToString(dailyWarmerTemperature(temperatures1)));

        System.out.println("\nExample 2:");
        System.out.println("Input: temperatures = " + arrayToString(temperatures2));
        System.out.println("Output: " + arrayToString(dailyWarmerTemperature(temperatures2)));

        System.out.println("\nExample 3:");
        System.out.println("Input: temperatures = " + arrayToString(temperatures3));
        System.out.println("Output: " + arrayToString(dailyWarmerTemperature(temperatures3)));
    }

    public static int[] dailyWarmerTemperature(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
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
}


