package BASICS;

public class pb3PalindromeNumber {
    public boolean isPalindrome(int n) {
        int num = n;
        int rev = 0;
        while (num > 0) {
            int x = num % 10;
            rev = rev * 10 + x;
            num = num / 10;
        }
        return (n == rev) ? true : false;
    }

    // alternative using string builder

    public static boolean isPalindrome1(int n) {
        // Convert the number to a string
        String str = Integer.toString(n);

        // Get the reversed version of the string
        String reversedStr = new StringBuilder(str).reverse().toString();

        // Check if the original string is equal to the reversed string
        return str.equals(reversedStr);
    }
}
