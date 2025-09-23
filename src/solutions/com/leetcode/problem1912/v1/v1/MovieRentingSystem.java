package com.leetcode.problem1912.v1.v1;

import java.util.*;

public class MovieRentingSystem {

    private final Map<Integer, TreeSet<int[]>> unrentedMovies; // movieId -> TreeSet of [price, shopId]
    private final TreeSet<int[]> rentedMovies; // TreeSet of [price, shopId, movieId]
    private final Map<String, Integer> shopMoviePrice; // "shopId,movieId" -> price

    public MovieRentingSystem(int n, int[][] entries) {
        this.unrentedMovies = new HashMap<>();
        this.rentedMovies = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // price
            if (a[1] != b[1]) return a[1] - b[1]; // shopId
            return a[2] - b[2]; // movieId
        });
        this.shopMoviePrice = new HashMap<>();

        for (int[] entry : entries) {
            int shopId = entry[0], movieId = entry[1], price = entry[2];
            unrentedMovies.computeIfAbsent(movieId, k -> new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0]; // price
                return a[1] - b[1]; // shopId
            })).add(new int[]{price, shopId});
            shopMoviePrice.put(shopId + "," + movieId, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        TreeSet<int[]> shops = unrentedMovies.get(movie);
        if (shops != null) {
            int count = 0;
            for (int[] shop : shops) {
                if (count++ >= 5) break;
                result.add(shop[1]); // shopId
            }
        }
        return result;
    }

    public void rent(int shop, int movie) {
        int price = shopMoviePrice.get(shop + "," + movie);
        unrentedMovies.get(movie).remove(new int[]{price, shop});
        rentedMovies.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = shopMoviePrice.get(shop + "," + movie);
        rentedMovies.remove(new int[]{price, shop, movie});
        unrentedMovies.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        int count = 0;
        for (int[] rental : rentedMovies) {
            if (count++ >= 5) break;
            result.add(Arrays.asList(rental[1], rental[2])); // [shopId, movieId]
        }
        return result;
    }
}
