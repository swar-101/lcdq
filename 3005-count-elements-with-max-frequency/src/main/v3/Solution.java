package main.v3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int maxFrequencyElements(int[] nums) {
        // let's calculate what the max value in this array is
        // so that we can get the max size of frequency array
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(num, maxVal);
        }

        int[] freq = new int[maxVal + 1];
        for (int num : nums) {
            freq[num]++;
        }

        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(f, maxFreq);
        }

        int total = 0;

        for (int f : freq) {
            if (f == maxFreq) total += f;
        }

        return total;
    }
}