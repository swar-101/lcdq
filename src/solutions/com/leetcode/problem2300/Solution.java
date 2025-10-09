package com.leetcode.problem2300;

import java.util.Arrays;

public class Solution {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        int[] result = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < m; i++) {
            long threshold = (long) Math.ceil((double) success / spells[i]);
            int index = search(threshold, potions);
            result[i] = m - index;
        }

        return result;
    }

    private int search(long target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int res = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if ((long) arr[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}