package com.leetcode.problem2125.v1;

public class Solution {

    public int numberOfBeams(String[] bank) {
        // pre-compute a freq array
        int m = bank.length;
        int n = bank[0].length();

        int[][] comp = new int[m][2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bank[i].charAt(j) == '0')
                    comp[i][0] += 1;
                else
                    comp[i][1] += 1;
            }
        }

        int i = 0;
        int count = 0;
        while (i < comp.length) {
            if (comp[i][1] != 0) {
                int d = comp[i][1];
                int j = i + 1;
                if (j >= comp.length)
                    break;

                while (j < comp.length && comp[j][1] == 0)
                    j++;

                if (j >= comp.length)
                    break;
                int lasers = d * comp[j][1];
                count += lasers;
            }
            i++;
        }
        return count;
    }
}