package BASICS;

class pb8Factorial {
    public static int check(int n) {
        if (n == 0) {
            return 1;
        }
        return n * check(n - 1);
    }

    public static void main(String[] args) {
        int x = 5;
        int g = check(x);
        System.out.println(g);
    }
}