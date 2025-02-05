/*Given a number n. Count the number of digits in n which evenly divide n. Return an integer, total number of digits of n which divides n evenly.
// Note :- Evenly divides means whether n is divisible by a digit i.e. leaves a remainder 0 when divided.*/

package BASICS;

class pb1CountDigits {
    public static int countDivisibleDigits(int n) {
        int count = 0;
        int original = n;

        while (n > 0) {
            int digit = n % 10; // Extract the last digit
            if (digit != 0 && original % digit == 0) {
                count++; // Check if the digit divides the original number
            }
            n /= 10; // Remove the last digit
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 120; // Example input
        int result = countDivisibleDigits(n);
        System.out.println("Number of divisible digits: " + result);
    }
}
