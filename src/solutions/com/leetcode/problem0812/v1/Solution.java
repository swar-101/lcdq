package com.leetcode.problem0812.v1;

public class Solution {

    public double largestTriangleArea(int[][] points) {
        double maxArea = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int xi = points[i][0];
                    int yi = points[i][1];
                    int xj = points[j][0];
                    int yj = points[j][1];
                    int xk = points[k][0];
                    int yk = points[k][0];

                    double area = 0.5 * Math.abs(xi * (yj - yk) +
                                                 xj * (yk - yi) +
                                                 xk * (yi - yj));
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(s.largestTriangleArea(points)); // expected: 2.0
    }
}
