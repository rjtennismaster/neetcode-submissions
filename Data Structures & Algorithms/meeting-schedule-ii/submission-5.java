/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));
        Queue<Integer> meetings = new PriorityQueue<>();
        meetings.offer(intervals.getFirst().end);

        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;

            if (start >= meetings.peek()) {
                meetings.poll();
            }

            meetings.offer(intervals.get(i).end);
        }

        return meetings.size();
    }
}
