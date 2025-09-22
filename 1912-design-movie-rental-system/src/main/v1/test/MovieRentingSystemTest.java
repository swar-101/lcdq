package main.v1.test;

import main.v1.MovieRentingSystem;

public class MovieRentingSystemTest {
    public static void main(String[] args) {
        int n = 3;
        int[][] entries = {{0,1,5},{0,2,6},{0,3,7},{1,1,4},{1,2,7},{2,1,5}};

        MovieRentingSystem mrs = new MovieRentingSystem(n, entries);

        System.out.println(mrs.search(1)); // expect [1, 0, 2]
        mrs.rent(0, 1);
        mrs.rent(1, 2);
        System.out.println(mrs.report()); // expect [[0, 1], [1, 2]]

        mrs.drop(1, 2);
        System.out.println(mrs.search(2)); // expect [0, 1]
    }
}
