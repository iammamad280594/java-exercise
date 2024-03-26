package com.adepuu.exercises.session6;
import java.util.Scanner;
public class Exercise1 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            double sum = 0;
            int count = 0;

            System.out.println("Enter numbers to calculate average and enter 'q' to finish.");

            while (true) {
                System.out.print("Enter a number or 'q' to finish: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("q")) {
                    if (count == 0) {
                        System.out.println("No numbers entered. Exiting...");
                    } else {
                        double average = sum / count;
                        System.out.println("Average: " + average);
                    }
                    break;
                }

                try {
                    double number = Double.parseDouble(input);
                    sum += number;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number or 'q' to finish.");
                }
            }

            scanner.close();
        }
    }
