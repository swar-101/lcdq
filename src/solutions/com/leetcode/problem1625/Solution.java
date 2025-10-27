package com.leetcode.problem1625;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> m = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String minString = s;

        m.add(s);
        visited.add(s);

        while (!m.isEmpty()) {
            String curr = m.poll();
            if (curr.compareTo(minString) < 0) minString = curr;

            String added = addOperation(curr, a);
            String rotated = rotateOperation(curr, b);

            if (visited.add(added)) m.add(added);
            if (visited.add(rotated)) m.add(rotated);
        }

        return minString;
    }

    private String addOperation(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) ((arr[i] - '0' + a) % 10 + '0');
        }
        return new String(arr);
    }

    private String rotateOperation(String s, int b) {
        int n = s.length();
        b = b % n; // in case b > n
        return s.substring(n - b) + s.substring(0, n - b);
    }
}