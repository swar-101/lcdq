package com.leetcode.problem3005.v1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;
        for (int f : freq.values()) {
            maxFreq = Math.max(f, maxFreq);
        }

        int totalElementsWithMaxFreq = 0;
        for (int f : freq.values()) {
            if (f == maxFreq) {
                totalElementsWithMaxFreq += f;
            }
        }

        return totalElementsWithMaxFreq;
    }
}
