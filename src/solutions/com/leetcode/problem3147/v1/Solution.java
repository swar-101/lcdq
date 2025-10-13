package com.leetcode.problem3147.v1;

public class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        if (n == 1) return energy[0];

        int[] suffix = new int[n];
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n)
                suffix[i] = energy[i] + Math.max(0, suffix[i + k]);
            else
                suffix[i] = energy[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, suffix[i]);
        }

        return max;
    }
}
