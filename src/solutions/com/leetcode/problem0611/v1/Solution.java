package com.leetcode.problem0611.v1;

import java.util.Arrays;

public class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int k = nums.length - 1; k >= 0; k--) {
            int i = 0;
            int j = k - 1;

            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                }
                else {
                    i++;
                }
            }
        }

        return count;
    }

}
