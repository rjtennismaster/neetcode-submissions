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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return true;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int lastEnd = intervals.getFirst().end;

        for (int i = 1; i < intervals.size(); i++) {
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;

            if (start < lastEnd) {
                return false;
            }

            lastEnd = end;
        }

        return true;
    }
}
