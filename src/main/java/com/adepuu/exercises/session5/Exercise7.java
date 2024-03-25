package com.adepuu.exercises.session5;
import java.util.HashMap;
import java.util.Map;
public class Exercise7 {
     public static void main(String[] args) {
            String s1 = "anagram";
            String t1 = "nagaram";

            String s2 = "rat";
            String t2 = "car";

            System.out.println("Example 1:");
            System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
            System.out.println("Output: " + isAnagram(s1, t1));

            System.out.println("\nExample 2:");
            System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
            System.out.println("Output: " + isAnagram(s2, t2));
        }

        public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            Map<Character, Integer> frequencyMap = new HashMap<>();

         
            for (char c : s.toCharArray()) {
                frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            }

         
            for (char c : t.toCharArray()) {
                if (!frequencyMap.containsKey(c) || frequencyMap.get(c) == 0) {
                    return false;
                }
                frequencyMap.put(c, frequencyMap.get(c) - 1);
            }

            return true; 
    }

