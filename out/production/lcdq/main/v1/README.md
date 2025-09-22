# MovieRentingSystem v1 – Brute Force Implementation

## Overview

This is the first version of the `MovieRentingSystem` using **lists (`ArrayList`)** to store both rented and unrented movies. It implements all four required functions:

* `search(movie)` – finds cheapest 5 shops with the movie available
* `rent(shop, movie)` – moves a movie from unrented to rented
* `drop(shop, movie)` – moves a movie from rented to unrented
* `report()` – lists the cheapest 5 rented movies

---

## How the Data is Stored

* **`unrentedMovieData`** – stores all unrented movies as `[entryId, shopId, movieId, price]`
* **`rentedMovieData`** – stores all rented movies in the same format
* Both are `List<List<Integer>>`.

---

## How Each Function Works

### `search(movie)`

1. Iterate through `unrentedMovieData` to find entries matching the movie.
2. Sort the filtered list by **price** → **shopId**.
3. Return the **shop IDs** of the top 5 entries.

**Time Complexity:**

* Filtering: O(n)
* Sorting: O(n log n)
* Extract top 5: O(1)

**Overall:** O(n log n) per search.

---

### `rent(shop, movie)`

1. Iterate through `unrentedMovieData` to find the matching entry.
2. Remove it from `unrentedMovieData` and add it to `rentedMovieData`.

**Time Complexity:**

* Search + remove in ArrayList: O(n)
* Add to `rentedMovieData`: O(1)

**Overall:** O(n) per rent.

> ⚠️ Linear search + removal is inefficient for large n.

---

### `drop(shop, movie)`

1. Iterate through `rentedMovieData` to find the matching entry.
2. Remove it from `rentedMovieData` and add it to `unrentedMovieData`.

**Time Complexity:**

* Same as `rent`: O(n)

---

### `report()`

1. Sort `rentedMovieData` by **price → shopId → movieId**.
2. Return the top 5 `[shopId, movieId]` pairs.

**Time Complexity:**

* Sorting: O(m log m), where m = number of rented movies
* Extract top 5: O(1)

---

## Why This Implementation is Inefficient

* **Linear searches:** `rent()` and `drop()` require scanning the whole list to find a specific movie.
* **Repeated sorting:** `search()` and `report()` sort the entire list each time, even if only 5 results are needed.
* **ArrayList removals in the middle:** `unrentedMovieData.remove(i)` is O(n) because elements shift left.
* **Overall complexity:** For large `n` and frequent operations, this approach can degrade to **O(n²)** in worst-case scenarios.

> ✅ Works fine for small main.v1.test cases (like LeetCode example), but will likely **TLE** on large inputs (`n` up to 3 × 10⁵).

---

## Takeaways from v1

* This brute-force approach is useful for **understanding logic and correctness**.
* The next versions (v2, v3…) can improve performance by:

    * Using **heaps** or **TreeSets** for fast sorting & top-5 queries.
    * Using **hash maps** for constant-time lookup of entries.
    * Avoiding repeated full-list sorts by maintaining **ordered sets** of rented/unrented movies.

