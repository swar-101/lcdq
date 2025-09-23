package com.leetcode.problem3005.v2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * Optimized version with single pass to find max frequency and count elements
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;

        // Single pass to build frequency map and track max frequency
        for (int num : nums) {
            int newFreq = freq.getOrDefault(num, 0) + 1;
            freq.put(num, newFreq);
            maxFreq = Math.max(maxFreq, newFreq);
        }

        // Count total elements with max frequency
        int result = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                result += f;
            }
        }

        return result;
    }
}
