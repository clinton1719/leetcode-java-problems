package problems.p146_lru_cache;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  class LRUCache {
    Node mruHead;
    Node lruTail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      mruHead = new Node(-1, -1);
      lruTail = new Node(-1, -1);
      mruHead.next = lruTail;
      lruTail.prev = mruHead;
      map = new HashMap<>();
    }

    public int get(int key) {
      Node node = map.get(key);
      if (node == null) return -1;

      moveToMRUCache(key);

      return node.val;
    }

    private void moveToMRUCache(int key) {
      Node node = map.get(key);
      Node prev = node.prev;
      Node next = node.next;
      prev.next = next;
      next.prev = prev;

      insert(node);
    }

    public void put(int key, int value) {
      if (capacity == 0) return;
      if (map.get(key) != null) {
        map.get(key).val = value;
        moveToMRUCache(key);
        return;
      }

      Node newLRUCache = new Node(key, value);
      insert(newLRUCache);
      map.put(key, newLRUCache);

      if (map.size() > capacity) {
        remove();
      }
    }

    private void insert(Node newLRUCache) {
      Node currentLRUCache = lruTail.prev;
      currentLRUCache.next = newLRUCache;
      newLRUCache.next = lruTail;
      newLRUCache.prev = currentLRUCache;
      lruTail.prev = newLRUCache;
    }

    private void remove() {
      Node currentMRUCache = mruHead.next;
      mruHead.next = currentMRUCache.next;
      currentMRUCache.next.prev = mruHead;
      currentMRUCache.next = null;
      currentMRUCache.prev = null;
      map.remove(currentMRUCache.key);
    }

    class Node {
      int key;
      int val;
      Node next;
      Node prev;

      Node(int key, int val) {
        this.key = key;
        this.val = val;
      }

      Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
      }
    }
  }
}
