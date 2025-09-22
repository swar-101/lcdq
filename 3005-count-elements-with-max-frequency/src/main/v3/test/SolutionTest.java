package main.v3.test;

import main.v3.Solution;

public class SolutionTest {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 1, 4};
        Solution s = new Solution();
        System.out.println(s.maxFrequencyElements(input)); // 4

        input = new int[]{1, 2, 3, 4, 5};
        System.out.println(s.maxFrequencyElements(input)); // 5
    }
}
