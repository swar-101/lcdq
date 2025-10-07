package com.leetcode.problem1488.v1;

import java.util.HashMap;
import java.util.TreeSet;

public class Solution {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] ans = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];

                if (lastRain.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(lastRain.get(lake));
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}