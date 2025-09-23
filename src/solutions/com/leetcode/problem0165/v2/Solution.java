package com.leetcode.problem0165.v2;

public class Solution {
    /**
     * Optimized version using String.split() for cleaner code
     */
    public int compareVersion(String version1, String version2) {
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        int maxLen = Math.max(v1Parts.length, v2Parts.length);

        for (int i = 0; i < maxLen; i++) {
            int v1Num = i < v1Parts.length ? Integer.parseInt(v1Parts[i]) : 0;
            int v2Num = i < v2Parts.length ? Integer.parseInt(v2Parts[i]) : 0;

            if (v1Num < v2Num) return -1;
            if (v1Num > v2Num) return 1;
        }

        return 0;
    }
}
