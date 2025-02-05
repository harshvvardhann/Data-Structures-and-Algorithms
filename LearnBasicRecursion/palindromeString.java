package LearnBasicRecursion;

public class palindromeString {

    // TC: O(n), SC: O(n)- bcoz new string is created.
    public static boolean checkString(String s) {
        String a = new StringBuilder(s).reverse().toString().trim();
        return s.trim().equals(a);
    }

    // TC: O(n), SC:O(1)
    public boolean isPalindromeBetter(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "HaaH";
        System.out.println(checkString(s));
    }
}
