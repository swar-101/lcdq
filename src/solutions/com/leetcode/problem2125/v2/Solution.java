package com.leetcode.problem2125.v2;

public class Solution {

    public int numberOfBeams(String[] bank) {
        int curr = 0;
        int prev = 0;
        int total = 0;
        for (int i = 0; i < bank.length; i++) {
            curr = count(bank[i]);
            if (curr == 0) continue;

            total += curr * prev;
            prev = curr;
        }
        return total;
    }

    private int count(String s) {
        int count = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') count++;
        }
        return count;
    }
}