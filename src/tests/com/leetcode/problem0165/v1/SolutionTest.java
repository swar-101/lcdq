package com.leetcode.problem0165.v1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testCompareVersionNumbers_BasicCases() {
        assertEquals(0, solution.compareVersion("1.01", "1.001"));
        assertEquals(0, solution.compareVersion("1.0", "1.0.0"));
        assertEquals(-1, solution.compareVersion("0.1", "1.1"));
        assertEquals(1, solution.compareVersion("1.0.1", "1"));
        assertEquals(-1, solution.compareVersion("7.5.2.4", "7.5.3"));
    }

    @Test
    void testCompareVersionNumbers_EdgeCases() {
        assertEquals(0, solution.compareVersion("1.0", "1"));
        assertEquals(1, solution.compareVersion("1.2", "1.1"));
        assertEquals(-1, solution.compareVersion("1.1", "1.2"));
    }
}
