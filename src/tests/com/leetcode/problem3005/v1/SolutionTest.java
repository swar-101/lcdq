package com.leetcode.problem3005.v1;

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
    void testMaxFrequencyElements_SingleElement() {
        assertEquals(1, solution.maxFrequencyElements(new int[]{1}));
    }

    @Test
    void testMaxFrequencyElements_AllSameElements() {
        assertEquals(3, solution.maxFrequencyElements(new int[]{1, 1, 1}));
    }

    @Test
    void testMaxFrequencyElements_MultipleMaxFreq() {
        // Elements 1 and 2 both appear twice (max frequency)
        assertEquals(4, solution.maxFrequencyElements(new int[]{1, 1, 2, 2, 3}));
    }
}
