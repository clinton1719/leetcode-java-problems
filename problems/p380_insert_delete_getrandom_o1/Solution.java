package problems.p380_insert_delete_getrandom_o1;

import java.util.*;

public class Solution {

  static void main() {
    Solution solution = new Solution();
  }

  class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
      map = new HashMap<>();
      list = new ArrayList<>();
      random = new Random();
    }

    public boolean insert(int val) {
      if (map.containsKey(val)) return false;

      map.put(val, list.size());
      list.add(val);
      return true;
    }

    public boolean remove(int val) {
      if (!map.containsKey(val)) return false;

      int index = map.get(val);
      map.put(list.get(list.size() - 1), index);
      map.remove(val);
      list.set(index, list.get(list.size() - 1));
      list.remove(list.size()-1);
      return true;
    }

    public int getRandom() {
      int index = random.nextInt(0, list.size());
      return list.get(index);
    }
  }
}
