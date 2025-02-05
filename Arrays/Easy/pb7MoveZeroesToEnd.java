package Arrays.Easy;

public class pb7MoveZeroesToEnd {
    public static int[] movetoEnd(int arr[]) {
        int i = 0;

        for (Integer a : arr) {
            if (a != 0) {
                arr[i] = a;
                i++;
            }
        }
        while (i < arr.length) {
            arr[i] = 0;
            i++;
        }
        return arr;
    }
}
