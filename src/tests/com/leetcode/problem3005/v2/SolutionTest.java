package com.leetcode.problem3005.v2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testMaxFrequencyElements_BasicCases() {
        assertEquals(4, solution.maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
        assertEquals(5, solution.maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void testMaxFrequencyElements_OptimizedVersion() {
        // Test the single-pass optimized solution
        assertEquals(1, solution.maxFrequencyElements(new int[]{1}));
        assertEquals(3, solution.maxFrequencyElements(new int[]{1, 1, 1}));
        assertEquals(4, solution.maxFrequencyElements(new int[]{1, 1, 2, 2, 3}));
    }

    @Test
    void testMaxFrequencyElements_LargeArrays() {
        // Test with larger arrays to verify optimization
        int[] largeArray = new int[1000];
        for (int i = 0; i < 500; i++) largeArray[i] = 1;  // 500 occurrences of 1
        for (int i = 500; i < 1000; i++) largeArray[i] = 2; // 500 occurrences of 2

        assertEquals(1000, solution.maxFrequencyElements(largeArray)); // Both have max frequency
    }
}
