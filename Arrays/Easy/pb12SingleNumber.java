package Arrays.Easy;

public class pb12SingleNumber {

    public static int singleNumber(int arr[]) {
        int xor1 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ arr[i];
        }
        return xor1;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 1, 3, 3, 2, 2 };
        System.out.println(singleNumber(arr));
    }
}
