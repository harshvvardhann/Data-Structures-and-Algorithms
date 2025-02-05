package BASICS;

public class pb2ReverseInteger {
    public static int reverse(int x) {
        int rev = 0;

        if (x < 0) {
            x = Math.abs(x);
            while (x > 0) {
                int a = x % 10;
                rev = rev * 10 + a;
                x = x / 10;
            }
            return -rev;
        } else {
            while (x > 0) {
                int a = x % 10;
                rev = rev * 10 + a;
                x = x / 10;
            }
            return rev;
        }
    }
}
