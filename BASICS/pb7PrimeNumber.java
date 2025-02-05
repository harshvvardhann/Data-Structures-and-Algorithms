package BASICS;

public class pb7PrimeNumber {

    // Function to check if a
    // given number is prime.
    static boolean checkPrime(int n) {

        // Initialize a counter variable to
        // count the number of factors.
        int cnt = 0;

        // Loop through numbers from 1
        // to the square root of n.
        for (int i = 1; i <= Math.sqrt(n); i++) {

            // If n is divisible by i
            // without any remainder.
            if (n % i == 0) {

                // Increment the counter.
                cnt = cnt + 1;

                // If n is not a perfect square,
                // count its reciprocal factor.means if for ex n=24 then root(24)=4 then 1*24
                // for this count will be 2 because 1 and 2 both are roots, same way i=2 for
                // this 2*12 both are roots,i=3 for this 3*8 both are roots so that's why we are
                // counting 2 times. if n=16 then 1*16, count=2, 2*8 count=4, 4*4 for this we
                // cannot do count+2 bcoz 4 is 2 times here.
                if (n / i != i) {
                    cnt = cnt + 1;
                }
            }
        }

        // If the number of
        // factors is exactly 2.
        if (cnt == 2) {
            // Return true, indicating
            // that the number is prime.
            return true;
        }
        // If the number of
        // factors is not 2.
        else {
            // Return false, indicating
            // that the number is not prime.
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 1483;
        boolean isPrime = checkPrime(n);
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }
    }
}
