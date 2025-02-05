package BASICS;

import java.util.Scanner;

public class pb5Armstrong {
    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int n) {
        int original = n;  // Store the original number
        int sum = 0;
        int digits = String.valueOf(n).length();  // Count the number of digits
        
        while (n > 0) {
            int digit = n % 10;  // Extract the last digit
            sum += Math.pow(digit, digits);  // Add the digit raised to the power of number of digits
            n /= 10;  // Remove the last digit
        }
        
        return sum == original;  // Check if the sum equals the original number
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        sc.close();
    }
}
