package BASICS;

class pbDivisiors {
    public static int generateCount(int x) {
        int y = 0;
        for (int i = 1; i <= x; i++) {
            if (x % i == 0) {
                y += i;
            }
        }
        return y;   
    }

    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            count += generateCount(i);
        }
        System.out.println(count);
    }
}