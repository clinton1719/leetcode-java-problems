package problems.p3885_design_event_manager;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

  class EventManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> map;

    public EventManager(int[][] events) {
      pq =
          new PriorityQueue<>(
              (a, b) -> {
                if (b[1] != a[1]) return b[1] - a[1]; // higher priority first
                return a[0] - b[0]; // smaller eventId first
              });

      map = new HashMap<>();

      for (int[] e : events) {
        map.put(e[0], e[1]);
        pq.offer(new int[] {e[0], e[1]});
      }
    }

    public void updatePriority(int eventId, int newPriority) {
      map.put(eventId, newPriority);
      pq.offer(new int[] {eventId, newPriority}); // lazy insert
    }

    public int pollHighest() {
      while (!pq.isEmpty()) {
        int[] top = pq.peek();
        int eventId = top[0];
        int priority = top[1];

        // check if still valid
        if (!map.containsKey(eventId) || map.get(eventId) != priority) {
          pq.poll(); // discard outdated
          continue;
        }

        pq.poll();
        map.remove(eventId); // mark inactive
        return eventId;
      }
      return -1;
    }
  }

  /**
   * Your EventManager object will be instantiated and called as such: EventManager obj = new
   * EventManager(events); obj.updatePriority(eventId,newPriority); int param_2 = obj.pollHighest();
   */
}
