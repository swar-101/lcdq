package com.leetcode.problem1912.v1;

import com.leetcode.problem1912.v1.v1.MovieRentingSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class MovieRentingSystemTest {

    @Test
    void testMovieRentingSystem_BasicOperations() {
        int[][] entries = {{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}};
        MovieRentingSystem system = new MovieRentingSystem(3, entries);

        // Search for movie 1
        List<Integer> result = system.search(1);
        assertEquals(Arrays.asList(1, 0, 2), result); // sorted by price then shopId

        // Rent movie 1 from shop 1
        system.rent(1, 1);

        // Search again for movie 1
        result = system.search(1);
        assertEquals(Arrays.asList(0, 2), result); // shop 1 no longer available

        // Report rented movies
        List<List<Integer>> report = system.report();
        assertEquals(1, report.size());
        assertEquals(Arrays.asList(1, 1), report.get(0)); // [shopId, movieId]

        // Drop movie 1 from shop 1
        system.drop(1, 1);

        // Search again for movie 1
        result = system.search(1);
        assertEquals(Arrays.asList(1, 0, 2), result); // shop 1 is available again
    }

    @Test
    void testMovieRentingSystem_EmptyResults() {
        int[][] entries = {{0, 1, 5}};
        MovieRentingSystem system = new MovieRentingSystem(1, entries);

        // Search for non-existent movie
        List<Integer> result = system.search(999);
        assertTrue(result.isEmpty());

        // Report when no movies are rented
        List<List<Integer>> report = system.report();
        assertTrue(report.isEmpty());
    }
}
