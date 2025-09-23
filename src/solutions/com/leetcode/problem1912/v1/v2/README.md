

# v2

In this version we, optimize our previously laggy code which had the following complexities: 

1. `search(movie)` T.C: `O(M log M)` where M is the size of unrented movies. In the worst case, this search will have all
the entries, N x 3 making this `O(N logN)`.
2. `rent(shop, movie)` T.C: `O(N)`, Linear search + removal 
3. `drop(shop, movie)` T.C: `O(N)`
4. `report()` : T.C: `O(M logM)` where M is the size of rented movies. Worst case: `O(N LogN)`.

These are especially bad for large inputs.


---

Let's use min heap for storing rented and unrented movies in `search(movie)` and `report()` methods! 
Let's use a hash map for searching and removing in `rent(shop, movie)` and `drop(shop, movie)` methods! 

### Min Heap for storing

1. Getting top 5 entries for search will become `O(5 logk)`, instead of storing all the entries.
    - We'll order the heap `price --> shopId`.
2. Getting top 5 rented movies will become `O(5 logM)` where M is the number of rented movies, awesome. 


### Hash Maps for querying a shop's movie 

1. 