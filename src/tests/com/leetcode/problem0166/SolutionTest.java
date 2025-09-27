package com.leetcode.problem0166;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.AggregateWith;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testFractionToDecimal_BasicCases() {
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
        assertEquals("2", solution.fractionToDecimal(10, 5));
        assertEquals("33.(33)", solution.fractionToDecimal(100, 3));
    }

    @Test
    void testFractionToDecimal_EdgeCases() {
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
        assertEquals("0", solution.fractionToDecimal(0, 1234));
    }
}