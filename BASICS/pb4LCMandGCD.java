package BASICS;

public class pb4LCMandGCD {
    // Function to calculate GCD of two numbers using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Function to calculate LCM of two numbers
    public static int lcm(int a, int b, int gcd) {
        return (a * b) / gcd; // Using the relationship: LCM(a, b) * GCD(a, b) = a * b
    }

    // Function to calculate LCM and GCD and return as a list
    public static int[] lcmAndGcd(int a, int b) {
        int gcdValue = gcd(a, b); // Calculate GCD
        int lcmValue = lcm(a, b, gcdValue); // Calculate LCM
        return new int[] { lcmValue, gcdValue }; // Return LCM and GCD as an array
    }

    public static void main(String[] args) {
        int a = 15; 
        int b = 20;

        int[] result = lcmAndGcd(a, b);
        System.out.println("LCM: " + result[0] + ", GCD: " + result[1]);
    }
}
