package com.leetcode.problem0120.v1;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        for(int row = triangle.size() - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            List<Integer> nextRow = triangle.get(row + 1);

            for (int col = 0; col < currentRow.size(); col++) {
                int a = currentRow.get(col);
                int b = nextRow.get(col);
                int c = nextRow.get(col + 1);

                currentRow.set(col, a + Math.min(b, c));
            }
        }

        return triangle.get(0).get(0);
    }
}