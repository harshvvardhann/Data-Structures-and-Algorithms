package Arrays.Easy;

public class pb10MissingElement {

    // optimal approach-1 TC:O(N) SC:O(1)
    public static int missingElement(int arr[], int N) {
        int sum = (N * (N + 1)) / 2;
        int s = 0;
        for (int i = 0; i < N - 1; i++) {
            s += arr[i];
        }
        return sum - s;
    }

    // optimal approach-2 TC:O(N) SC:O(1)
    public static int missingElement1(int arr[], int N) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < N - 1; i++) {
            xor1 = xor1 ^ arr[i];
            xor2 = xor2 ^ (i + 1);
        }
        xor2 = xor2 ^ N;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        System.out.println(missingElement(arr, 5));
        System.out.println(missingElement1(arr, 5));
    }
}
