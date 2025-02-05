package LearnBasicRecursion;

public class FibonacciNumber {

    public static int generateFN(int n) {
        // Handle base cases
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int a = 0; // First Fibonacci number
        int b = 1; // Second Fibonacci number
        int sum = 0; // To store the current Fibonacci number

        // Loop to calculate the nth Fibonacci number
        for (int i = 2; i <= n; i++) {
            sum = a + b; // Calculate current Fibonacci number
            a = b; // Update a to the previous number
            b = sum; // Update b to the current number
        }

        return sum; // Return the nth Fibonacci number
    }

    public static void main(String[] args) {
        int n = 4; // Example input
        System.out.println("The " + n + "th Fibonacci number is: " + generateFN(n));
    }
}
