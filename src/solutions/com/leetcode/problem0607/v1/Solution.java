package com.leetcode.problem0607.v1;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length < 3 || heightMap[0].length < 3) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    visited[i][j] = true;
                    minHeap.offer(new int[]{heightMap[i][j], i, j});
                }
            }
        }

        int result = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int h = cell[0];
            int x = cell[1];
            int y = cell[2];

            for (int[] pos : dir) {
                int nx = x + pos[0];
                int ny = y + pos[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    result += Math.max(0, h - heightMap[nx][ny]);
                    minHeap.add(new int[]{Math.max(h, heightMap[nx][ny]), nx, ny});
                }
            }
        }

        return result;
    }
}