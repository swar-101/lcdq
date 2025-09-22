package main.v1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (int f : freq.values()) {
            max = Math.max(f, max);
        }

        int total = 0;
        for (int f : freq.values()) {
            if (f == max) total += f;
        }

        return total;
    }
}