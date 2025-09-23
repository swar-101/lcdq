package com.leetcode.problem1912.v1.v2;

import java.util.*;

public class MovieRentingSystem {

    int n;
    int[][] entries;

    Map<Integer, PriorityQueue<MovieEntry>> unrentedMap;
    PriorityQueue<MovieEntry> rentedHeap;
    Map<String, MovieEntry> entryMap;


    public MovieRentingSystem(int n, int[][] entries) {
        unrentedMap = new HashMap<>();
        rentedHeap = new PriorityQueue<>(
                (a, b) -> {
                if (a.price != b.price) return a.price - b.price;
                if (a.shopId != b.shopId) return a.shopId - b.shopId;
                return a.movieId - b.movieId;
        });
        entryMap = new HashMap<>();

        for (int[] entry : entries) {
            int shopId = entry[0];
            int movieId = entry[1];
            int price = entry[2];

            MovieEntry movieEntry = new MovieEntry(shopId, movieId, price);
            unrentedMap
                    .computeIfAbsent(movieId, k -> new PriorityQueue<>(
                            (a, b) -> {
                                if (a.price != b.price) return a.price - b.price;
                                return a.shopId - b.shopId;
                            }
                    )).add(movieEntry);
            entryMap.put(shopId + "-" + movieId, movieEntry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<MovieEntry> heap = unrentedMap.get(movie);
        if (heap == null) return result;
        int count = 0;
        for (MovieEntry entry : heap) {
            result.add(entry.shopId);
            count++;
            if (count == 5) break;
        }
        return result;
    }

    public void rent(int shop, int movie) {
        String key = shop + "-" + movie;
        MovieEntry entry = entryMap.get(key);
        if (entry == null) return;

        PriorityQueue<MovieEntry> heap = unrentedMap.get(movie);
        heap.remove(entry);
        rentedHeap.add(entry);
    }

    public void drop(int shop, int movie) {
        String key = shop + "-" + movie;
        MovieEntry entry = entryMap.get(key);
        if (entry == null) return;

        rentedHeap.remove(entry);
        unrentedMap.get(movie).add(entry);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> result = new ArrayList<>();
        List<MovieEntry> temp = new ArrayList<>(rentedHeap);
        temp.sort((a, b) -> {
            if (a.price != b.price) return a.price - b.price;
            if (a.shopId != b.shopId) return a.shopId - b.shopId;
            return a.movieId - b.movieId;
        });
        for (int i = 0; i < Math.min(5, temp.size()); i++) {
            MovieEntry e = temp.get(i);
            result.add(Arrays.asList(e.shopId, e.movieId));
        }

        return result;
    }

    static class MovieEntry {
        int shopId;
        int movieId;
        int price;

        public MovieEntry(int shopId, int movieId, int price) {
            this.shopId = shopId;
            this.movieId = movieId;
            this.price = price;
        }
    }
}