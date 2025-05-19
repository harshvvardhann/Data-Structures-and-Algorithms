package TwopointeSlidingWindow;
import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
    int count = 0;           // To store the maximum length
    int left = 0, right = 0; // Sliding window boundaries
    int n = s.length();
    HashMap<Character, Integer> hm = new HashMap<>();

    while (right < n) {
        // Add current character to the hashmap
        hm.put(s.charAt(right), hm.getOrDefault(s.charAt(right), 0) + 1);

        // If distinct characters exceed k, move left pointer
        while (hm.size() > k) {
            char c = s.charAt(left);
            hm.put(c, hm.get(c) - 1);
            if (hm.get(c) == 0) {
                hm.remove(c);
            }
            left++;
        }

        // If valid window (at most k distinct chars), update result
        if (hm.size() <= k) {
            count = Math.max(count, right - left + 1);
        }

        right++;
    }
    return count;
}

}

