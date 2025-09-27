package com.leetcode.problem0120.v1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testMinimumTotal_BasicCases() {
        assertEquals(11, solution.minimumTotal(List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3))));
    }

    @Test
    void testMinimumTotal_EdgeCases() {
        assertEquals(-10, solution.minimumTotal(List.of(List.of(-10))));
    }
}