package com.leetcode.problem3186;

import java.util.*;

public class Solution {

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> total = new HashMap<>();
        for (int i = 0; i < power.length; i++) {
            total.put(power[i], total.getOrDefault(power[i], 0L) + power[i]);
        }

        List<Integer> uniques = new ArrayList<>(total.keySet());
        Collections.sort(uniques);

        long[] dp = new long[uniques.size()];

        for (int i = 0; i < uniques.size(); i++) {
            int x = uniques.get(i);
            long take = total.get(x);
        }

        return 0L;
    }
}
