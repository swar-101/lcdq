package com.leetcode.problem3494.v1;

public class Solution {
    public long minTime(int[] skills, int[] mana) {
        int n = skills.length;
        int m = mana.length;

        int[][] dp = new int[n][m];

        dp[0][0] = skills[0] * mana[0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + skills[0] * mana[j];
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + skills[i] + mana[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + skills[i] * mana[j];
            }
        }

        return dp[n - 1][m - 1];
    }
}