package LearnBasicRecursion;

public class SumOfFirstNNaturalNumbers {

    // Recursive function to calculate the sum of first n natural numbers
    public static int sum(int n) {
        // Base case: if n is 0, return 0
        if (n == 0) {
            return 0;
        }
        // Recursive case: sum of n and the sum of first (n-1) numbers
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        System.out.println("The sum of first " + number + " natural numbers is: " + sum(number));
    }
}
