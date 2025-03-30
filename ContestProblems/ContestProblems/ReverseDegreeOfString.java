package ContestProblems.ContestProblems;
import java.util.HashMap;
class Solution {
    public int reverseDegree(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int x = 26;
        for(char i='a';i<='z';i++){
            hm.put(i,x--);
        }
        int sum = 0;
        for(int i=1;i<=s.length();i++){
            sum += (i*hm.get(s.charAt(i-1)));
        }
        return sum;
    }
}