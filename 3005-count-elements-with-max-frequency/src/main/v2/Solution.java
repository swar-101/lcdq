package main.v2;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxFrequencyElements(int[] nums) {
        int total = 0, max = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);

            int v = freq.get(num);

            if (v > max) {
                max = v;
                total = v;
            } else if (v == max) {
                total += v;
            }
        }

        return total;
    }
}