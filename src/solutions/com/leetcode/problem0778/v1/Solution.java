package com.leetcode.problem0778.v1;

import java.util.PriorityQueue;

class Solution {

    public int swimInWater(int[][] grid) {
        if (grid.length == 1) return grid[0][0];
        return bfs(grid);
    }

    private int bfs(int[][] grid) {
        int maxElevation = -1;
        int n = grid.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][n];

        minHeap.add(new int[]{0, 0, grid[0][0]});
        visited[0][0] = true;

        while (!minHeap.isEmpty()) {
            int[] cell = minHeap.poll();
            int x = cell[0];
            int y = cell[1];
            int elevation = cell[2];

            maxElevation = Math.max(elevation, maxElevation);
            if (x == n - 1 && y == n - 1)
                return maxElevation;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    minHeap.add(new int[]{nx, ny, grid[nx][ny]});
                    visited[nx][ny] = true;
                }
            }
        }
        return maxElevation;
    }
}