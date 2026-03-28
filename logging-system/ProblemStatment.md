# LRU Cache

## Problem

Design a cache that follows the **Least Recently Used (LRU)** policy.

Implement:

* `get(key)` → return value if present, else `-1`. Marks key as recently used.
* `put(key, value)` → insert/update key. If capacity is exceeded, remove the least recently used key.

## Note

* Both operations should run in **O(1)** time.
  
## What we will be using (Hint)

* HashMap for O(1) lookup
* Doubly Linked List to maintain order of usage
* Head and Tail pointers to track most and least recently used elements
