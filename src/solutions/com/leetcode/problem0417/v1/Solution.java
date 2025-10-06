package com.leetcode.problem0417.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        if (height.length == 1 && height[0].length == 1)
            return List.of(List.of(0, 0));

        int m = height.length;
        int n = height[0].length;

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int r = 0; r < m; r++)
            dfs(r, 0, pacificVisited, height);
        for (int c = 0; c < n; c++)
            dfs(0, c, pacificVisited, height);

        for (int r = 0; r < m; r++)
            dfs(r, n - 1, atlanticVisited, height);
        for (int c = 0; c < n; c++)
            dfs(m - 1, c, atlanticVisited, height);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void dfs(int r, int c, boolean[][] visited, int[][] height) {
        visited[r][c] = true;
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int[] side : dirs) {
            int nr = r + side[0];
            int nc = c + side[1];

            if (isInBounds(nr, nc, height)
                    && !visited[nr][nc]
                    && height[nr][nc] >= height[r][c]) {

                dfs(nr, nc, visited, height);
            }
        }
    }

    private boolean isInBounds(int r, int c, int[][] grid) {
        return r >= 0
                && c >= 0
                && r < grid.length
                && c < grid[0].length;
    }
}