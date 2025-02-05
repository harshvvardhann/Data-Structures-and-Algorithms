package Arrays.Hard;

import java.util.List;
import java.util.ArrayList;

class pascalTriangle {
    public static List<Integer> func(int n) {
        List<Integer> list = new ArrayList<>();
        int ans = 1;
        list.add(ans);
        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);  
            ans = ans / i;
            list.add(ans);
        }
        return list;
    }

    public static List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            res.add(func(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> res = generate(n);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}