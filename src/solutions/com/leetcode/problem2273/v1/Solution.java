package com.leetcode.problem2273.v1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;

        int[][] signs = new int[n][26];
        for (int i = 0; i < n; i++) {
            int[] sign = new int[26];
            String word = words[i];
            int l = word.length();
            for (int c = 0; c < l; c++)
                sign[word.charAt(c) - 'a']++;
            signs[i] = sign;
        }

        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < n; i++) {
            if(!compare(signs[i], signs[i - 1]))
                result.add(words[i]);
        }
        return result;
    }

    private boolean compare(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i]) return false;
        return true;
    }
}
