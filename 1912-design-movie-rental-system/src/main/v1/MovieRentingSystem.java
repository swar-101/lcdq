package main.v1;

import java.util.ArrayList;
import java.util.List;

public class MovieRentingSystem {

    int n;
    int[][] entries; // [entryId]{shopId, movieId, priceId}

    List<List<Integer>> rentedMovieData;  // [rmId]{entryId, shopId, movieId, priceId}
    List<List<Integer>> unrentedMovieData; // [urId]{entryId, shopId, movieId, priceId}

    public MovieRentingSystem(int n, int[][] entries) {
        this.n = n;
        this.entries = entries;
        rentedMovieData = new ArrayList<>();
        unrentedMovieData = populateUnrentedMovieData(entries);
    }

    /*
     * Returns a list of 5 shop IDs with the cheapest movies
     * - Sorted by their price in ascending order
     * - In case of a tie, sorted by their shop ID in ascending
     *   order
     * - Returning all of them, if the result has less than 5
     *   shop IDs
     * */
    public List<Integer> search(int movie) {
        List<List<Integer>> movieData = new ArrayList<>();
        for (List<Integer> entry : unrentedMovieData) {
            int movieId = entry.get(2);
            if (movie == movieId) {
                movieData.add(entry);
            }
        }

        movieData.sort((a, b) -> {
            if (!a.get(3).equals(b.get(3))) {
                return a.get(3) - b.get(3); // sorted by price asc
            }
            return a.get(1) - b.get(1); // if price is same, sorted by shop ID asc
        });

        /*
         * Refer README.md to understand why this line is commented
         *
         * return movieData.stream().limit(5).map(e -> e.get(1)).toList();
         * */

        List<Integer> topCheapestMovieShopEntries = new ArrayList<>();
        for (int i = 0; i < Math.min(5, movieData.size()); i++) {
            int shopId = movieData.get(i).get(1);
            topCheapestMovieShopEntries.add(shopId);
        }
        return topCheapestMovieShopEntries;
    }

    public void rent(int shop, int movie) {
        for (int i = unrentedMovieData.size() - 1; i >= 0; i--) {
            List<Integer> entry = unrentedMovieData.get(i);
            int shopId = entry.get(1);
            int movieId = entry.get(2);
            if (shop == shopId && movie == movieId) {
                unrentedMovieData.remove(i);
                rentedMovieData.add(entry);
            }
        }
    }

    public void drop(int shop, int movie) {
        for (int i = rentedMovieData.size() - 1; i >= 0; i--) {
            List<Integer> entry = rentedMovieData.get(i);
            int shopId = entry.get(1);
            int movieId = entry.get(2);
            if (shop == shopId && movie == movieId) {
                rentedMovieData.remove(i);
                unrentedMovieData.add(entry);
            }
        }
    }

    /*
     * Returns a list of the top 5 rented movie data
     * - Sorted by their price in ascending order
     * - In case of a tie, sorted by their shop IDs in ascending
     *   order
     * - In case of a tie, sorted by their movie IDs in ascending
     *   order
     * - Returning all of them, if the list has less than 5
     *   movie data entries
     * */
    public List<List<Integer>> report() {
        rentedMovieData.sort((a, b) -> {
            if (!a.get(3).equals(b.get(3)))
                return a.get(3) - b.get(3);
            else if (!a.get(1).equals(b.get(1)))
                return a.get(1) - b.get(1);
            else
                return a.get(2) - b.get(2);
        });

        List<List<Integer>> topUnrentedMovieData = new ArrayList<>();
        for (int i = 0; i < Math.min(5, rentedMovieData.size()); i++) {
            List<Integer> entry = new ArrayList<>();
            entry.add(rentedMovieData.get(i).get(1));
            entry.add(rentedMovieData.get(i).get(2));
            topUnrentedMovieData.add(entry);
        }

        return topUnrentedMovieData;
    }

    private List<List<Integer>> populateUnrentedMovieData(int[][] entries) {
        List<List<Integer>> unrentedMovieData = new ArrayList<>();
        for (int i = 0; i < entries.length; i++) {
            int shopId = entries[i][0];
            int movieId = entries[i][1];
            int price = entries[i][2];

            List<Integer> entry = new ArrayList<>();
            entry.add(i);
            entry.add(shopId);
            entry.add(movieId);
            entry.add(price);
            unrentedMovieData.add(entry);
        }

        return unrentedMovieData;
    }
}